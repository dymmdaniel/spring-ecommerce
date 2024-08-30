package com.dm.ecommerce.inventory_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="rate_item")
public class RateItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rateItemId;

    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private List<Double> rating;
}
