package com.example.asm_t2009m1.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cart_items")
public class CartItem {
    @EmbeddedId
    private CartItemId id;
    private String productName;
    private String productImage;
    private int quantity;
    private BigDecimal unitPrice;
    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("shoppingCartId")
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;
}
