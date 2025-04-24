package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Item;
import com.example.demo.model.Raridade;
import com.example.demo.model.Tipo;
import com.example.demo.repository.ItemRepository;

@RestController
@RequestMapping("/itens")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public List<Item> listarTodos() {
        return itemRepository.findAll();
    }

    @GetMapping("/buscar/nome")
    public List<Item> buscarPorNome(@RequestParam String nome) {
        return itemRepository.findByNomeContainingIgnoreCase(nome);
    }

    @GetMapping("/buscar/tipo")
    public List<Item> buscarPorTipo(@RequestParam Tipo tipo) {
        return itemRepository.findByTipo(tipo);
    }

    @GetMapping("/buscar/preco")
    public List<Item> buscarPorPreco(@RequestParam double min, @RequestParam double max) {
        return itemRepository.findByPrecoBetween(min, max);
    }

    @GetMapping("/buscar/raridade")
    public List<Item> buscarPorRaridade(@RequestParam Raridade raridade) {
        return itemRepository.findByRaridade(raridade);
    }

    @PostMapping
    public Item criar(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    @PutMapping("/{id}")
    public Item atualizar(@PathVariable Long id, @RequestBody Item item) {
        item.setId(id);
        return itemRepository.save(item);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        itemRepository.deleteById(id);
    }
}
