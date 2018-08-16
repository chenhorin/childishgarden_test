package net.codingtech.dao;

import net.codingtech.dataobject.CourseSelection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @program: childishgarden_test
 * @description: 选课dao
 * @author: hongren
 * @create: 2018-08-13 16:27
 **/
public interface CourseSelectionDao extends JpaRepository<CourseSelection,String> {

    @Query(value = "SELECT * FROM course_selection WHERE WEEKOFYEAR(course_day) " +
            "= WEEKOFYEAR(FROM_UNIXTIME(:time ,'%y-%m-%d')); ",nativeQuery = true)
    List<CourseSelection> findOneWeekByNow(@Param("time") long timestamp);
}
