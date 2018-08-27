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
public class CurriculumDetail {

    @Id
    private String detailId;

    private String curriculumId;

    private String musicId;

    private String musicName;

    private String materialId;

    private String materialName;

    private String bookId;

    private String bookName;

    private Date createTime;

    private Date updateTime;


}
