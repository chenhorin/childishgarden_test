package net.codingtech.service.impl;

import net.codingtech.convert.CourseSelection2CourseSelectionDTOConverter;
import net.codingtech.dao.CourseSelectionRepository;
import net.codingtech.dao.CurriculumInfoRepository;
import net.codingtech.pojo.CourseSelection;
import net.codingtech.pojo.CurriculumInfo;
import net.codingtech.dto.CourseSelectionDTO;
import net.codingtech.common.enums.CourseSelectionStatusEnum;
import net.codingtech.common.enums.CurriculumStatusEnum;
import net.codingtech.common.enums.ResultEnum;
import net.codingtech.exception.CurriculumException;
import net.codingtech.service.ICourseSelectionService;
import net.codingtech.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseSelectionServiceImpl implements ICourseSelectionService {


    @Autowired
    private CourseSelectionRepository courseSelectionRepository;

    @Autowired
    private CurriculumInfoRepository curriculumInfoRepository;

    @Override
    //按班级查询课程
    public CourseSelectionDTO findCourseByClassId(long courseTime, String classId) {
        List<CourseSelection> oneWeekByClassId = courseSelectionRepository.findOneWeekByClassId(courseTime, classId, CurriculumStatusEnum.UP.getCode());
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
        CourseSelection courseSelection = courseSelectionRepository.findOne(courseId);
        if (courseSelection == null) {
            throw new CurriculumException(ResultEnum.COURSE_SELECTION_NOT_EXIST);
        }
        return courseSelection;
    }

    @Override
    public CourseSelection save(CourseSelection courseSelection) {
//        需要判断前端选择了哪些数据?用户/前台给的数据,课程id,班级id,需要上小课的孩子,上课地址,上课时间,第几节课,创建老师的id
        String courseId = KeyUtil.genUniqueKey();
        CurriculumInfo curriculumInfo = curriculumInfoRepository.findOne(courseSelection.getCurriculumId());
//      校验放在form认证中
        if (curriculumInfo == null) {
            throw new CurriculumException(ResultEnum.CURRICULUM_NO_FOUND);
        }
        courseSelection.setDetailId(courseId);
        courseSelection.setCurriculumName(curriculumInfo.getCurriculumName());
        return courseSelectionRepository.save(courseSelection);
    }

    @Override
    public CourseSelection offUsing(String detailId) {
        CourseSelection courseSelection = courseSelectionRepository.findOne(detailId);
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
        return courseSelectionRepository.save(courseSelection);
    }

    @Override
    public CourseSelection onUsing(String detailId) {
        CourseSelection courseSelection = courseSelectionRepository.findOne(detailId);
        if (courseSelection == null) {
            throw new CurriculumException(ResultEnum.COURSE_SELECTION_NOT_EXIST);
        }
        if (courseSelection.getCourseStatus() == CourseSelectionStatusEnum.UP.getCode()) {
            throw new CurriculumException(ResultEnum.COURSE_SELECTION_ERROR);
        }
        //更新
        courseSelection.setCourseStatus(CourseSelectionStatusEnum.UP.getCode());
        return courseSelectionRepository.save(courseSelection);
    }
}
