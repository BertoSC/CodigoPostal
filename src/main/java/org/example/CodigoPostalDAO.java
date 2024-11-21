package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class CodigoPostalDAO implements ICodigoPostalDAO {
    private static final String URL = "https://api.zippopotam.us/";
    String pais;  // la abreviatura es necesaria para completar la URL fijo
    Gson gson;

    public CodigoPostalDAO() {
        this.pais="es";  // se crea en null? o se hace un constructor que recoja el pais?
        configurarGsonBuilder();
    }

    public CodigoPostalDAO(String pais){
        this.pais=pais;  // se crea en null? o se hace un constructor que recoja el pais?
        configurarGsonBuilder();

    }

    @Override
    public CodigoPostal getCodigoPostal(String codigoPostal) {
        String jsonCp = obtenerJson(codigoPostal, pais);
        CodigoPostal actualCp= gson.fromJson(jsonCp, CodigoPostal.class);
        return actualCp;
    }

    @Override
    public CodigoPostal getCodigoPostal(String codigoPostal, String paisAbr) {
        String jsonCp = obtenerJson(codigoPostal, paisAbr);
        CodigoPostal actualCP = gson.fromJson(jsonCp, CodigoPostal.class);
        this.pais=paisAbr; //innecesario??? depende de la implementación de Controlador y Vista
        return actualCP;
    }

    public String obtenerJson(String cP, String P){
        try {
            URI uri = new URI(URL+P+"/"+cP);
            HttpURLConnection conexion = (HttpURLConnection) uri.toURL().openConnection();
            conexion.setRequestMethod("GET");
            if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (var br = new BufferedReader(new InputStreamReader(conexion.getInputStream()))) {
                    String linea = null;
                    StringBuilder codigoPostalJson = new StringBuilder();
                    while ((linea = br.readLine()) != null) {
                        codigoPostalJson.append(linea);
                    }
                    return codigoPostalJson.toString();
                }
            } else {
                System.out.println("Error en la petición: " + conexion.getResponseCode());
                return null;
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void configurarGsonBuilder(){
        this.gson = this.gson= new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(CodigoPostal.class, new CodigoPostalDeserializer())
                .registerTypeAdapter(Lugar.class, new LugarDeserializer()).create();
    }
}
