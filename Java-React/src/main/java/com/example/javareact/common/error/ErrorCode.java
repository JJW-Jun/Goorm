package com.example.javareact.common.error;

import lombok.Getter;

@Getter
public enum ErrorCode {

    ACCESS_DENIED(401, "AUTH_003", "ACCESS_DENIED.");

    private final int status;
    private final String code;
    private final String message;

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
