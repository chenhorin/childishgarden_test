package net.codingtech.form.portal;


import lombok.Data;

@Data
public class CurriculumCategoryForm {

    private Integer categoryId;

    private Boolean isParent;

    private Integer sortOrder;

    private Integer parentId;

    private String categoryName;

    private String categoryElements;
}
