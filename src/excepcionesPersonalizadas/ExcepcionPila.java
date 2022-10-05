package excepcionesPersonalizadas;

/**
 * La clase ExcepciónPila se encarga de lanzar mensajes excepción a través
 * de los comportamientos brindados por su herencia con Exception.
 * 
 * @author Kevin Alvarado.
 * @author Alina Rodriguez.
 */

public class ExcepcionPila extends Exception {

    /**
     * Corresponde al constructor de la clase ExcepcionPila, la cual extiende o
     * hereda Exception, por lo tanto, recibe un mensaje de excepción para ser
     * enviado a la clase padre y que este ejecute la acción necesaria.
     *
     * @param mensaje mensaje de error (excepción) que se quiere ser lanzado.
     */
    public ExcepcionPila(String mensaje) {
        super(mensaje);
    }
}
