public interface InterfaceGestionSocios<T extends Socio>{
    boolean addSocio(T socio);
    boolean removeSocio(T socio);
    boolean updateSocio(T socio, T newSocio);
    T getSocioById(int id);
    public void mejorarSocio(T socio);



}
