package com.ifi.trainer_ui.pokemonTypes.bo;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public class Trainer {

    private String name;

    private List<Pokemonl> team;

    private String password;

    public Trainer() {
    }

    public Trainer(String name) {
        this.name = name;
    }

    public List<Pokemonl> getTeam() {
        return team;
    }

    public void setTeam(List<Pokemonl> team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
