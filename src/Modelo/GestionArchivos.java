package Modelo;

import Enums.Posicion;
import org.json.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class GestionArchivos {
    public static void grabar(JSONArray array, String archivo) {
        try {
            FileWriter file = new FileWriter(archivo + ".json");
            file.write(array.toString());
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void grabar(JSONObject jsonObject, String archivo) {
        try {
            FileWriter file = new FileWriter(archivo + ".json");
            file.write(jsonObject.toString());
            file.flush();
            file.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static String leer(String archivo) {
        String contenido = "";


        if (!(Files.exists(Paths.get(archivo + ".json")))) {
            JSONArray jsonArray = new JSONArray();
            try {
                FileWriter filewr = new FileWriter(archivo + ".json");
                filewr.write(jsonArray.toString());
                filewr.flush();
                filewr.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }




        try {
            contenido = new String(Files.readAllBytes(Paths.get(archivo + ".json")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contenido;
    }

    public static HashMap<Integer, Socio> parseJSONSocios(String archivo) {
        HashMap<Integer, Socio> socios = new HashMap<>();

        String response = leer(archivo);

        JSONArray jsonArray;
        try {
            jsonArray = new JSONArray(response);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (jsonObject.has("fechaInicialActivo")) {

                    SocioActivo socioActivo = new SocioActivo(jsonObject.getInt("partidosVistos"), jsonObject.getInt("idSocio"), jsonObject.getString("nombre"), jsonObject.getString("apellido"), jsonObject.getInt("edad"));
                    socios.put(socioActivo.getIdSocio(), socioActivo);
                } else if (jsonObject.has("fechaInicioAdherente")) {
                    SocioAdherente socioAdherente = new SocioAdherente(jsonObject.getInt("partidosVistos"), jsonObject.getInt("idSocio"), jsonObject.getString("nombre"), jsonObject.getString("apellido"), jsonObject.getInt("edad"));
                    socios.put(socioAdherente.getIdSocio(), socioAdherente);
                } else if (jsonObject.has("fechaInicioVitalicio")) {
                    SocioVitalicio socioVitalicio = new SocioVitalicio(jsonObject.getInt("partidosVistos"), jsonObject.getInt("idSocio"), jsonObject.getString("nombre"), jsonObject.getString("apellido"), jsonObject.getInt("edad"));
                    socios.put(socioVitalicio.getIdSocio(), socioVitalicio);
                }
            }

            return socios;

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }

    public static HashMap<Integer, Jugador> parseJSONJugadores(String archivo) {
        HashMap<Integer, Jugador> jugadores = new HashMap<>();

        String response = leer(archivo);



        JSONArray jsonArray;
        try {
            jsonArray = new JSONArray(response);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                if (jsonObject.has("entradaAcademia")) {
                    JugadorInferiores jugadorInferiores = new JugadorInferiores(jsonObject.getString("nombre"), jsonObject.getInt("edad"), jsonObject.getString("apellido"), (Posicion) jsonObject.get("posicion"), jsonObject.getInt("idJugador"), jsonObject.getInt("defensa"), jsonObject.getInt("ataque"), jsonObject.getDouble("sueldo"));
                    jugadores.put(jugadorInferiores.getIdJugador(), jugadorInferiores);
                }else if (jsonObject.has("inicioPrimera")) {
                    Posicion posicion = Posicion.valueOf(jsonObject.getString("posicion"));
                    JugadorPrimera jugadorPrimera = new JugadorPrimera(jsonObject.getString("nombre"), jsonObject.getInt("edad"), jsonObject.getString("apellido"), posicion, jsonObject.getInt("idJugador"), jsonObject.getInt("defensa"), jsonObject.getInt("ataque"), jsonObject.getDouble("sueldo"));
                    jugadores.put(jugadorPrimera.getIdJugador(), jugadorPrimera);
                }

            }

            return jugadores;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}

