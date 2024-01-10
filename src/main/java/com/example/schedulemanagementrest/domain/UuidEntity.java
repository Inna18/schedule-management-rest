package com.example.schedulemanagementrest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.domain.Persistable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public abstract class UuidEntity implements Persistable<UUID>{

    @Id
    @Column(updatable = false, columnDefinition = "uuid")
    @GenericGenerator(name = "system", strategy = "uuid2")
    @GeneratedValue(generator = "system")
    @Getter
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID id;

    @Override
    @JsonIgnore
    public boolean isNew(){
        return id == null;
    }

    @Override
    public String toString(){
        return MoreObjects.toStringHelper(this).omitNullValues()
            .add("id", id).toString();
    }
}