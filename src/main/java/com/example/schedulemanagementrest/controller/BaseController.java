package com.example.schedulemanagementrest.controller;

import com.example.schedulemanagementrest.domain.response.ApiSuccessResponse;

import java.util.List;

public class BaseController {
    private int successCode;
    public <T> ApiSuccessResponse<T> wrap(T data) {
        if (data instanceof List && ((List<?>) data).size() > 0) {
            successCode = 200;
        } else if (data != null) {
            successCode = 200;
        }

        return new ApiSuccessResponse<>(successCode, "success", data);
    }
}
