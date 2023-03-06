package com.nitendo.pokedex;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
@RequestMapping("/pokemons")
public class PokedexController {
    private ArrayList<Pokemon> pokemons = new ArrayList<>();
    private int ultimoID = 1;

    @GetMapping
    public ArrayList<Pokemon> listar() {
        return pokemons;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarPokemon(@RequestBody Pokemon pokemon) {
        pokemon.setId(ultimoID);
        pokemons.add(pokemon);
        ultimoID++;
    }

    @DeleteMapping("/{id}")
    public void removerPokemon(@PathVariable int id) {
        Pokemon pokemonEncontrado = null;

        for (Pokemon p : pokemons) {
            if (p.getId() == id) {
                pokemonEncontrado = p;
                break;
            }
        }

        if (pokemonEncontrado != null) {
            pokemons.remove(pokemonEncontrado);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
