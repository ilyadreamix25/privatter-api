package com.privatter.api.global;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public class PrivatterShortResponseDto {
    @NotNull
    protected String message;

    @NotNull
    protected int statusCode;

    @NotNull
    protected boolean hasError;

    protected List<String> errorStackTrace;

    protected String errorMessage;

    public PrivatterShortResponseDto(
        String message,
        int statusCode,
        boolean hasError,
        List<String> errorStackTrace,
        String errorMessage
    ) {
        this.message = message;
        this.statusCode = statusCode;
        this.hasError = hasError;
        this.errorStackTrace = errorStackTrace;
        this.errorMessage = errorMessage;
    }

    public PrivatterShortResponseDto(
        String message,
        int statusCode,
        List<String> errorStackTrace,
        String errorMessage
    ) {
        this.message = message;
        this.statusCode = statusCode;
        this.hasError = true;
        this.errorStackTrace = errorStackTrace;
        this.errorMessage = errorMessage;
    }

    public PrivatterShortResponseDto(
        String message,
        int statusCode
    ) {
        this.message = message;
        this.statusCode = statusCode;
        this.hasError = true;
        this.errorStackTrace = null;
        this.errorMessage = null;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public List<String> getErrorStackTrace() {
        return errorStackTrace;
    }

    public void setErrorStackTrace(List<String> errorStackTrace) {
        this.errorStackTrace = errorStackTrace;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
