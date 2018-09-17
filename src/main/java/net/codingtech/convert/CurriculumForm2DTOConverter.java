package net.codingtech.convert;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import net.codingtech.common.enums.CurriculumStatusEnum;
import net.codingtech.common.enums.ResultEnum;
import net.codingtech.exception.CurriculumException;
import net.codingtech.pojo.CurriculumDetail;
import net.codingtech.dto.CurriculumDTO;
import net.codingtech.form.back.CurriculumManageForm;
import net.codingtech.form.portal.CurriculumForm;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CurriculumForm2DTOConverter {

    //管理form
    public static CurriculumDTO convert(CurriculumManageForm form) {
        Gson gson = new Gson();
        CurriculumDTO curriculumDTO = new CurriculumDTO();

        curriculumDTO.setCurriculumId(form.getCurriculumId());
        curriculumDTO.setCurriculumName(form.getCurriculumName());
        curriculumDTO.setCurriculumProperty(form.getCurriculumProperty());
        curriculumDTO.setUserId(form.getUserId());
        curriculumDTO.setUserName(form.getUserName());
        curriculumDTO.setCurriculumDifficulty(form.getCurriculumDifficulty());
        curriculumDTO.setCurriculumStatus(form.getCurriculumStatus());
        curriculumDTO.setCategoryId(form.getCategoryId());
        curriculumDTO.setCurriculumPlan(form.getCurriculumPlan());
        curriculumDTO.setCurriculumDescription(form.getCurriculumDescription());
        curriculumDTO.setCurriculumPrepare(form.getCurriculumPrepare());
        curriculumDTO.setActivityStep(form.getActivityStep());
        curriculumDTO.setActivityTarget(form.getActivityTarget());
        curriculumDTO.setActivityTarget2(form.getActivityTarget2());
        curriculumDTO.setCurriculumTarget(form.getCurriculumTarget());
        curriculumDTO.setCurriculumAge(form.getCurriculumAge());
        curriculumDTO.setCurriculumElement(form.getCurriculumElement());

        List<CurriculumDetail> curriculumDetailList = new ArrayList<>();
        try {
            curriculumDetailList = gson.fromJson(form.getItems(),
                    new TypeToken<List<CurriculumDetail>>() {
                    }.getType());
        } catch (Exception e) {
            log.error("【对象转换】错误, string={}", form.getItems());
            throw new CurriculumException(ResultEnum.PARAM_ERROR);
        }
        curriculumDTO.setCurriculumDetailList(curriculumDetailList);
        return curriculumDTO;
    }
    //前台form
    public static CurriculumDTO convert(CurriculumForm curriculumForm) {
        CurriculumManageForm curriculumManageForm = new CurriculumManageForm();
        BeanUtils.copyProperties(curriculumForm,curriculumManageForm);
        //因为是前台传入的课程，需要默认设置为上线，之后需要根据甲方看是否需要上线审核功能
        curriculumManageForm.setCurriculumStatus(CurriculumStatusEnum.UP.getCode());
        return convert(curriculumManageForm);
    }
}
