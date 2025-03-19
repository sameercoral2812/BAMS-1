package com.vartuhope.banking.bankig.entities;

import jakarta.annotation.Generated;
import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Nonnull
    @Column(name = "customer_name")
    private String name;

    @Nonnull
    @Column(name = "customer_email", unique = true, nullable = false)
    private String email;

    @Nonnull
    @Column(name = "customer_password", nullable = false)
    private String password;

    @Nonnull
    @Column(name = "customer_phone", unique = true, nullable = false)
    private String phone;

    @Nonnull
    @Column(name = "customer_address")
    private String address;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Account account; // Now Account will hold the foreign key

    // Constructors
    public Customer() {}

    public Customer(Long id, String name, String email,String password, String phone, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }
}
