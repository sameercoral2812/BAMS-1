package com.vartuhope.banking.bankig.dto;

import com.vartuhope.banking.bankig.entities.Account;

public class AccountDTO {

    private Long id;
    private String accountNo;
    private String accHolderName;
    private Double balance;

    // Customer Details
    private Long customerId;
    private String customerName;
	private String customerEmail;
    private String customerAddress;
    private String customerPhoneNumber;

    // Default Constructor
    public AccountDTO() {}

    // Constructor with fields
    public AccountDTO(Long id, String accountNo, String accHolderName, Double balance,
                      Long customerId, String customerName,String customerEmail, String customerAddress, String customerPhoneNumber) {
        this.id = id;
        this.accountNo = accountNo;
        this.accHolderName = accHolderName;
        this.balance = balance;
        this.customerId = customerId;
        this.customerName = customerName;
		this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerPhoneNumber = customerPhoneNumber;
    }

    // Constructor to Map Account Entity to DTO
    public AccountDTO(Account account) {
        this.id = account.getId();
        this.accountNo = account.getAccountNo();
        this.accHolderName = account.getAccHolderName();
        this.balance = account.getBalance();
        
        if (account.getCustomer() != null) {
            this.customerId = account.getCustomer().getId();
            this.customerName = account.getCustomer().getName();
			this.customerEmail = account.getCustomer().getEmail();
            this.customerAddress = account.getCustomer().getAddress();
            this.customerPhoneNumber = account.getCustomer().getPhone();
        }
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAccountNo() { return accountNo; }
    public void setAccountNo(String accountNo) { this.accountNo = accountNo; }

    public String getAccHolderName() { return accHolderName; }
    public void setAccHolderName(String accHolderName) { this.accHolderName = accHolderName; }

	public String getCustomerEmail() { return customerEmail; }
	public void setCustomeeEmail(String customerEmail) { this.customerEmail = customerEmail; }

    public Double getBalance() { return balance; }
    public void setBalance(Double balance) { this.balance = balance; }

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCustomerAddress() { return customerAddress; }
    public void setCustomerAddress(String customerAddress) { this.customerAddress = customerAddress; }

    public String getCustomerPhoneNumber() { return customerPhoneNumber; }
    public void setCustomerPhoneNumber(String customerPhoneNumber) { this.customerPhoneNumber = customerPhoneNumber; }
}
