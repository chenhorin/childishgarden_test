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

}
