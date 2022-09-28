package com.olix.email_service.domain.exception;

import com.olix.email_service.domain.enums.ExceptionCause;

public class BusinessException extends RuntimeException {
    private final ExceptionCause exceptionCause;

    public BusinessException(ExceptionCause exceptionCause) {
        this.exceptionCause = exceptionCause;
    }

    public ExceptionCause getExceptionCause() {
        return exceptionCause;
    }

    @Override
    public String getMessage() {
        return this.exceptionCause.value;
    }
}
