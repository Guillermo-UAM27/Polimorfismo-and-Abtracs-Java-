package models;

import interfaces.Combustible;

public class Carro extends Vehiculo implements Combustible {

    //Constructor para la subclase carro
    public Carro(String marca, String modelo) {
        super(marca, modelo);
    }

    //Se implementa el metodo mover de la clase Vehiculo
    public void mover() {
        System.out.println("El carro de la marca " + getMarca() + " y modelo " + getModelo() + " se esta moviendo en Carretera Masaya");
    }

    //Se implemento el metodo recargar para el Carro, proveniente de la interfaz Combustible
    public void recargar() {
        System.out.println("El carro de la marca " + getMarca() + " y modelo " + getModelo() + " se ha recargado con combustible Super");
    }
}
