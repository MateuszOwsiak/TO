package com.mateusz.vectors;

public interface IVector {

    public double abs();
    public double cdot(IVector param);
    public double getX();
    public double getY();
    public void setX(double x);
    public void setY(double y);
    public void add(IVector vector);
    public void multiply(double value);
    public double getDistance(IVector other);
}
