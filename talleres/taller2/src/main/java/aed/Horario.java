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
        return Integer.toString(hora) + ":" + Integer.toString(minutos);
    }

    @Override
    public boolean equals(Object otro) {
        // Implementar
        return true;
    }

}
