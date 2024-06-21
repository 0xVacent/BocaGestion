import java.util.Date;
import java.util.Objects;

public class SocioActivo extends Socio{
    private Date fechaInicialActivo;

    public Date getFechaInicialActivo() {
        return fechaInicialActivo;
    }

    public void setFechaInicialActivo(Date fechaInicialActivo) {
        this.fechaInicialActivo = fechaInicialActivo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SocioActivo that = (SocioActivo) o;
        return Objects.equals(fechaInicialActivo, that.fechaInicialActivo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fechaInicialActivo);
    }

    @Override
    public String toString() {
        return "SocioActivo{" +
                "fechaInicialActivo=" + fechaInicialActivo +
                "} " + super.toString();
    }
}
