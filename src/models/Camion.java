package models;

/**
 * Clase Camion que hereda de Vehiculo e implementa Combustible.
 */
public class Camion extends Vehiculo implements Combustible {

    public Camion(String marca, String modelo) {
        super(marca, modelo);
    }

    @Override
    public String mover() {
        return "🚚 El camión transporta carga pesada por la autopista.";
    }

    @Override
    public String recargar() {
        return "⛽ Recargando diésel en el camión...";
    }
}
