package com.example.asm_t2009m1.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class OrderDetailId implements Serializable {
    @Column(name = "order_id")
    private String orderId;

    @Column(name = "product_id")
    private String productId;
}
