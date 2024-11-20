//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        //creacion del mazo con las cartas
        Mazo miMazo = new Mazo();
        HashMap mazito = miMazo.crearMazo();
        miMazo.repartirMazo();

        miMazo.mezclarMazo();
        //hasta el momento si funciona bien
        List<ArrayList<String>> mazosDivididos = miMazo.partirMazo();

        ArrayList<String> mazo1 = mazosDivididos.get(0);
        ArrayList<String> mazo2 = mazosDivididos.get(1);

        //en este punto ya tengo las dos mitades de mi mazo
        //ahora sigue darle a cada jugador un mazo

        Jugador jugador1 = new Jugador(miMazo);
        Jugador jugador2 = new Jugador(miMazo);
        //aca ya le asigno al jugador la mitad necesaria
        ArrayList<String> mazo_jugador_1 = jugador1.mazoJugador(0);
        ArrayList<String> mazo_jugador_2 = jugador2.mazoJugador(1);
        //lo siguiente es ya jugar
        //como accedo a la primer carta del mazo?, esto es lo mismo que loopear y sacar el primer elemento
        //creo que no es necesario loopear al 100, ¿existe alguna función para ver el primer elemento de un array
        //tengo que tener al array disponible
        //es un while
        //cual es el nombre global del hashMap? es mazo
        while (!mazo_jugador_1.isEmpty() && !mazo_jugador_2.isEmpty()) {
            // Obtener la carta en la primera posición de cada mazo
            String carta_jugador1 = mazo_jugador_1.get(0);
            String carta_jugador2 = mazo_jugador_2.get(0);

            // Verificar que ambas cartas existan en el HashMap `mazito`
            if (mazito.containsKey(carta_jugador1) && mazito.containsKey(carta_jugador2)) {
                // Convertir los valores de las cartas a int
                int valor_jugador1 = (int) mazito.get(carta_jugador1);
                int valor_jugador2 = (int) mazito.get(carta_jugador2);

                // Comparar valores de las cartas
                if (valor_jugador1 > valor_jugador2) {
                    // Jugador 1 gana la ronda
                    mazo_jugador_1.add(carta_jugador2); // Agregar carta del jugador 2
                    mazo_jugador_2.remove(0); // Eliminar carta del jugador 2
                } else {
                    // Jugador 2 gana la ronda
                    mazo_jugador_2.add(carta_jugador1); // Agregar carta del jugador 1
                    mazo_jugador_1.remove(0); // Eliminar carta del jugador 1
                }
                // Eliminar la carta usada del ganador también
                mazo_jugador_1.remove(0); // Eliminar la carta del jugador 1
            } else {
                System.out.println("Error: Una de las cartas no está en el mazo.");
                break;
            }
        }

        if (mazo_jugador_1.isEmpty()) {
            System.out.println("¡El jugador 2 ganó el juego!");
        } else if (mazo_jugador_2.isEmpty()) {
            System.out.println("¡El jugador 1 ganó el juego!");
        }
    }
    //me salio bugueado

}