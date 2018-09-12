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

    private String categoryElements;
}
