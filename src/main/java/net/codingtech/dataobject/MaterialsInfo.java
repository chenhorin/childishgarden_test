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
public class MaterialsInfo {

    @Id
    private String materialId;

    private String materialName;

    private Integer categoryId;

    private String materialPic;

    private Integer materialStatus;

    private Date createTime;

    private Date updateTime;

}
