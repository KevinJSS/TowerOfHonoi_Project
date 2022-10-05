package pila;

/**
 * La clase Nodo, corresponde a un elemento que forma parte del funcionamiento
 * principal de las listas enlazadas, en este caso del tipo Pila. La clase Nodo
 * dentro del contexto de las Torres de Hanoi, representa a solo disco en la
 * torre (pila), además contiene un valor entero (int) que representará al
 * tamaño del disco. Como también una instancia que hace referencia al si-
 * guiente disco (Nodo) de la pila.
 *
 * @author Kevin Alvarado.
 * @author Alina Rodriguez.
 */
public class Nodo {

    private int tamañoDisco;
    private Nodo siguiente;

    /**
     * Corresponde al constructor de la clase Nodo (de Pila), que directamente
     * recibe un valor entero que indica el tamaño del disco que será
     * almacenado.
     *
     * @param tamañoDisco valor entero que representa el tamaño del disco.
     */
    public Nodo(int tamañoDisco) {
        this.tamañoDisco = tamañoDisco;
    }

    /**
     * getTamañoDisco() es un método común que se encarga de devolver el valor
     * entero almacenado dentro del nodo (disco). Es decir, el tamaño del disco.
     *
     * @return valor entero que representa el tamaño del disco.
     */
    public int getTamañoDisco() {
        return tamañoDisco;
    }

    /**
     * setSiguiente() es un método común que nos devulve el nodo siguiente
     * (siguiente disco) al que se encuentra apuntado nuestro puntero.
     *
     * @return el nodo siguiente (siguiente disco) que puede ser un valor nulo
     * ya que no se encuentra apuntado a nadie, o la dirección de memoria del
     * nodo al que se le apunta.
     */
    public Nodo getSiguiente() {
        return siguiente;
    }

    /**
     * setTamañoDisco() tiene acargo el asignarle o fijar un valor entero a la
     * variable tamañoDisco.
     *
     * @param tamañoDisco el valor brindado para ser asignado a la variable
     * tamañoDisco.
     */
    public void setTamañoDisco(int tamañoDisco) {
        this.tamañoDisco = tamañoDisco;
    }

    /**
     * Consiste en un método común, que le asigna una referencia al puntero nodo
     * que tenemos en la clase.
     *
     * @param siguiente la referencia o dirección de memoria brindada al nodo
     * que se quiere apuntar.
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
