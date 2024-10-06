package com.aky.banking.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountDto {

    private Long id;

    private String holderName;

    private double balance;


}
