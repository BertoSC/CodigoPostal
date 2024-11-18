package org.example;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class CodigoPostalDeserializer implements JsonDeserializer <CodigoPostal>{
    Type tipo = new TypeToken<List<Lugar>>() {}.getType();
    @Override
    public CodigoPostal deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jo = jsonElement.getAsJsonObject();
        String codigoPostal = jo.get("post code").getAsString();
        String pais = jo.get("country").getAsString();
        String abreviatura = jo.get("country abbreviation").getAsString();
        List<Lugar> lugares = jsonDeserializationContext.deserialize(jsonElement, tipo);

        CodigoPostal cp = new CodigoPostal(codigoPostal, pais, abreviatura, lugares);


        return null;
    }
}
