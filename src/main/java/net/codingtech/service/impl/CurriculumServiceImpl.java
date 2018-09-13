package net.codingtech.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import net.codingtech.VO.CurriculumDetailVO;
import net.codingtech.VO.CurriculumListVO;
import net.codingtech.common.config.Const;
import net.codingtech.common.enums.CurriculumStatusEnum;
import net.codingtech.common.enums.ResultEnum;
import net.codingtech.convert.Curriculum2CurriculumDTOConverter;
import net.codingtech.dao.CurriculumDetailRepository;
import net.codingtech.dao.CurriculumInfoRepository;
import net.codingtech.dao.mapper.CurriculumCategoryMapper;
import net.codingtech.dao.mapper.CurriculumInfoMapper;
import net.codingtech.dto.CurriculumDTO;
import net.codingtech.exception.CurriculumException;
import net.codingtech.pojo.CurriculumCategory;
import net.codingtech.pojo.CurriculumDetail;
import net.codingtech.pojo.CurriculumInfo;
import net.codingtech.service.ICurriculumCategoryService;
import net.codingtech.service.ICurriculumService;
import net.codingtech.specification.TestCurriculumInfoDaoSpec;
import net.codingtech.utils.KeyUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: childishgarden_test
 * @description:
 * @author: hongren
 * @create: 2018-08-14 17:15
 **/
@Service
@Slf4j
public class CurriculumServiceImpl implements ICurriculumService {

    @Autowired
    private CurriculumInfoRepository curriculumInfoRepository;

    @Autowired
    private CurriculumDetailRepository curriculumDetailRepository;

    @Autowired
    private CurriculumInfoMapper curriculumInfoMapper;

    @Autowired
    private CurriculumCategoryMapper curriculumCategoryMapper;

    @Autowired
    private ICurriculumCategoryService iCurriculumCategoryService;

    @Override
    public CurriculumDTO findOne(String curriculumId) {
        CurriculumInfo curriculumInfo = curriculumInfoRepository.findOne(curriculumId);
        if (curriculumInfo == null) {
            throw new CurriculumException(ResultEnum.CURRICULUM_NOT_EXIST);
        }
        List<CurriculumDetail> curriculumDetailList = curriculumDetailRepository.findByCurriculumId(curriculumId);
        if (CollectionUtils.isEmpty(curriculumDetailList)) {
            throw new CurriculumException(ResultEnum.CURRICULUM_DETAIL_NOT_EXIST);
        }
        CurriculumDTO curriculumDTO = Curriculum2CurriculumDTOConverter.convert(curriculumInfo);
        curriculumDTO.setCurriculumDetailList(curriculumDetailList);
        return curriculumDTO;
    }

    @Override
    public Page<CurriculumDTO> findUpAll(Pageable pageable) {
        List<CurriculumInfo> curriculumInfoList = curriculumInfoRepository.
                findByCurriculumStatus(CurriculumStatusEnum.UP.getCode());
        List<CurriculumDTO> curriculumDTOList = Curriculum2CurriculumDTOConverter.convert(curriculumInfoList);
        return new PageImpl<CurriculumDTO>(curriculumDTOList, pageable, curriculumDTOList.size());
    }

    @Override
    public Page<CurriculumDTO> findList(Pageable pageable) {

        List<CurriculumInfo> curriculumInfoList = curriculumInfoRepository.findAll();
        List<CurriculumDTO> curriculumDTOList = Curriculum2CurriculumDTOConverter.convert(curriculumInfoList);
        return new PageImpl<CurriculumDTO>(curriculumDTOList, pageable, curriculumDTOList.size());
    }

    @Override
    public Page<CurriculumDTO> findByDynamicCases(CurriculumDTO curriculumDTO, Pageable pageable) {
//        1.获取三个动态参数
//        2.设置课程对象查询
//        3.获取的对象封装成DTO对象//新建转化类
        CurriculumInfo curriculumInfo = new CurriculumInfo();

        curriculumInfo.setCurriculumAge(curriculumDTO.getCurriculumAge());
        curriculumInfo.setCurriculumProperty(curriculumDTO.getCurriculumProperty());
        curriculumInfo.setCategoryId(curriculumDTO.getCategoryId());

        Page<CurriculumInfo> curriculumInfoList = curriculumInfoRepository.findAll(TestCurriculumInfoDaoSpec.getSpec(curriculumInfo), pageable);//通过三个条件
        List<CurriculumDTO> curriculumDTOList = Curriculum2CurriculumDTOConverter.convert(curriculumInfoList.getContent());
        return new PageImpl<CurriculumDTO>(curriculumDTOList, pageable, curriculumInfoList.getTotalElements());

    }

