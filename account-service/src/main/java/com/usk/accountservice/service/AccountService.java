package com.usk.accountservice.service;

import com.usk.accountservice.entity.Account;
import com.usk.accountservice.model.request.AccountRequestPayload;
import com.usk.accountservice.model.response.AccountResponsePayload;
import com.usk.accountservice.repository.AccountRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public AccountResponsePayload saveAccount(AccountRequestPayload accountRequestPayload) {
        Account account = new Account();
        BeanUtils.copyProperties(accountRequestPayload, account);
        account.setCreatedAt(LocalDateTime.now());
        accountRepository.save(account);
        AccountResponsePayload accountResponsePayload = new AccountResponsePayload();
        BeanUtils.copyProperties(account, accountResponsePayload);
        return accountResponsePayload;
    }

    public AccountResponsePayload getAccountByCustomerId(Long id) {
        AccountResponsePayload accountResponsePayload = new AccountResponsePayload();
        Account account = accountRepository.findByCustomerId(id);
        BeanUtils.copyProperties(account, accountResponsePayload);
        return accountResponsePayload;
    }
}
