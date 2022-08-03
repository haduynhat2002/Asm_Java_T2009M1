package com.example.asm_t2009m1.controller;

import com.example.asm_t2009m1.entity.Product;
import com.example.asm_t2009m1.entity.dto.ProductDTO;
import com.example.asm_t2009m1.entity.emuns.ProductSimpleStatus;
import com.example.asm_t2009m1.repository.ProductRepository;
import org.hibernate.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductApi {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody ProductDTO productDTO) {
        // tạo ra product từ productdto
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(product.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setSlug(StringHelper.toSlug(productDTO.getName()));
        product.setStatus(ProductSimpleStatus.ACTIVE);
        productRepository.save(product);
        productDTO.setId(product.getId());
        productDTO.setCreatedAt(product.getCreatedAt() == null ? "" : product.getCreatedAt().toString());
        productDTO.setUpdatedAt(product.getUpdatedAt() == null ? "" : product.getUpdatedAt().toString());
        productDTO.setStatus(product.getStatus().name());
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }
}
