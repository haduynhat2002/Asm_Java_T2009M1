package com.example.asm_t2009m1.entity;

import com.example.asm_t2009m1.entity.base.BaseEntity;
import com.example.asm_t2009m1.entity.emuns.ProductSimpleStatus;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @Id
    private String id;
    private String name;
    private String slug;
    private String description;
    private String detail; // text
    private String thumbnails; // nhiều ảnh cách nhau bởi dấu ,
    private BigDecimal price;
    @Enumerated(EnumType.ORDINAL)
    private ProductSimpleStatus status;

    public Product(){
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
    }
}
