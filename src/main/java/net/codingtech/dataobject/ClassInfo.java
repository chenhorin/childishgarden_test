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
public class ClassInfo {

    @Id
    private String classId;
    private String className;
    private String userId;
    private String userName;
    private Integer classStatus;
    private String campId;
    private Date createTime;
    private Date updateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassInfo classInfo = (ClassInfo) o;
        return classStatus == classInfo.classStatus &&
                Objects.equals(classId, classInfo.classId) &&
                Objects.equals(className, classInfo.className) &&
                Objects.equals(userId, classInfo.userId) &&
                Objects.equals(userName, classInfo.userName) &&
                Objects.equals(campId, classInfo.campId) &&
                Objects.equals(createTime, classInfo.createTime) &&
                Objects.equals(updateTime, classInfo.updateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(classId, className, userId, userName, classStatus, campId, createTime, updateTime);
    }
}
