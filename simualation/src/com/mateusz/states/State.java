package com.mateusz.states;

import com.mateusz.population.Individual;

import java.util.List;

public abstract class State {

    private Individual individual;

    public State(Individual individual){
        this.individual = individual;
    }

    public abstract void infect(Individual other);

    @Override
    public String toString() {
        return super.toString();
    }
}
