package com.vartuhope.banking.bankig.services;

import com.vartuhope.banking.bankig.dto.CustomerDTO;

public interface CustomerService {

    public CustomerDTO registerCustomer(CustomerDTO customerDTO);

    public CustomerDTO getCustomerById(Long id);

    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);

    public void deleteCustomer(Long id);

    public CustomerDTO loginCustomer(String email, String password);
}
