package com.ifi.trainer_ui.controller;

import com.ifi.trainer_ui.pokemonTypes.bo.Trainer;
import com.ifi.trainer_ui.pokemonTypes.service.PokemonTypeService;
import com.ifi.trainer_ui.pokemonTypes.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TrainerController {

    @Autowired
    private final TrainerService trainerService;

    @Autowired
    private final PokemonTypeService pokemonTypeService;

    TrainerController(TrainerService trainerService, PokemonTypeService pokemonTypeService){
        this.trainerService = trainerService;
        this.pokemonTypeService = pokemonTypeService;
    }

    /*TrainerController(TrainerService trainerService){
        this.trainerService = trainerService;
    }
     */

    @GetMapping("/trainers")
    Iterable<Trainer> getAllTrainers(){
        return trainerService.getAllTrainers();
    }

    @GetMapping("/trainers/{name}")
    Trainer getTrainer(@PathVariable String name){
        return trainerService.getTrainer(name);
    }


    @DeleteMapping("/trainers/{name}")
    void deleteTrainer(@PathVariable String name){
        this.trainerService.deleteTrainer(name);
    }

    @PostMapping("/trainers")
    Trainer newTrainer(@RequestBody Trainer trainer){
        return trainerService.createTrainer(trainer);
    }

    @GetMapping("/profile")
    ModelAndView getProfil(){
        ModelAndView  mav = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) auth.getPrincipal();
        mav.setViewName("profile");
        mav.addObject("trainer", trainerService.getTrainer(principal.getUsername()) );
        mav.addObject("ts",trainerService);
        return mav;
    }

}
