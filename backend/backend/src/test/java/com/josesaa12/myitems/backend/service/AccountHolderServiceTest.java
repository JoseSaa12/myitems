package com.josesaa12.myitems.backend.service;

import com.josesaa12.myitems.backend.dto.AccountHolderRequest;
import com.josesaa12.myitems.backend.dto.AccountHolderResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountHolderServiceTest {

    @Autowired
    private AccountHolderService service;

    // ✅ 1. GET all (ya lo tienes, lo dejamos aquí)
    @Test
    void testFindAll_ReturnsSeeds() {
        List<AccountHolderResponse> result = service.findAll();

        assertNotNull(result);
        assertTrue(result.size() > 0, "Debe haber seeds cargados en H2");
        assertNotNull(result.get(0).getName());
        assertFalse(result.get(0).getName().isBlank());
    }

    // ✅ 2. POST (crear nuevo AccountHolder)
    @Test
    void testSave_CreatesNewAccountHolder() {
        AccountHolderRequest request = new AccountHolderRequest();
        request.setName("TestUser");
        request.setDescription("Usuario creado en test");
        request.setTags(List.of("test"));

        AccountHolderResponse created = service.save(request);

        assertNotNull(created.getId());
        assertEquals("TestUser", created.getName());
        assertEquals("Usuario creado en test", created.getDescription());
    }

    // ✅ 3. GET by ID
    @Test
    void testFindById_ReturnsAccountHolder() {
        // Creamos un nuevo usuario
        AccountHolderRequest request = new AccountHolderRequest();
        request.setName("FindMe");
        request.setDescription("Buscar por ID");
        request.setTags(List.of("lookup"));

        AccountHolderResponse created = service.save(request);

        // Lo buscamos por su ID
        Optional<AccountHolderResponse> found = service.findById(created.getId());

        assertTrue(found.isPresent(), "El usuario debería existir");
        assertEquals("FindMe", found.get().getName());
    }

    // ✅ 4. DELETE
    @Test
    void testDelete_RemovesAccountHolder() {
        // Creamos un usuario temporal
        AccountHolderRequest request = new AccountHolderRequest();
        request.setName("DeleteMe");
        request.setDescription("Usuario temporal");
        request.setTags(List.of("temp"));

        AccountHolderResponse created = service.save(request);

        // Lo borramos
        boolean deleted = service.delete(created.getId());

        assertTrue(deleted, "El usuario debería borrarse");
        assertTrue(service.findById(created.getId()).isEmpty(), "El usuario ya no debería existir");
    }
}
