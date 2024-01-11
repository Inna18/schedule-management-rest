package com.example.schedulemanagementrest.repository;

import com.example.schedulemanagementrest.domain.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {
    TaskEntity getTaskEntityById(UUID id);
    List<TaskEntity> findAllByRegisterDateBetweenOrderByRegisterDateAsc(LocalDate start, LocalDate end);
    TaskEntity save(TaskEntity entity);
    void deleteById(UUID id);
}
