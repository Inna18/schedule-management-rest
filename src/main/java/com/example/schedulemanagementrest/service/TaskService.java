package com.example.schedulemanagementrest.service;

import com.example.schedulemanagementrest.entity.TaskEntity;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    TaskEntity get(UUID id);
    List<TaskEntity> getAll();
    TaskEntity create(TaskEntity entity);
    TaskEntity update(UUID id, String content);
    void delete(UUID id);
}
