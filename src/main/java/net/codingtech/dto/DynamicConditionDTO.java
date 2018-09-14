package net.codingtech.dto;

import lombok.Data;

@Data
//TODO 是否需要DTO对象返回
public class DynamicConditionDTO {

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

    public DynamicConditionDTO(String childId, String childName) {
        this.childId = childId;
        this.childName = childName;
    }

    public DynamicConditionDTO() {
    }
}
