package net.codingtech.controller.portal;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.sun.org.apache.regexp.internal.REUtil;
import lombok.extern.slf4j.Slf4j;
import net.codingtech.VO.CurriculumCategoryTreeVO;
import net.codingtech.VO.ResultVO;
import net.codingtech.convert.CurriculumForm2DTOConverter;
import net.codingtech.dto.CurriculumDTO;
import net.codingtech.dto.DynamicConditionDTO;
import net.codingtech.form.back.CurriculumManageForm;
import net.codingtech.service.ICurriculumCategoryService;
import net.codingtech.service.ICurriculumService;
import net.codingtech.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/curriculum")
@Slf4j
public class CurriculumController {

    @Autowired
    private ICurriculumService iCurriculumService;

    @Autowired
    private ICurriculumCategoryService curriculumCategoryService;

    @RequestMapping("/save")
//    ok
    //课程保存，返回的是DTO对象，组合了课程详情，返回值得确定需要，和前端商定是否需要回调，还是只需要id
    public ResultVO<Map<String, String>> curriculumSave(HttpSession session, @Valid CurriculumManageForm curriculum,
                                                        BindingResult bindingResult) {
        CurriculumDTO createResult = iCurriculumService.save(CurriculumForm2DTOConverter.convert(curriculum));

        Map<String, String> map = new HashMap<>();
        map.put("curriculumId", createResult.getCurriculumId());
        return ResultVOUtil.success(map);
    }

    @RequestMapping("/list")
    //课程显示的筛选
//    ok
    public ResultVO<PageInfo> list(@RequestParam(value = "keyword", required = false) String keyword,
                                   @RequestParam(value = "categoryId", required = false) Integer categoryId,
                                   @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                   @RequestParam(value = "orderBy", defaultValue = "") String orderBy,
                                   @RequestParam(value = "curriculumProperty", required = false) Integer curriculumProperty,
                                   @RequestParam(value = "curriculumAge", required = false) String curriculumAge) {
        return ResultVOUtil.success(iCurriculumService.findCurriculumByKeywordCategoryIdPropertyAge(keyword,
                categoryId, pageNum, pageSize, orderBy, curriculumProperty, curriculumAge));
    }

    @RequestMapping("/tree")
    //课程筛选时的分类选择，区别于elements因为不会显示元素
//    ok
    public ResultVO<CurriculumCategoryTreeVO> listTree(HttpSession session, @RequestParam(value = "parentId", defaultValue = "0") Integer parentId) {
        return ResultVOUtil.success(curriculumCategoryService.findCurriculumCategoryList(parentId));
    }

    @RequestMapping("/detail")
    //课程详情展示的是课程新增和保存的数据，所以数据源需要一致返回的是CurriculumDTO
//    ok
    public ResultVO<CurriculumDTO> detail(String curriculumId) {
        return ResultVOUtil.success(iCurriculumService.findOne(curriculumId));
    }

    @RequestMapping("/elements")
    //创建课程的时候，显示元素，多选框在后代获取的是json数组需要，转化，展示需要分割转化
//    ok
    public ResultVO<CurriculumCategoryTreeVO> ListElements(HttpSession session, @RequestParam(value = "parentId", defaultValue = "0") Integer parentId) {
        return ResultVOUtil.success(curriculumCategoryService.findCurriculumCategoryElement(parentId));
    }

    @RequestMapping("/teacher")
    //应用场景，创建课程时需要，遍历
//    ok
    public ResultVO<List<DynamicConditionDTO>> getTeacherList(String campId) {
        return ResultVOUtil.success(iCurriculumService.findTeacherList(campId));
    }

    @RequestMapping("/age")
    //应用场景，创建课程时需要，遍历
//    ok
    public ResultVO<List<DynamicConditionDTO>> getTeacherList() {
        return ResultVOUtil.success(iCurriculumService.findCurriculumAge());
//        return ResultVOUtil.success(null);测试json 返回null
    }

    @RequestMapping("/property")
    //应用场景1：创建更改课程时
    //应用场景2：课程查询时的选择借口
    // 涉及到枚举值的转化问题
// ok
    public ResultVO<List> getPropertiesList() {
        List properties = new ArrayList<>();

        //map只对应着一个值所以，如果放在数组中所有的元素都会一样
        HashMap<Object, Object> map1 = Maps.newHashMap();
        map1.put("propertyId", 0);
        map1.put("propertyName", "室内课");
        properties.add(map1);

        HashMap<Object, Object> map2 = Maps.newHashMap();
        map2.put("property", 1);
        map2.put("propertyName", "室外活动");
        properties.add(map2);
        return ResultVOUtil.success(properties);
    }

    @RequestMapping("/difficulty")
    //应用场景1：创建更改课程时
    //应用场景2：课程查询时的选择借口
    // 涉及到枚举值的转化问题
//    ok
    public ResultVO<List> getDifficulty() {
        List properties = new ArrayList<>();

        //map只对应着一个值所以，如果放在数组中所有的元素都会一样
        HashMap<Object, Object> map1 = Maps.newHashMap();
        map1.put("difficultyId", 0);
        map1.put("difficultyGrade", "入门");
        properties.add(map1);

        HashMap<Object, Object> map2 = Maps.newHashMap();
        map2.put("difficultyId", 1);
        map2.put("difficultyGrade", "困难");
        properties.add(map2);
        return ResultVOUtil.success(properties);
    }
}
 /* @RequestMapping("/dynamic_list")
    //不是按条件查询，而是遍历，按老师，难度，适合年龄返回Id,name
    public ResultVO createListOnTeacherCurriAgeCurriDifficulty(DynamicConditionForm dynamicConditionForm) {
        DynamicConditionDTO dynamicConditionDTO = new DynamicConditionDTO();
        BeanUtils.copyProperties(dynamicConditionForm,dynamicConditionDTO);
        return ResultVOUtil.success(iCurriculumService.getByDynamicCondition(dynamicConditionDTO));
    }*/