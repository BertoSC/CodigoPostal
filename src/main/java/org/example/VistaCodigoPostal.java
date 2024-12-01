package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaCodigoPostal extends JFrame implements IVistaCodigoPostal{
    private ICodigoPostalController codigoPostalController;
    JFrame marco = new JFrame("Buscador de Códigos Postales");
    JTextField campoCodigoPostal = new JTextField();
    JTextField campoAbreviatura = new JTextField();
    JTextArea areaResultados = new JTextArea();

    @Override
    public void mostrarError() {
        areaResultados.setText("ERROR: Lugares no encontrados");

    }

    @Override
    public void addLugar(String codigoPostal, String abreviatura) {

        if (codigoPostal.isEmpty() || abreviatura.isEmpty()) {
            areaResultados.setText("Por favor, ingrese el código postal y la abreviatura del país.");
            return;
        }

        String res = codigoPostalController.getLugares(campoCodigoPostal.getText(), campoAbreviatura.getText(), false);

        if (res==null){
            mostrarError();
        } else {
            areaResultados.setText(res);
        }

    }

    @Override
    public void deleteLugares() {
        areaResultados.setText("");

    }

    @Override
    public void setLugares(String lugares) {
            // no tiene sentido
    }

    @Override
    public void setController(ICodigoPostalController controller) {
       this.codigoPostalController= controller;
    }

    @Override
    public void mostrar() {

        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(600, 400);
        marco.setLayout(new BorderLayout());

        // Panel superior para entrada de datos
        JPanel panelEntrada = new JPanel(new GridLayout(3, 2, 10, 10));

        JLabel etiquetaCodigoPostal = new JLabel("Código Postal:");

        JLabel etiquetaAbreviatura = new JLabel("Abreviatura del País:");

        JButton botonBuscar = new JButton("Buscar");
        JButton botonEliminar= new JButton("Eliminar");

        panelEntrada.add(etiquetaCodigoPostal);
        panelEntrada.add(campoCodigoPostal);
        panelEntrada.add(etiquetaAbreviatura);
        panelEntrada.add(campoAbreviatura);

        panelEntrada.add(botonBuscar);
        panelEntrada.add(botonEliminar);

        areaResultados.setEditable(false);
        JScrollPane scrollResultados = new JScrollPane(areaResultados);


        JPanel panelAbreviaturas = new JPanel(new BorderLayout());
        JLabel etiquetaAbreviaturas = new JLabel("Lista de Abreviaturas de Países:");
        JTextArea areaAbreviaturas = new JTextArea("US - Estados Unidos\nMX - México\nFR - Francia\nES - España\n...");
        areaAbreviaturas.setEditable(false);
        JScrollPane scrollAbreviaturas = new JScrollPane(areaAbreviaturas);

        panelAbreviaturas.add(etiquetaAbreviaturas, BorderLayout.NORTH);
        panelAbreviaturas.add(scrollAbreviaturas, BorderLayout.CENTER);


        marco.add(panelEntrada, BorderLayout.NORTH);
        marco.add(scrollResultados, BorderLayout.CENTER);
        marco.add(panelAbreviaturas, BorderLayout.SOUTH);


        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigoPostal = campoCodigoPostal.getText().trim();
                String abreviatura = campoAbreviatura.getText().trim();
                addLugar(codigoPostal, abreviatura);
            }
        });

        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteLugares();
            }
        });

        marco.setVisible(true);

    }

    public static void main(String[] args) {
        VistaCodigoPostal vm = new VistaCodigoPostal();
        CodigoPostalController cc = new CodigoPostalController();
        vm.setController(cc);
        vm.mostrar();
    }
}
