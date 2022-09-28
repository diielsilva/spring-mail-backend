package com.olix.email_service.domain.helper;

import com.olix.email_service.common.representation.ExceptionDetails;
import org.springframework.validation.ObjectError;

import java.time.OffsetDateTime;
import java.util.List;

public interface ExceptionHelper {
    static ExceptionDetails getExceptionDetailsInstance(Integer status, String message, String path) {
        return new ExceptionDetails(OffsetDateTime.now().toInstant().toEpochMilli(), status, message, path);
    }

    static void fillExceptionDetails(ExceptionDetails exceptionDetails, List<ObjectError> errors) {
        for (ObjectError error : errors) {
            exceptionDetails.getDetails().add(error.getDefaultMessage());
        }
    }
}
