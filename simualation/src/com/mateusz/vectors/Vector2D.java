package com.mateusz.vectors;


import java.lang.Math;
public class Vector2D implements IVector {

    private double x;
    private double y;

    public Vector2D(double x,double y){
        this.x = x;
        this.y = y;
    }
    @Override
    public double abs() {
        return Math.sqrt(x*x+y*y);
    }

    @Override
    public double cdot(IVector param) {
        return this.x*param.getX()+this.y*param.getY();
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public void add(IVector vector) {
        this.x+=vector.getX();
        this.y+=vector.getY();
    }

    @Override
    public void multiply(double value) {
        this.x*=value;
        this.y*=value;
    }
    @Override
    public double getDistance(IVector other){
        return Math.sqrt(Math.pow(other.getX()-this.x,2)+Math.pow(other.getY()-this.y,2));
    }
}
