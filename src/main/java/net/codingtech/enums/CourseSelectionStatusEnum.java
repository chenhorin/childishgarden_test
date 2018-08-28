package net.codingtech.enums;

import lombok.Getter;

@Getter
public enum CourseSelectionStatusEnum {
    UP(0, "在线"),
    DOWN(1, "下线");

    private Integer code;

    private String message;

    CourseSelectionStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
