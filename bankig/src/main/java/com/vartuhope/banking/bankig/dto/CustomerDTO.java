package com.vartuhope.banking.bankig.dto;

public class CustomerDTO {

    // Customer Details
    private Long customerId;
    private String customerName;
	private String customerEmail;
	private String customerPassWord;
    private String customerAddress;
    private String customerPhoneNumber;
    // Account Details
    private Long id;
    private String accountNo;
    private String accHolderName;
    private Double balance;

    // Default Constructor
    public CustomerDTO() {}



    // Constructor with fields  
    public CustomerDTO(Long customerId, String customerName, String customerEmail, String customerPassWord, String customerAddress, String customerPhoneNumber, Long id, String accountNo, String accHolderName, Double balance) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPassWord = customerPassWord;
        this.customerAddress = customerAddress;
        this.customerPhoneNumber = customerPhoneNumber;
        this.id = id;
        this.accountNo = accountNo;
        this.accHolderName = accHolderName;
        this.balance = balance;
    }

    // Getters and Setters
    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }

    public String getCustomerPassWord() { return customerPassWord; }
    public void setCustomerPassWord(String customerPassWord) { this.customerPassWord = customerPassWord; }

    public String getCustomerAddress() { return customerAddress; }
    public void setCustomerAddress(String customerAddress) { this.customerAddress = customerAddress; }

    public String getCustomerPhoneNumber() { return customerPhoneNumber; }
    public void setCustomerPhoneNumber(String customerPhoneNumber) { this.customerPhoneNumber = customerPhoneNumber; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAccountNo() { return accountNo; }
    public void setAccountNo(String accountNo) { this.accountNo = accountNo; }

    public String getAccHolderName() { return accHolderName; }
    public void setAccHolderName(String accHolderName) { this.accHolderName = accHolderName; }

    public Double getBalance() { return balance; }
    public void setBalance(Double balance) { this.balance = balance; }

    // toString() method
    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerPassWord='" + customerPassWord + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                ", id=" + id +
                ", accountNo='" + accountNo + '\'' +
                ", accHolderName='" + accHolderName + '\'' +
                ", balance=" + balance +
                '}';
    }



    public CustomerDTO orElseThrow(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'orElseThrow'");
    }

}
