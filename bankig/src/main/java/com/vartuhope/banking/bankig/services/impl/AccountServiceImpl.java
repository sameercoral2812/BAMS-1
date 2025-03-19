package com.vartuhope.banking.bankig.services.impl;

import com.vartuhope.banking.bankig.dto.AccountDTO;
import com.vartuhope.banking.bankig.entities.Account;
import com.vartuhope.banking.bankig.entities.Customer;
import com.vartuhope.banking.bankig.mapper.AccountMapper;
import com.vartuhope.banking.bankig.reposetories.AccountReposetory;
import com.vartuhope.banking.bankig.reposetories.CustomerReposetory;
import com.vartuhope.banking.bankig.services.AccountService;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountReposetory accountRepository;
	private final CustomerReposetory customerReposetory;


    public AccountServiceImpl(AccountReposetory accountRepository, CustomerReposetory customerReposetory) {
        this.accountRepository = accountRepository;
		this.customerReposetory = customerReposetory;
    }


    @Override
    public AccountDTO createAccount(AccountDTO accDTO) {

        // Convert DTO to Entity
        Account acc = AccountMapper.mapToAccount(accDTO);
		Customer customer = acc.getCustomer();
        // Save to Database
		customerReposetory.save(customer);
        Account savedAccount = accountRepository.save(acc);
        
        // Convert Back to DTO and Return
        return AccountMapper.convertToDTO(savedAccount);
    }

	@Override
	public AccountDTO getAccountById(Long Id) {
		Account acc= accountRepository.findById(Id).orElseThrow();
		return AccountMapper.convertToDTO(acc);
	}

	@Override
	public AccountDTO diposite(Long id, Double amount) {
		Account acc= accountRepository.findById(id).orElseThrow();
		Double finalAmount = amount+acc.getBalance(); 
		System.out.println("=========== Deposit Amount : "+amount+" last Amount : "+acc.getBalance()+" currnt balance : "+finalAmount);
		acc.setBalance(finalAmount);
		Account saveAcc= accountRepository.save(acc);
		return AccountMapper.convertToDTO(saveAcc);
	}

	@Override
	public AccountDTO withdrow(Long id, Double amount) {
		Account acc= accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
		if (amount > acc.getBalance()) {
	        throw new RuntimeException("Insufficient balance! You only have " + acc.getBalance());
	    }
		Double finalAmount = acc.getBalance()-amount; 
		System.out.println("=========== withdrow Amount : "+amount+" last Amount : "+acc.getBalance()+" currnt balance : "+finalAmount);
		acc.setBalance(finalAmount);
		Account saveAcc= accountRepository.save(acc);
		return AccountMapper.convertToDTO(saveAcc);
	}

	@Override
	public List<AccountDTO> getAllAccounts() {
		List<Account> accounts = accountRepository.findAll();
		return	accounts.stream().map((account)->AccountMapper.convertToDTO(account)).collect(Collectors.toList());
	}

	@Override
	public void deleteAccounts(Long Id) {
		Account acc= accountRepository.findById(Id).orElseThrow(() -> new RuntimeException("Account not found"));
		accountRepository.deleteById(Id);
	}
}
