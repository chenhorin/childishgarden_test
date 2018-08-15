package net.codingtech.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
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
public class ParentChildRelate {

    @Id
    private String relateId;
    private String parentId;
    private String parentName;
    private String childId;
    private String childName;
    private String relationship;
    private Date createTime;
    private Date updateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParentChildRelate that = (ParentChildRelate) o;
        return Objects.equals(relateId, that.relateId) &&
                Objects.equals(parentId, that.parentId) &&
                Objects.equals(parentName, that.parentName) &&
                Objects.equals(childId, that.childId) &&
                Objects.equals(childName, that.childName) &&
                Objects.equals(relationship, that.relationship) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(relateId, parentId, parentName, childId, childName, relationship, createTime, updateTime);
    }
}
