package com.aky.banking.service.impl;

import com.aky.banking.dto.AccountDto;
import com.aky.banking.entity.Account;
import com.aky.banking.mapper.AccountMapper;
import com.aky.banking.repository.AccountRepository;
import com.aky.banking.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAcount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return  AccountMapper.mapToAcountDto(savedAccount);
    }

    public AccountDto getAccountById(Long Id) {
        Account account = accountRepository.findById(Id).orElseThrow(()-> new RuntimeException("Account does not exist"));
        return  AccountMapper.mapToAcountDto(account);
    }
}
