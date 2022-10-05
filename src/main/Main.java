package main;

import vistas.VentanaInicio;

/**
 * La clase Main, corresponde a una simple clase que almacena o contiene el
 * metodo main que se encarga de ejecutar la acciones establecidas. En este caso
 * establecer nuestra ventana de inicio visible.
 *
 * @author Kevin Alvarado.
 * @author Alina Rodriguez.
 */
public class Main {
    
    /**
     * El método main se encarga de hacer la ventana de inicio visible, 
     * permitiéndo al programa iniciar.
     *
     * @param args son los argumentos de línea de
     * comandos como un arreglo de String
     */
    public static void main(String[] args) {
        new VentanaInicio().setVisible(true);
    }
}
