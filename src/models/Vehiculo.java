package models;

/**
 * Clase abstracta que representa un vehículo genérico.
 */
public abstract class Vehiculo {
    protected String marca;
    protected String modelo;

    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    /**
     * Método abstracto que define el movimiento del vehículo.
     * @return mensaje del movimiento
     */
    public abstract String mover();

    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo;
    }
}
