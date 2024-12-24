package com.usk.accountservice.controller;

import com.usk.accountservice.model.request.AccountRequestPayload;
import com.usk.accountservice.model.response.AccountResponsePayload;
import com.usk.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    Environment environment;

    @Autowired
    private AccountService accountService;

    @PostMapping("/createAccount")
    public ResponseEntity<AccountResponsePayload> saveAccount(@RequestBody AccountRequestPayload payload) {
        return new ResponseEntity<>(accountService.saveAccount(payload), HttpStatus.CREATED);
    }

    @GetMapping("/getAccountByCustomerId/{id}")
    public ResponseEntity<AccountResponsePayload> getAccountByCustomerId(@PathVariable Long id) {
        String port = environment.getProperty("local.server.port");
        System.out.println("port num =============>> "+port);
        return new ResponseEntity<>(accountService.getAccountByCustomerId(id), HttpStatus.CREATED);
    }

}
