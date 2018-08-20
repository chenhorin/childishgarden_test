package net.codingtech.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

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
    private Integer categoryStatus;
    private Date createTime;
    private Date updateTime;
    private String categoryElements;


    public CurriculumCategory() {
    }

    public CurriculumCategory(Boolean isParent, Integer sortOrder, Integer parentId,
                              String categoryName, Integer categoryStatus, Date createTime, Date updateTime) {
        this.isParent = isParent;
        this.sortOrder = sortOrder;
        this.parentId = parentId;
        this.categoryName = categoryName;
        this.categoryStatus = categoryStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurriculumCategory that = (CurriculumCategory) o;
        return categoryId == that.categoryId &&
                Objects.equals(isParent, that.isParent) &&
                Objects.equals(sortOrder, that.sortOrder) &&
                Objects.equals(parentId, that.parentId) &&
                Objects.equals(categoryName, that.categoryName) &&
                Objects.equals(categoryStatus, that.categoryStatus) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(categoryId, isParent, sortOrder, parentId, categoryName, categoryStatus, createTime, updateTime);
    }
}
