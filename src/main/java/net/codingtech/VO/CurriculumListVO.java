package net.codingtech.VO;

import lombok.Data;

import java.io.Serializable;

@Data
public class CurriculumListVO implements Serializable {

    private static final long serialVersionUID = 3464252069588832521L;

    private String curriculumId;

    private String curriculumName;

    private String curriculumAge;

    private String curriculumElement;

    private Integer categoryId;

    private String categoryName;
}
