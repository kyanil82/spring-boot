package com.aky.banking.mapper;

import com.aky.banking.dto.AccountDto;
import com.aky.banking.entity.Account;

public class AccountMapper {

    public static Account mapToAcount(AccountDto accountDto){
        Account account = new Account(
                accountDto.getId(),
                accountDto.getHolderName(),
                accountDto.getBalance()
        );

        return account;
    }

    public static AccountDto mapToAcountDto(Account account){
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getHolderName(),
                account.getBalance()
        );

        return accountDto;
    }
}
