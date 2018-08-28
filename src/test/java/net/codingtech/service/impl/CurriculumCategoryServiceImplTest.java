package net.codingtech.service.impl;

import net.codingtech.VO.CurriculumCategoryTreeVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurriculumCategoryServiceImplTest {

    @Autowired
    CurriculumCategoryServiceImpl categoryService;

    @Test
    public void findOne() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findByCategoryIdIn() {
    }

    @Test
    public void findCurriculumCategoryList() {
       /* List<CurriculumCategoryTreeVO> curriculumCategoryList = categoryService.findCurriculumCategoryList(1);
        Assert.assertNotEquals(0, curriculumCategoryList.size());*/
    }
}