package net.codingtech.dao;

import net.codingtech.dataobject.CurriculumCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurriculumCategoryDaoTest {

    @Autowired
    private CurriculumCategoryDao curriculumCategoryDao;

    @Test
    public void findOneTest() {
        CurriculumCategory curriculumCategory = curriculumCategoryDao.findOne(1);
        Assert.assertNotNull(curriculumCategory);
    }

    @Test
    public void savaTest() {
        CurriculumCategory curriculumCategory = curriculumCategoryDao.findOne(1);
        curriculumCategory.setCategoryName("个人和社会发展");
        CurriculumCategory result = curriculumCategoryDao.save(curriculumCategory);

        Assert.assertNotNull(result);
    }

    @Test
    public void findByParentId() {
        List<CurriculumCategory> categoryList = curriculumCategoryDao.findByParentId(1);
        Assert.assertNotNull(categoryList);
    }
}
