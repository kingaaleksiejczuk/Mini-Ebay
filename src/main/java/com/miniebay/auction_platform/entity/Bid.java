package com.miniebay.auction_platform.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "bid")
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bid_id")
    private Long id;


    @NotNull
    private double bidAmount;

    private Date bidDate;

    private Boolean bidStatus;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;
}
