package com.aky.banking.controller;

import com.aky.banking.dto.AccountDto;
import com.aky.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService)
    {
        this.accountService = accountService;
    }

    // Add Account Rest API

    @PostMapping("/addAccount")
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto)
    {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping("/getAccount/{Id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long Id)
    {
        return new ResponseEntity<>(accountService.getAccountById(Id), HttpStatus.OK);
    }
}
