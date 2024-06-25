package Modelo;

import Interface.InterfaceGestionSocios;

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

    public void mejorarSocio(T socio){
        Date hoy = Calendar.getInstance().getTime();
        if(socio != null) {
            if(socio instanceof SocioAdherente) {
                Date fechaAdherente = ((SocioAdherente) socio).getFechaInicioAdherente();
                long diferenciaMilisegundos = hoy.getTime() - fechaAdherente.getTime();
                long diferenciaSegundos = diferenciaMilisegundos / 1000;
                long diferenciaMinutos = diferenciaSegundos / 60;
                long diferenciaHours = diferenciaMinutos / 60;
                long diferenciaDays = diferenciaHours / 24;
                if (diferenciaDays > 150){
                    removeSocio(socio);
                    SocioActivo nuevoActivo = new SocioActivo(socio.getPartidosVistos(), socio.getIdSocio(), socio.getNombre(), socio.getApellido(), socio.getEdad());
                    addSocio((T) nuevoActivo);
                }
            }
            if(socio instanceof SocioActivo){
                Date fechaActivo = ((SocioActivo)socio).getFechaInicialActivo();
                long diferenciaMilisegundos = hoy.getTime() - fechaActivo.getTime();
                long diferenciaSegundos = diferenciaMilisegundos / 1000;
                long diferenciaMinutos = diferenciaSegundos / 60;
                long diferenciaHours = diferenciaMinutos / 60;
                long diferenciaDays = diferenciaHours / 24;
                if (diferenciaDays > 720){
                    removeSocio(socio);
                    SocioVitalicio nuevoVitalicio = new SocioVitalicio(socio.getPartidosVistos(), socio.getIdSocio(), socio.getNombre(), socio.getApellido(), socio.getEdad());
                    addSocio((T) nuevoVitalicio);
                }
            }
        }
    }
}
