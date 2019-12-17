package com.ifi.trainer_ui.pokemonTypes.service;

import com.ifi.trainer_ui.pokemonTypes.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@Service
public class TrainerServiceImpl implements TrainerService{


    @Autowired
    private RestTemplate restTemplate;

    private String pokemonServiceUrl;

    @Override
    public Iterable<Trainer> getAllTrainers() {
        var t = restTemplate.getForObject(pokemonServiceUrl + "/trainers/" , Trainer.class);
        return Arrays.asList(t);
    }

    @Override
    public Trainer getTrainer(String name) {
        var t = restTemplate.getForObject(pokemonServiceUrl + "/trainers/" +name, Trainer.class);
        return t;
    }

    @Override
    public Trainer createTrainer(Trainer trainer) {
        return null;
    }

    @Override
    public void deleteTrainer(String id){
    }

    @Autowired
    @Qualifier("trainerApiRestTemplate")
    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }



}

