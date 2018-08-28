package net.codingtech.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    CURRICULUM_NO_FOUND(0, "没有此课程"),
    CURRICULUM_STATUS_ERROR(1,"课程状态不正确"),
    CURRICULUM_NOT_EXIST(2,"课程不存在"),
    CURRICULUM_DETAIL_NOT_EXIST(3, "课程详情不存在"),
    COURSE_SELECTION_NOT_EXIST(4, "该选课不存在"),
    COURSE_SELECTION_ERROR(5, "选课状态不正确"),
    CURRICULUM_CATEGORY_NOT_EXIST(6, "课程分类不存在"),
    CURRICULUM_CATEGORY_STATUS_ERROR(7, "分类状态不正确"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
