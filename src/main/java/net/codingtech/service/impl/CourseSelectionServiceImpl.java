package net.codingtech.service.impl;

import net.codingtech.convert.CourseSelection2CourseSelectionDTO;
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
    public CourseSelectionDTO findCourseByClassId(long courseTime,String classId) {
        List<CourseSelection> oneWeekByClassId = courseSelectionDao.findOneWeekByClassId(courseTime,classId);
        CourseSelectionDTO courseSelectionDTO = CourseSelection2CourseSelectionDTO.course2CourseDTO(oneWeekByClassId);
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
}
