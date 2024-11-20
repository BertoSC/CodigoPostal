package org.example;

public class CodigoPostalController implements ICodigoPostalController{
    CodigoPostalDAO codigoPostalDAO;
    VistaCodigoPostal vistaCodigoPostal;

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
        return null;
    }

    @Override
    public String getLugares(String codigoPostal, String pais, boolean asHTML) {
        return null;
    }

    @Override
    public void setLugares(String codigoPostal, boolean asHTML) {

    }

    @Override
    public void setVista(IVistaCodigoPostal vista) {

    }
}
