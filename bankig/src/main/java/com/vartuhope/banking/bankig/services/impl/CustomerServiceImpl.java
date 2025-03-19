package com.vartuhope.banking.bankig.services.impl;

import org.springframework.stereotype.Service;

import com.vartuhope.banking.bankig.dto.CustomerDTO;
import com.vartuhope.banking.bankig.entities.Account;
import com.vartuhope.banking.bankig.entities.Customer;
import com.vartuhope.banking.bankig.mapper.CustomerMapper;
import com.vartuhope.banking.bankig.reposetories.AccountReposetory;
import com.vartuhope.banking.bankig.reposetories.CustomerReposetory;
import com.vartuhope.banking.bankig.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

     private final AccountReposetory accountRepository;
	private final CustomerReposetory customerReposetory;

    public CustomerServiceImpl(AccountReposetory accountRepository, CustomerReposetory customerReposetory) {
        this.accountRepository = accountRepository; 
        this.customerReposetory = customerReposetory;   
    }
    

    @Override
    public CustomerDTO registerCustomer(CustomerDTO customerDTO) {
        
        // Convert DTO to Entity
        Customer cust = CustomerMapper.toEntity(customerDTO);
        Customer saveCustomer = customerReposetory.save(cust);
        Account acc = cust.getAccount();
        acc.setCustomer(saveCustomer);
        // Save to Database
		accountRepository.save(acc);
        // Convert Back to DTO and Return
        return CustomerMapper.toDTO(saveCustomer);
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCustomerById'");
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCustomer'");
    }

    @Override
    public void deleteCustomer(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCustomer'");
    }

    @Override
    public CustomerDTO loginCustomer(String email, String password) {
        Customer customer = customerReposetory.findByEmail(email);
        if(customer == null) {
            return null;
        }else{
           // if(customer.getPassword().equals(password)){
                return CustomerMapper.toDTO(customer);
            // }else{
            //     return null;
            // }
        }
    }

}
