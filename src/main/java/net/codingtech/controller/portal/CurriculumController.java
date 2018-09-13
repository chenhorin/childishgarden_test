package net.codingtech.controller.portal;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import net.codingtech.VO.ResultVO;
import net.codingtech.service.ICurriculumCategoryService;
import net.codingtech.service.ICurriculumService;
import net.codingtech.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/curriculum")
@Slf4j
public class CurriculumController {

    @Autowired
    private ICurriculumService curriculumService;

    @Autowired
    private ICurriculumCategoryService curriculumCategoryService;

    @RequestMapping("/list")
    public ResultVO<PageInfo> list(@RequestParam(value = "keyword",required = false)String keyword,
                                   @RequestParam(value = "categoryId",required = false)Integer categoryId,
                                   @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                   @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                   @RequestParam(value = "orderBy",defaultValue = "") String orderBy,
                                   @RequestParam(value = "curriculumProperty",required = false)Integer curriculumProperty,
                                   @RequestParam(value = "curriculumAge",required = false)String curriculumAge){
        return ResultVOUtil.success(curriculumService.getCurriculumByKeywordCategory(keyword,
                categoryId,pageNum,pageSize,orderBy,curriculumProperty,curriculumAge));
    }

    @RequestMapping("/detail")
    public ResultVO detail(String curriculumId){
        return ResultVOUtil.success(curriculumService.findOne(curriculumId));
    }

    @RequestMapping("/elements")
    public ResultVO ListElements(HttpSession session, @RequestParam(value = "parentId", defaultValue = "0") Integer parentId) {
        return ResultVOUtil.success(curriculumCategoryService.findCurriculumCategoryElement(parentId));
    }

    @RequestMapping("/tree")
    public ResultVO listTree(HttpSession session, @RequestParam(value = "parentId", defaultValue = "0") Integer parentId) {
        return ResultVOUtil.success(curriculumCategoryService.findCurriculumCategoryList(parentId));
    }
}
