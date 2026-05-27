package com.mifel.poke.service;

import com.mifel.poke.entity.Item;
import com.mifel.poke.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ItemService {

    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public List<Item> getItems(String nombre) {
        log.info("Consultando items con filtro: '{}'", nombre);
        if (nombre == null || nombre.isEmpty()) {
            log.info("Retornando catálogo completo");
            return repository.findAll();
        }
        return repository.findByNombreContainingIgnoreCase(nombre);
    }
}
