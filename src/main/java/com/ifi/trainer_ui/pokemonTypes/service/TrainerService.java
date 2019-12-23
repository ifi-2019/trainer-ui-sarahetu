package com.ifi.trainer_ui.pokemonTypes.service;


import com.ifi.trainer_ui.pokemonTypes.bo.Trainer;

import java.util.List;

public interface TrainerService {

    List<Trainer> getAllTrainers();
    Trainer getTrainer(String name);
    Trainer createTrainer(Trainer trainer);
    void deleteTrainer(String id);
    List<Trainer> listOtherTrainers(Trainer principal);

}
