package com.mifel.poke.controller;

import com.mifel.poke.service.CryptoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/crypto")
public class CryptoController {
    private final CryptoService cryptoService;

    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @PostMapping("/encrypt")
    public ResponseEntity<?> encrypt(@RequestBody Map<String, String> body) {
        try {
            String texto = body.get("texto");
            String encrypted = cryptoService.encrypt(texto);
            return ResponseEntity.ok(Map.of(
                    "original", texto,
                    "encrypted", encrypted));
        }catch (Exception e){
            return ResponseEntity.status(500).body(Map.of(
                    "error", e.getMessage()));

        }
    }
    @PostMapping("/decrypt")
    public ResponseEntity<?> decrypt(@RequestBody Map<String, String> body) {
        try {
            String texto = body.get("texto");
            String decrypted = cryptoService.decrypt(texto);
            return ResponseEntity.ok(Map.of(
                    "encrypted", texto,
                    "decrypted", decrypted));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("error", e.getMessage()));
        }
    }
}
