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
public class UserInfo {

    @Id
    private String userId;
    private String userName;
    private Integer userStatus;
    private String campId;
    private String campName;
    private Date createTime;
    private Date updateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return userStatus == userInfo.userStatus &&
                Objects.equals(userId, userInfo.userId) &&
                Objects.equals(userName, userInfo.userName) &&
                Objects.equals(campId, userInfo.campId) &&
                Objects.equals(campName, userInfo.campName) &&
                Objects.equals(createTime, userInfo.createTime) &&
                Objects.equals(updateTime, userInfo.updateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, userName, userStatus, campId, campName, createTime, updateTime);
    }
}
