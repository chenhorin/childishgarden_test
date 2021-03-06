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
public class MusicCategory {

    @Id
    @GeneratedValue
    private Integer categoryId;

    private String categoryName;

    private Integer categoryStatus;

    private Date createTime;

    private Date updateTime;


}
