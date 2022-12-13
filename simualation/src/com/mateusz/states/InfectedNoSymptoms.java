package com.mateusz.states;

import com.mateusz.population.Individual;


import java.util.concurrent.ThreadLocalRandom;

public class InfectedNoSymptoms extends State{

    public InfectedNoSymptoms(Individual individual){
        super(individual);
    }
    @Override
    public void infect(Individual other) {
        if(!(other.getState() instanceof Immune)) {
            int i = ThreadLocalRandom.current().nextInt(0, 2);
            if (i == 1) {
                other.setState(ThreadLocalRandom.current().nextInt(1,3) == 1 ? new InfectedSymptoms(other): new InfectedNoSymptoms(other));
            }
        }
    }
    @Override
    public String toString() {
        return "Zarażony oraz nie posiada objawów";
    }
}
