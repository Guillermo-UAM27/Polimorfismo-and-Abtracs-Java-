package run;

import interfaces.Combustible;
import models.Camion;
import models.Carro;
import models.Moto;
import models.Vehiculo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Se inicializa un ArrayList de Vehiculos
        ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

        //Se agrega instancias al Arraylist

        vehiculos.add(new Carro("Toyota", "Rav4 2016"));
        vehiculos.add(new Moto("Hyundai", "CB500 2025"));
        vehiculos.add(new Camion("Freightliner", "M2 2010"));

        //Se imprime el metodo mover para cada iteracion del Arraylist

        System.out.println("----Metodo Mover----");
        for (Vehiculo v : vehiculos) {
            v.mover();
        }

        //Se implementa el metodo recargar solo para las subclases Carro y Camion
        System.out.println("---Metodo Recargar---");
        for (Vehiculo v : vehiculos) {
            if (v instanceof Combustible) {
                ((Combustible) v).recargar();
            } else {
                System.out.println("El vehiculo no se puede recargar de combustible");
            }
        }
    }
}
