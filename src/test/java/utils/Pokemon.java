package utils;

import lombok.Getter;

public enum Pokemon {


    Pikachu("Trovoada", "Rápido"),
    Bulbasauro("Chicote", "Folhas");

    Pokemon(String golpePrimeiro, String golpeSegundo) {
        this.golpePrimeiro = golpePrimeiro;
        this.golpeSegundo = golpeSegundo;
    }

    @Getter
    String golpePrimeiro;
    @Getter
    String golpeSegundo;
}
