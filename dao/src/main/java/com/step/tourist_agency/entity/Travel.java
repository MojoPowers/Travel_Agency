package com.step.tourist_agency.entity;

import com.step.tourist_agency.entity.parent.LogNameEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@SuppressWarnings("PMD")
@Entity
@Table(name = "ta_travel")
public class Travel extends LogNameEntity {

    @Basic
    @Column(name = "order_id", insertable = false, updatable = false)
    private Long orderId;

    @Basic
    @Column(name = "price")
    private Double price;

    @Basic
    @Column(name = "type")
    private String type;

    @Basic
    @Column(name = "country_from")
    private String countryFrom;

    @Basic
    @Column(name = "country_to")
    private String countryTo;

    @Basic
    @Column(name = "days")
    private int days;

//    @Basic
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "date_departure")
//    private Data dateDeparture;

    //------------------------------------------------------------------------------------------------------------------

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "ta_order_travel",
            joinColumns = @JoinColumn(name = "travel_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"),
            foreignKey = @ForeignKey(name = "fk_travel_to_order")
    )
    private List<Order> orderList;
}