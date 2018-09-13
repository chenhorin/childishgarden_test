package net.codingtech.form.portal;

import lombok.Data;

@Data
public class CourseForm {

    private Long courseTime;

    private String userId;

    private String classId;

    private String childId;

//  private Integer courseStatus;需要使用定时器功能

}
