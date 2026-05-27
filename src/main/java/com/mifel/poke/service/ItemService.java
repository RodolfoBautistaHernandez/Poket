package com.mifel.poke.service;

import com.mifel.poke.entity.Item;
import com.mifel.poke.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public List<Item> getItems(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return repository.findAll();
        }
        return repository.findByNombreContainingIgnoreCase(nombre);
    }
}
