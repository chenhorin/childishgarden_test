package net.codingtech.service.impl;

import net.codingtech.convert.CourseSelection2CourseSelectionDTOConverter;
import net.codingtech.dao.CourseSelectionDao;
import net.codingtech.dataobject.CourseSelection;
import net.codingtech.dto.CourseSelectionDTO;
import net.codingtech.service.CourseSelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseSelectionServiceImpl implements CourseSelectionService {


    @Autowired
    private CourseSelectionDao courseSelectionDao;

    @Override
    //按班级查询课程
    public CourseSelectionDTO findCourseByClassId(long courseTime,String classId) {
        List<CourseSelection> oneWeekByClassId = courseSelectionDao.findOneWeekByClassId(courseTime,classId);
        CourseSelectionDTO courseSelectionDTO = CourseSelection2CourseSelectionDTOConverter.convert(oneWeekByClassId);
        return courseSelectionDTO;
    }

    @Override
    public CourseSelectionDTO findCourseByChildId(long courseTime,String childId) {
        return null;
    }

    @Override
    public CourseSelectionDTO findCourseByUserId(long courseTime,String useId) {
        return null;
    }

    @Override
    public CourseSelection findOne(String courseId) {
        return null;
    }

    @Override
    public CourseSelection save(CourseSelection courseSelection) {
        return null;
    }

    @Override
    public void delete(CourseSelection courseSelection) {

    }
}
