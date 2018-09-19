package net.codingtech.controller.back;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.codingtech.VO.ResultVO;
import net.codingtech.common.enums.ResultEnum;
import net.codingtech.exception.CurriculumException;
import net.codingtech.form.back.CurriculumCategoryManageForm;
import net.codingtech.pojo.CurriculumCategory;
import net.codingtech.service.ICurriculumCategoryService;
import net.codingtech.utils.MyStringUtil;
import net.codingtech.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/manage/category")
@Api(tags = "Manage-Curriculum-Category",description = "后台-课程分类相关")
public class CurriculumCategoryManageController {

    @Autowired
    private ICurriculumCategoryService curriculumCategoryService;

    @ApiOperation(value = "管理员创建分类",notes = "根据相应规则创建分类")
    @PostMapping("/add")
    //新增分类 --初步使用ok
    public ResultVO addCategory(HttpSession session,@Valid CurriculumCategoryManageForm categoryForm,
                                BindingResult bindingResult){
        /*UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            throw  new CurriculumException(ResultEnum.NEED_LOGIN);
        }*/
        CurriculumCategory curriculumCategory = new CurriculumCategory();
        BeanUtils.copyProperties(categoryForm,curriculumCategory);

        String[] categoryFormCategoryElements = categoryForm.getCategoryElements();
        curriculumCategory.setCategoryElements(MyStringUtil.stringArray2StringConvert(categoryFormCategoryElements));

        if(curriculumCategoryService.addCategory(curriculumCategory) != null){
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(ResultEnum.CURRICULUM_CATEGORY_STATUS_ERROR);
    }

    @ApiOperation(value = "更新设置课分类", notes = "根据相应规则设置分类")
    @PostMapping("/set")
    //更新分类 --初步使用ok
    public ResultVO updateCategory(HttpSession session,@Valid CurriculumCategoryManageForm categoryForm,
                                    BindingResult bindingResult){
        /*UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            throw  new CurriculumException(ResultEnum.NEED_LOGIN);
        }*/
//        if(iUserService.checkAdminRole(user).isSuccess()){
//            //更新categoryName
//            return iCategoryService.updateCategoryName(categoryId,categoryName);
//        }else{
//            return ServerResponse.createByErrorMessage("无权限操作,需要管理员权限");
//        }
        CurriculumCategory curriculumCategory = new CurriculumCategory();
        if (categoryForm.getCategoryId() != null) {
            curriculumCategory = curriculumCategoryService.findOne(categoryForm.getCategoryId());
        } else {
            throw new CurriculumException(ResultEnum.CURRICULUM_CATEGORY_STATUS_ERROR);
        }
        BeanUtils.copyProperties(categoryForm, curriculumCategory);
//      字符串数组传化格式
        String[] categoryFormCategoryElements = categoryForm.getCategoryElements();
        curriculumCategory.setCategoryElements(MyStringUtil.stringArray2StringConvert(categoryFormCategoryElements));

        if(curriculumCategoryService.updateCategory(curriculumCategory) != null){
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(ResultEnum.CURRICULUM_CATEGORY_STATUS_ERROR);
    }

    //上架
    @GetMapping("/up")
    @ApiOperation(value = "分类上线使用",notes = "根据相应的规则将已下线的分类重新上线")
    public ResultVO onUsing(@RequestParam("categoryId") Integer curriculumCategoryId) {

        if (curriculumCategoryService.onUsing(curriculumCategoryId) != null)
            return ResultVOUtil.success();

        return ResultVOUtil.error(ResultEnum.CURRICULUM_CATEGORY_STATUS_ERROR);
    }

    //下架
    @GetMapping("/down")
    @ApiOperation(value = "分类下线",notes = "根据相应的规则分类下线")
    public ResultVO offUsing(@RequestParam("categoryId") Integer curriculumCategoryId) {

        if (curriculumCategoryService.offUsing(curriculumCategoryId) != null)
            return ResultVOUtil.success();

        return ResultVOUtil.error(ResultEnum.CURRICULUM_CATEGORY_STATUS_ERROR);
    }

    //查询子节点不递归
    @GetMapping("/getCategory")
    @ApiOperation(value = "查询分类下的叶子节点",notes ="查询分类下的叶子节点(不递归)")
    public ResultVO<List<CurriculumCategory>> getChildrenParallelCategory(HttpSession session, @RequestParam(value = "categoryId" ,defaultValue = "0") Integer categoryId){
//        User user = (User)session.getAttribute(Const.CURRENT_USER);
//        if(user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录");
//        }
//        if(iUserService.checkAdminRole(user).isSuccess()){
//            //查询子节点的category信息,并且不递归,保持平级
//            return iCategoryService.getChildrenParallelCategory(categoryId);
//        }else{
//            return ServerResponse.createByErrorMessage("无权限操作,需要管理员权限");
//        }
        return ResultVOUtil.success(curriculumCategoryService.findByParentId(categoryId));
    }

    //查询子节点递归
    @GetMapping("/getDeepCategory")
    @ApiOperation(value = "查询分类下的所有叶子节点",notes ="查询分类下的叶子节点(递归)")
    public ResultVO<List<CurriculumCategory>> getCategoryAndDeepChildrenCategory(HttpSession session,@RequestParam(value = "categoryId" ,defaultValue = "0") Integer categoryId) {
        return ResultVOUtil.success(curriculumCategoryService.getCategoryAndDeepChildrenCategory(categoryId));
    }
}
