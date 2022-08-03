package com.example.asm_t2009m1.search;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchCriteria {
    private String key; // trường nào
    private SearchCriteriaOperator operator; // toán tử
    private Object value; // giá trị là gì
}
