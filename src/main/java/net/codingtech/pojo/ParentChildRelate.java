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


}
