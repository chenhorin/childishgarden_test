package net.codingtech.service;


import net.codingtech.form.portal.CourseForm;
import net.codingtech.pojo.CourseSelection;
import net.codingtech.dto.CourseSelectionDTO;

/**
 * 课程表的服务
 */
public interface ICourseSelectionService {


    /**
     * 按班级返回课表  当班级为空时，为私课 //需要考虑班级加其他人的情况吗?需要考虑的是不能是本班的学生
     * 这样查询个人的时候才不会重复
     *
     * @param courseForm
     * @return
     */
    CourseSelectionDTO findByClassIdOrChildIdOrUserId(CourseForm courseForm);

    /**
     * 查找单节课
     *
     * @param courseId
     * @return
     */
    CourseSelection findOne(String courseId);

    /**
     * 新增修改选课
     *
     * @param courseSelection
     * @return
     */
    // TODO 创建和修改是否需要分开?
    CourseSelection save(CourseSelection courseSelection);

    /**
     * 逻辑下线选课
     *
     * @param detailId
     * @return
     */
    CourseSelection offUsing(String detailId);

    /**
     * 上线选课
     *
     * @param detailId
     * @return
     */
    CourseSelection onUsing(String detailId);


}
