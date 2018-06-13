package com.epam.training.building;

import java.util.Objects;

public class Items extends Flat {

    public Items(String name,double area){
        this.area = area;
        this.name = name;
    }
    @Override
    public double getArea() {
        return area;
    }

    @Override
    public void setArea(double area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Items items = (Items) o;
        return Double.compare(items.area, area) == 0 &&
                Objects.equals(name, items.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), area, name);
    }

    @Override
    public String toString() {
        return "Items{" +
                "area=" + area +
                ", name='" + name + '\'' +
                '}';
    }
}
