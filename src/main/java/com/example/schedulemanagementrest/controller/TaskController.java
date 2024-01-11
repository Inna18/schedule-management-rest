package com.example.schedulemanagementrest.controller;

import com.example.schedulemanagementrest.domain.request.TaskContentRequest;
import com.example.schedulemanagementrest.domain.request.TaskRequest;
import com.example.schedulemanagementrest.domain.response.ApiSuccessResponse;
import com.example.schedulemanagementrest.domain.response.TaskResponse;
import com.example.schedulemanagementrest.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TaskController extends BaseController {
    private final TaskService taskService;

    @GetMapping("/tasks/{id}")
    public Callable<ApiSuccessResponse<TaskResponse>> get(@PathVariable  UUID id) {
        return () -> wrap(taskService.get(id));
    }

    @GetMapping("/tasks")
    public Callable<ApiSuccessResponse<List<TaskResponse>>> getAll() {
        return () -> wrap(taskService.getAll());
    }

    @PostMapping("/tasks")
    public Callable<ApiSuccessResponse<TaskResponse>> create(@RequestBody TaskRequest request) {
        return () -> wrap(taskService.create(request));
    }

    @PatchMapping("/tasks/{id}")
    public Callable<ApiSuccessResponse<TaskResponse>> update(@PathVariable UUID id, @RequestBody TaskContentRequest request) {
        return () -> wrap(taskService.update(id, request));
    }

    @DeleteMapping("/tasks/{id}")
    public Callable<ApiSuccessResponse<Boolean>> delete(@PathVariable UUID id) {
        return () -> wrap(taskService.delete(id));
    }
}
