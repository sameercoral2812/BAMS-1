package com.vartuhope.banking.bankig.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="accounts")
public class Account {
	
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Nonnull
	@Column(name = "account_holder_name")
	private String accHolderName;
	
	@Nonnull
	@Column
	private Double balance; 
	
	
	public Account(Long id, String accHolderName, Double balance) {
		super();
		this.id = id;
		this.accHolderName = accHolderName;
		this.balance = balance;
	}


	public Account() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getAccHolderName() {
		return accHolderName;
	}


	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}


	public Double getBalance() {
		return balance;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	
	

}
