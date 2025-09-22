package models;

import interfaces.Combustible;

public class Camion extends Vehiculo implements Combustible {

    //Constructor de la subclase Camion
    public Camion(String marca, String modelo) {
        super(marca, modelo);
    }


    //Se implementa el metodo mover de la clase Vehiculo
    public void mover() {
        System.out.println("El camion de la marca " + getMarca() + " y modelo " + getModelo() + " esta arrancando en Carretera Masaya");
    }

    //Se implementa el metodo recargar de la interfaz Combustible
    public void recargar() {
        System.out.println("El camion de la marca " + getMarca() + " y modelo " +getModelo() + " se ha recargado con gasolina Diesel");
    }


}
