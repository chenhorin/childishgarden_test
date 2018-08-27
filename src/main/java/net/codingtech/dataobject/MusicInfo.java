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
public class MusicInfo {

    @Id
    private String musicId;

    private String musicName;

    private Integer categoryId;

    private String musicPic;

    private String musicUrl;

    private Integer musicStatus;

    private Date createTime;

    private Date updateTime;


}
