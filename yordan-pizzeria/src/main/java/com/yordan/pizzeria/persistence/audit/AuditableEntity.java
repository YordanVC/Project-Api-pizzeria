package com.yordan.pizzeria.persistence.audit;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
@MappedSuperclass
public class AuditableEntity {
    //atributos para auditroria
    @Column(name="created_date")
    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name="modified_date")
    private LocalDateTime modifiedDate;

    @CreatedBy
    @Column(name = "created_by")
    private String createdBy;

    @LastModifiedBy
    @Column(name = "modified_by")
    private String  modifiedBy;
}
