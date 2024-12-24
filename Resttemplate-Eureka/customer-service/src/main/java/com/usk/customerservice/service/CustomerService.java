package com.usk.customerservice.service;

import com.usk.customerservice.connectivity.AccountClient;
import com.usk.customerservice.entity.Customer;
import com.usk.customerservice.model.request.CustomerRequestPayload;
import com.usk.customerservice.model.response.AccountResponse;
import com.usk.customerservice.model.response.AccountResponsePayload;
import com.usk.customerservice.model.response.CustomerResponsePayload;
import com.usk.customerservice.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AccountClient accountClient;

    public CustomerResponsePayload saveCustomer(CustomerRequestPayload customerRequestPayload) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerRequestPayload,  customer);
        Customer dbCustomer = customerRepository.save(customer);

        AccountResponsePayload accountResponsePayload = accountClient.createAccount(dbCustomer.getId());


        CustomerResponsePayload customerResponsePayload = new CustomerResponsePayload();
        BeanUtils.copyProperties(dbCustomer, customerResponsePayload);

        AccountResponse accountResponse = new AccountResponse();
        BeanUtils.copyProperties(accountResponsePayload, accountResponse);
        customerResponsePayload.setAccountResponse(accountResponse);

        return customerResponsePayload;
    }

    public CustomerResponsePayload getCustomerDetails(Long id) {
        CustomerResponsePayload customerResponsePayload = new CustomerResponsePayload();
        Customer customer = customerRepository.findById(id).get();
        BeanUtils.copyProperties(customer, customerResponsePayload);


        AccountResponse accountDetails = accountClient.getAccountDetails(id);
        customerResponsePayload.setAccountResponse(accountDetails);

        return customerResponsePayload;
    }
}
