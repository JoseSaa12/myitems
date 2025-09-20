package com.josesaa12.myitems.backend.service;

import com.josesaa12.myitems.backend.model.AccountHolder;
import com.josesaa12.myitems.backend.repository.AccountHolderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountHolderService {

    private final AccountHolderRepository repository;

    // Inyección del repositorio por constructor
    public AccountHolderService(AccountHolderRepository repository) {
        this.repository = repository;
    }

    public List<AccountHolder> findAll() {
        return repository.findAll();
    }

    public Optional<AccountHolder> findById(Long id) {
        return repository.findById(id);
    }

    public AccountHolder save(AccountHolder accountHolder) {
        return repository.save(accountHolder);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
