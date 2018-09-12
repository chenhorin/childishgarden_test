package net.codingtech.exception;

import lombok.Getter;
import net.codingtech.common.enums.ResultEnum;

@Getter
public class CurriculumException extends RuntimeException {

    private Integer code;

    public CurriculumException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public CurriculumException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
