package com.mateusz.simulator;

import com.mateusz.memento.CareTaker;
import com.mateusz.population.Individual;
import com.mateusz.random.RandomGenerator;
import com.mateusz.states.*;

import com.mateusz.vectors.IVector;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
public class Simulation {
    private List<Individual> population;
    private int n;
    private int m;
    private int seconds;
    private RandomGenerator randomGenerator;
    private int frequency;
    private int start_population;

    private Scanner sc;
    private List<CareTaker>careTakers = new ArrayList<>();
    public Simulation(int n,int m,int start_population,int frequency){
        this.n = n;
        this.m = m;
        this.population = new ArrayList<>();
        this.randomGenerator = new RandomGenerator();
        this.start_population = start_population;
        this.frequency = frequency;
        randomGenerator.init(n,m);
        sc = new Scanner(System.in);
    }

    public void simulate(){
         initialize();
         while(true){
            System.out.println("Obecna sekunda symulacji: "+seconds);
            System.out.println("MENU SYMULACJI");
            System.out.println("1.Sekunda do przodu");
            System.out.println("2.Zapisz stan symulacji");
            System.out.println("3.Wczytaj stan symulacji");
            System.out.println("4.Wypisz aktualny stan symulacji");
            System.out.println("5.Zakończ symulacje");
            System.out.print("Wybór: ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                {
                    for(int i=0; i<25; i++){
                        for(Individual in:population){
                            update(in);
                            in.check_near(population);
                        }
                        check_if_on_border();
                    }
                    seconds++;
                    for(Individual in : population){
                        in.setSecondsOnGrid(in.getSecondsOnGrid()+1);
                    }
                    if(seconds % frequency == 0){
                        for(int i=0; i<500; i++){
                            create_new_individual();
                        }
                    }
                }break;
                case 2:{
                    for(CareTaker ct: careTakers){
                        ct.create();

                    }
                }break;
                case 3:{
                    restore();
                }break;
                case 4:{
                    print();
                }break;
                case 5:{
                    System.out.println("Koniec symulacji");
                    System.exit(0);
                }break;
                default:{
                    System.out.println("Niepoprawna opcja");
                }break;
            }
        }
    }
    public void check_if_on_border(){
        for(int i=0; i<population.size(); i++){
            if(population.get(i).getSecondsOnGrid()>0) {
                if (population.get(i).getPosition().getX() == n || population.get(i).getPosition().getY() == m || population.get(i).getPosition().getX() == 0 || population.get(i).getPosition().getY() == 0) {
                    boolean delete = (ThreadLocalRandom.current().nextInt(0, 2) == 1 ? true : false);
                    if (delete) {
                        population.get(i).setOnDelete(true);
                    }
                }
            }
        }
        population.removeIf(Individual::getOnDelete);
    }
    public void update(Individual individual){
        double r = ThreadLocalRandom.current().nextDouble(0,0.25);
        double angle = Math.toRadians(Math.random() * 360);

        if(((individual.getPosition().getX()+(Math.cos(angle)*r)>=0 && individual.getPosition().getX()+(Math.cos(angle)*r)<=n)) && (individual.getPosition().getY()+(Math.sin(angle)*r)>=0 && individual.getPosition().getY()+(Math.sin(angle)*r)<=m)){
            individual.move(r,angle);
        }
        else if(((individual.getPosition().getX()+(Math.cos(angle)*r)<0 || individual.getPosition().getX()+(Math.cos(angle)*r)>n)) || (individual.getPosition().getY()+(Math.sin(angle)*r)<0 || individual.getPosition().getY()+(Math.sin(angle)*r)>m)){
            if(individual.getPosition().getX()+(Math.cos(angle)*r)<0){
                individual.getPosition().setX(0);
            }
            if(individual.getPosition().getX()+(Math.cos(angle)*r)>n){
                individual.getPosition().setX(n);
            }
            if(individual.getPosition().getY()+(Math.sin(angle)*r)<0){
                individual.getPosition().setY(0);
            }
            if(individual.getPosition().getY()+(Math.sin(angle)*r)>m){
                individual.getPosition().setY(m);
            }
        }
    }
    public void create_new_individual(){
            IVector position = randomGenerator.getRandomPosition();
            Individual newIndividual = new Individual(position);
            State state1 = (ThreadLocalRandom.current().nextInt(1,3)==2 ? new InfectedNoSymptoms(newIndividual):new InfectedSymptoms(newIndividual));
            State state = (ThreadLocalRandom.current().nextInt(1,11)==4 ? state1: new Healthy(newIndividual));
            newIndividual.setState(state);
            population.add(newIndividual);
            careTakers.add(new CareTaker(newIndividual));
    }
    public void initialize(){
        population.clear();
        careTakers.clear();
        for(int i=0; i<start_population; i++){
            create_new_individual();
        }
    }
    public List<Individual> getPopulation(){
        return this.population;
    }
    public int getStartPopulation(){
        return this.start_population;
    }
    public int getFrequency() {
        return frequency;
    }
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
    public void print(){
        int healthy = 0;
        int immune = 0;
        int infected_s = 0;
        int infected_n = 0;
        int all = 0;
        for(Individual in: population){
            all++;
            if(in.getState() instanceof Healthy)
                healthy++;
            if(in.getState() instanceof InfectedSymptoms)
                infected_s++;
            if(in.getState() instanceof InfectedNoSymptoms)
                infected_n++;
            if(in.getState() instanceof Immune)
                immune++;
        }
        System.out.println("Liczba wszystkich osobników: "+all);
        System.out.println("Liczba odpornych osobników w populacji: "+immune);
        System.out.println("Liczba zdrowych osobników w populacji: "+healthy);
        System.out.println("Liczba zakażonych osobników z objawami: "+infected_s);
        System.out.println("Liczba zakażonych osobników bez objawów: "+infected_n);
    }

    public void restore(){
        System.out.println("Którą sekunde symulacji chcesz przywrócić: ");
        int sec = sc.nextInt();
        for(CareTaker ct: careTakers) {
           ct.restore(sec);
        }
    }
}
