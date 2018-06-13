package com.epam.training.createbuilding;

import com.epam.training.building.Building;
import com.epam.training.building.Bulb;
import com.epam.training.building.Flat;
import com.epam.training.building.Items;
import com.epam.training.com.epam.training.exception.AreaUsageTooMuchException;
import com.epam.training.com.epam.training.exception.IlluminanceTooMuchException;

public class CreateBuilding {
    public static void main(String[] args) throws IlluminanceTooMuchException, AreaUsageTooMuchException {
        Building building1 = new Building("Building 1");
        building1.createFlatList();
        building1.createItemsList();
        building1.createBulbList();
        Flat flat1 = new Flat("Flat1",200,3);
        building1.addRoom( flat1 );
        Bulb bulb1 = new Bulb(250);
        building1.addBulb(bulb1);
        Items item1 = new Items("Divan", 60);
        Items item2 = new Items("Divan2", 70);
        building1.addBulb(bulb1);
        building1.addItems(item1,flat1);
        building1.addItems(item2,flat1);
        building1.describe(building1,flat1);
        building1.createFlatList();
        building1.createItemsList();
        building1.createBulbList();
        Flat flat2 = new Flat("Flat2",500,4);
        building1.addRoom( flat2 );
        Items item3 = new Items("Divan3", 400);
        Items item4 = new Items("Divan4", 120);
        building1.addItems(item3,flat1);
        building1.addItems(item4,flat1);
        Bulb bulb2 = new Bulb(400);
        building1.addBulb(bulb2);
        building1.describe(building1,flat2);

    }
}
