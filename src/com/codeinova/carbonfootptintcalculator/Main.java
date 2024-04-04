package com.codeinova.carbonfootptintcalculator;
import static com.codeinova.functions.Energy.EnergyEmision;
import static com.codeinova.functions.Vehicles.*;

public class Main {
    public static void main(String [] args) {
        //---------Vehiculos--------------
        boolean Moto = false;
        boolean Bus = false;
        boolean Car = false;
        System.out.println("La cantidad de Co2 emitido semanalmente por sus vehiculos es: " + VehiclesEmision(Moto, Car, Bus) + " Kg");

        //---------Energia--------------
        // esta se puede calcular de manera facil sabiendo que el factor de emision es 20 gramos/kwh
        // y solo multiplicando por la cantidad de kW usados que muestra el recibo de luz
        boolean Microwave = true;
        boolean Fridge = true;
        boolean WashingMachine = true;
        float pepe = EnergyEmision(Microwave,Fridge,WashingMachine);
        System.out.println("La cantidad de Co2 emitido semanalmente por los electrodomesticos de su hogar es: " + EnergyEmision(Microwave,Fridge,WashingMachine) + " gr");
    }
}