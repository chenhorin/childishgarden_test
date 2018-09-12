package net.codingtech.convert;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseSelection2CourseSelectionDTOConverterTest {

    private CourseSelection2CourseSelectionDTOConverter courseSelectionDTO = new CourseSelection2CourseSelectionDTOConverter();

    @Test

    public void course2CourseDTO() {
    }

    @Test
    public void dateToWeek() {
//        String toWeek = CourseSelection2CourseSelectionDTOConverter.dateToWeek(new Date());
//        Assert.assertNotEquals(null,toWeek);
//        System.out.println(CourseSelection2CourseSelectionDTOConverter.dateToWeek(new Date()));
    }
}