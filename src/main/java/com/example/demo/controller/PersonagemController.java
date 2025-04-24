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

import com.example.demo.model.Classe;
import com.example.demo.model.Personagem;
import com.example.demo.repository.PersonagemRepository;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {

    @Autowired
    private PersonagemRepository personagemRepository;

    @GetMapping
    public List<Personagem> listarTodos() {
        return personagemRepository.findAll();
    }

    @GetMapping("/buscar/nome")
    public List<Personagem> buscarPorNome(@RequestParam String nome) {
        return personagemRepository.findByNomeContainingIgnoreCase(nome);
    }

    @GetMapping("/buscar/classe")
    public List<Personagem> buscarPorClasse(@RequestParam Classe classe) {
        return personagemRepository.findByClasse(classe);
    }

    @PostMapping
    public Personagem criar(@RequestBody Personagem personagem) {
        return personagemRepository.save(personagem);
    }

    @PutMapping("/{id}")
    public Personagem atualizar(@PathVariable Long id, @RequestBody Personagem personagem) {
        personagem.setId(id);
        return personagemRepository.save(personagem);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        personagemRepository.deleteById(id);
    }
}
