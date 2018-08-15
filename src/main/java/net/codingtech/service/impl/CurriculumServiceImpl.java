package net.codingtech.service.impl;

import net.codingtech.dao.CurriculumInfoDao;
import net.codingtech.dataobject.CurriculumInfo;
import net.codingtech.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
