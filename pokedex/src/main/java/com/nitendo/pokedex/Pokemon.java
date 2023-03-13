package com.nitendo.pokedex;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.*;

@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String especie;
    private String tipo;
    private int nivel;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void atualizar(Pokemon pokemon) {
        this.nome = pokemon.getNome();
        this.especie = pokemon.getEspecie();
        this.tipo = pokemon.getTipo();
        this.nivel = pokemon.getNivel();
    }
}
