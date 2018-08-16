package net.codingtech.dao;

import net.codingtech.dataobject.CourseSelection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseSelectionDaoTest {

    @Autowired
    CourseSelectionDao courseSelectionDao;

    @Test
    public void findOneWeekByNow() {
        List<CourseSelection> result = courseSelectionDao.findOneWeekByNow(1535619647);
        Assert.assertNotEquals(0, result.size());
    }
}