package com.josesaa12.myitems.backend.controller;

import com.josesaa12.myitems.backend.dto.AccountHolderRequest;
import com.josesaa12.myitems.backend.dto.AccountHolderResponse;
import com.josesaa12.myitems.backend.dto.PagedResponse;
import com.josesaa12.myitems.backend.service.AccountHolderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/account-holders")
public class AccountHolderController {

    private final AccountHolderService service;

    public AccountHolderController(AccountHolderService service) {
        this.service = service;
    }

    // ✅ Listar todos (sin paginación)
    @GetMapping
    public List<AccountHolderResponse> list() {
        return service.findAll();
    }

    // ✅ Listar con paginación
    @GetMapping("/paged")
    public PagedResponse<AccountHolderResponse> listPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return service.findAllPaged(page, size);
    }



    // ✅ Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<AccountHolderResponse> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    // ✅ Crear
    @PostMapping
    public AccountHolderResponse create(@Valid @RequestBody AccountHolderRequest request) {
        return service.save(request);
    }

    // ✅ Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<AccountHolderResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody AccountHolderRequest request
    ) {
        return service.update(id, request)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ Borrar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.findById(id)
                .map(existing -> {
                    service.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ⚠️ Manejo simple de errores de validación dentro controller
    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(
            org.springframework.web.bind.MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
