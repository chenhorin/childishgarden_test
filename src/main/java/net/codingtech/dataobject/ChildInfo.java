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
public class ChildInfo {

    @Id
    private String childId;
    private String childName;
    private String userId;
    private String userName;
    private Integer childGender;
    private String campId;
    private Integer childStatus;
    private Date createTime;
    private Date updateTime;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChildInfo childInfo = (ChildInfo) o;
        return childGender == childInfo.childGender &&
                childStatus == childInfo.childStatus &&
                Objects.equals(childId, childInfo.childId) &&
                Objects.equals(childName, childInfo.childName) &&
                Objects.equals(userId, childInfo.userId) &&
                Objects.equals(userName, childInfo.userName) &&
                Objects.equals(campId, childInfo.campId) &&
                Objects.equals(createTime, childInfo.createTime) &&
                Objects.equals(updateTime, childInfo.updateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(childId, childName, userId, userName, childGender, campId, childStatus, createTime, updateTime);
    }
}
