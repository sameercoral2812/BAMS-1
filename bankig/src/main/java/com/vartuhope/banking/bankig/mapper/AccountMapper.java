package com.vartuhope.banking.bankig.mapper;

import com.vartuhope.banking.bankig.dto.AccountDTO;
import com.vartuhope.banking.bankig.entities.Account;
import com.vartuhope.banking.bankig.entities.Customer;

public class AccountMapper {

    // Convert DTO to Entity
    public static Account mapToAccount(AccountDTO accDTO) {
        Customer customer = new Customer(
            accDTO.getCustomerId(),  // Existing ID (null for new customer)
            accDTO.getCustomerName(),
			accDTO.getCustomerEmail(),
			accDTO.getCustomerPhoneNumber(),
            accDTO.getCustomerAddress()
        );

        Account acc = new Account(
            accDTO.getId(), 
            accDTO.getAccountNo(), 
            accDTO.getAccHolderName(), 
            accDTO.getBalance(), 
            customer
        );

        customer.setAccount(acc); // Ensure bidirectional mapping

        return acc;
    }

    // Convert Entity to DTO
    public static AccountDTO convertToDTO(Account account) {
        if (account == null) {
            return null;
        }
        
        Customer customer = account.getCustomer();
        return new AccountDTO(
            account.getId(),
            account.getAccountNo(),
            account.getAccHolderName(),
            account.getBalance(),
            customer != null ? customer.getId() : null,
            customer != null ? customer.getName() : null,
			customer != null ? customer.getEmail() : null,
            customer != null ? customer.getAddress() : null,
            customer != null ? customer.getPhone() : null
        );
    }
}
