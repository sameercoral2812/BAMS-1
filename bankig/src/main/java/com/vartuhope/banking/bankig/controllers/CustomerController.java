package com.vartuhope.banking.bankig.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vartuhope.banking.bankig.dto.AccountDTO;
import com.vartuhope.banking.bankig.dto.CustomerDTO;
import com.vartuhope.banking.bankig.services.CustomerService;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private  final CustomerService customerService;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;

    }

    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody CustomerDTO cust) {
        try {
            String hashedPassword = passwordEncoder.encode(cust.getCustomerPassWord());
            cust.setCustomerPassWord(hashedPassword);
            customerService.registerCustomer(cust);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<CustomerDTO> loginAuthCustomer(@RequestBody Map<String, String> request) {
        
        if(!request.containsKey("email") || !request.containsKey("password") || request.get("email").isEmpty() || request.get("password").isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        CustomerDTO customer = customerService.loginCustomer(request.get("email"), request.get("password"));

        // Match the raw password with the encrypted password in DB
        if (!passwordEncoder.matches(request.get("password"),customer.getCustomerPassWord())) {
            return ResponseEntity.badRequest().body(null);
        }

         return ResponseEntity.ok().body(customer);
    }




}
