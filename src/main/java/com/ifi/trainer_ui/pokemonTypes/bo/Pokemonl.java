package com.ifi.trainer_ui.pokemonTypes.bo;

public class Pokemonl  {

    private int pokemonType;
    private int level;

    public Pokemonl() {
    }

    public Pokemonl(int pokemonType, int level) {
        this.pokemonType = pokemonType;
        this.level = level;
    }

    public int getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(int pokemonType) {
        this.pokemonType = pokemonType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
