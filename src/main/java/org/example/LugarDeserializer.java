package org.example;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class LugarDeserializer implements JsonDeserializer<List<Lugar>> {
    @Override
    public List<Lugar> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
       List<Lugar> lugares = new ArrayList<>();
        JsonArray ja = jsonElement.getAsJsonArray();
        for(JsonElement je:ja){
            JsonObject jo = je.getAsJsonObject();
            String nome = jo.get("place name").getAsString();
            double lon = jo.get("longitude").getAsDouble();
            String est = jo.get("state").getAsString();
            double lat = jo.get("latitude").getAsDouble();
            String abr = jo.get("state abbreviation").getAsString();
            lugares.add(new Lugar(nome, lon, lat, est, abr));
        }
        return lugares;
    }
}
