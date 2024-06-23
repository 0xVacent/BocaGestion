import org.json.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;

public class GestionArchivos {
    public static void grabar(JSONArray array, String archivo) {
        try {
            FileWriter file = new FileWriter(archivo+".json");
            file.write(array.toString());
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void grabar(JSONObject jsonObject, String archivo) {
        try {
            FileWriter file = new FileWriter(archivo+".json");
            file.write(jsonObject.toString());
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String leer(String archivo)
    {
        String contenido = "";
        try
        {
            contenido = new String(Files.readAllBytes(Paths.get(archivo+".json")));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return contenido;
    }

    public static HashMap<Integer, Socio> parseJSON(String archivo) {
        HashMap<Integer, Socio> socios = new HashMap<>();

        String response = leer(archivo);

        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(response);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (jsonObject.has("fechaInicialActivo")) {
                    SocioActivo socioActivo = new SocioActivo(jsonObject.getInt("partidosVistos"), jsonObject.getInt("idSocio"), jsonObject.getString("nombre"), jsonObject.getString("apellido"), jsonObject.getInt("edad"));
                    socios.put(socioActivo.getIdSocio(), socioActivo);
                }else if (jsonObject.has("fechaInicioAdherente")) {
                    SocioAdherente socioAdherente = new SocioAdherente(jsonObject.getInt("partidosVistos"), jsonObject.getInt("idSocio"), jsonObject.getString("nombre"), jsonObject.getString("apellido"), jsonObject.getInt("edad"));
                    socios.put(socioAdherente.getIdSocio(), socioAdherente);
                }else if (jsonObject.has("fechaInicioVitalicio")) {
                    SocioVitalicio socioVitalicio = new SocioVitalicio(jsonObject.getInt("partidosVistos"), jsonObject.getInt("idSocio"), jsonObject.getString("nombre"), jsonObject.getString("apellido"), jsonObject.getInt("edad"));
                    socios.put(socioVitalicio.getIdSocio(), socioVitalicio);
                }
            }

            return socios;

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }




    }


}

