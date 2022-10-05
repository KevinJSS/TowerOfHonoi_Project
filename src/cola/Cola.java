package cola;

import excepcionesPersonalizadas.ExcepcionCola;

/**
 * La clase Cola, corresponde representa a la lista de movimientos, dentro del
 * contexto del juego Torres de Hanoi, donde los movimientos realizados son
 * almacenados en una estructura de datos como este caso. Esta clase posee un
 * elemento frontal y trasero ambos objetos de la clase Nodo, además de un valor
 * entero que representa el tamaño de la cola en cuanto a la cantidad de nodos
 * (movimientos) almacenados.
 *
 * @author Kevin Alvarado.
 * @author Alina Rodriguez.
 */
public class Cola {

    private Nodo frontal;
    private Nodo trasero;
    private int tamaño;

    /**
     * getTamaño() es un método común que se encarga de indicar el tamaño o el
     * número de nodos (movimientos) que contiene la cola.
     *
     * @return el contador (tamaño) con la cantidad específica de nodos
     * (movimientos) que contiene.
     */
    public int getTamaño() {
        return tamaño;
    }

    /**
     * encolar(Movimiento) es uno de los métodos más importantes de la Cola, el
     * cual se encarga de introducir los nuevos nodos (movimientos realizados)
     * detrás del nodo (movimiento) anterior. Para ello valida si la cola
     * contiene elementos (nodos/movimientos) al frente, de no contener lo
     * establece como el primero, para luego continuar colocando elementos por
     * la parte trasera de la Cola.
     *
     * @param movimiento hace referencia al movimiento realizado y que se
     * requiere almacenar.
     * @return el movimiento almacenado.
     */
    public Movimiento encolar(Movimiento movimiento) {
        Nodo temp = new Nodo(movimiento);
        if (frontal == null) {
            frontal = trasero = temp;
        } else {
            trasero.setSiguiente(temp);
            trasero = temp;
        }
        tamaño++;
        return movimiento;
    }

    /**
     * desencolar() es el método que cumple la función contraria a encolar(), de
     * ahí la importancia del mismo. Este método se encuentra a cargo de la
     * extracción de elementos (movimientos) que se encuentra al frente de la
     * cola (frontal).
     *
     * @return el elemento (movimiento) recien removido de la cola.
     * @throws ExcepcionCola en caso de haber elementos por desencolar, se lanza
     * un mensaje indicando que la cola se encuentra vacía.
     */
    public Movimiento desencolar() throws ExcepcionCola {
        if (frontal == null) {
            throw new ExcepcionCola("Cola vac\u00EDa");
        }
        Movimiento Movimiento = frontal.getMovimiento();
        if (frontal == trasero) {
            frontal = trasero = null;
        } else {
            frontal = frontal.getSiguiente();
        }
        tamaño--;
        return Movimiento;
    }

    /**
     * estaVacia() es un método sencillo utilizado para preguntar si la cola se
     * encuentra vacía en el momento de su llamado.
     *
     * @return un true en el caso de que la cola sí se encuentre vacía, de lo
     * contrario retornará un false.
     */
    public boolean estaVacia() {
        return tamaño == 0;
    }

    /**
     * La función del método getCima() es darnos de vuelta el movimiento que se
     * encuentra primero en la cola.
     *
     * @return el movimiento realizado (valor del elemento frontal)
     * @throws ExcepcionCola lanza un mensaje que indique que la cola se
     * encuentra vacía, por lo tanto, no podrá retornar ningún valor.
     */
    public Movimiento getFrontal() throws ExcepcionCola {
        if (frontal == null) {
            throw new ExcepcionCola("Cola vac\u00EDa");
        }
        return frontal.getMovimiento();
    }
}