    @Override
    public CurriculumDTO save(CurriculumDTO curriculumDTO) {
//      设置课程id
        String curriculumId = KeyUtil.genUniqueKey();
        if (curriculumDTO.getCurriculumId() == null) {
            curriculumDTO.setCurriculumId(curriculumId);
        }

//      写入课程库
        CurriculumInfo curriculumInfo = new CurriculumInfo();
        BeanUtils.copyProperties(curriculumDTO, curriculumInfo);
//       因为DTO的信息没有那么全,所以需要自行补上,例如id需要自己添加
        curriculumInfoRepository.save(curriculumInfo);
//      写入课程详情库
//        TODO 还需要判断详情具体的书记这些的条件是什么情况
        for (CurriculumDetail curriculumDetail : curriculumDTO.getCurriculumDetailList()) {
            curriculumDetail.setDetailId(KeyUtil.genUniqueKey());
            curriculumDetail.setCurriculumId(curriculumId);

//            curriculumDetail.getBookId();是否需要做库存管理?
            curriculumDetailRepository.save(curriculumDetail);
        }

        return curriculumDTO;
    }

    @Override
    public CurriculumInfo onUsing(String curriculumId) {
        CurriculumInfo curriculumInfo = curriculumInfoRepository.findOne(curriculumId);
        if (curriculumInfo == null) {
            throw new CurriculumException(ResultEnum.CURRICULUM_NO_FOUND);
        }
        if (curriculumInfo.getCurriculumStatusEnum() == CurriculumStatusEnum.UP) {
            throw new CurriculumException(ResultEnum.CURRICULUM_STATUS_ERROR);
        }

        //更新
        curriculumInfo.setCurriculumStatus(CurriculumStatusEnum.UP.getCode());
        return curriculumInfoRepository.save(curriculumInfo);
    }

    @Override
    public CurriculumInfo offUsing(String curriculumId) {
        CurriculumInfo curriculumInfo = curriculumInfoRepository.findOne(curriculumId);
        if (curriculumInfo == null) {
            throw new CurriculumException(ResultEnum.CURRICULUM_NO_FOUND);
        }
        if (curriculumInfo.getCurriculumStatusEnum() == CurriculumStatusEnum.DOWN) {
            throw new CurriculumException(ResultEnum.CURRICULUM_STATUS_ERROR);
        }

        //更新
        curriculumInfo.setCurriculumStatus(CurriculumStatusEnum.DOWN.getCode());
        return curriculumInfoRepository.save(curriculumInfo);
    }

    @Override
    public PageInfo getCurriculumList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<CurriculumInfo> curriculumInfoList = curriculumInfoRepository.findAll();

        List<CurriculumListVO> curriculumListVOList = Lists.newArrayList();
        for (CurriculumInfo curriculumInfo : curriculumInfoList) {
            CurriculumListVO curriculumListVO = new CurriculumListVO();
            BeanUtils.copyProperties(curriculumInfo, curriculumListVO);
            curriculumListVOList.add(curriculumListVO);
        }
        PageInfo pageResult = new PageInfo(curriculumInfoList);
        pageResult.setList(curriculumListVOList);
        return pageResult;
    }

    @Override
