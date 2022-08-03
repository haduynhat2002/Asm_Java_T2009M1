package com.example.asm_t2009m1.service;

import com.example.asm_t2009m1.entity.Account;
import com.example.asm_t2009m1.entity.Credential;
import com.example.asm_t2009m1.entity.dto.AccountLoginDto;
import com.example.asm_t2009m1.entity.dto.AccountRegisterDto;
import com.example.asm_t2009m1.repository.AccountRepository;
import com.example.asm_t2009m1.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {
    final AccountRepository accountRepository;
    final PasswordEncoder passwordEncoder;

    public AccountRegisterDto register(AccountRegisterDto accountRegisterDto) {
        Optional<Account> optionalAccount =
                accountRepository.findAccountByUserName(accountRegisterDto.getUserName());
        if (optionalAccount.isPresent()){
            return null;
        }
        Account account = Account.builder()
                .userName(accountRegisterDto.getUserName())
                .passwordHash(passwordEncoder.encode(accountRegisterDto.getPassword()))
                .role(accountRegisterDto.getRole())
                .build();
        accountRepository.save(account);
        accountRegisterDto.setId(account.getId());
        return accountRegisterDto;

    }
    public Credential login(AccountLoginDto accountLoginDto){
        Optional<Account> optionalAccount = accountRepository.findAccountByUserName(accountLoginDto.getUserName());
        if (!optionalAccount.isPresent()) {
            throw new UsernameNotFoundException("User name is not found");
        }
        Account account = optionalAccount.get();
        boolean isMatch = passwordEncoder.matches(accountLoginDto.getPassword(), account.getPasswordHash());
        if(isMatch) {
            int expiredAfterDay = 7;
            String accessToKen = JwtUtil.generateTokenByAccount(account, expiredAfterDay * 24 * 60 * 60 * 1000);
            String refreshToken = JwtUtil.generateTokenByAccount(account, 14 * 24 * 60 * 1000);
            Credential credential = new Credential();
            credential.setAccessToken(accessToKen);
            credential.setRefreshToken(refreshToken);
            credential.setScope("basic_information");
            return credential;
        } else {
            throw new UsernameNotFoundException("Password is not match");
        }

    }
    public void getInformation(){

    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Account>  optionalAccount = accountRepository.findAccountByUserName(userName);
        if (!optionalAccount.isPresent()) {
            throw new UsernameNotFoundException("User name is not found");
        }
        Account account = optionalAccount.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        SimpleGrantedAuthority simpleGrantedAuthority
                = new SimpleGrantedAuthority(account.getRole() == 1 ? "ADMIN" : "USER");
        authorities.add(simpleGrantedAuthority);
        return new
                User(account.getUserName(), account.getPasswordHash(), authorities);
    }

}
