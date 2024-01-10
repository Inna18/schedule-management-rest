package com.example.schedulemanagementrest.domain.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class TaskResponse {
    private UUID id;
    private String content;
    private LocalDate registerDate;
}
