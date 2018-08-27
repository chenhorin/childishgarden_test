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

}
