package net.codingtech.controller.back;

import net.codingtech.VO.ResultVO;
import net.codingtech.common.config.Const;
import net.codingtech.common.enums.ResultEnum;
import net.codingtech.pojo.CurriculumCategory;
import net.codingtech.pojo.UserInfo;
import net.codingtech.exception.CurriculumException;
import net.codingtech.form.back.CurriculumManageForm;
import net.codingtech.service.ICurriculumCategoryService;
import net.codingtech.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequestMapping("/manage/category")
public class CurriculumCategoryManageController {

    @Autowired
    private ICurriculumCategoryService curriculumCategoryService;


    @RequestMapping("/add")
    //新增分类
    public ResultVO addCategory(HttpSession session,@Valid CurriculumManageForm categoryForm,
                                BindingResult bindingResult){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            throw  new CurriculumException(ResultEnum.NEED_LOGIN);
        }
        CurriculumCategory curriculumCategory = new CurriculumCategory();
        BeanUtils.copyProperties(categoryForm,curriculumCategory);
        if(curriculumCategoryService.addCategory(curriculumCategory) != null){
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(ResultEnum.CURRICULUM_CATEGORY_STATUS_ERROR);
    }

    @RequestMapping("/set")
    //更新分类
    public ResultVO updateCategory(HttpSession session,@Valid CurriculumManageForm categoryForm,
                                    BindingResult bindingResult){
        UserInfo user = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            throw  new CurriculumException(ResultEnum.NEED_LOGIN);
        }
//        if(iUserService.checkAdminRole(user).isSuccess()){
//            //更新categoryName
//            return iCategoryService.updateCategoryName(categoryId,categoryName);
//        }else{
//            return ServerResponse.createByErrorMessage("无权限操作,需要管理员权限");
//        }
        CurriculumCategory curriculumCategory = null;
        if (categoryForm.getCategoryId() != null) {
            curriculumCategory = curriculumCategoryService.findOne(categoryForm.getCategoryId());
        } else {
            throw new CurriculumException(ResultEnum.CURRICULUM_CATEGORY_STATUS_ERROR);
        }
        BeanUtils.copyProperties(categoryForm,curriculumCategory);
        if(curriculumCategoryService.updateCategory(curriculumCategory) != null){
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(ResultEnum.CURRICULUM_CATEGORY_STATUS_ERROR);
    }

    //上架
    @RequestMapping("/up")
    public ResultVO onUsing(@RequestParam("categoryId") Integer curriculumCategoryId) {

        if (curriculumCategoryService.onUsing(curriculumCategoryId) != null)
            return ResultVOUtil.success();

        return ResultVOUtil.error(ResultEnum.CURRICULUM_CATEGORY_STATUS_ERROR);
    }

    //下架
    @RequestMapping("/down")
    public ResultVO offUsing(@RequestParam("categoryId") Integer curriculumCategoryId) {

        if (curriculumCategoryService.offUsing(curriculumCategoryId) != null)
            return ResultVOUtil.success();

        return ResultVOUtil.error(ResultEnum.CURRICULUM_CATEGORY_STATUS_ERROR);
    }

    //查询子节点不递归
    @RequestMapping("/getCategory")
    public ResultVO getChildrenParallelCategory(HttpSession session,@RequestParam(value = "categoryId" ,defaultValue = "0") Integer categoryId){
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
        return ResultVOUtil.success(curriculumCategoryService.findAllSonCategory());
    }

    //查询子节点递归
    @RequestMapping("/getDeepCategory")
    public ResultVO getCategoryAndDeepChildrenCategory(HttpSession session,@RequestParam(value = "categoryId" ,defaultValue = "0") Integer categoryId) {
        return ResultVOUtil.success(curriculumCategoryService.getCategoryAndDeepChildrenCategory(categoryId));
    }
}
