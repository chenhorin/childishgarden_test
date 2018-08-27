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
public class CourseSelection {

    @Id
    private String detailId;

    private String curriculumId;

    private String userId;

    private String userName;

    private String classId;

    private String className;

    private String childId;

    private String classroom;

    private Date courseDay;

    private Integer courseNum;

    private Integer courseStatus;

    private Date createTime;

    private Date updateTime;


}
