package org.delivery.api.exceptionHandler;

import lombok.extern.slf4j.Slf4j;
import org.delivery.api.common.api.Api;
import org.delivery.api.common.error.ErrorCode;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@Order(value= Integer.MAX_VALUE)
public class GlobalExceptionHandler {

    public ResponseEntity<Api<Object>> exception (
            Exception exception
    ){
        log.error("",exception);

        return ResponseEntity
                .status(500)
                .body(
                        Api.ERROR(ErrorCode.SERVER_ERROR)
                );
    }
}
