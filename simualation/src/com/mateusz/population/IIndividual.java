package com.mateusz.population;

import com.mateusz.memento.Memento;
import com.mateusz.states.State;
import com.mateusz.vectors.IVector;
import java.util.List;

public interface IIndividual {

    public State getState();
    public void setState(State newState);
    public void move(double r,double angle);
    public void infect(Individual other);
    public IVector getPosition();
    public Memento getMemento();
    public void setMemento(Memento memento);

    public void check_near(List<Individual> population);
    public void setTimer(int timer);

    public void setSecondsOnGrid(int secondsOnGrid);
    public int getSecondsOnGrid();
    public void getImmune();
    public void setOnDelete(boolean onDelete);
    public boolean getOnDelete();
}
