package com.example.asm_t2009m1.entity.search;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FilterParameter {
    private String keyword;
    private int page;
    private int limit;
    private String userId;
    private int status;
}
