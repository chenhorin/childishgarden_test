package net.codingtech.VO;

import lombok.Data;

/**
 * 动态查询返回对象
 */
// TODO 是否需要VO对象返回
@Data
public class CurriculumDynamicVO {

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


}
