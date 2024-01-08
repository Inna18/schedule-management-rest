package com.example.schedulemanagementrest.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="task")
public class TaskEntity extends MutableUuidEntity {
    private String content;
    private LocalDate registerDate;
}


