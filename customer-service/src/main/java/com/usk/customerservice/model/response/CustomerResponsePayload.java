package com.usk.customerservice.model.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class CustomerResponsePayload {

    private Long id;

    private String name;

    private String address;

    private String phone;

    private String email;

    private AccountResponse accountResponse;

    public AccountResponse getAccountResponse() {
        return accountResponse;
    }

    public void setAccountResponse(AccountResponse accountResponse) {
        this.accountResponse = accountResponse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}