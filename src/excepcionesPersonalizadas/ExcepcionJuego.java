package excepcionesPersonalizadas;

/**
 * La clase ExcepciónJuego se encarga de lanzar mensajes excepción a través de
 * los comportamientos brindados por su herencia con Exception.
 *
 * @author Kevin Alvarado.
 * @author Alina Rodriguez.
 */
public class ExcepcionJuego extends Exception {

    /**
     * Corresponde al constructor de la clase ExcepcionJuego, la cual hereda de
     * Exception, por lo cual recibe un mensaje de excepción para ser enviado a
     * la clase padre y que el ejecute la acción necesaria.
     *
     * @param mensaje mensaje de error (excepción) que se quiere sea lanzado.
     */
    public ExcepcionJuego(String mensaje) {
        super(mensaje);
    }
}