//    按关键字或课程id搜索
    public PageInfo searchCurriculum(String curriculumName, Integer curriculumId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        if (StringUtils.isNotBlank(curriculumName)) {
            curriculumName = new StringBuilder().append("%").append(curriculumName).append("%").toString();
        }
        List<CurriculumInfo> curriculumInfoList = curriculumInfoMapper.selectByNameAndProductId(curriculumName, curriculumId);
        List<CurriculumListVO> curriculumListVOList = Lists.newArrayList();
        for (CurriculumInfo curriculumInfo : curriculumInfoList) {
            CurriculumListVO curriculumListVO = new CurriculumListVO();
            BeanUtils.copyProperties(curriculumInfo, curriculumListVO);
            curriculumListVOList.add(curriculumListVO);
        }
        PageInfo pageResult = new PageInfo(curriculumInfoList);
        pageResult.setList(curriculumListVOList);
        return pageResult;
    }

    @Override
    public PageInfo getCurriculumByKeywordCategory(String keyword, Integer categoryId, Integer pageNum, Integer pageSize, String orderBy, Integer curriculumProperty, String curriculumAge) {
        if (StringUtils.isBlank(keyword) && categoryId == null) {
            throw new CurriculumException(ResultEnum.INFO_BY_BACK.getCode(), "无法显示");
        }
        List<Integer> categoryIdList = new ArrayList<Integer>();

        if (categoryId != null) {
            CurriculumCategory curriculumCategory = curriculumCategoryMapper.selectByPrimaryKey(categoryId);
            if (curriculumCategory == null && StringUtils.isBlank(keyword)) {
                //没有该分类,并且还没有关键字,这个时候返回一个空的结果集,不报错
                PageHelper.startPage(pageNum, pageSize);
                List<CurriculumListVO> curriculumListVOList = Lists.newArrayList();
                PageInfo pageInfo = new PageInfo(curriculumListVOList);
                return pageInfo;
            }
            //递归子节点
            categoryIdList = iCurriculumCategoryService.getCategoryAndDeepChildrenCategory(curriculumCategory.getCategoryId());
        }
        if (StringUtils.isNotBlank(keyword)) {
            keyword = new StringBuilder().append("%").append(keyword).append("%").toString();
        }

        PageHelper.startPage(pageNum, pageSize);
        //排序处理
        if (StringUtils.isNotBlank(orderBy)) {
            if (Const.CurriculumListOrderBy.CREATETIME_ASC_DESC.contains(orderBy)) {
                String[] orderByArray = orderBy.split("_");
                PageHelper.orderBy(orderByArray[0] + " " + orderByArray[1]);
            }
        }
        List<CurriculumInfo> curriculumInfoList = curriculumInfoMapper.selectByNameAndCategoryIds(StringUtils.isBlank(keyword) ? null : keyword,
                categoryIdList.size() == 0 ? null : categoryIdList,
                curriculumProperty == null ? null :curriculumProperty,
                StringUtils.isBlank(curriculumAge) ? null : curriculumAge);

        List<CurriculumListVO> curriculumListVOList = Lists.newArrayList();
        for (CurriculumInfo curriculumInfo : curriculumInfoList) {
            CurriculumListVO curriculumListVO = new CurriculumListVO();
            BeanUtils.copyProperties(curriculumInfo, curriculumListVO);
            curriculumListVOList.add(curriculumListVO);
        }

        PageInfo pageInfo = new PageInfo(curriculumInfoList);
        pageInfo.setList(curriculumListVOList);
        return pageInfo;
    }

    @Override
    public CurriculumDetailVO manageCurriculumDetail(String curriculumId) {

        if (curriculumId == null) {
            throw new CurriculumException(ResultEnum.PARAM_ERROR);
        }

        CurriculumInfo curriculumInfo = curriculumInfoMapper.selectByPrimaryKey(curriculumId);

        if (curriculumInfo == null) {
            throw new CurriculumException(ResultEnum.INFO_BY_BACK.getCode(), "课程不存在");
        }
        List<CurriculumDetail> curriculumDetailList = curriculumDetailRepository.findByCurriculumId(curriculumId);

        if (CollectionUtils.isEmpty(curriculumDetailList)) {
            throw new CurriculumException(ResultEnum.INFO_BY_BACK.getCode(), "未查询到需要准备的材料");
        }

        CurriculumDTO curriculumDTO = new CurriculumDTO();
        BeanUtils.copyProperties(curriculumInfo, curriculumDTO);
        curriculumDTO.setCurriculumDetailList(curriculumDetailList);

        CurriculumDetailVO curriculumDetailVO = new CurriculumDetailVO();
        BeanUtils.copyProperties(curriculumDTO, curriculumDetailVO);
        return curriculumDetailVO;
    }
}
