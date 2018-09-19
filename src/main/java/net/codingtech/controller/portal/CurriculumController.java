package net.codingtech.controller.portal;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.codingtech.VO.CurriculumCategoryTreeVO;
import net.codingtech.VO.CurriculumListVO;
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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/curriculum")
@Slf4j
@Api(tags = "Portal-Curriculum",description = "前台-课程相关")
public class CurriculumController {

    @Autowired
    private ICurriculumService iCurriculumService;

    @Autowired
    private ICurriculumCategoryService curriculumCategoryService;

    @PostMapping("/save")
//    ok
    //课程保存，返回的是DTO对象，组合了课程详情，返回值得确定需要，和前端商定是否需要回调，还是只需要id
    @ApiOperation(notes = "根据相应的规则和条件动态的,新建和更新在线课程",value = "新建和更新课程")
    public ResultVO<Map<String, String>> curriculumSave(HttpSession session, @Valid CurriculumManageForm curriculum,
                                                        BindingResult bindingResult) {
        CurriculumDTO createResult = iCurriculumService.save(CurriculumForm2DTOConverter.convert(curriculum));

        Map<String, String> map = new HashMap<>();
        map.put("curriculumId", createResult.getCurriculumId());
        return ResultVOUtil.success(map);
    }

    @GetMapping("/list")
    //课程显示的筛选
//    ok
    @ApiOperation(notes = "根据课程关键字、分类id、室内外课属性、适应年龄、实现动态排序*排序条件为创建时间",value = "按条件显示在线课程")
    public ResultVO<PageInfo<List<CurriculumListVO>>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                           @RequestParam(value = "categoryId", required = false) Integer categoryId,
                                                           @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                                           @RequestParam(value = "orderBy", defaultValue = "") String orderBy,
                                                           @RequestParam(value = "curriculumProperty", required = false) Integer curriculumProperty,
                                                           @RequestParam(value = "curriculumAge", required = false) String curriculumAge) {
        return  ResultVOUtil.success(iCurriculumService.findCurriculumByKeywordCategoryIdPropertyAge(keyword,
                categoryId, pageNum, pageSize, orderBy, curriculumProperty, curriculumAge));
    }

    @GetMapping("/tree")
    //课程筛选时的分类选择，区别于elements因为不会显示元素
//    ok
    @ApiOperation(notes = "根据父节点id显示所有子节点的Id",value = "分类树的筛选显示")
    public ResultVO<CurriculumCategoryTreeVO> listTree(HttpSession session, @RequestParam(value = "parentId", defaultValue = "0") Integer parentId) {
        return ResultVOUtil.success(curriculumCategoryService.findCurriculumCategoryList(parentId));
    }

    @GetMapping("/detail")
    @ApiOperation(value = "课程详情",notes = "根据课程Id显示课程的详情状况")
    //课程详情展示的是课程新增和保存的数据，所以数据源需要一致返回的是CurriculumDTO
//    ok
    public ResultVO<CurriculumDTO> detail(String curriculumId) {
        return ResultVOUtil.success(iCurriculumService.findOne(curriculumId));
    }

    @GetMapping("/elements")
    @ApiOperation(value = "分类选择（筛选元素）",notes = "创建更新课程时，筛选元素")
    //创建课程的时候，显示元素，多选框在后代获取的是json数组需要，转化，展示需要分割转化
//    ok
    public ResultVO<CurriculumCategoryTreeVO> ListElements(HttpSession session, @RequestParam(value = "parentId", defaultValue = "0") Integer parentId) {
        return ResultVOUtil.success(curriculumCategoryService.findCurriculumCategoryElement(parentId));
    }

    @GetMapping("/teacher")
    //应用场景，创建课程时需要，遍历
//    ok
    @ApiOperation(value = "显示老师列表）",notes = "根据校区id显示所有该校区所有在校老师的id，" +
            "输入参数为动态对象，其他的属性无需注入")
    public ResultVO<List<DynamicConditionDTO>> getTeacherList(String campId) {
        return ResultVOUtil.success(iCurriculumService.findTeacherList(campId));
    }

    @GetMapping("/age")
    //应用场景，创建课程时需要，遍历
//    ok
    @ApiOperation(value = "显示课程的年龄区间",notes = "显示课程的年龄区间方便筛选，应用在课程搜索和创建更新中")
    public ResultVO<List<DynamicConditionDTO>> getTeacherList() {
        return ResultVOUtil.success(iCurriculumService.findCurriculumAge());
//        return ResultVOUtil.success(null);测试json 返回null
    }

    @GetMapping("/property")
    //应用场景1：创建更改课程时
    //应用场景2：课程查询时的选择借口
    // 涉及到枚举值的转化问题
// ok
    @ApiOperation(value = "显示室内外属性",notes = "显示课程室内外，应用在课程搜索和创建更新中")
    public ResultVO<List<Map<String,String>>> getPropertiesList() {
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

    @GetMapping("/difficulty")
    //应用场景1：创建更改课程时
    //应用场景2：课程查询时的选择借口
    // 涉及到枚举值的转化问题
//    ok
    @ApiOperation(value = "显示课程所有难度",notes = "显示课程难度系数，应用在课程创建更新中")
    public ResultVO<List<Map<String,String>>> getDifficulty() {
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