package com.mifel.poke.controller;

import com.mifel.poke.service.PokeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/poke")
public class PokeController {
    private final PokeService pokeService;

    public PokeController(PokeService pokeService){
        this.pokeService = pokeService;
    }

    @GetMapping("/ditto")
    public Object getDtto(){
        return pokeService.getDitto();
    }
}
