package com.example.asm_t2009m1.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CredentialDto {
    private String accessToken;
    private String refreshToken;
    private long expiredAt;
    private String scope;
}