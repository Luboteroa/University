public class Partida {
    private Jugador jugador1, jugador2;
    public Partida(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }
    public void jugar() {
        Jugador actual, siguiente;
        actual = seleccionarJugadorAleatoriamente();
        String pos = "";

        while(!valida(pos)){
            pos = ingresoPosition(actual);
        }

        actualizarTablero(pos);

        while(!tableroLleno() && ganador()==null){
            //Se inicia la posición nueva como vacío
            pos = "";

            if(actual==jugador1) siguiente=jugador2;
            else siguiente = jugador1;

            while(!valida(pos)){
                pos = ingresoPosition(siguiente);
            }

            actualizarTablero(pos);
            actual = siguiente;
        }
        if(tableroLleno())
            mostrarMensajeTableroLleno();
        else if(ganador()!=null)
            mostrarMensajeGanador();
    }

    private void mostrarMensajeGanador() {
    }

    private void mostrarMensajeTableroLleno() {
        
    }

    private void actualizarTablero(String pos) {
    }

    private boolean tableroLleno() {
        return  false;
    }

    private boolean valida(String pos) {
        return  false;
    }

    private String ingresoPosition(Jugador actual) {
        return null;
    }

    private Jugador seleccionarJugadorAleatoriamente() {
        Jugador jugador = null;
        return jugador;
    }

    public Jugador ganador() {
        return null; //TODO.
    }
}
