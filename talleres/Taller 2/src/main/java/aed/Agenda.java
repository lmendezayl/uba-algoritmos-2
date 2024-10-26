package aed;

public class Agenda {

    public Fecha fecha;
    public ArregloRedimensionableDeRecordatorios agenda;

    public Agenda(Fecha fechaActual) {
        fecha = fechaActual;
        agenda = new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        agenda.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
        String display_string = new String(fechaActual() + "\n=====\n" );
        for(int i = 0; i < agenda.longitud(); i++){
            if (fechaActual().equals(agenda.obtener(i).fecha())) {
                display_string = display_string + agenda.obtener(i) .toString() + "\n";
            }
        }
        return display_string;
    }

    public void incrementarDia() {
        fecha.incrementarDia();
    }

    public Fecha fechaActual() {
        Fecha fecha_devuelta = new Fecha(fecha);
        return fecha_devuelta;
    }

}
