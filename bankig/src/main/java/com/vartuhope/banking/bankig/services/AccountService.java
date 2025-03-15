package com.vartuhope.banking.bankig.services;

import java.util.List;

import com.vartuhope.banking.bankig.dto.AccountDTO;

public interface AccountService {

	AccountDTO createAccount(AccountDTO accDTO);
	
	AccountDTO getAccountById(Long Id);
	
	AccountDTO diposite(Long id,Double amount);
	
	AccountDTO withdrow(Long id,Double amount);
	
	List<AccountDTO> getAllAccounts();
	
	void deleteAccounts(Long Id);

}
