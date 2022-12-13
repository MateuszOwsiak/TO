package com.mateusz.states;

import com.mateusz.population.Individual;

public class Healthy extends State{

    public Healthy(Individual individual) {
        super(individual);
    }

    @Override
    public void infect(Individual other) {
        //NIE ZARAŻA
    }

    @Override
    public String toString() {
        return "Zdrowy";
    }
}
