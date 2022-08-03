package com.example.asm_t2009m1.entity.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountLoginDto {
    private String userName;
    private String password;
}