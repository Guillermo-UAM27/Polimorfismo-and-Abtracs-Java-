package models;

public class Moto extends Vehiculo {

    //Constructor de la subclase moto
    public Moto(String marca, String modelo) {
        super(marca, modelo);
    }


    //Se implementa el metodo mover de la clase Vehiculo
    public void mover() {
        System.out.println("La moto de la marca " + getMarca() + " y modelo " + getModelo() + " esta acelerando en Carretera Masaya");
    }
}
