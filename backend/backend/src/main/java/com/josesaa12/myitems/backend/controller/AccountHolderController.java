package com.josesaa12.myitems.backend.controller;

import com.josesaa12.myitems.backend.model.AccountHolder;
import com.josesaa12.myitems.backend.service.AccountHolderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account-holders")
public class AccountHolderController {

    private final AccountHolderService service;

    public AccountHolderController(AccountHolderService service) {
        this.service = service;
    }

    // Listado simple (opcional, útil para probar rápido)
    @GetMapping
    public List<AccountHolder> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public AccountHolder create(@RequestBody AccountHolder accountHolder) {
        return service.save(accountHolder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AccountHolder accountHolder) {
        return service.findById(id)
                .map(existing -> {
                    accountHolder.setId(id);
                    return ResponseEntity.ok(service.save(accountHolder));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return service.findById(id)
                .map(existing -> {
                    service.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

