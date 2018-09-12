package net.codingtech.common.enums;

import lombok.Getter;

@Getter
public enum CurriculumStatusEnum implements CodeEnum {
    UP(0, "在线"),
    DOWN(1, "下线");

    private Integer code;

    private String message;

    CurriculumStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
