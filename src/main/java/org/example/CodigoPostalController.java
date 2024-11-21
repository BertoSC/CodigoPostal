package org.example;

public class CodigoPostalController implements ICodigoPostalController{
    ICodigoPostalDAO codigoPostalDAO;
    IVistaCodigoPostal vistaCodigoPostal;

    // Constructor que recoge la referencia al modelo
    public CodigoPostalController(ICodigoPostalDAO codigoPostalDAO, IVistaCodigoPostal vistaCodigoPostal) {
        this.codigoPostalDAO = codigoPostalDAO;
        this.vistaCodigoPostal = vistaCodigoPostal;
    }

    public CodigoPostalController(IVistaCodigoPostal vistaCodigoPostal) {
        codigoPostalDAO = new CodigoPostalDAO();
        this.vistaCodigoPostal = vistaCodigoPostal;
    }

    public CodigoPostalController() {
        codigoPostalDAO = new CodigoPostalDAO();
    }

    @Override
    public String getLugares(String codigoPostal, boolean asHTML) {
        CodigoPostal temp = codigoPostalDAO.getCodigoPostal(codigoPostal);
        if (temp==null) {
            return null;
        } else if (temp!=null && asHTML){
            return temp.getLugaresAsHTML();
        } else {
            StringBuilder sb = new StringBuilder();
                for (Lugar l:temp.getLugares()){
                    sb.append(l).append(System.lineSeparator());
                }
            return sb.toString();
        }
    }

    @Override
    public String getLugares(String codigoPostal, String pais, boolean asHTML) {
        CodigoPostal temp = codigoPostalDAO.getCodigoPostal(codigoPostal, pais);
        if (temp==null) {
            return null;
        } else if (temp!=null && asHTML){
            return temp.getLugaresAsHTML();
        } else {
            StringBuilder sb = new StringBuilder();
            for (Lugar l:temp.getLugares()){
                sb.append(l).append(System.lineSeparator());
            }
            return sb.toString();
        }
    }

    @Override
    public void setLugares(String codigoPostal, boolean asHTML) {
        //vistaCodigoPostal.setLugares(codigoPostalDAO.getCodigoPostal(codigoPostal).getLugares());
    }

    @Override
    public void setVista(IVistaCodigoPostal vista) {
         this.vistaCodigoPostal=vista;
    }
}
