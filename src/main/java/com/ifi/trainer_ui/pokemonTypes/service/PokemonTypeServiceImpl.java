package com.ifi.trainer_ui.pokemonTypes.service;

import com.ifi.trainer_ui.pokemonTypes.bo.Pokemonl;
import com.ifi.trainer_ui.pokemonTypes.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.ifi.trainer_ui.bo.PokemonType;

import java.lang.reflect.Array;
import java.util.*;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService{

    @Autowired
    private RestTemplate restTemplate;
    private String pokemonServiceUrl;

    @Autowired
    public PokemonTypeServiceImpl(){
    }

    @Override
    public List<PokemonType> listPokemonsTypes() {
        var p = restTemplate.getForObject(pokemonServiceUrl + "/pokemon-types/", PokemonType[].class);
        return Arrays.asList(p);
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${pokemonType.service.url}")
    public void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
        this.pokemonServiceUrl = pokemonServiceUrl ;
    }

    @Override
    public List<PokemonType> findAllPokemonByType(String type) {
        var p = restTemplate.getForObject(pokemonServiceUrl + "/pokemon-types/?types=" + type, PokemonType[].class);
        return Arrays.asList(p);
    }

    @Override
    public List<PokemonType> listPokemonsTypesByTrainer(Trainer trainer) {
        List<PokemonType> result = new ArrayList<>();
        for (Pokemonl pl : trainer.getTeam())
            result.add(restTemplate.getForObject(pokemonServiceUrl+"/pokemon-types/" + pl.getPokemonType(), PokemonType.class));
        return result;
    }

}
