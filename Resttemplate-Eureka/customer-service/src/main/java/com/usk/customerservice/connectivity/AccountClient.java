package com.usk.customerservice.connectivity;


import com.usk.customerservice.model.response.AccountResponse;

import com.usk.customerservice.model.response.AccountResponsePayload;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Random;


@Component
public class AccountClient {

    @Autowired
    RestTemplate restTemplate;

    public AccountResponse getAccountDetails(Long custId) {
        String url = "http://ACCOUNT-SERVICE/account-service/getAccountByCustomerId/"+custId;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<AccountResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, AccountResponse.class);

        return response.getBody();

    }


    public AccountResponsePayload createAccount(Long custId){
        String url = "http://ACCOUNT-SERVICE/account-service/createAccount";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject requestBody = new JSONObject();
        requestBody.put("accountNumber", getAccNum());
        requestBody.put("customerId", custId);
        requestBody.put("accountType", "Savings");
        requestBody.put("balance", 10000);


        HttpEntity<String> entity = new HttpEntity<>(requestBody.toString() ,headers);

        ResponseEntity<AccountResponsePayload> response = restTemplate.exchange(url, HttpMethod.POST, entity, AccountResponsePayload.class);

        return response.getBody();
    }


    private long getAccNum() {
        Random random = new Random();
        return Math.round(random.nextFloat() * Math.pow(10,12));
    }

}
