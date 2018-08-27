package net.codingtech.service;


import net.codingtech.dataobject.CourseSelection;
import net.codingtech.dto.CourseSelectionDTO;

/**
 * 课程表的服务
 */
public interface CourseSelectionService {

    //按班级返回课表  当班级为空时，为私课
   CourseSelectionDTO findCourseByClassId(long courseTime,String classId);

    //按个人返回课表   班级课表加私课
    CourseSelectionDTO findCourseByChildId(long courseTime,String childId);

    //按老师返回课表
    CourseSelectionDTO findCourseByUserId(long courseTime,String useId);

    //查找单个选课信息
    CourseSelection findOne(String courseId);

    //增加修改
    CourseSelection save(CourseSelection courseSelection);

    //删除,可以直接删除吗?逻辑删除.
    void delete(CourseSelection courseSelection);


}
