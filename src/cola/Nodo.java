package cola;

/**
 * La clase Nodo, corresponde a un elemento que forma parte del funcionamiento
 * principal de las listas enlazadas, en este caso del tipo Cola. Esta clase,
 * dentro del contexto de las Torres de Hanoi, representa a un movimiento
 * realizado por el usuario. Además de contener un objeto movimiento, contiene
 * una instancia que hace referencia al siguiente nodo (movimiento) de la cola.
 *
 * @author Kevin Alvarado.
 * @author Alina Rodriguez.
 */
public class Nodo {

    private Movimiento movimiento;
    private Nodo siguiente;

    /**
     * Constructor de la clase Nodo (de Cola), el cual recibe un movimiento
     * realizado para directamente almacenarlo en el Nodo (Objeto movimiento).
     *
     * @param movimiento corresponde al objeto movimiento, que fue realizado y
     * por tanto se requiere de su almacenamiento.
     */
    public Nodo(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    /**
     * getMovimiento() es un método común que se encarga de devolver el objeto
     * "movimiento" almacenado.
     *
     * @return el puntero o la dirección de memoria del objeto "movimiento"
     * almacenado dentro del Nodo.
     */
    public Movimiento getMovimiento() {
        return movimiento;
    }

    /**
     * setSiguiente() es un método común que nos devulve el nodo siguiente al
     * que se encuentra apuntado nuestro nodo.
     *
     * @return el nodo siguiente (siguiente disco) que puede ser un valor nulo
     * ya que no se encuentra apuntado a nadie, o la dirección de memoria del
     * nodo al que se le apunta.
     */
    public Nodo getSiguiente() {
        return siguiente;
    }

    /**
     * setMovimiento() tiene acargo el asignarle o fijar un nuevo moviento al
     * objeto "movimiento" de esta clase Nodo.
     *
     * @param movimiento el nuevo movimiento que será asignado a nuestro objeto.
     */
    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    /**
     * Consiste en un método común que le asigna una referencia al puntero nodo
     * que tenemos en esta clase.
     *
     * @param siguiente la referencia o dirección de memoria brindada al nodo
     * que se quiere apuntar.
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
