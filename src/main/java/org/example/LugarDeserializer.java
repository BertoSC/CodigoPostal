package org.example;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class LugarDeserializer implements JsonDeserializer<Lugar> {
    @Override
    public Lugar deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jo = jsonElement.getAsJsonObject();
        String nome = jo.get("place name").getAsString();
        double lon = jo.get("longitude").getAsDouble();
        String est = jo.get("state").getAsString();
        double lat = jo.get("latitude").getAsDouble();
        String abr = jo.get("state abbreviation").getAsString();
        Lugar lug = new Lugar(nome, lon, lat, est, abr);
        return lug;
    }

}
