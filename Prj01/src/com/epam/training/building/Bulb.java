package com.epam.training.building;

import java.util.Objects;

public class Bulb extends Flat{

     public Bulb(int light){
         this.light = light;
         }

    @Override
    public String toString() {
        return "Bulb{" +
                "light=" + light +
                '}';
    }

}

