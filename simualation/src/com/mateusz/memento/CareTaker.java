package com.mateusz.memento;

import com.mateusz.population.Individual;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {

    private Individual individual;
    private List<Memento> mementos = new ArrayList<>();

    public CareTaker(Individual individual){
        this.individual = individual;
    }

    public void create(){
        Memento memento = this.individual.getMemento();
        mementos.add(memento);
    }

    public void restore(int index){
        if(index<0 || index>=this.mementos.size()){
            System.out.println("Unable to restore");
        }else {
            Memento memento = this.mementos.get(index);
            this.individual.setMemento(memento);
        }
    }

}
