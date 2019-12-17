package com.ifi.trainer_ui.pokemonTypes.service;

import java.util.List;
import com.ifi.trainer_ui.bo.PokemonType;
import org.springframework.web.client.RestTemplate;

public interface PokemonTypeService {

    List<PokemonType> listPokemonsTypes();
    void setRestTemplate(RestTemplate restTemplate);
    void setPokemonTypeServiceUrl(String pokemonServiceUrl);
    List<PokemonType> findAllPokemonByType(String types);
}
