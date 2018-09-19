package net.codingtech.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.codingtech.pojo.CurriculumDetail;

import java.util.Date;
import java.util.List;

@Data
@ApiModel(value = "课程返回对象",description = "课程模型")
public class CurriculumDTO {

    private String curriculumId;

    private String curriculumName;

    private Integer curriculumProperty;

    private String userId;

    private String userName;

    private Integer curriculumDifficulty;

    @ApiModelProperty(value = "状态",dataType = "net.codingtech.common.enums.CurriculumStatusEnum")
    private Integer curriculumStatus;

    private Integer categoryId;

    private String curriculumPlan;

    private String curriculumDescription;

    private String curriculumPrepare;

    private String activityStep;

    private String activityTarget;

    private String activityTarget2;

    private String curriculumTarget;

    private String curriculumAge;

    private String curriculumElement;

    private Date createTime;

    private Date updateTime;

    private List<CurriculumDetail> curriculumDetailList;
}
