package com.vartuhope.banking.bankig.mapper;

import com.vartuhope.banking.bankig.dto.CustomerDTO;
import com.vartuhope.banking.bankig.entities.Account;
import com.vartuhope.banking.bankig.entities.Customer;

public class CustomerMapper {

    public static CustomerDTO toDTO(Customer customer) {
        if(customer == null) {
            return null;
        }

        Account account = customer.getAccount();
        return new CustomerDTO(
            customer.getId(),
            customer.getName(),
            customer.getEmail(),
            customer.getPassword(),
            customer.getAddress(),
            customer.getPhone(),
            account != null ? account.getId() : null,
            account != null ? account.getAccountNo() : null,
            account != null ? account.getAccHolderName() : null,
            account != null ? account.getBalance() : null
            );
    }

    public static Customer toEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setName(customerDTO.getCustomerName());
        customer.setEmail(customerDTO.getCustomerEmail());
        customer.setPassword(customerDTO.getCustomerPassWord());
        customer.setAddress(customerDTO.getCustomerAddress());
        customer.setPhone(customerDTO.getCustomerPhoneNumber());

        Account account = new Account();
        account.setId(customerDTO.getId());
        account.setAccountNo(customerDTO.getAccountNo());
        account.setAccHolderName(customerDTO.getAccHolderName());
        account.setBalance(customerDTO.getBalance());
        customer.setAccount(account);

        return customer;
    }

}
