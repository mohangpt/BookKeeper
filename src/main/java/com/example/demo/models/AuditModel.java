package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@MappedSuperclass //need to understand function of it
@EntityListeners(AuditingEntityListener.class) // need to understand this one
// these are properties to be ignored
@JsonIgnoreProperties(
        value = {"createdAt","updatedAt"},
        allowGetters = true
)
@Data
public abstract class AuditModel implements Serializable {
    @Temporal(TemporalType.TIMESTAMP) // this need to find out what is this??
    @Column(name = "created_at", nullable = false, updatable = false) // these are column properties
    @CreatedDate //this signifies that this one is created date
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false, updatable = true)
    @LastModifiedDate //this signify last updated date
    private Date updatedAt;
}
