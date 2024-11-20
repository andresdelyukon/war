import java.util.*;

public class Mazo {
    //el primer objetivo es crear un hashmap con todas las cartas
    private HashMap<String, Integer> mazo;


    public Mazo() {
        this.mazo = new HashMap<>();
    }

    // Método para obtener el mazo
    public HashMap<String, Integer> getMazo() {
        return mazo;
    }

    // Método para establecer un nuevo mazo
    public void setMazo(HashMap<String, Integer> mazo) {
        this.mazo = mazo;
    }

    //lo que no se es como llamar al metodo para crear el hashmap
    //esta madre regresa un hashmap
    public HashMap crearMazo() {
        //como meto el hashmap ya creado en la clase?
        String[] palos = {"diamantes", "corazones", "trebol", "picas"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for (int i = 0; i < palos.length; i++) {
            for (int j = 0; j < valores.length; j++) {
                mazo.put(palos[i] + valores[j], j + 2);
            }
        }
        return mazo;
    }

    //esto se logra revolviendo el mazo
    //el problema es que no podemos revolver un hashmap
    //no importa, basta con poner las claves en un arrayList y esas ya se les puede cambiar el índice
    //guardar las claves de un hashmap en un arraylist
    public ArrayList repartirMazo() {
        ArrayList<String> cartas = new ArrayList<>();
        //como recorro un hashmap y agarro solo las claves
        for (String i : mazo.keySet()) {
            cartas.add(i);
        }

        return cartas;
    }

    public ArrayList<String> mezclarMazo() {
        ArrayList<String> cartas = repartirMazo();

        Random random = new Random();
        for (int i = cartas.size() - 1; i > 0; i--) {
            // Elegir un índice aleatorio entre 0 y i (inclusive)
            int j = random.nextInt(i + 1);

            // Intercambiar list[i] con list[j] usando Collections.swap
            Collections.swap(cartas, i, j);
        }
        return cartas;
    }
    //puedo regresar dos arrays en un metodo
    public List<ArrayList<String>> partirMazo(){
        ArrayList<String> cartas = mezclarMazo();
        ArrayList<String> mazo1 = new ArrayList<>();
        ArrayList<String> mazo2 = new ArrayList<>();

        //pues se me ocurren dos for loops
        for (int i = 0; i < cartas.size()/2; i++) {
            mazo1.add(cartas.get(i));
        }

        for (int i = cartas.size()/2; i < cartas.size(); i++) {
            mazo2.add(cartas.get(i));
        }
        // Retornar ambos mazos en una lista
        List<ArrayList<String>> mazosDivididos = new ArrayList<>();
        mazosDivididos.add(mazo1);
        mazosDivididos.add(mazo2);

        return mazosDivididos;

    }

    //
    //como hago para sacar la primer carta de cada mazo y compararlas?
    //como accedo al primer elemento de un array y lo quito de un array
    //una funcion que quite la carta del array
    //lo que no se es si conviene pegarla o hacer que se le meta otra en caso de que gane



}
