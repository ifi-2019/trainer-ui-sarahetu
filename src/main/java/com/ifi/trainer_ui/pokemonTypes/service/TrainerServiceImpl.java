package com.ifi.trainer_ui.pokemonTypes.service;

import com.ifi.trainer_ui.pokemonTypes.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@Service
public class TrainerServiceImpl implements TrainerService{

    private RestTemplate restTemplate;

    private String pokemonServiceUrl;


    @Value("${trainer.service.url}")
    public void setPokemonTypeServiceUrl(String url) {
        this.pokemonServiceUrl = url;
    }

    @Override
    public List<Trainer> getAllTrainers() {
        return Arrays.asList(restTemplate.getForObject(pokemonServiceUrl + "/trainers/" , Trainer[].class));
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

    @Override
    public List<Trainer> listOtherTrainers(Trainer principal) {
        List <Trainer> list = new LinkedList<>(getAllTrainers());
        Iterator<Trainer> i = list.iterator();
        while (i.hasNext()) {
            Trainer t = i.next(); // must be called before you can call i.remove()
            if (principal.getName().equals(t.getName())) {
                i.remove();
            }
        }
        return list;
    }


}

