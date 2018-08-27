package net.codingtech.service.impl;

import net.codingtech.convert.Curriculum2CurriculumDTOConverter;
import net.codingtech.dao.CurriculumDetailDao;
import net.codingtech.dao.CurriculumInfoDao;
import net.codingtech.dataobject.CurriculumDetail;
import net.codingtech.dataobject.CurriculumInfo;
import net.codingtech.dto.CurriculumDTO;
import net.codingtech.service.CurriculumService;
import net.codingtech.specification.TestCurriculumInfoDaoSpec;
import net.codingtech.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * @program: childishgarden_test
 * @description:
 * @author: hongren
 * @create: 2018-08-14 17:15
 **/
@Service
public class CurriculumServiceImpl implements CurriculumService {

    @Autowired
    private CurriculumInfoDao curriculumInfoDao;

    @Autowired
    private CurriculumDetailDao curriculumDetailDao;


    @Override
    public CurriculumDTO findOne(String curriculumId) {
        return null;
    }

    @Override
    public Page<CurriculumDTO> findUpAll(Pageable pageable) {
        return null;
    }

    @Override
    public Page<CurriculumDTO> findList(Pageable pageable) {
        return null;
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
        String curriculumId = KeyUtil.genUniqueKey();

//      写入课程库
        CurriculumInfo curriculumInfo = new CurriculumInfo();
        curriculumInfo.setCurriculumId(curriculumId);
        BeanUtils.copyProperties(curriculumDTO, curriculumInfo);
//      写入课程详情库
        for (CurriculumDetail curriculumDetail : curriculumDTO.getCurriculumDetailList()) {
            curriculumDetail.setDetailId(KeyUtil.genUniqueKey());
            curriculumDetail.setCurriculumId(curriculumId);
            curriculumDetailDao.save(curriculumDetail);
        }

        curriculumInfoDao.save(curriculumInfo);

        return curriculumDTO;
    }

    @Override
    public CurriculumDTO onUsing(String curriculumId) {
        return null;
    }

    @Override
    public CurriculumDTO offUsing(String curriculumId) {
        return null;
    }
}
