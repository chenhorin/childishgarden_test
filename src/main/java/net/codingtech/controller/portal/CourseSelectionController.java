package net.codingtech.controller.portal;

import io.swagger.annotations.ApiOperation;
import net.codingtech.VO.ResultVO;
import net.codingtech.dto.CourseSelectionDTO;
import net.codingtech.form.portal.CourseForm;
import net.codingtech.service.ICourseSelectionService;
import net.codingtech.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseSelectionController {

    @Autowired
    ICourseSelectionService courseSelectionService;

    @ApiOperation(value="动态查询",notes = "第一个测试api")
    @GetMapping("/findByClassId")
    public ResultVO findByClassId(CourseForm courseForm) {
        return ResultVOUtil.success(courseSelectionService.findByClassIdOrChildIdOrUserId(courseForm));
    }
}
