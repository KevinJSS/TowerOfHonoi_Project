package pila;

import excepcionesPersonalizadas.ExcepcionPila;

/**
 * La clase Pila, corresponde o representa a una sola torre, dentro del contexto
 * del juego "Torres de hanoi". Por lo tanto, esta se encarga de almacenar los
 * discos con sus respectivos tamaños (de valor entero). Además de la instancia
 * "cima" que representa al disco o elemento que se encuentra en la superficie
 * de la torre como parte del funcionamiento característico de una pila.
 * También, contiene una variable que se encarga de llevar el conteo de la
 * cantidad de discos que una torre (pila) contiene, y otra variable constante
 * que representa el tamaño maximo de la pila.
 *
 * @author Kevin Alvarado.
 * @author Alina Rodriguez.
 */
public class Pila {

    private Nodo cima;
    private int tamaño;
    private final int tamañoPorDefecto = 10;

    /**
     * El método getTamaño() indica el tamaño o número de nodos (discos) que
     * contiene la pila (torre).
     *
     * @return el contador (tamaño) con la cantidad específica de nodos (discos)
     * que contiene.
     */
    public int getTamaño() {
        return tamaño;
    }

    /**
     * estaVacia() es un método sencillo para preguntar si la pila se encuentra
     * vacia en el momento de su llamado.
     *
     * @return un true en caso de que la pila este vacia, por lo contrario,
     * retornará un false.
     */
    public boolean estaVacia() {
        return tamaño == 0;
    }

    /**
     * La función del método getCima() es darnos de vuelta el valor del elemento
     * que se encuentra en el tope o superficie de la pila.
     *
     * @return el tamaño del disco (valor de elemento cima).
     * @throws ExcepcionPila lanza un mensaje que nos avisa que la pila se
     * encuentra vacía, por lo tanto, no podrá devolver ningun valor.
     */
    public int getCima() throws ExcepcionPila {
        if (estaVacia()) {
            throw new ExcepcionPila("Pila vac\u00EDa");
        }
        return cima.getTamañoDisco();
    }

    /**
     * apilar(int) es uno de los métodos más importantes de la pila, el cual se
     * encarga de introducir nuevos nodos (discos) en la cima o superficie de la
     * pila (torre). Para ello realiza una validación de si la pila contiene
     * elementos en la cima, de no contener establece ese elemento (nodo/disco)
     * como el primero, para luego colocar los siguientes sobre este.
     *
     * @param tamañoDisco indica el valor entero (tamaño) que almacenará el
     * nuevo nodo (disco).
     * @return el valor entero que almacenó ese nuevo nodo (tamaño del disco).
     * @throws ExcepcionPila lanza un mensaje con el fin avisar que la pila
     * (torre) ya se encuentra llena.
     */
    public int apilar(int tamañoDisco) throws ExcepcionPila {
        if (tamaño == tamañoPorDefecto) {
            throw new ExcepcionPila("Pila llena");
        }
        Nodo temp = new Nodo(tamañoDisco);
        if (cima != null) {
            temp.setSiguiente(cima);
        }
        cima = temp;
        tamaño++;
        return tamañoDisco;
    }

    /**
     * Desapilar() es un método que cumple la función contraria al método
     * apilar, de ahí su importancia. Este se encuentra a cargo de la extraer el
     * elemento (nodo/disco) que se encuentra en la parte superior de la pila
     * (cima).
     *
     * @return el elemento desapliado o removido de la parte superior de la
     * pila, o el anterior elemento "cima".
     * @throws ExcepcionPila en caso de no haber elemento por desapilar, es
     * decir, que la pila se encuentra vacia. Será lanzado un mensaje que lo
     * indique.
     */
    public int desapilar() throws ExcepcionPila {
        if (estaVacia()) {
            throw new ExcepcionPila("Pila vac\u00EDa");
        }
        int temp = cima.getTamañoDisco();
        cima = cima.getSiguiente();
        tamaño--;
        return temp;
    }
}
