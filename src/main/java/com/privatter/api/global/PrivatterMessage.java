package com.privatter.api.global;

public enum PrivatterMessage {
    OK("OK"),

    SERVER_ERROR("Server error"),
    INVALID_REQUEST("Invalid request"),
    SERVICE_DISABLED("This service is disabled right now. Try again later"),
    SERVICE_NOT_FOUND("Service not found"),

    SENT_EMAIL("We sent a message to your mail (%s)");

    public final String value;

    PrivatterMessage(String value) {
        this.value = value;
    }
}
