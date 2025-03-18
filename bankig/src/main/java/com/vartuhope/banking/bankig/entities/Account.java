package com.vartuhope.banking.bankig.entities;


import org.hibernate.annotations.Cascade;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    @Column(name = "account_no", unique = true, nullable = false)
    private String accountNo;  // Unique account number

    @Nonnull
    @Column(name = "account_holder_name")
    private String accHolderName;

    @Nonnull
    @Column
    private Double balance;

	@OneToOne
	@JoinColumn(name = "customer_id")
    private Customer customer;  // Now using customer_id as foreign key

    // Constructors
    public Account() {}

    public Account(Long id, String accountNo, String accHolderName, Double balance, Customer customer) {
        this.id = id;
        this.accountNo = accountNo;
        this.accHolderName = accHolderName;
        this.balance = balance;
        this.customer = customer;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAccountNo() { return accountNo; }
    public void setAccountNo(String accountNo) { this.accountNo = accountNo; }

    public String getAccHolderName() { return accHolderName; }
    public void setAccHolderName(String accHolderName) { this.accHolderName = accHolderName; }

    public Double getBalance() { return balance; }
    public void setBalance(Double balance) { this.balance = balance; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}
