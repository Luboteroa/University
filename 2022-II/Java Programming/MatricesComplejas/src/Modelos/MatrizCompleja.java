package Modelos;

public class MatrizCompleja {
    private final Complejo[][] dato;
    private final int filas, columnas;

    public MatrizCompleja(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        dato = new Complejo[filas][columnas];
    }
    public MatrizCompleja(MatrizCompleja A)
    {
        filas = A.getFilas();
        columnas = A.getColumnas();
        dato = new Complejo[filas][columnas];

        for (int fila = 0; fila<filas; ++fila)
        {
            for(int columna = 0; columna<columnas; ++columna)
            {
                dato[fila][columna] = A.getDato(fila, columna);
            }
        }
    }

    private Complejo getDato(int fila, int columna) {
        return dato[fila][columna];
    }

    private int getColumnas() {
        return 0;
    }

    private int getFilas() {
        return 0;
    }
}
