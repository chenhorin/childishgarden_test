package net.codingtech.form.portal;

import lombok.Data;

@Data
//TODO 筛选是否需要对象输入
public class DynamicConditionForm {

    private String userName;

    private String userId;

    //室内室外
    private Integer curriculumProperty;

    private Integer curriculumDifficulty;

    private String curriculumAge;

    private String childName;

    private String childId;

    private String classId;

    private String className;

    private Integer campId;
}
