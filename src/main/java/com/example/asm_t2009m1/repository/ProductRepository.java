package com.example.asm_t2009m1.repository;

import com.example.asm_t2009m1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
