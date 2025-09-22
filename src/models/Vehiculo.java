package models;

public abstract class Vehiculo {
    private String marca;
    private String modelo;

    //Constructor de la clase abstracta
    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    //Setters y Getters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    //Metodo abstracto
    public abstract void mover();
}
