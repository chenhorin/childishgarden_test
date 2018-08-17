package net.codingtech.convert;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseSelection2CourseSelectionDTOTest {

    private CourseSelection2CourseSelectionDTO courseSelectionDTO = new CourseSelection2CourseSelectionDTO();

    @Test

    public void course2CourseDTO() {
    }

    @Test
    public void dateToWeek() {
        String toWeek = CourseSelection2CourseSelectionDTO.dateToWeek(new Date());
        Assert.assertNotEquals(null,toWeek);
        System.out.println(CourseSelection2CourseSelectionDTO.dateToWeek(new Date()));
    }
}