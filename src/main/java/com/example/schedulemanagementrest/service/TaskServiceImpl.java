package com.example.schedulemanagementrest.service;

import com.example.schedulemanagementrest.domain.entity.TaskEntity;
import com.example.schedulemanagementrest.domain.request.TaskContentRequest;
import com.example.schedulemanagementrest.domain.request.TaskRequest;
import com.example.schedulemanagementrest.domain.response.TaskResponse;
import com.example.schedulemanagementrest.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public TaskResponse get(UUID id) {
        return mapEntityToResponse(taskRepository.getTaskEntityById(id));
    }

    @Override
    public List<TaskResponse> getAll() {
        List<TaskEntity> entities = taskRepository.findAllByOrderByCreatedAtDesc();
        List<TaskResponse> responses = new ArrayList<>();
        entities.forEach(e -> {
            TaskResponse response = mapEntityToResponse(e);
            responses.add(response);
        });
        return responses;
    }

    @Override
    public TaskResponse create(TaskRequest request) {
        TaskEntity entity = mapRequestToEntity(request);
        return mapEntityToResponse(taskRepository.save(entity));
    }

    @Override
    public TaskResponse update(UUID id, TaskContentRequest request) {
        TaskEntity foundEntity = taskRepository.getTaskEntityById(id);
        foundEntity.setContent(request.getContent());
        return mapEntityToResponse(taskRepository.save(foundEntity));
    }

    @Override
    public boolean delete(UUID id) {
        try {
            taskRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private TaskResponse mapEntityToResponse(TaskEntity entity) {
        TaskResponse response = new TaskResponse();
        response.setId(entity.getId());
        response.setContent(entity.getContent());
        response.setRegisterDate(entity.getRegisterDate());
        return response;
    }

    private TaskEntity mapRequestToEntity(TaskRequest request) {
        TaskEntity entity = new TaskEntity();
        entity.setContent(request.getContent());
        entity.setRegisterDate(request.getRegisterDate());
        return entity;
    }

}
