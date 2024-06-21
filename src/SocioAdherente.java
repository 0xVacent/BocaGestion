import java.util.Date;
import java.util.Objects;

public class SocioAdherente extends Socio{
    private Date fechaInicioAdherente;

    public Date getFechaInicioAdherente() {
        return fechaInicioAdherente;
    }

    public void setFechaInicioAdherente(Date fechaInicioAdherente) {
        this.fechaInicioAdherente = fechaInicioAdherente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SocioAdherente that = (SocioAdherente) o;
        return Objects.equals(fechaInicioAdherente, that.fechaInicioAdherente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fechaInicioAdherente);
    }

    @Override
    public String toString() {
        return "SocioAdherente{" +
                "fechaInicioAdherente=" + fechaInicioAdherente +
                "} " + super.toString();
    }
}
