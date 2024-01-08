package com.example.schedulemanagementrest.controller;

import com.example.schedulemanagementrest.entity.TaskEntity;
import com.example.schedulemanagementrest.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/task")
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/tasks/{id}")
    public TaskEntity get(@PathVariable  UUID id) {
        return taskService.get(id);
    }

    @GetMapping("/tasks")
    public List<TaskEntity> getAll() {
        return taskService.getAll();
    }

    @PostMapping("/tasks")
    public TaskEntity create(@RequestBody TaskEntity entity) {
        return taskService.create(entity);
    }

    @PatchMapping("/tasks/{id}")
    public TaskEntity update(@PathVariable UUID id, @RequestParam String content) {
        return taskService.update(id, content);
    }

    @DeleteMapping("/tasks/{id}")
    public void delete(@PathVariable UUID id) {
        taskService.delete(id);
    }
}
