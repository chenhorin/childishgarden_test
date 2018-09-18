package net.codingtech.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
//TODO 是否需要DTO对象返回
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class DynamicConditionDTO implements Serializable {

    private static final long serialVersionUID = 4512777601143840277L;
    
    private String userName;

    private String userId;

    //室内室外
    private Integer curriculumProperty;

    private Integer curriculumDifficulty;

    private String curriculumAge;

    private String childName;

    private String childId;

    private String classId;

    @JsonProperty("test_name")
    private String className;

    private Integer campId;

    public DynamicConditionDTO(String childId, String childName) {
        this.childId = childId;
        this.childName = childName;
    }

    public DynamicConditionDTO() {
    }
}
