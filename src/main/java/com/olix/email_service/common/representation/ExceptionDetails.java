package com.olix.email_service.common.representation;

import java.util.HashSet;
import java.util.Set;

public class ExceptionDetails {
    private final Long timestamps;
    private final Integer status;
    private final String message;
    private final String path;
    private final Set<String> details = new HashSet<>();

    public ExceptionDetails(Long timestamps, Integer status, String message, String path) {
        this.timestamps = timestamps;
        this.status = status;
        this.message = message;
        this.path = path;
    }

    public Long getTimestamps() {
        return timestamps;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public Set<String> getDetails() {
        return details;
    }
}
