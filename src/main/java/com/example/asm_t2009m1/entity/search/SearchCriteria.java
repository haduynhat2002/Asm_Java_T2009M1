package com.example.asm_t2009m1.entity.search;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchCriteria {
    private String key;
    private SearchCriteriaOperator operator;
    private Object value;
}
