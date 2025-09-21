package com.josesaa12.myitems.backend.repository;

import com.josesaa12.myitems.backend.model.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {
}