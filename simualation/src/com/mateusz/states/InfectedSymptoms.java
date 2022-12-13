package com.mateusz.states;

import com.mateusz.population.Individual;

import java.util.concurrent.ThreadLocalRandom;

public class InfectedSymptoms extends State{

    public InfectedSymptoms(Individual individual){
        super(individual);
    }

    @Override
    public void infect(Individual other) {
        if(!(other.getState() instanceof Immune))
            other.setState(ThreadLocalRandom.current().nextInt(1,3) == 1 ? new InfectedSymptoms(other): new InfectedNoSymptoms(other));
    }
    @Override
    public String toString() {
        return "Zarażony oraz posiada objawy";
    }
}
