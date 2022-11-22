import java.util.Scanner;

public class Escenario {
    public static void main(String[] args) {
        Jugador jugador1, jugador2;

        //La partida inicia al ejecutar el programa, solicitando el nombre de los jugadores
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del jugador 1: ");
        jugador1 = new Jugador(sc.next());
        System.out.println("Ingrese el nombre del jugador 2: ");
        jugador2 = new Jugador(sc.next());

        //Una vez ingresados los nombres
        Partida partida = new Partida(jugador1, jugador2);
        boolean vamosAJugar=true;
        while (vamosAJugar) {
            partida.jugar();
        }
        //Una vez finaliza la partida, el sistema debe actualizar los puntajes de los jugadores de acuerdo a los resultados.
        if(partida.ganador()!=null)
            partida.ganador().incrementarPuntaje();

        //Después el sistema debe preguntar al usuario si quiere seguir jugando.
        vamosAJugar = preguntarSiQuierenSeguirJugando();
    }

    private static boolean preguntarSiQuierenSeguirJugando() {
        return false;
    }
}
