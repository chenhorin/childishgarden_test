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
public class MusicCategory {

    @Id
    @GeneratedValue
    private Integer categoryId;
    private String categoryName;
    private Integer categoryStatus;
    private Date createTime;
    private Date updateTime;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicCategory that = (MusicCategory) o;
        return categoryId == that.categoryId &&
                categoryStatus == that.categoryStatus &&
                Objects.equals(categoryName, that.categoryName) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, categoryName, categoryStatus, createTime, updateTime);
    }
}
