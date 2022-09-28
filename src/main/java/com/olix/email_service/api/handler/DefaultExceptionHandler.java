package com.olix.email_service.api.handler;

import com.olix.email_service.common.representation.ExceptionDetails;
import com.olix.email_service.domain.enums.ExceptionCause;
import com.olix.email_service.domain.exception.BusinessException;
import com.olix.email_service.domain.helper.ExceptionHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ExceptionDetails> handleBusinessException(BusinessException exception,
                                                                       HttpServletRequest request) {
        ExceptionDetails exceptionDetails =
                ExceptionHelper.getExceptionDetailsInstance(exception.getExceptionCause().status,
                        exception.getMessage(), request.getServletPath());
        return new ResponseEntity<>(exceptionDetails, HttpStatus.valueOf(exceptionDetails.getStatus()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ExceptionDetails> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception,
                                                                                     HttpServletRequest request) {
        ExceptionDetails exceptionDetails =
                ExceptionHelper.getExceptionDetailsInstance(ExceptionCause.INVALID_FIELDS_RECEIVED.status,
                        ExceptionCause.INVALID_FIELDS_RECEIVED.value, request.getServletPath());
        ExceptionHelper.fillExceptionDetails(exceptionDetails, exception.getAllErrors());
        return new ResponseEntity<>(exceptionDetails, HttpStatus.valueOf(exceptionDetails.getStatus()));
    }

}
