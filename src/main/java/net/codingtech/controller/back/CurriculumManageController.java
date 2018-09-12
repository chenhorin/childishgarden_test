package net.codingtech.controller.back;


import net.codingtech.VO.ResultVO;
import net.codingtech.convert.CurriculumForm2DTOConverter;
import net.codingtech.dataobject.CurriculumInfo;
import net.codingtech.dto.CurriculumDTO;
import net.codingtech.form.portal.CurriculumForm;
import net.codingtech.service.CurriculumService;
import net.codingtech.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/manage/curriculum")
public class CurriculumManageController {

    @Autowired
    private CurriculumService curriculumService;

    @RequestMapping("/create")
    public ResultVO<Map<String,String>> productSave(HttpSession session, @Valid CurriculumForm curriculum,
                                BindingResult bindingResult) {
      /*  User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录管理员");

        }
        if(iUserService.checkAdminRole(user).isSuccess()){
            //填充我们增加产品的业务逻辑
            return iProductService.saveOrUpdateProduct(product);
        }else{
            return ServerResponse.createByErrorMessage("无权限操作");
        }*/
        CurriculumDTO createResult = curriculumService.save(CurriculumForm2DTOConverter.convert(curriculum));

        Map<String, String> map = new HashMap<>();
        map.put("curriculumId", createResult.getCurriculumId());
        return ResultVOUtil.success(map);
    }

    @RequestMapping("/list")
    public ResultVO list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                         @RequestParam(value = "size", defaultValue = "10") Integer size,
                         @RequestParam(value = "sort",defaultValue = "Sort.Direction.DESC") String sort) {
        PageRequest request = new PageRequest(page - 1, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        map.put("orderDTOPage", orderDTOPage);
        map.put("currentPage", page);
        map.put("size", size);
//        orderDTOPage.getTotalPages()
        return new ModelAndView("order/list", map);
    }
}
