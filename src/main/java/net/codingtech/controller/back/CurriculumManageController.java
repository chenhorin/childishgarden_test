package net.codingtech.controller.back;


import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.codingtech.VO.CurriculumDetailVO;
import net.codingtech.VO.CurriculumListVO;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/manage/curriculum")
@Api(tags = "Manage-Curriculum",description = "后台-课程管理相关")
public class CurriculumManageController {

    @Autowired
    private ICurriculumService iCurriculumService;

    @Autowired
    private IFileService iFileService;

    @PostMapping("/save")
    //后台的新增和保存
//    ok
    @ApiOperation(notes = "根据相应的规则和条件动态的,新建和更新课程",value = "新建和更新课程")
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

    @PostMapping("/detail")
//    ok
    @ApiOperation(value = "课程详情",notes = "课程基本状况加上课程的详情")
    public ResultVO<CurriculumDetailVO> getDetail(HttpSession session, String curriculumId) {
        return ResultVOUtil.success(iCurriculumService.manageCurriculumDetail(curriculumId));
    }

    @GetMapping("/list")
//    *ok
    //返回curriculumListVOList的分页对象
    @ApiOperation(value = "显示所有课程",notes = "显示所有课程,包括所有非在线课程")
    protected ResultVO<PageInfo<List<CurriculumListVO>>> list(HttpSession session, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                              @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        return ResultVOUtil.success(iCurriculumService.manageFindCurriculumList(pageNum, pageSize));
    }

    @GetMapping("/search")
    //返回curriculumListVOList的分页对象
//    *ok
    @ApiOperation(value = "后台搜索",notes = "根据课程关键字或者课程Id进行查询,默认分页为page_num = 1,page_size = 10")
    public ResultVO<PageInfo<List<CurriculumListVO>>> productSearch(HttpSession session, String curriculumName, String curriculumId,
                                            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {

        return ResultVOUtil.success(iCurriculumService.manageFindSearchCurriculum(curriculumName, curriculumId, pageNum, pageSize));
    }

    @GetMapping("/on_use")
    //课程的上线
//    ok
    @ApiOperation(value = "课程的上线",notes = "根据相应的规则上线课程")
    public ResultVO<CurriculumInfo> onUse(HttpSession session, String curriculumId) {
        return ResultVOUtil.success(iCurriculumService.onUsing(curriculumId));
    }

    @GetMapping("/off_use")
    //课程的下线
//    ok
    @ApiOperation(value = "课程的下线",notes = "根据相应的规则下线课程")
    public ResultVO<CurriculumInfo> offUse(HttpSession session, String curriculumId) {
        return ResultVOUtil.success(iCurriculumService.offUsing(curriculumId));
    }


    @PostMapping("/upload")
    @ApiOperation(value = "文件上传",notes = "文件上传到服务器,尚未打通")
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
