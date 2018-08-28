package net.codingtech.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.codingtech.convert.Curriculum2CurriculumDTOConverter;
import net.codingtech.dao.CurriculumDetailDao;
import net.codingtech.dao.CurriculumInfoDao;
import net.codingtech.dataobject.CurriculumDetail;
import net.codingtech.dataobject.CurriculumInfo;
import net.codingtech.dto.CurriculumDTO;
import net.codingtech.enums.CurriculumStatusEnum;
import net.codingtech.enums.ResultEnum;
import net.codingtech.exception.CurriculumException;
import net.codingtech.service.CurriculumService;
import net.codingtech.specification.TestCurriculumInfoDaoSpec;
import net.codingtech.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @program: childishgarden_test
 * @description:
 * @author: hongren
 * @create: 2018-08-14 17:15
 **/
@Service
@Slf4j
public class CurriculumServiceImpl implements CurriculumService {

    @Autowired
    private CurriculumInfoDao curriculumInfoDao;

    @Autowired
    private CurriculumDetailDao curriculumDetailDao;


    @Override
    public CurriculumDTO findOne(String curriculumId) {
        CurriculumInfo curriculumInfo = curriculumInfoDao.findOne(curriculumId);
        if (curriculumInfo == null) {
            throw new CurriculumException(ResultEnum.CURRICULUM_NOT_EXIST);
        }
        List<CurriculumDetail> curriculumDetailList = curriculumDetailDao.findByCurriculumId(curriculumId);
        if (CollectionUtils.isEmpty(curriculumDetailList)) {
            throw new CurriculumException(ResultEnum.CURRICULUM_DETAIL_NOT_EXIST);
        }
        CurriculumDTO curriculumDTO = Curriculum2CurriculumDTOConverter.convert(curriculumInfo);
        curriculumDTO.setCurriculumDetailList(curriculumDetailList);
        return curriculumDTO;
    }

    @Override
    public Page<CurriculumDTO> findUpAll(Pageable pageable) {

        List<CurriculumInfo> curriculumInfoList = curriculumInfoDao.
                findByCurriculumStatus(CurriculumStatusEnum.UP.getCode());
        List<CurriculumDTO> curriculumDTOList = Curriculum2CurriculumDTOConverter.convert(curriculumInfoList);
        return new PageImpl<CurriculumDTO>(curriculumDTOList,pageable,curriculumDTOList.size());
    }

    @Override
    public Page<CurriculumDTO> findList(Pageable pageable) {

        List<CurriculumInfo> curriculumInfoList = curriculumInfoDao.findAll();
        List<CurriculumDTO> curriculumDTOList = Curriculum2CurriculumDTOConverter.convert(curriculumInfoList);
        return new PageImpl<CurriculumDTO>(curriculumDTOList,pageable,curriculumDTOList.size());
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

        Page<CurriculumInfo> curriculumInfoList = curriculumInfoDao.findAll(TestCurriculumInfoDaoSpec.getSpec(curriculumInfo), pageable);//通过三个条件
        List<CurriculumDTO> curriculumDTOList = Curriculum2CurriculumDTOConverter.convert(curriculumInfoList.getContent());
        return new PageImpl<CurriculumDTO>(curriculumDTOList,pageable,curriculumInfoList.getTotalElements());

    }

    @Override
    public CurriculumDTO save(CurriculumDTO curriculumDTO) {
//      设置课程id
        String curriculumId = KeyUtil.genUniqueKey();

//      写入课程库
        CurriculumInfo curriculumInfo = new CurriculumInfo();
        BeanUtils.copyProperties(curriculumDTO, curriculumInfo);
        curriculumInfo.setCurriculumId(curriculumId);
//       因为DTO的信息没有那么全,所以需要自行补上,例如id需要自己添加
        curriculumInfoDao.save(curriculumInfo);
//      写入课程详情库
//        TODO 还需要判断详情具体的书记这些的条件是什么情况
        for (CurriculumDetail curriculumDetail : curriculumDTO.getCurriculumDetailList()) {
            curriculumDetail.setDetailId(KeyUtil.genUniqueKey());
            curriculumDetail.setCurriculumId(curriculumId);
            curriculumDetailDao.save(curriculumDetail);
        }

        return curriculumDTO;
    }

    @Override
    public CurriculumInfo onUsing(String curriculumId) {
        CurriculumInfo curriculumInfo = curriculumInfoDao.findOne(curriculumId);
        if (curriculumInfo == null) {
            throw new CurriculumException(ResultEnum.CURRICULUM_NO_FOUND);
        }
        if (curriculumInfo.getCurriculumStatusEnum() == CurriculumStatusEnum.UP) {
            throw new CurriculumException(ResultEnum.CURRICULUM_STATUS_ERROR);
        }

        //更新
        curriculumInfo.setCurriculumStatus(CurriculumStatusEnum.UP.getCode());
        return curriculumInfoDao.save(curriculumInfo);
    }

    @Override
    public CurriculumInfo offUsing(String curriculumId) {
        CurriculumInfo curriculumInfo = curriculumInfoDao.findOne(curriculumId);
        if (curriculumInfo == null) {
            throw new CurriculumException(ResultEnum.CURRICULUM_NO_FOUND);
        }
        if (curriculumInfo.getCurriculumStatusEnum() == CurriculumStatusEnum.DOWN) {
            throw new CurriculumException(ResultEnum.CURRICULUM_STATUS_ERROR);
        }

        //更新
        curriculumInfo.setCurriculumStatus(CurriculumStatusEnum.DOWN.getCode());
        return curriculumInfoDao.save(curriculumInfo);
    }
}
