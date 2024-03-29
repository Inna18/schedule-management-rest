package com.example.schedulemanagementrest.domain.response;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ApiSuccessResponse<T> extends ApiResponse {
    private final T data;

    public ApiSuccessResponse(int code, String message, T data) {
        super(code, message);
        this.data = data;
    }
}
