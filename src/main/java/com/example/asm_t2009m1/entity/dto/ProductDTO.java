package com.example.asm_t2009m1.entity.dto;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String id;
    private String name;
    private String slug;
    private String description;
    private String detail;
    private String thumbnails;
    private BigDecimal price;
    private String createdAt;
    private String updatedAt;
    private String status;
}
