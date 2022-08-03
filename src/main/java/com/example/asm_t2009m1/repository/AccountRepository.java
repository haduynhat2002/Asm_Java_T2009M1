package com.example.asm_t2009m1.repository;

import com.example.asm_t2009m1.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findAccountByUserName(String userName);
}
