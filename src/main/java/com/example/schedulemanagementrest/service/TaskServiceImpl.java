package com.example.schedulemanagementrest.service;

import com.example.schedulemanagementrest.entity.TaskEntity;
import com.example.schedulemanagementrest.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public TaskEntity get(UUID id) {
        return taskRepository.getTaskEntityById(id);
    }

    @Override
    public List<TaskEntity> getAll() {
        return taskRepository.findAllByOrderByCreatedAtDesc();
    }

    @Override
    public TaskEntity create(TaskEntity entity) {
        return taskRepository.save(entity);
    }

    @Override
    public TaskEntity update(UUID id, String content) {
        TaskEntity foundEntity = get(id);
        foundEntity.setContent(content);
        return taskRepository.save(foundEntity);
    }

    @Override
    public void delete(UUID id) {
        taskRepository.deleteById(id);
    }
}
