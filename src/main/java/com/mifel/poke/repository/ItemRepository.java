package com.mifel.poke.repository;

import com.mifel.poke.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository  extends JpaRepository<Item, Long> {
    List<Item> findByNombreContainingIgnoreCase(String nombre);

}
