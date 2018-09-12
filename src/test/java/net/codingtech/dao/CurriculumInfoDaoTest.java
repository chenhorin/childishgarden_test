package net.codingtech.dao;

import net.codingtech.dataobject.CurriculumInfo;
import net.codingtech.common.enums.CurriculumStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurriculumInfoDaoTest {

    @Autowired
    CurriculumInfoDao curriculumInfoDao;

    @Test
    public void findByCategoryId() {
        List<CurriculumInfo> curriculumInfoList = curriculumInfoDao.findByCategoryId(3);
        Assert.assertNotEquals(0, curriculumInfoList.size());
    }

    @Test
    public void findByCurriculumStatus() {
        List<CurriculumInfo> curriculumInfoList = curriculumInfoDao.findByCurriculumStatus(CurriculumStatusEnum.UP.getCode());
        assertNotEquals(0,curriculumInfoList.size());
    }
}