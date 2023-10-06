package com.example.kdbe.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.Date;

@MappedSuperclass
@Getter
public class BaseEntity {



    private String registProcessorId = "TEST";

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registTime")
    private Date registTime;

    private String updateProcessorId = "TEST";

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updateTime")
    private Date updateTime;



}
