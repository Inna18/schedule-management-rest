package com.example.schedulemanagementrest.domain.response;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ApiResponse {
    private final int code;
    private final String message;

    public ApiResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
