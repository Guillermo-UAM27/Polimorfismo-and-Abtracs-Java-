package runner;

import models.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Interfaz gráfica para gestionar vehículos.
 * Permite agregar vehículos personalizados, moverlos y recargar combustible.
 */
public class Main extends JFrame {

    private JTextArea outputArea;
    private ArrayList<Vehiculo> vehiculos;
    private JComboBox<String> tipoVehiculoCombo;
    private JTextField txtMarca, txtModelo;

    public Main() {
        setTitle("🚗 Gestión de Vehículos");
        setSize(600, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        vehiculos = new ArrayList<>();

        // ---------- PANEL SUPERIOR ----------
        JPanel formPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Agregar Vehículo"));

        tipoVehiculoCombo = new JComboBox<>(new String[]{"Carro", "Moto", "Camion"});
        txtMarca = new JTextField();
        txtModelo = new JTextField();

        JButton btnAgregar = new JButton("Agregar Vehículo");

        formPanel.add(new JLabel("Tipo:"));
        formPanel.add(new JLabel("Marca:"));
        formPanel.add(new JLabel("Modelo:"));

        formPanel.add(tipoVehiculoCombo);
        formPanel.add(txtMarca);
        formPanel.add(txtModelo);

        add(formPanel, BorderLayout.NORTH);
        add(btnAgregar, BorderLayout.WEST);

        // ---------- PANEL CENTRAL ----------
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.CENTER);

        // ---------- PANEL INFERIOR ----------
        JPanel panelAcciones = new JPanel(new GridLayout(1, 3, 10, 10));
        panelAcciones.setBorder(BorderFactory.createTitledBorder("Acciones"));

        JButton btnMover = new JButton("Mover Vehículos");
        JButton btnRecargar = new JButton("Recargar Combustible");
        JButton btnSalir = new JButton("Salir");

        panelAcciones.add(btnMover);
        panelAcciones.add(btnRecargar);
        panelAcciones.add(btnSalir);

        add(panelAcciones, BorderLayout.SOUTH);

        // ---------- LISTENERS ----------
        btnAgregar.addActionListener(e -> agregarVehiculo());
        btnMover.addActionListener(e -> moverVehiculos());
        btnRecargar.addActionListener(e -> recargarCombustible());
        btnSalir.addActionListener(e -> System.exit(0));
    }

    private void agregarVehiculo() {
        String tipo = (String) tipoVehiculoCombo.getSelectedItem();
        String marca = txtMarca.getText().trim();
        String modelo = txtModelo.getText().trim();

        if (marca.isEmpty() || modelo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "⚠ Debes ingresar marca y modelo.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Vehiculo nuevo = null;
        switch (tipo) {
            case "Carro": nuevo = new Carro(marca, modelo); break;
            case "Moto": nuevo = new Moto(marca, modelo); break;
            case "Camion": nuevo = new Camion(marca, modelo); break;
        }

        vehiculos.add(nuevo);
        outputArea.append("✅ Vehículo agregado: " + nuevo + "\n");

        txtMarca.setText("");
        txtModelo.setText("");
    }

    private void moverVehiculos() {
        if (vehiculos.isEmpty()) {
            outputArea.append("⚠ No hay vehículos para mover.\n");
            return;
        }
        for (Vehiculo v : vehiculos) {
            outputArea.append(v + " -> " + v.mover() + "\n");
        }
    }

    private void recargarCombustible() {
        if (vehiculos.isEmpty()) {
            outputArea.append("⚠ No hay vehículos para recargar.\n");
            return;
        }
        for (Vehiculo v : vehiculos) {
            if (v instanceof Combustible) {
                outputArea.append(v + " -> " + ((Combustible) v).recargar() + "\n");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main ventana = new Main();
            ventana.setVisible(true);
        });
    }
}
