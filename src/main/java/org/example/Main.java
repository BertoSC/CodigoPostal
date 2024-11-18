package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Type listProvType = new TypeToken<List<Lugar>>() {}.getType();

        System.out.println("INFORMACIÓN DE CÓDIGOS POSTALES");
        System.out.println();
        System.out.println("Introduce el Código Postal que quieres consultar");

        Scanner sc = new Scanner(System.in);
        int idCP = sc.nextInt();
        String json = null;
        //Boolean existe = comprobarIdConcello(idConcello);

       // if (existe) {
            System.out.println();
            System.out.println("INFORMACIÓN DE CP:");
            System.out.println();
            json = obtenerCodigoPostalJson(idCP);
       // }

        if (json != null) {
            Gson gson = construirGsonBuilder();
            CodigoPostal p = gson.fromJson(json, CodigoPostal.class);
            System.out.println(p);

        } else {
            System.out.println("No se pudo obtener la predicción.");
        }

    }

    public static String obtenerCodigoPostalJson(int idCodigo) {
        String urlAcceso = "https://api.zippopotam.us/es/" + idCodigo;
        try {
            URI uri = new URI(urlAcceso);
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

    public static Gson construirGsonBuilder(){
        Type listType = new TypeToken<List<Lugar>>() {}.getType();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(CodigoPostal.class, new CodigoPostalDeserializer())
                .registerTypeAdapter(Lugar.class, new LugarDeserializer())
                .create();
        return gson;
    }
}