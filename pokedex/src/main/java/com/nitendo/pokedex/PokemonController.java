package com.nitendo.pokedex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {
    @Autowired
    private PokemonRepository repository;

    @GetMapping
    public Iterable<Pokemon> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Pokemon listarPorID(@PathVariable long id) {
        Optional<Pokemon> pokemonOptional = repository.findById(id);

        if (pokemonOptional.isPresent()) {
            return pokemonOptional.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void inserir(@RequestBody Pokemon pokemon) {
        repository.save(pokemon);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable long id, @RequestBody Pokemon pokemon) {
        Optional<Pokemon> pokemonOptional = repository.findById(id);

        if (pokemonOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Pokemon pokemonEncontrado = pokemonOptional.get();
        pokemonEncontrado.atualizar(pokemon);

        repository.save(pokemonEncontrado);
    }

    @DeleteMapping("/{id}")
    public void removerPokemon(@PathVariable long id) {
        Optional<Pokemon> pokemonOptional = repository.findById(id);

        if (pokemonOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        repository.delete(pokemonOptional.get());
    }
}
