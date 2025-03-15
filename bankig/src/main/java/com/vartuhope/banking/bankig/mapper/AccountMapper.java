package com.vartuhope.banking.bankig.mapper;

import com.vartuhope.banking.bankig.dto.AccountDTO;
import com.vartuhope.banking.bankig.entities.Account;

public class AccountMapper {
	
	public static Account mapToAccount(AccountDTO accDTO) {
		Account acc = new Account(
					accDTO.getId(),
					accDTO.getAccHolderName(),
					accDTO.getBalance()
				);
		return acc;
	} 
	
	
	public static AccountDTO mapToAccountDTO(Account acc) {
		AccountDTO accDTO = new AccountDTO(
					acc.getId(),
					acc.getAccHolderName(),
					acc.getBalance()
				);
		
		return accDTO;
	}

}
