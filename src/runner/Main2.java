package runner;

import models.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    Scanner input = new Scanner(System.in);
    ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    public static void main(String[] args) {
        Main2 main = new Main2();
        main.menu();
    }

    public void menu(){
        boolean bandera = true;
        while (bandera) {

            System.out.println("Bienvenido al sistema de control de Vehiculos");
            System.out.println("1.  Agregar Vehiculo");
            System.out.println("2.  Mover Vehiculos");
            System.out.println("3.  Ver vehiculos activos");
            System.out.println("4. Recargar combustible");
            System.out.println("5. Salir");

            int opcion =  input.nextInt();
            input.nextLine();

            switch(opcion){
                case 1:
                    Agregar();
                    break;

                case 2:
                    Mover();
                    break;

                case 3:
                    Ver_vehiculos();
                    break;

                case 4:
                    Recargar_combustible();
                    break;

                case 5:
                    bandera = false;
                    break;

                default:
                    System.out.println("Ingrese opcion de acuerdo a menu");
                    break;
            }
        }
    }

    public void Recargar_combustible(){
        if (vehiculos.isEmpty()){
            System.out.println("No hay vehiculos");
        }else {
            for (Vehiculo v : vehiculos) {
                if (v instanceof Carro || v instanceof Camion) {
                    System.out.println(((Combustible) v).recargar());
                }
            }
        }
    }

    public void Mover(){
        if (vehiculos.isEmpty()){
            System.out.println("No hay vehiculos");
        }else{
            for(Vehiculo v : vehiculos){
                System.out.println(v.mover());
            }
        }

    }

    public void Ver_vehiculos(){
        if (vehiculos.isEmpty()){
            System.out.println("No hay vehiculos");
        }else{
            System.out.println("Vehiculos activos");
            for(Vehiculo v : vehiculos){
                System.out.println(v.toString());
            }
        }
    }

    public void Agregar(){
        System.out.println("Tipo de vehiculo");
        boolean bandera = true;
        while (bandera) {
            System.out.println("1. Moto");
            System.out.println("2. Carro");
            System.out.println("3. Camion");
            int opcion =  input.nextInt();
            input.nextLine();
            String[] datos;
            switch (opcion){
                case 1:
                    datos = Datos_agregar();
                    vehiculos.add(new Moto(datos[0],datos[1]));
                    bandera = false;
                    break;
                case 2:
                    datos = Datos_agregar();
                    vehiculos.add(new Carro(datos[0],datos[1]));
                    bandera = false;
                    break;

                case 3:
                    datos = Datos_agregar();
                    vehiculos.add(new Camion(datos[0],datos[1]));
                    bandera = false;
                    break;
                default:
                    System.out.println("Ingrese opcion de acuerdo a menu");
                    break;
            }
        }

    }

    public String[] Datos_agregar(){
        System.out.println("Marca");
        String marca = input.nextLine();
        System.out.println("Modelo");
        String modelo = input.nextLine();
        return new String[]{marca, modelo};
    }
}
