package com.epam.training.building;

import com.epam.training.com.epam.training.exception.AreaUsageTooMuchException;
import com.epam.training.com.epam.training.exception.IlluminanceTooMuchException;


import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Building {
    private String name;
    private List<Flat> flatList;
    protected List<Items> itemsList;
    protected List<Bulb> bulbList;
    protected double currentArea;
    protected double currentLight;
    final double light = 4000;
    public Building(){

    }
    public Building(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Flat> getFlatList() {
        return flatList;
    }

    public void setFlatList(List<Flat> flatList) {
        this.flatList = flatList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return Objects.equals(name, building.name) &&
                Objects.equals(flatList, building.flatList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, flatList);
    }

    @Override
    public String toString() {
        return "Building{" +
                "name='" + name + '\'' +
                ", flatList=" + flatList +
                '}';
    }
    public void addRoom(Flat flat) throws IlluminanceTooMuchException {

        flatList.add(flat);
        if(light > currentLight){
        currentLight=+(flat.numberOfWindows * 700);}
        else {
            throw new IlluminanceTooMuchException();
        }
    }

    public void addBulb(Bulb bulb) throws IlluminanceTooMuchException {
        bulbList.add(bulb);
        if(light > currentLight){
        currentLight+=bulb.getLight();}
        else{
            throw new IlluminanceTooMuchException();
        }


    }
    public void addItems(Items items,Flat flat) throws AreaUsageTooMuchException {

        itemsList.add(items);
        if(((flat.getArea()*70)/100)> currentArea){
        currentArea +=items.getArea();}
        else{
            throw new AreaUsageTooMuchException();
        }

    }


    public void getFinalArea(){
        System.out.println(currentArea);
    }
    public void getCurrentLight(){
        System.out.println(currentLight);
    }
    public void createFlatList(){
        flatList = new ArrayList<Flat>();
    }
    public void createItemsList(){
        itemsList = new ArrayList<>();
    }
    public void createBulbList(){
        bulbList = new ArrayList<>();
    }
    public void describe(Building building,Flat flat){
        System.out.println(building.getName());
        for (Flat vault : flatList) {
            System.out.println("\t" + vault.getName());

        }
        System.out.print("\t    Освещенность = "+ currentLight +" ( " + flat.getNumberOfWindows()+" окна по 700лт, лампочки: ");
        int i = 1;
        for (Bulb vault3:bulbList){
            System.out.print(i+ ". " + vault3.getLight()+ "лт ");
            i++;
        }
        System.out.println(")");
        System.out.println("\t    Площадь = " + flat.getArea() + " м^2 "+ " ( занято "+ currentArea +" м^2,"+" гарантированно свободно " + (flat.getArea()- currentArea)+ " м^2 или " +(((flat.getArea()- currentArea)*100)/flat.getArea()) + "% площади )");
        System.out.println("\tМебель:");
        for (Items vault1:itemsList){
            if(vault1 == null){
                System.out.println("Мебели нет");
                break;
            }
            else {
                System.out.println("    \t" +vault1.getName()+ " ( " + vault1.getArea()+" м^2 ) ");
            }
        }
        System.out.println("\n");
    }


}



