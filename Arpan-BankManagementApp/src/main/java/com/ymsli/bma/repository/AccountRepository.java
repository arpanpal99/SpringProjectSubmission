package com.ymsli.bma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ymsli.bma.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
