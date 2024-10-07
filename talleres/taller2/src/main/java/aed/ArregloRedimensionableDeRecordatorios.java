package aed;

class ArregloRedimensionableDeRecordatorios {

    private Recordatorio[] seq_recordatorios;
    private int espacio_ocupado;

    public ArregloRedimensionableDeRecordatorios() {
        seq_recordatorios = new Recordatorio[0];
        espacio_ocupado = 0;
    }   

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        // El constructor por copia de una clase es el que toma como unico parametro otra instancia de la misma clase y lo usa para construir una copia.
        espacio_ocupado = vector.espacio_ocupado; 
        seq_recordatorios  = new Recordatorio[vector.espacio_ocupado];
        for(int i = 0; i < vector.espacio_ocupado; i++){
            seq_recordatorios[i] = vector.obtener(i);
        }
        espacio_ocupado = vector.longitud();
    }

    public int longitud() {
        return espacio_ocupado;
    }

    public void agregarAtras(Recordatorio recordatorio_a_agregar) {
        espacio_ocupado++;
        Recordatorio[] nuevo_seq_recordatorios = new Recordatorio[espacio_ocupado];
        for(int i = 0; i < espacio_ocupado - 1; i++){
            nuevo_seq_recordatorios[i] = seq_recordatorios[i];
        }
        nuevo_seq_recordatorios[espacio_ocupado - 1] = recordatorio_a_agregar;
        seq_recordatorios = nuevo_seq_recordatorios;
        
    }

    public Recordatorio obtener(int indice) {
        return seq_recordatorios[indice];
    }

    public void quitarAtras() {
        espacio_ocupado--;
        Recordatorio[] nuevo_seq_recordatorios = new Recordatorio[espacio_ocupado];
        for(int i = 0; i < espacio_ocupado; i++){
            nuevo_seq_recordatorios[i] = seq_recordatorios[i];
        }
        seq_recordatorios = nuevo_seq_recordatorios;
     }

    public void modificarPosicion(int indice, Recordatorio valor) {
        seq_recordatorios[indice] = valor; 
        
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios new_seq_recordatorios = new ArregloRedimensionableDeRecordatorios();
        for (int i = 0; i < espacio_ocupado; i++){
            new_seq_recordatorios.agregarAtras(seq_recordatorios[i]);
            // new_seq_recordatorios puede usar los metodos que definimos anteriormente pues es un arreglo redimensionable
            // como queremos que copie los recordatorios de seq_recordatorios
            // basta con usar el metodo agregarAtras para agregar todos los recordatorios ya presentes en el original.
        }
        return new_seq_recordatorios;
    }
}
