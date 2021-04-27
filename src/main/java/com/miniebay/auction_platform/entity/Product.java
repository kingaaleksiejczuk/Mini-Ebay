package com.miniebay.auction_platform.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;

    @Column (name = "product_name")
    private String name;

    @Column (name = "product_desc")
    private String description;

    @Column (name = "product_price")
    private double price;

    @Column (name = "initial_bid")
    private int initial_bid;

    @Column (name = "max_bid")
    private int max_bid;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "product")
    private List<Bid> bids;

}
