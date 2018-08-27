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


}
