package net.codingtech.form.back;

import lombok.Data;

@Data
public class CurriculumManageForm {

    private String curriculumId;

    private String curriculumName;

    private Integer curriculumProperty;

    private String userId;

    private String userName;

    private Integer curriculumDifficulty;

    /**
     * 课程在线码
     */
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

    private String items;
}
