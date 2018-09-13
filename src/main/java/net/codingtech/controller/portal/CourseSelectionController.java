package net.codingtech.controller.portal;

import io.swagger.annotations.ApiOperation;
import net.codingtech.dto.CourseSelectionDTO;
import net.codingtech.service.ICourseSelectionService;
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

    @ApiOperation(value="一个测试API",notes = "第一个测试api")
    @GetMapping("/findByClassId")
    public CourseSelectionDTO findByClassId( @RequestParam("weekTime") long courseTime, @RequestParam("classId") String classId) {

        return  courseSelectionService.findCourseByClassId(courseTime,classId);
//        return  courseSelectionService.findCourseByClassId(Long.parseLong(courseTime),classId);
    }
}
