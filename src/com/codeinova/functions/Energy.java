package com.codeinova.functions;

import java.util.HashMap;

public class Energy {
    public static float EnergyEmision (boolean microwave, boolean fridge, boolean washingMachine){

        HashMap<String,Float> Co2Energy = new HashMap<>();
        Co2Energy.put("Microwave",0f);
        Co2Energy.put("Fridge",0f);
        Co2Energy.put("WashingMachine",0f);

        if (microwave){
            int Times = 5; //veces que se usa por semana
            float RealTime = (Times*5)/60;//tiempo total en horas, si promedio de 5 minutos por uso
            float Power = 1f; // por defecto microondas de 1kw
            float consume = Power * RealTime; //Kw/h
            float co2 = consume * 10; //gramos de Co2
            Co2Energy.replace("Microwave" , co2);
        }
        if (fridge){
            float Power = 0.6f; // por defecto lavadora de 0.6kw
            float consume = Power * 168; //Kw/h
            float co2 = consume * 10; //gramos de Co2
            Co2Energy.replace("Fridge" , co2);
        }
        if (washingMachine){
            int Times = 2; //veces que se usa por semana
            float RealTime = Times;//tiempo total en horas, si promedio de 1 h por uso
            float Power = 1.5f; // por defecto lavadora de 1.5kw
            float consume = Power * RealTime; //Kw/h
            float co2 = consume * 10; //gramos de Co2
            Co2Energy.replace("WashingMachine" , co2);
        }
        float gCo2 = 0.0f;
        for (Float co2 : Co2Energy.values()){
            gCo2 += co2;
        }
        return gCo2;
    }
}
