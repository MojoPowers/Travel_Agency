package com.step.tourist_agency.entity.parent;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@SuppressWarnings("PMD")
@MappedSuperclass
public abstract class LogNameEntity extends LogEntity {

    @Basic
    @Column(name = "name")
    private String name;
}