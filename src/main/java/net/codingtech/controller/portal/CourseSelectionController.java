package net.codingtech.controller.portal;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.codingtech.VO.ResultVO;
import net.codingtech.dto.CourseSelectionDTO;
import net.codingtech.form.portal.CourseForm;
import net.codingtech.service.ICourseSelectionService;
import net.codingtech.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
@Api(tags = "Portal-CourseSelect",description = "前台-排课表相关")
public class CourseSelectionController {

    @Autowired
    ICourseSelectionService courseSelectionService;

    @ApiOperation(value="动态查询",notes = "根据班级id,用户Id,学生Id动态查询选课表,以周为单位")
    @GetMapping("/findByClassId")
//    Ok
    public ResultVO<CourseSelectionDTO> findByClassId(CourseForm courseForm) {
        return ResultVOUtil.success(courseSelectionService.findByClassIdOrChildIdOrUserId(courseForm));
    }
}
