package com.example.asm_t2009m1.controller;

import com.example.asm_t2009m1.entity.CartItem;
import com.example.asm_t2009m1.entity.CartItemId;
import com.example.asm_t2009m1.entity.Product;
import com.example.asm_t2009m1.entity.ShoppingCart;
import com.example.asm_t2009m1.entity.dto.CartItemDTO;
import com.example.asm_t2009m1.entity.dto.ShoppingCartDTO;
import com.example.asm_t2009m1.repository.ProductRepository;
import com.example.asm_t2009m1.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/shopping-carts")
public class ShoppingCartApi {

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.POST)
    public void saveCart(@RequestParam String userId, @RequestBody ShoppingCartDTO shoppingCartDTO){
        boolean hasException = false;
        ShoppingCart shoppingCart = ShoppingCart.builder()
                .id(UUID.randomUUID().toString())
                .userId(userId)
                .shipName(shoppingCartDTO.getShipName())
                .shipAddress(shoppingCartDTO.getShipAddress())
                .shipNote(shoppingCartDTO.getShipNote())
                .shipPhone(shoppingCartDTO.getShipPhone())
                .build();
        Set<CartItem> setCartItem = new HashSet<>();
        System.out.println(shoppingCart.getId());
        for (CartItemDTO cartItemDTO :
                shoppingCartDTO.getItems()) {
            Optional<Product> optionalProduct = productRepository.findById(cartItemDTO.getProductId());
            if(!optionalProduct.isPresent()){
                hasException = true;
                break;
            }
            Product product = optionalProduct.get();
            CartItem cartItem = CartItem.builder()
                    .id(new CartItemId(shoppingCart.getId(), product.getId()))
                    .productName(product.getName())
                    .productImage(product.getThumbnails())
                    .quantity(cartItemDTO.getQuantity())
                    .unitPrice(product.getPrice())
                    .shoppingCart(shoppingCart)
                    .build();

            shoppingCart.addTotalPrice(cartItem);
            setCartItem.add(cartItem);
        }
        shoppingCart.setItems(setCartItem);
        shoppingCartRepository.save(shoppingCart);
    }
}
