package com.example.asm_t2009m1.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.math.BigDecimal;

public class OrderDetail {
    @EmbeddedId
    private OrderDetailId id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Order order;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Product product;
    private Integer quantity;
    private BigDecimal unitPrice;
}
