package com.mateusz;

import com.mateusz.simulator.Simulation;

public class Main {

    public static void main(String[] args) {
        Simulation simulation = new Simulation(10,10,1000,1);
        simulation.simulate();
    }
}
