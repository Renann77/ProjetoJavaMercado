package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Item;
import com.example.demo.model.Raridade;
import com.example.demo.model.Tipo;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByNomeContainingIgnoreCase(String nome);

    List<Item> findByTipo(Tipo tipo);

    List<Item> findByPrecoBetween(double precoMin, double precoMax);

    List<Item> findByRaridade(Raridade raridade);
}
