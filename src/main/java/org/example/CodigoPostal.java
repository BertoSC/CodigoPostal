package org.example;

import java.util.List;

public class CodigoPostal {
    private String codigoPostal;
    private String pais;
    private String abreviaturaPais;
    private List<Lugar> lugares;

    public CodigoPostal(){}
    public CodigoPostal(String cp, String pa, String abr, List<Lugar> lug){
        this.codigoPostal=cp;
        this.pais=pa;
        this.abreviaturaPais=abr;
        this.lugares=lug;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getAbreviaturaPais() {
        return abreviaturaPais;
    }

    public void setAbreviaturaPais(String abreviaturaPais) {
        this.abreviaturaPais = abreviaturaPais;
    }

    public List<Lugar> getLugares() {
        return lugares;
    }

    public void setLugares(List<Lugar> lugares) {
        this.lugares = lugares;
    }

    public void addLugar (Lugar lug){
        lugares.add(lug);
    }

    public String getLugaresAsHTML() {
        StringBuilder sb = new StringBuilder("<html><body>");
        lugares.forEach(lugar -> {
            sb.append(lugar.toHTML()).append("<br>");
        });
        sb.append("</body></html>");
        return sb.toString();
    }

    public String getLugaresAsHTML(boolean asTable) {
        StringBuilder sb = new StringBuilder("<html><body>");
        if (asTable) {
            sb.append("<table border=\"1\">");
            sb.append("<tr style=\"background-color: #cccccc\">");
            sb.append("<th>Lugar</th>");
            sb.append("<th>Longitud</th>");
            sb.append("<th>Latitud</th>");
            sb.append("<th>Comunidad</th>");
            sb.append("<th>Abreviatura Comunidad</th>");
            sb.append("</tr>");
            lugares.forEach(lugar -> {
                sb.append(lugar.toHTML(true));
            });
            sb.append("</table>");
        } else {
            lugares.forEach(lugar -> {
                sb.append(lugar.toHTML()).append("<br>");
            });
        }
        sb.append("</body></html>");
        return sb.toString();
    }

    @Override
    public String toString() {
        var sb = new StringBuilder("Código Postal: '"
                + codigoPostal + System.lineSeparator()
                + "Pais: '" + pais + System.lineSeparator()
                + "AbreviaturaPais: " + abreviaturaPais + System.lineSeparator());
        lugares.forEach(lugar -> {
            sb.append(lugar).append(System.lineSeparator());
        });
        return sb.toString();
    }
}