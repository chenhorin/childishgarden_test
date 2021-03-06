package net.codingtech.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import net.codingtech.common.enums.CurriculumStatusEnum;
import net.codingtech.utils.EnumUtil;
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
public class CurriculumInfo {

    @Id
    private String curriculumId;

    private String curriculumName;

    private Integer curriculumProperty;

    private String userId;

    private String userName;

    private Integer curriculumDifficulty;

    /**
     * 课程在线码
     */
    private Integer curriculumStatus = CurriculumStatusEnum.UP.getCode();

    private Integer categoryId;

    private String curriculumPlan;

    private String curriculumDescription;

    private String curriculumPrepare;

    private String activityStep;

    private String activityTarget;

    private String activityTarget2;

    private String curriculumTarget;

    private String curriculumAge;

    private String curriculumElement;

    private Date createTime;

    private Date updateTime;

    private String categoryName;


    public CurriculumInfo() {
    }


    public CurriculumInfo(String curriculumId, String curriculumName, Integer curriculumProperty, String userId, String userName, Integer curriculumDifficulty, Integer curriculumStatus, Integer categoryId, String curriculumPlan, String curriculumDescription, String curriculumPrepare, String activityStep, String activityTarget, String activityTarget2, String curriculumTarget, String curriculumAge, String curriculumElement, Date createTime, Date updateTime, String categoryName) {
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
        this.curriculumElement = curriculumElement;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.categoryName = categoryName;
    }

    @JsonIgnore
    public CurriculumStatusEnum getCurriculumStatusEnum() {
        return EnumUtil.getByCode(curriculumStatus, CurriculumStatusEnum.class);
    }
}
