package models;

/**
 * Clase Carro que hereda de Vehiculo e implementa Combustible.
 */
public class Carro extends Vehiculo implements Combustible {

    public Carro(String marca, String modelo) {
        super(marca, modelo);
    }

    @Override
    public String mover() {
        return "🚗 El carro se mueve por carretera.";
    }

    @Override
    public String recargar() {
        return "⛽ Recargando gasolina en el carro...";
    }
}
