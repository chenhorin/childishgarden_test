package net.codingtech.VO;

import lombok.Data;
import net.codingtech.pojo.CurriculumDetail;

import java.util.Date;
import java.util.List;

@Data
public class CurriculumDetailVO {

    private String curriculumId;

    private String curriculumName;

    private Integer curriculumProperty;

    private String userId;

    private String userName;

    private Integer curriculumDifficulty;

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

    private Date createTime;

    private Date updateTime;

    private List<CurriculumDetail> curriculumDetailList;

}
