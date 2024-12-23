package com.usk.customerservice.connectivity;

import com.usk.customerservice.model.response.AccountResponse;
import jakarta.servlet.http.HttpServlet;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class AccountClient {

    RestTemplate restTemplate = new RestTemplate();

    public AccountClient(HttpServlet httpServlet) {
    }


    public AccountResponse getAccountDetails(Long custId) {
        String url = "http://localhost:8081/account-service/getAccountByCustomerId/"+custId;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<AccountResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, AccountResponse.class);

        return response.getBody();

    }

}
