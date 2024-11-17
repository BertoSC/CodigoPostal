package org.example;

import java.util.concurrent.Executors;

public class Lugar {
    private String nome;
    private double longitud;
    private double latitud;
    private String estado;
    private String abreviaturaEstado;

    public Lugar(){}
    public Lugar (String nom, double lon, double lat, String est, String abr){
        this.nome=nom;
        this.longitud = lon;
        this.latitud = lat;
        this.estado = est;
        this.abreviaturaEstado = abr;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAbreviaturaEstado() {
        return abreviaturaEstado;
    }

    public void setAbreviaturaEstado(String abreviaturaEstado) {
        this.abreviaturaEstado = abreviaturaEstado;
    }

    public String toHTML() {
        return "<h1>" + nome + "</h1>"
                + "Longitud: " + longitud + "<br/>"
                + "Latitud: " + latitud + "<br/>"
                + "Comunidad: " + estado + "<br/>"
                + "Abreviatura Comunidad: " + abreviaturaEstado + "<br/>";
    }

    public String toHTML(boolean fila) {
        return (fila) ? "<tr style=\"background-color: #cccccc\">"
                + "<td>" + nome + "</td>"
                + "<td>" + longitud + "</td>"
                + "<td>" + latitud + "</td>"
                + "<td>" + estado + "</td>"
                + "<td>" + abreviaturaEstado + "</td>"
                + "</tr>"
                : "<h1>" + nome + "</h1>"
                + "Longitud: " + longitud + "<br/>"
                + "Latitud: " + latitud + "<br/>"
                + "Comunidad: " + estado + "<br/>"
                + "Abreviatura Comunidad: " + abreviaturaEstado + "<br/>";
    }

    @Override
    public String toString() {
        return " Lugar: " + nome + System.lineSeparator()
                + " Longitud: " + longitud + System.lineSeparator()
                + " Latitud: " + latitud + System.lineSeparator()
                + " Comunidad: " + estado + System.lineSeparator()
                + " Abreviatura Comunidad: " + abreviaturaEstado + System.lineSeparator();
    }
}