package com.mifel.poke.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneral(Exception exception){
        return ResponseEntity.status(500).body(Map.of(
                "error", exception.getMessage(),
                "timestam", LocalDateTime.now().toString(),
                "status", 500
        ));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRuntime(RuntimeException runtimeException){
        return ResponseEntity.badRequest().body(Map.of(
                "erro", runtimeException.getMessage(),
                "timestamp", LocalDateTime.now().toString(),
                "status", 400

        ));
    }
}
