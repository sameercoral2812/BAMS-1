package com.vartuhope.banking.bankig.reposetories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vartuhope.banking.bankig.entities.Account;

public interface AccountReposetory extends JpaRepository<Account, Long> {

}
