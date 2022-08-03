package com.example.asm_t2009m1;

import com.example.asm_t2009m1.entity.Credential;
import com.example.asm_t2009m1.entity.dto.AccountLoginDto;
import com.example.asm_t2009m1.entity.dto.AccountRegisterDto;
import com.example.asm_t2009m1.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AsmT2009M1Application.class)
class AsmT2009M1ApplicationTests {

    @Autowired
    AccountService accountService;
    @Test
    void register() {
        AccountRegisterDto accountRegisterDto = new AccountRegisterDto();
        accountRegisterDto.setUserName("haduynhat");
        accountRegisterDto.setPassword("1234567");
        accountRegisterDto.setRole(1);
        AccountRegisterDto afterCreate = accountService.register(accountRegisterDto);
        System.out.println(afterCreate);
    }
    @Test
    void login() {
        AccountLoginDto accountLoginDto = new AccountLoginDto();
        accountLoginDto.setUserName("haduynhat");
        accountLoginDto.setPassword("1234567");
        Credential credential = accountService.login(accountLoginDto);
        System.out.println(credential.toString());
    }

}
