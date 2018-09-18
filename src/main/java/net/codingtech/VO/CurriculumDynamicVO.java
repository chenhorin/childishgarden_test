package net.codingtech.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 动态查询返回对象
 */
// TODO 是否需要VO对象返回
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class CurriculumDynamicVO implements Serializable {

    private static final long serialVersionUID = 4351948287835018484L;

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


}
