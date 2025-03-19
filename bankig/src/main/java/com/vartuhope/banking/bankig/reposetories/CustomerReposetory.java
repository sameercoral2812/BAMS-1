package com.vartuhope.banking.bankig.reposetories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vartuhope.banking.bankig.entities.Customer;

public interface CustomerReposetory extends JpaRepository<Customer, Long> {

    public Customer findByEmail(String email);

}
