package org.example;

import javax.swing.*;
import java.util.List;

public class VistaCodigoPostal extends JFrame implements IVistaCodigoPostal{
    private ICodigoPostalController codigoPostalController;
    private List<Lugar> listaLugares;
    private CodigoPostal codigoPostal;
    @Override
    public void mostrarError(String mensaje) {

    }

    @Override
    public void addLugar(String lugar) {

    }

    @Override
    public void deleteLugares() {

    }

    @Override
    public void setLugares(String lugares) {

    }

    @Override
    public void setController(ICodigoPostalController controller) {

    }

    @Override
    public void mostrar() {

        /*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuscadorCodigosPostales {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> crearVista());
    }

    private static void crearVista() {
        // Crear el marco principal
        JFrame marco = new JFrame("Buscador de Códigos Postales");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(600, 400);
        marco.setLayout(new BorderLayout());

        // Panel superior para entrada de datos
        JPanel panelEntrada = new JPanel(new GridLayout(3, 2, 10, 10));

        JLabel etiquetaCodigoPostal = new JLabel("Código Postal:");
        JTextField campoCodigoPostal = new JTextField();
        JLabel etiquetaAbreviatura = new JLabel("Abreviatura del País:");
        JTextField campoAbreviatura = new JTextField();
        JButton botonBuscar = new JButton("Buscar");

        panelEntrada.add(etiquetaCodigoPostal);
        panelEntrada.add(campoCodigoPostal);
        panelEntrada.add(etiquetaAbreviatura);
        panelEntrada.add(campoAbreviatura);
        panelEntrada.add(new JLabel()); // Espacio vacío
        panelEntrada.add(botonBuscar);

        // Panel central para desplegar información
        JTextArea areaResultados = new JTextArea();
        areaResultados.setEditable(false);
        JScrollPane scrollResultados = new JScrollPane(areaResultados);

        // Panel inferior con la lista de abreviaturas de países
        JPanel panelAbreviaturas = new JPanel(new BorderLayout());
        JLabel etiquetaAbreviaturas = new JLabel("Lista de Abreviaturas de Países:");
        JTextArea areaAbreviaturas = new JTextArea("US - Estados Unidos\nMX - México\nFR - Francia\nES - España\n...");
        areaAbreviaturas.setEditable(false);
        JScrollPane scrollAbreviaturas = new JScrollPane(areaAbreviaturas);

        panelAbreviaturas.add(etiquetaAbreviaturas, BorderLayout.NORTH);
        panelAbreviaturas.add(scrollAbreviaturas, BorderLayout.CENTER);

        // Añadir componentes al marco
        marco.add(panelEntrada, BorderLayout.NORTH);
        marco.add(scrollResultados, BorderLayout.CENTER);
        marco.add(panelAbreviaturas, BorderLayout.SOUTH);

        // Acción del botón Buscar
        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigoPostal = campoCodigoPostal.getText().trim();
                String abreviatura = campoAbreviatura.getText().trim();

                if (codigoPostal.isEmpty() || abreviatura.isEmpty()) {
                    areaResultados.setText("Por favor, ingrese el código postal y la abreviatura del país.");
                    return;
                }

                // Aquí puedes conectar con tu controlador para obtener los datos
                areaResultados.setText("Buscando lugares para el código postal " + codigoPostal +
                        " en el país con abreviatura " + abreviatura + "...\n");

                // Simulación de datos de prueba
                areaResultados.append("Resultados:\n- Lugar 1: Ciudad Solar\n- Lugar 2: Villa Lumínica\n");
            }
        });

        // Mostrar la ventana
        marco.setVisible(true);
    }
}*/



    }
}
