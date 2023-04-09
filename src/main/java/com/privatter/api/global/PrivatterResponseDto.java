package com.privatter.api.global;

import java.util.List;

public class PrivatterResponseDto <T> extends PrivatterShortResponseDto {
    private T data;

    public PrivatterResponseDto(
        String message,
        int statusCode,
        T data,
        boolean hasError,
        List<String> errorStackTrace,
        String errorMessage
    ) {
        super(message, statusCode, hasError, errorStackTrace, errorMessage);
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
