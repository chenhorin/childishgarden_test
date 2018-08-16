package net.codingtech.service.impl;

import net.codingtech.dao.CurriculumInfoDao;
import net.codingtech.dataobject.CurriculumInfo;
import net.codingtech.service.CurriculumService;
import net.codingtech.specification.TestCurriculumInfoDaoSpec;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public List<CurriculumInfo> findByCategoryId(Integer id) {
//        curriculumInfoDao.
        return null;
    }

    @Override
    public List<CurriculumInfo> findByDynamicCases(CurriculumInfo curriculumInfo) {

        List<CurriculumInfo> curriculumInfoList = curriculumInfoDao.findAll(TestCurriculumInfoDaoSpec.getSpec(curriculumInfo));//通过三个条件
        return curriculumInfoList;

    }
}
