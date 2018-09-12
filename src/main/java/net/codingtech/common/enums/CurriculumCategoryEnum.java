package net.codingtech.common.enums;

import lombok.Getter;

@Getter
public enum CurriculumCategoryEnum {
    SON_DOT(0, "子节点"),
    PARENT_DOT(1, "父节点"),
    UP(0, "上线"),
    DOWN(1, "下线"),
    ;

    private Integer code;

    private String message;

    CurriculumCategoryEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    }
