package net.codingtech.dao;

import net.codingtech.dataobject.CourseSelection;
import net.codingtech.enums.CurriculumStatusEnum;
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
    public void findOneWeekByClassId() {
        List<CourseSelection> result = courseSelectionDao.findOneWeekByClassId(1534867200,"02", CurriculumStatusEnum.UP.getCode());
        Assert.assertNotEquals(0, result.size() );
    }

    @Test
    public void findOneWeekByUserId() {
        List<CourseSelection> result = courseSelectionDao.findOneWeekByChildId(1534867200,"01",CurriculumStatusEnum.UP.getCode());
        Assert.assertNotEquals(0, result.size() );
    }

    @Test
    public void findOneWeekByChildId() {
        List<CourseSelection> result = courseSelectionDao.findOneWeekByUserId(1534867200,"01",CurriculumStatusEnum.UP.getCode());
        Assert.assertNotEquals(0, result.size() );
    }
}