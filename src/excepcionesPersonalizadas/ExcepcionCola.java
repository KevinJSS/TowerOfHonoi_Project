package excepcionesPersonalizadas;

/**
 * La clase ExcepcionCola se encarga de lanzar mensakes excepción a través de
 * los comportamientos brindados (contructor(String)) por su herencia con
 * Excepción.
 *
 * @author Kevin Alvarado.
 * @author Alina Rodriguez.
 */
public class ExcepcionCola extends Exception {

    /**
     * Corresponde al constructor de la clase ExcepcionCola, la cual extiende o
     * hereda Exception, por lo tanto, recibe un mensaje de excepción para ser
     * enviado a la clase padre y que este ejecute la acción necesaria.
     *
     * @param mensaje mensaje de error (excepción) que se quiere ser lanzado.
     */
    public ExcepcionCola(String mensaje) {
        super(mensaje);
    }
}
