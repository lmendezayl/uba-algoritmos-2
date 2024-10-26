package aed;

public class Horario {

    private int hora;
    private int minutos;

    public Horario(int hora, int minutos) {
        this.hora = hora;
        this.minutos = minutos;
    }

    public int hora() {
        return this.hora;
    }

    public int minutos() {
        return this.minutos;
    }

    @Override
    public String toString() {
        return "" + hora + ":" + minutos;
    }

    @Override
    public boolean equals(Object otro) {
        // mismo concepto que en Fecha, verificamos si son de clase distinta o si
        // es nulo, luego no son iguales, sino verificamos hora y minutos en este caso
        if (this.getClass() != otro.getClass() || otro == null) {
            return false;
        } else {
            return this.hora == ((Horario) otro).hora && this.minutos == ((Horario) otro).minutos;
        }
    }

}
