package net.codingtech.pojo;

import lombok.Data;
import net.codingtech.common.enums.CurriculumStatusEnum;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @program: childishgarden_test
 * @description:
 * @author: hongren
 * @create: 2018-08-13 15:12
 **/
@Entity
@Data
@DynamicUpdate
public class CurriculumCategory {

    @Id
    @GeneratedValue
    private Integer categoryId;

    private Boolean isParent;

    private Integer sortOrder;

    private Integer parentId;

    private String categoryName;

    private Integer categoryStatus = CurriculumStatusEnum.UP.getCode();

    private Date createTime;

    private Date updateTime;

    private String categoryElements;


    public CurriculumCategory() {
    }

    public CurriculumCategory(Boolean isParent, Integer sortOrder, Integer parentId, String categoryName,
                              Integer categoryStatus, Date createTime,
                              Date updateTime, String categoryElements) {
        this.isParent = isParent;
        this.sortOrder = sortOrder;
        this.parentId = parentId;
        this.categoryName = categoryName;
        this.categoryStatus = categoryStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.categoryElements = categoryElements;
    }
}
