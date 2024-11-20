import java.util.ArrayList;
import java.util.List;

public class Jugador {
    String nombre;
    Integer puntaje;
    ArrayList<String> cartas;

    private Mazo mazo;

    public Jugador(Mazo mazo) {
        this.mazo = mazo;
    }


    //un metodo que agarre el método partirMazo
    public ArrayList<String> mazoJugador(int mitad){
        //el parametro es para saber que mitad dar
        //tengo una lista de arraysList
        List<ArrayList<String>> mazosDivididos = mazo.partirMazo();
        //aca elijo que mitad dar
        ArrayList<String> mazo = mazosDivididos.get(mitad);
        return mazo;
    }


}
