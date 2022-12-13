package com.mateusz.random;

import com.mateusz.vectors.Vector2D;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {
    private List<Vector2D> coordinates = new ArrayList<>();
    public void init(int n,int m){
        coordinates.clear();
        for(int i=0; i<=n; i++){
            coordinates.add(new Vector2D(i,0));
            coordinates.add(new Vector2D(i,m));
        }
        for(int i=0; i<=m; i++){
            coordinates.add(new Vector2D(0,i));
            coordinates.add(new Vector2D(n,i));
        }
    }
    public Vector2D getRandomPosition(){
        int max = coordinates.size();
        return coordinates.get(ThreadLocalRandom.current().nextInt(0, max));
    }
}
