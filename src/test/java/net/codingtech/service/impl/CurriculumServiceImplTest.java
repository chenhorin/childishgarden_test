package net.codingtech.service.impl;

import net.codingtech.dataobject.CurriculumInfo;
import net.codingtech.service.CurriculumService;
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
public class CurriculumServiceImplTest {

    @Autowired
    CurriculumService curriculumService;


    @Test
    public void findByCategoryId() {
    }

    @Test
    public void findByDynamicCases() {
        CurriculumInfo curriculumInfo = new CurriculumInfo();
        curriculumInfo.setCurriculumProperty(0);
        List<CurriculumInfo> curriculumInfoList = curriculumService.findByDynamicCases(curriculumInfo);
        Assert.assertNotEquals(0, curriculumInfoList.size());
    }
}