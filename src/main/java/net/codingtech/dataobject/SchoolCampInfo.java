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
public class SchoolCampInfo {

    @Id
    @GeneratedValue
    private Integer campId;
    private String campName;
    private String campAdress;
    private String userId;
    private String userName;
    private Date createTime;
    private Date updateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolCampInfo that = (SchoolCampInfo) o;
        return Objects.equals(campId, that.campId) &&
                Objects.equals(campName, that.campName) &&
                Objects.equals(campAdress, that.campAdress) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(campId, campName, campAdress, userId, userName, createTime, updateTime);
    }
}
