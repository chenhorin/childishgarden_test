package net.codingtech.dao;

import net.codingtech.pojo.CourseSelection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @program: childishgarden_test
 * @description: 选课dao
 * @author: hongren
 * @create: 2018-08-13 16:27
 **/
public interface CourseSelectionRepository extends JpaRepository<CourseSelection, String> {


    //班级查询
    @Query(value = "SELECT detail_id, curriculum_id, curriculum_name, user_id, user_name, class_id, class_name," +
            "child_id, classroom, course_day, course_num, course_status, create_time, update_time " +
            "FROM course_selection c " +
            "WHERE WEEKOFYEAR(course_day)" +
            "=WEEKOFYEAR(FROM_UNIXTIME(?1,'%y-%m-%d')) and class_id=?2 and course_status=?3", nativeQuery = true)
    List<CourseSelection> findOneWeekByClassId(long time, String classId, Integer courseStatus);

    //老师查询
    @Query(value = "SELECT detail_id, curriculum_id, curriculum_name, user_id, user_name, class_id, class_name," +
            "child_id, classroom, course_day, course_num, course_status, create_time, update_time " +
            "FROM course_selection c " +
            "WHERE WEEKOFYEAR(course_day)" +
            "=WEEKOFYEAR(FROM_UNIXTIME(?1,'%y-%m-%d')) and user_id=?2 and course_status=?3", nativeQuery = true)
    List<CourseSelection> findOneWeekByUserId(long time, String userId, Integer courseStatus);

    //个人查询
    //TODO 个人查询
    @Query(value = "SELECT detail_id, curriculum_id, curriculum_name, user_id, user_name, class_id, class_name," +
            "child_id, classroom, course_day, course_num, course_status, create_time, update_time " +
            "FROM course_selection c " +
            "WHERE WEEKOFYEAR(course_day)" +
            "=WEEKOFYEAR(FROM_UNIXTIME(?1,'%y-%m-%d')) and class_id=?2 and course_status=?3", nativeQuery = true)
    List<CourseSelection> findOneWeekByChildId(long time, String childId, Integer courseStatus);

}
