import java.util.HashMap;

public class GestionSocios <T extends Socio> implements InterfaceGestionSocios<T> {
    HashMap<Integer, Socio> mapaSocios;


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
}
