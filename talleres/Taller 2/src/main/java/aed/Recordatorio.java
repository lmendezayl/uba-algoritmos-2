package aed;

public class Recordatorio {

    private String mensaje;
    private Fecha fecha;
    private Horario horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha = new Fecha(fecha); // y con esto tambien
        this.horario = new Horario(horario.hora(), horario.minutos());
    }

    public Horario horario() {
        return horario;
    }

    public Fecha fecha() {
        Fecha nueva_fecha = new Fecha(fecha); // con esto nos ahorramos el aliasing
        return nueva_fecha;
    }

    public String mensaje() {
        return mensaje;
    }

    @Override
    public String toString() {
        return this.mensaje + " @ " + this.fecha + " " + this.horario;
    }

    @Override
    public boolean equals(Object otro) {
        if (this.getClass() != otro.getClass()) {
            return false;
        } else {
            Recordatorio otroRecordatorio = (Recordatorio) otro;
            // no me andaba porque estaba haciendo aliasing y no estaba usando el metodo
            // equals XD
            return (otroRecordatorio.mensaje.equals(mensaje) &&
                    otroRecordatorio.horario.equals(horario) &&
                    otroRecordatorio.fecha.equals(fecha));
        }
    }
}
