package net.codingtech.controller.back;


import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import net.codingtech.VO.CurriculumDetailVO;
import net.codingtech.VO.ResultVO;
import net.codingtech.convert.CurriculumForm2DTOConverter;
import net.codingtech.dto.CurriculumDTO;
import net.codingtech.form.back.CurriculumManageForm;
import net.codingtech.pojo.CurriculumInfo;
import net.codingtech.service.ICurriculumService;
import net.codingtech.service.IFileService;
import net.codingtech.utils.PropertiesUtil;
import net.codingtech.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/manage/curriculum")
public class CurriculumManageController {

    @Autowired
    private ICurriculumService iCurriculumService;

    @Autowired
    private IFileService iFileService;

    @RequestMapping("/save")
    //后台的新增和保存
    public ResultVO<Map<String, String>> curriculumSave(HttpSession session, @Valid CurriculumManageForm curriculum,
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
        CurriculumDTO createResult = iCurriculumService.save(CurriculumForm2DTOConverter.convert(curriculum));

        Map<String, String> map = new HashMap<>();
        map.put("curriculumId", createResult.getCurriculumId());
        return ResultVOUtil.success(map);
    }

    @RequestMapping("/detail")
    public ResultVO<CurriculumDetailVO> getDetail(HttpSession session, String productId) {
        return ResultVOUtil.success(iCurriculumService.manageCurriculumDetail(productId));
    }

    @RequestMapping("/list")
    //返回curriculumListVOList的分页对象
    protected ResultVO<PageInfo> list(HttpSession session, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                      @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        return ResultVOUtil.success(iCurriculumService.manageFindCurriculumList(pageNum, pageSize));
    }

    @RequestMapping("/search")
    //返回curriculumListVOList的分页对象
    public ResultVO<PageInfo> productSearch(HttpSession session, String curriculumName, Integer curriculumId,
                                            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {

        return ResultVOUtil.success(iCurriculumService.manageFindSearchCurriculum(curriculumName, curriculumId, pageNum, pageSize));
    }

    @RequestMapping("/on_use")
    //课程的上线
    public ResultVO<CurriculumInfo> onUse(HttpSession session, String productId) {
        return ResultVOUtil.success(iCurriculumService.onUsing(productId));
    }

    @RequestMapping("/off_use")
    //课程的下线
    public ResultVO<CurriculumInfo> offUse(HttpSession session, String productId) {
        return ResultVOUtil.success(iCurriculumService.offUsing(productId));
    }


    @RequestMapping("/upload")
    public ResultVO upload(HttpSession session, @RequestParam(value = "upload_file", required = false) MultipartFile file, HttpServletRequest request) {
        /*User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录管理员");
        }
        if(iUserService.checkAdminRole(user).isSuccess()){
            String path = request.getSession().getServletContext().getRealPath("upload");
            String targetFileName = iFileService.upload(file,path);
            String url = PropertiesUtil.getProperty("ftp.server.http.prefix")+targetFileName;

            Map fileMap = Maps.newHashMap();
            fileMap.put("uri",targetFileName);
            fileMap.put("url",url);
            return ServerResponse.createBySuccess(fileMap);
        }else{
            return ServerResponse.createByErrorMessage("无权限操作");
        }*/
        String path = request.getSession().getServletContext().getRealPath("upload");
        String targetFileName = iFileService.upload(file, path);
        String url = PropertiesUtil.getProperty("ftp.server.http.prefix") + targetFileName;

        Map fileMap = Maps.newHashMap();
        fileMap.put("uri", targetFileName);
        fileMap.put("url", url);
        return ResultVOUtil.success(fileMap);
    }



   /* @RequestMapping("richtext_img_upload")
    @ResponseBody
    public Map richtextImgUpload(HttpSession session, @RequestParam(value = "upload_file",required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        Map resultMap = Maps.newHashMap();
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            resultMap.put("success",false);
            resultMap.put("msg","请登录管理员");
            return resultMap;
        }
        //富文本中对于返回值有自己的要求,我们使用是simditor所以按照simditor的要求进行返回
//        {
//            "success": true/false,
//                "msg": "error message", # optional
//            "file_path": "[real file path]"
//        }
        if(IUserService.checkAdminRole(user).isSuccess()){
            String path = request.getSession().getServletContext().getRealPath("upload");
            String targetFileName = iFileService.upload(file,path);
            if(StringUtils.isBlank(targetFileName)){
                resultMap.put("success",false);
                resultMap.put("msg","上传失败");
                return resultMap;
            }
            String url = PropertiesUtil.getProperty("ftp.server.http.prefix")+targetFileName;
            resultMap.put("success",true);
            resultMap.put("msg","上传成功");
            resultMap.put("file_path",url);
            response.addHeader("Access-Control-Allow-Headers","X-File-Name");
            return resultMap;
        }else{
            resultMap.put("success",false);
            resultMap.put("msg","无权限操作");
            return resultMap;
        }*/
}
