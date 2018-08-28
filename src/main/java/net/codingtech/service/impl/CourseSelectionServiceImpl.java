package net.codingtech.service.impl;

import net.codingtech.convert.CourseSelection2CourseSelectionDTOConverter;
import net.codingtech.dao.CourseSelectionDao;
import net.codingtech.dao.CurriculumInfoDao;
import net.codingtech.dataobject.CourseSelection;
import net.codingtech.dataobject.CurriculumInfo;
import net.codingtech.dto.CourseSelectionDTO;
import net.codingtech.enums.CourseSelectionStatusEnum;
import net.codingtech.enums.CurriculumStatusEnum;
import net.codingtech.enums.ResultEnum;
import net.codingtech.exception.CurriculumException;
import net.codingtech.service.CourseSelectionService;
import net.codingtech.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseSelectionServiceImpl implements CourseSelectionService {


    @Autowired
    private CourseSelectionDao courseSelectionDao;

    @Autowired
    private CurriculumInfoDao curriculumInfoDao;

    @Override
    //按班级查询课程
    public CourseSelectionDTO findCourseByClassId(long courseTime, String classId) {
        List<CourseSelection> oneWeekByClassId = courseSelectionDao.findOneWeekByClassId(courseTime, classId, CurriculumStatusEnum.UP.getCode());
        CourseSelectionDTO courseSelectionDTO = CourseSelection2CourseSelectionDTOConverter.convert(oneWeekByClassId);
        return courseSelectionDTO;
    }

    @Override
    public CourseSelectionDTO findCourseByChildId(long courseTime, String childId) {
        return null;
    }

    @Override
    //按老师查询课程
    public CourseSelectionDTO findCourseByUserId(long courseTime, String useId) {
        return null;
    }

    @Override
    public CourseSelection findOne(String courseId) {
        CourseSelection courseSelection = courseSelectionDao.findOne(courseId);
        if (courseSelection == null) {
            throw new CurriculumException(ResultEnum.COURSE_SELECTION_NOT_EXIST);
        }
        return courseSelection;
    }

    @Override
    public CourseSelection save(CourseSelection courseSelection) {
//        需要判断前端选择了哪些数据?用户/前台给的数据,课程id,班级id,需要上小课的孩子,上课地址,上课时间,第几节课,创建老师的id
        String courseId = KeyUtil.genUniqueKey();
        CurriculumInfo curriculumInfo = curriculumInfoDao.findOne(courseSelection.getCurriculumId());
//      校验放在form认证中
        if (curriculumInfo == null) {
            throw new CurriculumException(ResultEnum.CURRICULUM_NO_FOUND);
        }
        courseSelection.setDetailId(courseId);
        courseSelection.setCurriculumName(curriculumInfo.getCurriculumName());
        return courseSelectionDao.save(courseSelection);
    }

    @Override
    public CourseSelection offUsing(String detailId) {
        CourseSelection courseSelection = courseSelectionDao.findOne(detailId);
        //非空判断
        if (courseSelection == null) {
            throw new CurriculumException(ResultEnum.COURSE_SELECTION_NOT_EXIST);
        }
        //状态判断
        if (courseSelection.getCourseStatus() == CourseSelectionStatusEnum.DOWN.getCode()) {
            throw new CurriculumException(ResultEnum.COURSE_SELECTION_ERROR);
        }
        //更新
        courseSelection.setCourseStatus(CourseSelectionStatusEnum.UP.getCode());
        return courseSelectionDao.save(courseSelection);
    }

    @Override
    public CourseSelection onUsing(String detailId) {
        CourseSelection courseSelection = courseSelectionDao.findOne(detailId);
        if (courseSelection == null) {
            throw new CurriculumException(ResultEnum.COURSE_SELECTION_NOT_EXIST);
        }
        if (courseSelection.getCourseStatus() == CourseSelectionStatusEnum.UP.getCode()) {
            throw new CurriculumException(ResultEnum.COURSE_SELECTION_ERROR);
        }
        //更新
        courseSelection.setCourseStatus(CourseSelectionStatusEnum.UP.getCode());
        return courseSelectionDao.save(courseSelection);
    }
}
