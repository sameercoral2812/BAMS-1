package com.vartuhope.banking.bankig.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vartuhope.banking.bankig.dto.AccountDTO;
import com.vartuhope.banking.bankig.services.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accDTO) {
        AccountDTO savedAccount = accountService.createAccount(accDTO);
        return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
    }
    
    //Get method rest api
    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getAccount(@PathVariable Long id) {
        AccountDTO savedAccount = accountService.getAccountById(id);
        return ResponseEntity.ok(savedAccount);
    }
    
    @PutMapping("/deposit/{id}")
    public ResponseEntity<AccountDTO> deposit(@PathVariable Long id,@RequestBody Map<String, Double> amount) {
        AccountDTO savedAccount = accountService.diposite(id,amount.get("amount"));
        return ResponseEntity.ok(savedAccount);
    }
    
    
    @PutMapping("/withdrow/{id}")
    public ResponseEntity<AccountDTO> withdrow(@PathVariable Long id,@RequestBody Map<String, Double> amount) {
        AccountDTO savedAccount = accountService.withdrow(id,amount.get("amount"));
        return ResponseEntity.ok(savedAccount);
    }
    
    
    
    @GetMapping("/all")
    public ResponseEntity<List<AccountDTO>> getAllAccounts() {
    	List<AccountDTO> savedAccount = accountService.getAllAccounts();
        return ResponseEntity.ok(savedAccount);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccounts(@PathVariable Long id) {
    	 accountService.deleteAccounts(id);
    	return ResponseEntity.ok("Account deleted successfully");
  
    }
}
