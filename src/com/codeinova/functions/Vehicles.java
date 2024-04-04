package com.codeinova.functions;
import java.util.HashMap;

public class Vehicles {

    //Calculo de emision de vehiculos
    public static float VehiclesEmision (boolean moto, boolean car, boolean bus){
        //Aqui se selecciona el vehiculo con el que se trasnporte, puede ser mas de 1


        //Se crea un mapa que contenga la informacion de las emisiones del usuario por vehiculo
        HashMap<String,Float> vehicles = new HashMap<>();
        vehicles.put("Moto",0f);
        vehicles.put("Car",0f);
        vehicles.put("Bus",0f);

        //Si tiene el vehiculo se activa la condicional y hace los calculos pertinentes
        if (moto){
            int cc = 125;//125-150-180-200
            float fuelConsume = MotoCons(cc);//litros por cada 100km
            float time = 6.5f;// tiempo de uso del vehiculo en horas
            boolean diesel = false;
            vehicles.replace("Moto",co2Emission(time,fuelConsume,diesel));
        }

        //Si tiene el vehiculo se activa la condicional y hace los calculos pertinentes
        if (car){
            int cc =1500;//1300-1500-1800-2000
            float fuelConsume = CarCons(cc);//litros por cada 100km
            float time = 6.5f;// tiempo de uso del vehiculo en horas
            boolean diesel = false;
            vehicles.replace("Car",co2Emission(time,fuelConsume,diesel));
        }

        //Si tiene el vehiculo se activa la condicional y hace los calculos pertinentes
        if (bus){
            int cc = 15000;
            float fuelConsume = 20f;//litros por cada 100km
            float time = 6.5f;// tiempo de uso del vehiculo en horas
            boolean diesel = true;
            float realCo2 = co2Emission(time,fuelConsume,diesel)/20; //dividido entre todos los pasajeros
            vehicles.replace("Bus",realCo2);
        }

        float KgCo2 = 0.0f;
        for (Float co2 : vehicles.values()){
            KgCo2 += co2;
        }
        return KgCo2;
    }

    //determina el consumo del vehiculo segun su cilindrada
    public static float CarCons (int cc){
        float consume;
        switch (cc){
            case 1300:
                consume= 7f;
                break;
            case 1500:
                consume= 8f;
                break;
            case 1800:
                consume= 9f;
                break;
            case 2000:
                consume= 10f;
                break;
            default:
                consume = 10f;
        }
        return consume;
    };

    //determina el consumo del vehiculo segun su cilindrada
    public static float MotoCons (int cc){
        float consume;
        switch (cc){
            case 125:
                consume= 2.5f;
                break;
            case 150:
                consume= 3f;
                break;
            case 180:
                consume= 3.5f;
                break;
            case 200:
                consume= 4f;
                break;
            default:
                consume = 4f;
        }
        return consume;
    };

    public static float co2Emission(float Time, float FuelConsume, boolean Diesel){
        int AverageSpeed=60;//velocidad promedio de popayan
        float Distance = AverageSpeed * Time;//calculo de la distancia recorrida
        float BurnedFuel = (FuelConsume*Distance)/100;//calculo del combustible consumido
        float Emission;
        //elije el factor de emision segun el tipo de combustible
        if (Diesel){Emission = 2.68f;}//kgco2 por litro
        else {Emission = 2.31f;}

        float CarbonEmission =BurnedFuel*Emission;
        return CarbonEmission;
    }
}
