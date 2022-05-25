package com.step.tourist_agency.entity;

import com.step.tourist_agency.entity.parent.LogEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ta_order")
public class Order extends LogEntity {
    // необязательное поле, но можно использовать для запросов
    @Basic
    @Column(name = "customer_id", insertable = false, updatable = false)
    private Long customerId;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "completed")
    private Boolean completed;

    //------------------------------------------------------------------------------------------------------------------

    // отношение Order к customer
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "customer_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_order_to_customer")
    )
    private Customer customer;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "ta_order_travel",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "travel_id"),
            foreignKey = @ForeignKey(name = "fk_order_to_travel")
    )
    private List<Travel> travelList;
}
