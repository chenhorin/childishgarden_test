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
    private Date createTime;
    private Date updateTime;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseSelection that = (CourseSelection) o;
        return courseNum == that.courseNum &&
                Objects.equals(detailId, that.detailId) &&
                Objects.equals(curriculumId, that.curriculumId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(classId, that.classId) &&
                Objects.equals(className, that.className) &&
                Objects.equals(childId, that.childId) &&
                Objects.equals(classroom, that.classroom) &&
                Objects.equals(courseDay, that.courseDay) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(detailId, curriculumId, userId, userName, classId, className, childId, classroom, courseDay, courseNum, createTime, updateTime);
    }
}
