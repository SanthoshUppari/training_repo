package com.usk.accountservice.repository;

import com.usk.accountservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByCustomerId(Long id);

}
