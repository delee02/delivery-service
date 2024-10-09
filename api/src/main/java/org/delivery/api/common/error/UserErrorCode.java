package org.delivery.api.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/*
* 사용자에 관한 에러는 1000번대라고 정의한다*/
@AllArgsConstructor
@Getter
public enum UserErrorCode implements ErrorCodeIfs{

    USER_NOT_FOUND(400,1404,"사용자 찾을 수 없음"),
    ;

    private final Integer httpStatusCode;

    private final Integer errorCode;

    private final String description;
}
