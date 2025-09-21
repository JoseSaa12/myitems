package com.josesaa12.myitems.backend.config;

import com.josesaa12.myitems.backend.dto.AccountHolderRequest;
import com.josesaa12.myitems.backend.service.AccountHolderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataSeeder {

    // ✅ bean  automatico al arrancar la app
    @Bean
    CommandLineRunner initDatabase(AccountHolderService service) {
        return args -> {
            if (service.findAll().isEmpty()) {
                // 👉 Solo inserta si la base está vacía
                service.save(new AccountHolderRequest(
                        "Jose",
                        "Administrador inicial",
                        List.of("admin", "mma")
                ));

                service.save(new AccountHolderRequest(
                        "Laura",
                        "Primera clienta",
                        List.of("premium", "fitness")
                ));

                service.save(new AccountHolderRequest(
                        "Carlos",
                        "Cliente de prueba",
                        List.of("basic", "trial")
                ));

                System.out.println("✅ Datos iniciales cargados en AccountHolder");
            } else {
                System.out.println("ℹ️ Ya existían datos, no se insertaron seeds.");
            }
        };
    }
}
