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

    private String curriculumName;

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


    public CourseSelection(String detailId, String curriculumId, String curriculumName,
                           String userId, String userName, String classId, String className,
                           String childId, String classroom,
                           Date courseDay, Integer courseNum, Integer courseStatus,
                           Date createTime, Date updateTime) {
        this.detailId = detailId;
        this.curriculumId = curriculumId;
        this.curriculumName = curriculumName;
        this.userId = userId;
        this.userName = userName;
        this.classId = classId;
        this.className = className;
        this.childId = childId;
        this.classroom = classroom;
        this.courseDay = courseDay;
        this.courseNum = courseNum;
        this.courseStatus = courseStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public CourseSelection() {
    }
}
