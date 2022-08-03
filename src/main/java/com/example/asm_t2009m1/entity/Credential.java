package com.example.asm_t2009m1.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Credential {
    private String accessToken;
    private String refreshToken;
    private long expiredAt;
    private String scope;
}