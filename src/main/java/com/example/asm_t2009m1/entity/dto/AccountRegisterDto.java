package com.example.asm_t2009m1.entity.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountRegisterDto {
    private long id;
    private String userName;
    private String password;
    private String confirmPassword;
    private int role;
}