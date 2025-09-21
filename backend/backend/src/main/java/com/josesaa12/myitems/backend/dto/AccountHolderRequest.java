package com.josesaa12.myitems.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

public class AccountHolderRequest {

    @NotBlank
    @Size(min = 2, max = 100)
    private String name;

    @Size(max = 1000)
    private String description;

    // Lista de tags que enviaremos/recibiremos como array de strings
    private List<String> tags;

    // ✅ Constructor vacío (necesario para Spring)
    public AccountHolderRequest() {
    }

    // ✅ Constructor con parámetros (necesario para DataSeeder)
    public AccountHolderRequest(String name, String description, List<String> tags) {
        this.name = name;
        this.description = description;
        this.tags = tags;
    }

    // Getters & setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }
}