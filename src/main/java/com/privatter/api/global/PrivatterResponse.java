package com.privatter.api.global;

import org.jetbrains.annotations.NotNull;
import java.util.List;

public enum PrivatterResponse {
    OK(new PrivatterShortResponseDto(
        PrivatterMessage.OK.value,
        PrivatterStatusCode.OK.value
    )),

    SERVER_ERROR(new PrivatterShortResponseDto(
        PrivatterMessage.SERVER_ERROR.value,
        PrivatterStatusCode.SERVER_ERROR.value
    )),
    INVALID_REQUEST(new PrivatterShortResponseDto(
        PrivatterMessage.INVALID_REQUEST.value,
        PrivatterStatusCode.INVALID_REQUEST.value
    )),
    SERVICE_DISABLED(new PrivatterShortResponseDto(
        PrivatterMessage.SERVICE_DISABLED.value,
        PrivatterStatusCode.SERVICE_DISABLED.value
    )),
    INVALID_CAPTCHA(new PrivatterShortResponseDto(
        PrivatterMessage.INVALID_REQUEST.value,
        PrivatterStatusCode.INVALID_CAPTCHA.value
    )),
    INVALID_VERIFICATION_TOKEN(new PrivatterShortResponseDto(
        PrivatterMessage.INVALID_REQUEST.value,
        PrivatterStatusCode.INVALID_VERIFICATION_TOKEN.value
    )),
    SERVICE_NOT_FOUND(new PrivatterShortResponseDto(
        PrivatterMessage.SERVICE_NOT_FOUND.value,
        PrivatterStatusCode.SERVICE_NOT_FOUND.value
    )),

    USER_EXISTS(new PrivatterShortResponseDto(
        PrivatterMessage.INVALID_REQUEST.value,
        PrivatterStatusCode.USER_EXISTS.value
    ));

    public final PrivatterShortResponseDto value;

    PrivatterResponse(PrivatterShortResponseDto value) {
        this.value = value;
    }

    @NotNull
    public static <D> PrivatterResponseDto<D> parseOk(D data) {
        return new PrivatterResponseDto<>(
            OK.value.message,
            OK.value.statusCode,
            data,
            false,
            null,
            null
        );
    }

    @NotNull
    public static PrivatterShortResponseDto parseInvalidRequestError(String message, List<String> stackTrace) {
        var error = INVALID_REQUEST.value;

        error.setErrorMessage(message);
        error.setErrorStackTrace(stackTrace);

        return error;
    }

    @NotNull
    public static PrivatterShortResponseDto parseEmailSent(String address) {
        return new PrivatterShortResponseDto(
            PrivatterMessage.SENT_EMAIL.value.formatted(address),
            PrivatterStatusCode.SENT_EMAIL.value,
            false,
            null,
            null
        );
    }

    @NotNull
    public <D> PrivatterResponseDto<D> toFullDto(D data) {
        return new PrivatterResponseDto<>(
            this.value.message,
            this.value.statusCode,
            data,
            this.value.hasError,
            this.value.errorStackTrace,
            this.value.errorMessage
        );
    }
}
