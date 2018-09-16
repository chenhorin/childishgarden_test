package net.codingtech.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.codingtech.common.enums.CourseSelectionStatusEnum;
import net.codingtech.common.enums.ResultEnum;
import net.codingtech.convert.CourseSelection2CourseSelectionDTOConverter;
import net.codingtech.dao.ChildInfoRepository;
import net.codingtech.dao.CourseSelectionRepository;
import net.codingtech.dao.CurriculumInfoRepository;
import net.codingtech.dto.CourseSelectionDTO;
import net.codingtech.exception.CurriculumException;
import net.codingtech.form.portal.CourseForm;
import net.codingtech.pojo.ChildInfo;
import net.codingtech.pojo.CourseSelection;
import net.codingtech.pojo.CurriculumInfo;
import net.codingtech.service.ICourseSelectionService;
import net.codingtech.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CourseSelectionServiceImpl implements ICourseSelectionService {


    @Autowired
    private CourseSelectionRepository courseSelectionRepository;

    @Autowired
    private CurriculumInfoRepository curriculumInfoRepository;

    @Autowired
    private ChildInfoRepository childInfoRepository;
    @Override
    //按班级查询课程
    public CourseSelectionDTO findByClassIdOrChildIdOrUserId(CourseForm courseForm) {
        List<CourseSelection> courseSelectionList = new ArrayList();

        CourseSelectionDTO courseSelectionDTO = new CourseSelectionDTO();
        if (courseForm.getUserId() != null) {
            courseSelectionList = courseSelectionRepository.findOneWeekByUserId(courseForm.getCourseTime(),
                    courseForm.getUserId(), CourseSelectionStatusEnum.UP.getCode());
            return CourseSelection2CourseSelectionDTOConverter.convert(courseSelectionList);

        }
        if (courseForm.getClassId() != null) {
            courseSelectionList = courseSelectionRepository.findOneWeekByClassId(courseForm.getCourseTime(),
                    courseForm.getClassId(), CourseSelectionStatusEnum.UP.getCode());
            return CourseSelection2CourseSelectionDTOConverter.convert(courseSelectionList);
        }
        if (courseForm.getChildId() != null) {
//            实体类缺少两个字段
//            学生的课是班级和私人的并集
            ChildInfo childInfo = childInfoRepository.findOne(courseForm.getChildId());
            List<CourseSelection> weekByClassId = courseSelectionRepository.findOneWeekByClassId(courseForm.getCourseTime(), childInfo.getClassId(),
                    CourseSelectionStatusEnum.UP.getCode());

            courseSelectionList = courseSelectionRepository.findOneWeekByChildId(courseForm.getCourseTime(),
                    courseForm.getChildId(), CourseSelectionStatusEnum.UP.getCode());

            for (CourseSelection courseByClass : weekByClassId) {
                courseSelectionList.add(courseByClass);
            }
            return CourseSelection2CourseSelectionDTOConverter.convert(courseSelectionList);
        } else throw new CurriculumException(ResultEnum.PARAM_ERROR);
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
