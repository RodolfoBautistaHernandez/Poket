package com.mifel.poke.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequest {

    @NotBlank(message = "El usuario es obligatorio")
    private String username;

    @NotBlank(message = "El password es obligatorio")
    @Size(min = 6, message = "Mínimo 6 caracteres")
    private String password;
}
