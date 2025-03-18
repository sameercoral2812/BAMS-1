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
        try {
            System.out.println("=========== AccountDTO : "+accDTO.getCustomerEmail());
            AccountDTO savedAccount = accountService.createAccount(accDTO);
            return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("=========== Exception : "+e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getAccount(@PathVariable Long id) {
        AccountDTO savedAccount = accountService.getAccountById(id);
        return savedAccount != null ? ResponseEntity.ok(savedAccount) : ResponseEntity.notFound().build();
    }

    @PutMapping("/deposit/{id}")
    public ResponseEntity<AccountDTO> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        if (!request.containsKey("amount") || request.get("amount") <= 0) {
            return ResponseEntity.badRequest().body(null);
        }
        AccountDTO updatedAccount = accountService.diposite(id, request.get("amount"));
        return ResponseEntity.ok(updatedAccount);
    }

    @PutMapping("/withdraw/{id}")
    public ResponseEntity<AccountDTO> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        if (!request.containsKey("amount") || request.get("amount") <= 0) {
            return ResponseEntity.badRequest().body(null);
        }
        AccountDTO updatedAccount = accountService.withdrow(id, request.get("amount"));
        return ResponseEntity.ok(updatedAccount);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AccountDTO>> getAllAccounts() {
        List<AccountDTO> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAccounts(@PathVariable Long id) {
        accountService.deleteAccounts(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
