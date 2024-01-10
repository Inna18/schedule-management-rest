package com.example.schedulemanagementrest.service;

import com.example.schedulemanagementrest.domain.entity.TaskEntity;
import com.example.schedulemanagementrest.domain.request.TaskRequest;
import com.example.schedulemanagementrest.domain.response.TaskResponse;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    TaskResponse get(UUID id);
    List<TaskResponse> getAll();
    TaskResponse create(TaskRequest request);
    TaskResponse update(UUID id, String content);
    boolean delete(UUID id);
}
