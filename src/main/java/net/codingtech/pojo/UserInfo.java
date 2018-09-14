package net.codingtech.pojo;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
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
public class UserInfo {

    @Id
    private String userId;

    private String userName;

    private Integer userStatus;

    private String campId;

    private String campName;

    //需要查询老师所在班级
    private String classId;

    //需要查询角色
    private String role;

    private Date createTime;

    private Date updateTime;

}
