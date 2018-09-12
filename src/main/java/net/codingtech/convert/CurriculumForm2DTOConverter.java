package net.codingtech.convert;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import net.codingtech.common.enums.CurriculumStatusEnum;
import net.codingtech.common.enums.ResultEnum;
import net.codingtech.dataobject.CurriculumDetail;
import net.codingtech.dto.CurriculumDTO;
import net.codingtech.exception.CurriculumException;
import net.codingtech.form.back.CurriculumManageForm;
import net.codingtech.form.portal.CurriculumForm;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CurriculumForm2DTOConverter {

    public static CurriculumDTO convert(CurriculumManageForm form) {
        Gson gson = new Gson();
        CurriculumDTO curriculumDTO = new CurriculumDTO();


        curriculumDTO.setCategoryId(form.getCategoryId());
        curriculumDTO.setCurriculumId(form.getCurriculumId());
        curriculumDTO.setActivityStep(form.getActivityStep());
        curriculumDTO.setActivityTarget(form.getActivityTarget());
        curriculumDTO.setActivityTarget2(form.getActivityTarget2());
        curriculumDTO.setCurriculumAge(form.getCurriculumAge());
        curriculumDTO.setCurriculumDescription(form.getCurriculumDescription());
        curriculumDTO.setCurriculumDifficulty(form.getCurriculumDifficulty());
        curriculumDTO.setCurriculumPrepare(form.getCurriculumPrepare());
        curriculumDTO.setCurriculumProperty(form.getCurriculumProperty());
        curriculumDTO.setCurriculumPlan(form.getCurriculumPlan());
        curriculumDTO.setCurriculumTarget(form.getCurriculumTarget());
        curriculumDTO.setUserName(form.getUserName());
        curriculumDTO.setCurriculumStatus(form.getCurriculumStatus());
        curriculumDTO.setUserId(form.getUserId());

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
    public static CurriculumDTO convert(CurriculumForm curriculumForm) {
        CurriculumManageForm curriculumManageForm = new CurriculumManageForm();
        BeanUtils.copyProperties(curriculumForm,curriculumManageForm);
        curriculumManageForm.setCurriculumStatus(CurriculumStatusEnum.UP.getCode());
        return convert(curriculumManageForm);
    }
}
