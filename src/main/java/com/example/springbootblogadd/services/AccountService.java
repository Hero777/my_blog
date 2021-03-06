package com.example.springbootblogadd.services;

import com.example.springbootblogadd.models.Account;
import com.example.springbootblogadd.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account save(Account account) {
        return accountRepository.save(account);
    }


    public Optional<Account> findOneByEmail(String email) {
        return accountRepository.findOneByEmail(email);
    }
}
