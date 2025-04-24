package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Classe;
import com.example.demo.model.Personagem;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {

    List<Personagem> findByNomeContainingIgnoreCase(String nome);

    List<Personagem> findByClasse(Classe classe);
}
