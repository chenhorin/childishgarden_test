package net.codingtech.controller.portal;

import lombok.extern.slf4j.Slf4j;
import net.codingtech.service.ICurriculumCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: childishgarden_test
 * @description: 课程分类管理api
 * @author: hongren
 * @create: 2018-08-14 16:41
 **/

@RestController
@RequestMapping("/curriculum")
@Slf4j
public class CurriculumCategoryController {

    @Autowired
     private ICurriculumCategoryService curriculumCategoryService;

    //TODO
    /*@GetMapping("/category")
    public List<CurriculumCategoryTreeVO> getCurriculumCategoryList(@RequestParam(name = "id", defaultValue = "0") Integer parentId) {
        return curriculumCategoryService.findCurriculumCategoryList(parentId);
    }*/
}
