package com.mateusz.states;

import com.mateusz.population.Individual;



public class Immune extends State{

   public Immune(Individual individual){
       super(individual);
   }

    @Override
    public void infect(Individual other) {
        ///NIE ZARAŻA
    }

    @Override
    public String toString() {
        return "Odporny";
    }
}
