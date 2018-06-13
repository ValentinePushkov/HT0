package com.epam.training.building;

import java.util.List;
import java.util.Objects;

public class Flat extends Building {
    protected int numberOfWindows;
    protected double area;
    protected String name;
    protected final double window = 700;
    protected int light;
    protected double curentArea;
    protected double currentLight;

    public Flat() {

    }



    public Flat(String name, double area, int numberOfWindows) {
        this.area = area;
        this.name = name;
        this.numberOfWindows = numberOfWindows;
    }
    public Flat(String name,double area){
        this.area = area;
        this. name = name;
    }
    public Flat(int light ){
        this.light = light;
    }
    public int getNumberOfWindows() {
        return numberOfWindows;
    }

    public void setNumberOfWindows(int numberOfWindows) {
        this.numberOfWindows = numberOfWindows;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Flat{" +
                "numberOfWindows=" + numberOfWindows +
                ", area=" + area +
                ", name='" + name + '\'' +
                '}';
    }

    public int getLight() {
        return light;
    }

    public void setLight(int light) {
        this.light = light;
    }
}
