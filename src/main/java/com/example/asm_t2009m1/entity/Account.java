package com.example.asm_t2009m1.entity;

import com.example.asm_t2009m1.entity.base.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class Account extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String password;
    private String passwordHash;
    private double phone;
    private String email;
    private int role;
    private int status;
}
