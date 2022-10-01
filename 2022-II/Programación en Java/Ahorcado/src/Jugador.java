import java.util.LinkedList;

public class Jugador {
    private final String nombre;
    private int puntaje;
    private Jugador jugadorActual = null;

    public static void main(String[] args)
    {
        Jugador persona = new Jugador("Daniel");

        persona.IncrementarPuntaje(persona, 20);
        persona.IncrementarPuntaje(persona, 50);
    }

    public Jugador(String nombre) {

        this.nombre = nombre;
        puntaje = 0;

        System.out.println("nombre: " + nombre);
    }

    public void JugadorActual(Jugador jugador)
    {
        jugadorActual = jugador;
    }

    public void IncrementarPuntaje(Jugador jugador, int puntaje)
    {
        jugador.puntaje += puntaje;

        System.out.println("Puntaje: " + jugador.puntaje);
    }

    public void AcaboPartida()
    {
        //Clase de ranking en la cual esta función manda el jugador actual con el puntaje
        //Ranking.getJugador(jugadorActual);
        jugadorActual = null;
    }
}
