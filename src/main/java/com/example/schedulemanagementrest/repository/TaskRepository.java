package com.example.schedulemanagementrest.repository;

import com.example.schedulemanagementrest.domain.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {
    TaskEntity getTaskEntityById(UUID id);
    List<TaskEntity> findAllByOrderByCreatedAtDesc();
    TaskEntity save(TaskEntity entity);
    void deleteById(UUID id);
}
