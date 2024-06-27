package Modelo;

import Interface.InterfaceGestionSocios;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


public class GestionSocios <T extends Socio> implements InterfaceGestionSocios<T> {
    public HashMap<Integer, Socio> mapaSocios;


    public GestionSocios() {
        this.mapaSocios = new HashMap<Integer, Socio>();
    }


    public HashMap<Integer, Socio> getMapaSocios() {
        return mapaSocios;
    }

    public void setMapaSocios(HashMap<Integer, Socio> mapaSocios) {
        this.mapaSocios = mapaSocios;
    }

    @Override
    public boolean addSocio(T socio) {
        if (socio != null) {
            mapaSocios.put(socio.getIdSocio(), socio);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeSocio(T socio) {
        if (socio != null) {
            mapaSocios.remove(socio.getIdSocio());
            return true;
        }
        return false;
    }

    @Override
    public boolean updateSocio(T socio, T newSocio) {
        if(socio != null && newSocio != null) {
            removeSocio(socio);
            addSocio(newSocio);
        }
        return false;
    }

    @Override
    public T getSocioById(int id) {
        if (mapaSocios.containsKey(id)) {
            return (T) mapaSocios.get(id);
        }
        return null;
    }

    public void mejorarSocios(){
        for (Socio socio : mapaSocios.values()) {
            mejorarSocio((T) socio);
        }
    }

    public void mejorarSocio(T socio){
        LocalDate hoy = LocalDate.now();
        if(socio != null) {
            if(socio instanceof SocioAdherente) {
                LocalDate fechaAdherente = ((SocioAdherente) socio).getFechaInicioAdherente();
                long diferenciaDias = ChronoUnit.DAYS.between(fechaAdherente, hoy);
                if (diferenciaDias > 870){
                    removeSocio(socio);
                    SocioVitalicio nuevoVitalicio = new SocioVitalicio(socio.getPartidosVistos(), socio.getIdSocio(), socio.getNombre(), socio.getApellido(), socio.getEdad());
                    addSocio((T) nuevoVitalicio);
                }else if (diferenciaDias > 150){
                    removeSocio(socio);
                    SocioActivo nuevoActivo = new SocioActivo(socio.getPartidosVistos(), socio.getIdSocio(), socio.getNombre(), socio.getApellido(), socio.getEdad());
                    addSocio((T) nuevoActivo);
                }
            }
            if(socio instanceof SocioActivo){
                LocalDate fechaActivo = ((SocioActivo)socio).getFechaInicialActivo();
                long diferenciaDias = ChronoUnit.DAYS.between(fechaActivo, hoy);
                if (diferenciaDias > 720){
                    removeSocio(socio);
                    SocioVitalicio nuevoVitalicio = new SocioVitalicio(socio.getPartidosVistos(), socio.getIdSocio(), socio.getNombre(), socio.getApellido(), socio.getEdad());
                    addSocio((T) nuevoVitalicio);
                }
            }
        }
    }
}
