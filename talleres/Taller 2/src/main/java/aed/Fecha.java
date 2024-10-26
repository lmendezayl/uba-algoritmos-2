package aed;

public class Fecha {

    private int dia;
    private int mes;

    // constructor con parametros de ingreso dia y mes
    public Fecha(int dia, int mes) {
        this.dia = dia;
        this.mes = mes;
    }

    // constructor con parametro de ingreso Fecha
    public Fecha(Fecha fecha) {
        this.dia = fecha.dia;
        this.mes = fecha.mes;
    }

    public Integer dia() {
        return dia;
    }

    public Integer mes() {
        return mes;
    }

    @Override
    public String toString() {

        // usamos metodo toString() de la clase Integer
        // good practice
        //
        // update: no creo que este bien usar el metodo toString()
        // porque le quita la gracia al ej, pero bueno
        return String.valueOf(dia) + "/" + String.valueOf(mes);
    }

    @Override
    public boolean equals(Object otra) {
        // si Object otra es una Fecha fecha
        // retorna True
        // sino retorna False
        if (this.getClass() != otra.getClass() || otra == null) {
            return false;
        } else {
            Fecha otraFecha = (Fecha) otra;
            return otraFecha.dia == dia && otraFecha.mes == mes;
        }
    }

    public void incrementarDia() {
        // si dia es igual la cantidad de dias en el mes
        // dia = 1; mes++
        // sino, dia++
        if (dia == diasEnMes(mes)) {
            dia = 1;
            if (mes++ == 12)
                mes = 1;
        } else {
            dia++;
        }
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
