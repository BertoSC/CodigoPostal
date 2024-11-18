package org.example;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CodigoPostalDeserializer implements JsonDeserializer <CodigoPostal>{
    //Type tipo = new TypeToken<List<Lugar>>() {}.getType();
    @Override
    public CodigoPostal deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jo = jsonElement.getAsJsonObject();
        String codigoPostal = jo.get("post code").getAsString();
        String pais = jo.get("country").getAsString();
        String abreviatura = jo.get("country abbreviation").getAsString();

        JsonArray ja = jo.getAsJsonArray("places");
        List<Lugar> lugares = new ArrayList<>();
        for (JsonElement je: ja) {
            Lugar lug = jsonDeserializationContext.deserialize(je, Lugar.class);
            lugares.add(lug);
        }

        CodigoPostal cp = new CodigoPostal(codigoPostal, pais, abreviatura, lugares);


        return cp;
    }
}
