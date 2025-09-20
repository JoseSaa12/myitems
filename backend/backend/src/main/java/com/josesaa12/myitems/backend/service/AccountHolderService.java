package com.josesaa12.myitems.backend.service;

import com.josesaa12.myitems.backend.dto.AccountHolderRequest;
import com.josesaa12.myitems.backend.dto.AccountHolderResponse;
import com.josesaa12.myitems.backend.dto.PagedResponse;
import com.josesaa12.myitems.backend.mapper.AccountHolderMapper;
import com.josesaa12.myitems.backend.model.AccountHolder;
import com.josesaa12.myitems.backend.repository.AccountHolderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountHolderService {

    private final AccountHolderRepository repository;

    public AccountHolderService(AccountHolderRepository repository) {
        this.repository = repository;
    }

    // 🔹 Listar todos (sin paginación, simple)
    public List<AccountHolderResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(AccountHolderMapper::toResponse)
                .collect(Collectors.toList());
    }

    // 🔹 Buscar por ID
    public Optional<AccountHolderResponse> findById(Long id) {
        return repository.findById(id)
                .map(AccountHolderMapper::toResponse);
    }

    // 🔹 Crear nuevo
    public AccountHolderResponse save(AccountHolderRequest request) {
        AccountHolder entity = new AccountHolder();
        AccountHolderMapper.apply(entity, request);
        AccountHolder saved = repository.save(entity);
        return AccountHolderMapper.toResponse(saved);
    }

    // 🔹 Actualizar existente
    public Optional<AccountHolderResponse> update(Long id, AccountHolderRequest request) {
        return repository.findById(id).map(existing -> {
            AccountHolderMapper.apply(existing, request);
            AccountHolder updated = repository.save(existing);
            return AccountHolderMapper.toResponse(updated);
        });
    }

    // 🔹 Borrar
    public boolean delete(Long id) {
        return repository.findById(id).map(existing -> {
            repository.delete(existing);
            return true;
        }).orElse(false);
    }

    // 🔹 Borrar por ID
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    // 🔹 Listar con paginación
    public PagedResponse<AccountHolderResponse> findAllPaged(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<AccountHolder> result = repository.findAll(pageable);

        List<AccountHolderResponse> data = result.getContent()
                .stream()
                .map(AccountHolderMapper::toResponse)
                .toList();

        return new PagedResponse<>(data, result.getNumber(), result.getSize(), result.getTotalElements());
    }
}
