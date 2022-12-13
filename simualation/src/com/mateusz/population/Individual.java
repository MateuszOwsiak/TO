package com.mateusz.population;


import com.mateusz.memento.Memento;
import com.mateusz.states.*;
import com.mateusz.vectors.IVector;
import com.mateusz.vectors.Vector2D;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Individual implements IIndividual{
    private IVector position;
    private State state;
    private boolean onDelete;
    private Map<Individual,Integer>closeTo;
    private int timer;
    private int secondsOnGrid;

    public Individual(IVector position){
        this.position = position;
        this.state = new Immune(this);
        this.onDelete = false;
        this.closeTo = new HashMap<>();
        this.timer = 0;
        this.secondsOnGrid = 0;
    }
    @Override
    public State getState(){
        return this.state;
    }
    @Override
    public void setState(State newState){
        this.state = newState;
    }
    @Override
    public void move(double r,double angle){
        Vector2D updateVector = new Vector2D(Math.cos(angle),Math.sin(angle));
        updateVector.multiply(r);
        this.position.add(updateVector);
        if(this.state instanceof InfectedNoSymptoms || this.state instanceof InfectedSymptoms){
            timer++;
            this.getImmune();
        }
    }
    @Override
    public void infect(Individual other) {
       state.infect(other);
    }
    @Override
    public IVector getPosition() {
        return this.position;
    }
    @Override
    public Memento getMemento(){
        return new Memento(this.position,this.state,this.secondsOnGrid,this.closeTo,this.timer);
    }
    @Override
    public void setMemento(Memento memento){
        this.position = memento.position;
        this.state = memento.state;
        this.secondsOnGrid = memento.secondsOnGrid;
        this.closeTo = memento.closeTo;
        this.timer = memento.timer;
    }

    @Override
    public String toString() {
        return "Położenie: ["+this.getPosition().getX()+" , "+this.getPosition().getY()+"], Stan: "+this.getState();
    }
    @Override
    public void setOnDelete(boolean onDelete){
        this.onDelete = onDelete;
    }
    @Override
    public boolean getOnDelete(){
        return onDelete;
    }
    @Override
    public void check_near(List<Individual> population) {
        if (this.state instanceof InfectedSymptoms || this.state instanceof InfectedNoSymptoms) {
            for (Individual i : population) {
                if (this.getPosition().getDistance(i.getPosition()) <= 2) {
                    if (closeTo.containsKey(i)) {
                        int old_value = closeTo.get(i);
                        closeTo.replace(i, old_value + 1);
                        if (closeTo.get(i) == 75) {
                            this.infect(i);
                        }
                    } else {
                        closeTo.put(i, 1);
                    }
                } else {
                    if (closeTo.containsKey(i)) {
                        closeTo.remove(i);
                    }
                }
            }
        }
    }
    @Override
    public void setTimer(int timer){
        this.timer = timer;
    }
    @Override
    public void setSecondsOnGrid(int secondsOnGrid){
        this.secondsOnGrid = secondsOnGrid;
    }
    @Override
    public int getSecondsOnGrid(){
        return this.secondsOnGrid;
    }
    @Override
    public void getImmune() {
        if (this.timer == 500) {
            this.setState(new Immune(this));
            this.setTimer(0);
        }
    }

}
