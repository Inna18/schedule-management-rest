package com.example.schedulemanagementrest.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.MappedSuperclass;
import java.time.Instant;

@MappedSuperclass
public abstract class MutableUuidEntity extends ImmutableUuidEntity{

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Getter
    @UpdateTimestamp
    private Instant updatedAt;
}
