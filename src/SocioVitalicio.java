import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class SocioVitalicio extends Socio{
    private Date fechaInicioVitalicio;

    public SocioVitalicio(int partidosVistos, int idSocio, String nombre, String apellido, int edad) {
        super(0, partidosVistos, idSocio, nombre, apellido, edad);
        this.fechaInicioVitalicio = Calendar.getInstance().getTime();
    }

    public Date getFechaInicioVitalicio() {
        return fechaInicioVitalicio;
    }

    public void setFechaInicioVitalicio(Date fechaInicioVitalicio) {
        this.fechaInicioVitalicio = fechaInicioVitalicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SocioVitalicio that = (SocioVitalicio) o;
        return Objects.equals(fechaInicioVitalicio, that.fechaInicioVitalicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fechaInicioVitalicio);
    }

    @Override
    public String toString() {
        return "SocioVitalicio{" +
                "fechaInicioVitalicio=" + fechaInicioVitalicio +
                "} " + super.toString();
    }
}
