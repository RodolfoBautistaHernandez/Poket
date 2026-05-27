package com.mifel.poke.service;

import com.mifel.poke.security.JwtAuthFilter;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PokeService {

    private final WebClient webClient;

    public PokeService(WebClient.Builder builder) {
        this.webClient = builder
                .baseUrl("https://pokeapi.co/api/v2")
                .build();
    }

    public Object getDitto() {
        return webClient.get()
                .uri("/pokemon/ditto")
                .retrieve()
                .bodyToMono(Object.class)
                .block();
    }
}
