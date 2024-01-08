package com.example.schedulemanagementrest.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class ImmutableUuidEntity extends UuidEntity{
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(updatable = false)
    @Getter
    @CreatedDate
    private Instant createdAt;
}
