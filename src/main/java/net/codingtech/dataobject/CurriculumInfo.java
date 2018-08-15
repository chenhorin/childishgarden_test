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
public class CurriculumInfo {

    @Id
    private String curriculumId;
    private String curriculumName;
    private Byte curriculumProperty;
    private String userId;
    private String userName;
    private Integer curriculumDifficulty;
    private Integer curriculumStatus;
    private Integer categoryId;
    private String curriculumPlan;
    private String curriculumDescription;
    private String curriculumPrepare;
    private String activityStep;
    private String activityTarget;
    private String activityTarget2;
    private String curriculumTarget;
    private String curriculumAge;
    private Date createTime;
    private Date updateTime;


    public CurriculumInfo() {
    }

    public CurriculumInfo(String curriculumId, String curriculumName,
                          Byte curriculumProperty, String userId,
                          String userName, Integer curriculumDifficulty,
                          Integer curriculumStatus, Integer categoryId,
                          String curriculumPlan, String curriculumDescription,
                          String curriculumPrepare, String activityStep, String activityTarget, String activityTarget2, String curriculumTarget, String curriculumAge, Date createTime, Date updateTime) {
        this.curriculumId = curriculumId;
        this.curriculumName = curriculumName;
        this.curriculumProperty = curriculumProperty;
        this.userId = userId;
        this.userName = userName;
        this.curriculumDifficulty = curriculumDifficulty;
        this.curriculumStatus = curriculumStatus;
        this.categoryId = categoryId;
        this.curriculumPlan = curriculumPlan;
        this.curriculumDescription = curriculumDescription;
        this.curriculumPrepare = curriculumPrepare;
        this.activityStep = activityStep;
        this.activityTarget = activityTarget;
        this.activityTarget2 = activityTarget2;
        this.curriculumTarget = curriculumTarget;
        this.curriculumAge = curriculumAge;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurriculumInfo that = (CurriculumInfo) o;
        return curriculumDifficulty == that.curriculumDifficulty &&
                curriculumStatus == that.curriculumStatus &&
                categoryId == that.categoryId &&
                Objects.equals(curriculumId, that.curriculumId) &&
                Objects.equals(curriculumName, that.curriculumName) &&
                Objects.equals(curriculumProperty, that.curriculumProperty) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(curriculumPlan, that.curriculumPlan) &&
                Objects.equals(curriculumDescription, that.curriculumDescription) &&
                Objects.equals(curriculumPrepare, that.curriculumPrepare) &&
                Objects.equals(activityStep, that.activityStep) &&
                Objects.equals(activityTarget, that.activityTarget) &&
                Objects.equals(activityTarget2, that.activityTarget2) &&
                Objects.equals(curriculumTarget, that.curriculumTarget) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(curriculumId, curriculumName, curriculumProperty, userId, userName, curriculumDifficulty, curriculumStatus, categoryId, curriculumPlan, curriculumDescription, curriculumPrepare, activityStep, activityTarget, activityTarget2, curriculumTarget, createTime, updateTime);
    }
}
