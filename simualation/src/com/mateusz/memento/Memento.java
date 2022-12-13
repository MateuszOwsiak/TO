package com.mateusz.memento;

import com.mateusz.population.Individual;
import com.mateusz.states.State;
import com.mateusz.vectors.IVector;

import java.util.Map;

public class Memento {
    public IVector position;
    public State state;
    public int secondsOnGrid;
    public Map<Individual,Integer> closeTo;
    public int timer;
    public Memento(IVector position,State state,int secondsOnGrid,Map<Individual,Integer>closeTo,int timer){
        this.position = position;
        this.state = state;
        this.secondsOnGrid = secondsOnGrid;
        this.closeTo = closeTo;
        this.timer = timer;
    }

}
