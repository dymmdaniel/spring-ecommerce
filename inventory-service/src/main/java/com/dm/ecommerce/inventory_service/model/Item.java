package com.dm.ecommerce.inventory_service.model;


import com.dm.ecommerce.user_service.model.Comment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    private Long itemNumber;

    private String name;

    private String shortDescription;

    private String description;

    private BigDecimal price;

    private boolean isActivated;

    @Transient
    private List<Comment> comments;

    @OneToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

    @OneToOne
    @JoinColumn(name = "rate_item_id")
    private RateItem rateItem;

    @ManyToMany
    @JoinTable(
            name = "item_category",
            joinColumns = @JoinColumn(name="item_id"),
            inverseJoinColumns = @JoinColumn(name="category_id")
    )
    private List<Category> category;

}
