package net.codingtech.form.back;

import lombok.Data;
import net.codingtech.common.enums.CurriculumStatusEnum;

@Data
public class CurriculumCategoryManageForm {

    private Integer categoryId;

    private Boolean isParent;

    private Integer sortOrder;

    private Integer parentId;

    private String categoryName;

    private Integer categoryStatus ;

    //是否应用字符串数组对象，待定
    private String[] categoryElements;
}
