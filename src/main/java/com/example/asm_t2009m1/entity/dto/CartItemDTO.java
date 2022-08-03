package com.example.asm_t2009m1.entity.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItemDTO {
    private String productId;
    private int quantity;
}
