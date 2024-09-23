package aed;

public class Recordatorio {

    private String mensaje;
    private Fecha fecha;
    private Horario horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.horario = horario;
    }

    public Recordatorio (Recordatorio otro) {
        this.fecha = otro.fecha;
   }

    public Horario horario() {
        return horario;
    }

    public Fecha fecha() {
        return fecha;
    }

    public String mensaje() {
        return mensaje;
    }

    @Override
    public String toString() {
        return mensaje + " @ " + fecha + " " + horario;
    }

    @Override
    public boolean equals(Object otro) {
        if (this.getClass() != otro.getClass() || otro == null) {
            return false;
        } else {
            return  this.mensaje == ((Recordatorio) otro).mensaje &&
                    this.fecha == ((Recordatorio) otro).fecha &&
                    this.horario == ((Recordatorio) otro).horario;
        }
    }

}
