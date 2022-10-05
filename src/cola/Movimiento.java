package cola;

/**
 * La clase Movimiento, corresponde a la representación dentro del sistema, a un
 * movimiento realizado por el usuario. El cual se compone de dos valores
 * enteros fijos (final), uno que indica la torre desde donde se comienza el
 * movimiento (TorreOrigen) y el otro representa la torre en donde concluye este
 * mismo movimiento (TorreDestino). Todo esto, dentro del contexto del juego de
 * las Torres de Hanoi.
 *
 * @author Kevin Alvarado.
 * @author Alina Rodriguez.
 */
public class Movimiento {

    private final int torreOrigen;
    private final int torreDestino;

    /**
     * Constructor de la clase Movimiento, que recibe la torre desde donde se
     * originó el movimiento, y la torre donde el mismo concluye para
     * almacenarlos en las variables de valor entero.
     *
     * @param torreOrigen representa el origen del movimiento.
     * @param torreDestino representa el lugar donde concluye el movimiento.
     */
    public Movimiento(int torreOrigen, int torreDestino) {
        this.torreOrigen = torreOrigen;
        this.torreDestino = torreDestino;
    }

    /**
     * Corresponde a un método común que se encarga de devolver la torre de
     * origen del movimiento.
     *
     * @return torreOrigen.
     */
    public int getTorreOrigen() {
        return torreOrigen;
    }

    /**
     * Corresponde a un método común que se encarga de devolver la torre de
     * destino del movimiento.
     *
     * @return torreDestino.
     */
    public int getTorreDestino() {
        return torreDestino;
    }

    /**
     * Método común sobreescrito para dar formato a los datos contenidos en la
     * clase.
     *
     * @return información del movimiento realizado.
     */
    @Override
    public String toString() {
        return "Se movi\u00F3 un disco de la torre " + torreOrigen + " a la torre " + torreDestino;
    }
}
