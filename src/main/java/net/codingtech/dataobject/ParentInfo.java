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
public class ParentInfo {

    @Id
    private String parentId;
    private String parentName;
    private String classId;
    private String className;
    private String campId;
    private String parentPhone;
    private String parentWechat;
    private String parentAddress;
    private Date createTime;
    private Date updateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParentInfo that = (ParentInfo) o;
        return Objects.equals(parentId, that.parentId) &&
                Objects.equals(parentName, that.parentName) &&
                Objects.equals(classId, that.classId) &&
                Objects.equals(className, that.className) &&
                Objects.equals(campId, that.campId) &&
                Objects.equals(parentPhone, that.parentPhone) &&
                Objects.equals(parentWechat, that.parentWechat) &&
                Objects.equals(parentAddress, that.parentAddress) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(parentId, parentName, classId, className, campId, parentPhone, parentWechat, parentAddress, createTime, updateTime);
    }
}
