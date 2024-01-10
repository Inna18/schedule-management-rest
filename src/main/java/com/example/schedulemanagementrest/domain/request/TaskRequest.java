package com.example.schedulemanagementrest.domain.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TaskRequest {
    private String content;
    private LocalDate registerDate;
}
