package models;

/**
 * Clase Moto que hereda de Vehiculo.
 */
public class Moto extends Vehiculo {

    public Moto(String marca, String modelo) {
        super(marca, modelo);
    }

    @Override
    public String mover() {
        return "🏍️ La moto se desplaza rápidamente entre el tráfico.";
    }
}
