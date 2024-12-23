package com.usk.customerservice.controller;

import com.usk.customerservice.entity.Customer;
import com.usk.customerservice.model.request.CustomerRequestPayload;
import com.usk.customerservice.model.response.CustomerResponsePayload;
import com.usk.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping(path = "/saveCustomer")
    public ResponseEntity<CustomerResponsePayload> saveCustomer(@RequestBody CustomerRequestPayload customerRequestPayload) {
        return new ResponseEntity<>(customerService.saveCustomer(customerRequestPayload), HttpStatus.CREATED);
    }

    @GetMapping("/getCustomerDetainls/{id}")
    public ResponseEntity<CustomerResponsePayload> getCustomerDetails(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.getCustomerDetails(id), HttpStatus.OK);
    }
}
