package vistas;

import cola.Cola;
import cola.Movimiento;
import excepcionesPersonalizadas.ExcepcionCola;
import excepcionesPersonalizadas.ExcepcionJuego;
import excepcionesPersonalizadas.ExcepcionPila;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import pila.Pila;

/**
 * La ventana de juego es la principal del programa, contiene botones para
 * realizar distintas acciones necesarias para jugar, además de la
 * representación gráfica y lógica de juego.
 *
 * @author Kevin Alvarado.
 * @author Alina Rodriguez.
 */
public class VentanaDeJuego extends javax.swing.JDialog {

    private final javax.swing.JPanel[] paneles = new javax.swing.JPanel[3];
    private ArrayList<Integer[]> listaMovimientosGenerados;
    private final Pila[] torres = new Pila[3];
    private Cola colaMovimientos;
    private int cantidadDiscos = 5;
    private Simulacion simulacion;
    private boolean enJuego;
    private boolean mostrandoSimulacion;

    /**
     * El constructor que crea a la ventana y la posiciona en el medio de la
     * pantalla.Además, carga los paneles a un vector y rellena los paneles con
     * un formato inicial.
     *
     * @param parent
     * @param modal
     */
    public VentanaDeJuego(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        pnTorre1.setLayout(new GridLayout(10, 1));
        pnTorre2.setLayout(new GridLayout(10, 1));
        pnTorre3.setLayout(new GridLayout(10, 1));
        cargarPaneles();
        formatoInicialPaneles();
    }

    /**
     * IniciarJuego() es un metodo sencillo que se encarga de establecer los
     * datos iniciales para que el juego comience: inicializa los objetos que
     * pueden almacenar algun dato de la partida anterior, inicia el juego y se
     * asegura que la interfaz este en optimas condiciones para iniciar.
     */
    private void iniciarJuego() {
        listaMovimientosGenerados = new ArrayList<>();
        colaMovimientos = new Cola();
        enJuego = true;
        limpiarInterfaz();
        rellernarTorres();
        actualizarInterfaz();
        interrumpirSimulacion();
    }

    /**
     * actualizarInterfaz() corresponde a uno de los métodos más importantes de
     * la clase y del juego. Tiene acargo la función de actualizar la interfaz
     * (paneles / torres gráficas) de acuerdo al estado de las torres internas
     * (pilas), realizando un recorrido y evaluación para determinar cuándo es
     * necesario actualizar las torres gráficas con nuevos elementos (discos).
     * Una vez determine que se requiere actualizar una torre, se encargará de
     * hacer un desencole temporal para cargar los nuevos elementos al panel, en
     * un formato específico (elemento, fuente, tamaño, color, cuadricula). Para
     * al final devolver los datos extraidos (desencolados) temporalmente al su
     * sitio de origen.
     */
    private void actualizarInterfaz() {
        Pila pilaTemp;
        javax.swing.JLabel temp;
        //Para todas las torres
        for (int i = 0; i < torres.length; i++) {
            if (!torres[i].estaVacia()) {
                limpiarPanel(paneles[i]);
            }
            pilaTemp = new Pila();
            temp = null;
            //Cargando valores a los paneles
            for (int j = 0; j < 10; j++) {
                try {
                    if (!torres[i].estaVacia()) {
                        if (j >= 10 - torres[i].getTamaño()) {
                            pilaTemp.apilar(torres[i].desapilar());
                            temp = new JLabel("   " + pilaTemp.getCima() + "   ");
                        } else {
                            temp = new JLabel("      ");
                        }
                        //Estableciendo estilos
                        temp.setFont(new java.awt.Font("Tahoma", 0, 20));
                        temp.setForeground(Color.BLACK);
                        temp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(20)));
                        temp.setSize(800, 800);
                        paneles[i].add(temp); //elemento agregado
                    } else {
                        rellenarVacio(paneles[i]);
                    }
                } catch (ExcepcionPila ex) {
                }
            }
            //Devolviendo datos a la pila original
            while (!pilaTemp.estaVacia()) {
                try {
                    torres[i].apilar(pilaTemp.desapilar());
                } catch (ExcepcionPila ex) {
                }
            }
        }
    }

    /**
     * Este metodo esta encargado de rellenar los paneles en su formato incial;
     * con espacios vacios.
     */
    private void formatoInicialPaneles() {
        for (int i = 0; i < paneles.length; i++) {
            rellenarVacio(paneles[i]);
        }
    }

    /**
     * rellenarVacio() se encarga de recibir por parametro un panel el cual será
     * rellenado con espacios vacios, aplicando un formato especifico (fuente,
     * tamaño, formato cuadricula) y lo agrega al panel.
     */
    private void rellenarVacio(javax.swing.JPanel panel) {
        javax.swing.JLabel temp;
        limpiarPanel(panel);

        for (int j = 0; j < 10; j++) {
            temp = new JLabel("        ");
            temp.setFont(new java.awt.Font("Tahoma", 0, 20));
            temp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(70, 70, 70)));
            temp.setSize(800, 800);
            panel.add(temp);
        }
    }

    /**
     * LimpiarPanel(), este método tiene la función de limpiar el panel
     * utilizando los metodos de JPanel: removeAll() y updateUI().
     */
    private void limpiarPanel(javax.swing.JPanel panel) {
        panel.removeAll();
        panel.updateUI();
    }

    /**
     * CargarPaneles() tiene con función única el cargar los tres JPaneles que
     * se utiliza en la interfaz, dentro de un vector, para el un mejor manejo
     * de estos.
     */
    private void cargarPaneles() {
        paneles[0] = pnTorre1;
        paneles[1] = pnTorre2;
        paneles[2] = pnTorre3;
    }

    /**
     * Método que rellena las torres al iniciar el juego. Incializa las tres
     * torres y carga el número de discos estipulados por el usuario en la
     * primera torre.
     */
    private void rellernarTorres() {
        for (int i = 0; i < torres.length; i++) {
            torres[i] = new Pila();
        }
        //Rellenando la torre 1
        int temp = 0;
        while (temp < cantidadDiscos) {
            try {
                torres[0].apilar(cantidadDiscos - (temp++));

            } catch (ExcepcionPila ex) {
                System.out.println("EXCEPTION");
            }
        }
    }

    /**
     * limpiarInterfaz() es el metodo que establece los campos donde
     * anteriormente pudo haber quedado texto, en su forma inicial (vacios).
     */
    private void limpiarInterfaz() {
        taMovimientoAnterior.setText("");
    }

    /**
     * Corresponde a un método sencillo que se encarga de interrumpir al hilo de
     * la simulación si se inicia un nuevo juego, haciendo uso del método de la
     * clase Thread: "interrupt()".
     */
    private void interrumpirSimulacion() {
        if (simulacion != null) {
            simulacion.interrupt();
        }
    }

    /**
     * moverDisco(int, int) es un método que tiene gran relevancia en el
     * contexto del juego. Este se encarga de mover un disco de la torre de
     * origen y destino específicadas por el usuario. Primero verificando que el
     * movimiento realizado sea válido y que cumpla con las reglas del juego,
     * luego mueve el disco de la torre origen a la torre destino, y finalmente
     * actualiza la interfaz para mostrar el movimiento realizado y lo encola a
     * la lista de movimientos. Y al final pregunta si el juego ha terminado.
     * Nota: En el caso de que se esté mostrando la solución, el algoritmo no
     * guardará los movimientos realizados por la computadora.
     *
     * @param torreOrigen torre desde donde se toma el disco.
     * @param torreDestino torre en la que se quiere colocar el disco extraido.
     */
    private void moverDisco(int torreOrigen, int torreDestino) throws ExcepcionJuego {
        torreOrigen = torreOrigen - 1;
        torreDestino = torreDestino - 1;

        try {
            //Validando movimiento
            validarMovimiento(torreOrigen, torreDestino);

            //Realizando y almacenando movimiento valido
            torres[torreDestino].apilar(torres[torreOrigen].desapilar());
            actualizarInterfaz();
            imprimirMovimiento(torreOrigen, torreDestino);
            if (!mostrandoSimulacion) {
                guardarMovimiento(torreOrigen, torreDestino);
            }

            //Evaluando si ya finalizó el juego
            if (juegoTerminado() && !mostrandoSimulacion) {
                imprimirDatosFinales();
                enJuego = false;
            } else if (juegoTerminado() && mostrandoSimulacion) {
                enJuego = false;
            }
        } catch (ExcepcionPila ex) {
        }
    }

    /**
     * validarMovimiento() es un metodo encargado de las excepciones/reglas de
     * los movimientos se encarga de determinar si el movimiento cumple o no lo
     * estipulado. En caso de que no lo haga generará una excepción con la regla
     * violentada.
     *
     * @param torreOrigen torre desde donde se toma el disco.
     * @param torreDestino torre en la que se quiere colocar el disco extraido.
     * @throws ExcepcionJuego excepción de una regla del juego.
     * @throws ExcepcionPila problema generado desde la clase Pila.
     */
    private void validarMovimiento(int torreOrigen, int torreDestino) throws ExcepcionJuego, ExcepcionPila {
        if (torreOrigen == torreDestino) {
            throw new ExcepcionJuego("La torre de origen y la torre de destino no pueden ser la misma, intente nuevamente");
        }
        if (torres[torreOrigen].estaVacia()) {
            throw new ExcepcionJuego("No seleccionar una torre de origen vac\u00EDa para realizar un movimiento, intente nuevamente");
        }
        if (!torres[torreDestino].estaVacia() && torres[torreDestino].getCima() < torres[torreOrigen].getCima()) {
            throw new ExcepcionJuego("Movimiento inv\u00E1lido, no puede colocar un disco grande sobre uno m\u00E1s peque\u00F1o");
        }
    }

    /**
     * guardarMovimiento() se encarga de cargar el movimiento realizado a la
     * cola de movimientos.
     *
     * @param torreOrigen torre desde donde se toma el disco.
     * @param torreDestino torre en la que se quiere colocar el disco extraido.
     */
    private void guardarMovimiento(int torreOrigen, int torreDestino) {
        colaMovimientos.encolar(new Movimiento(torreOrigen + 1, torreDestino + 1));
    }

    /**
     * imprimirMovimiento() cumple la función de cargar el toString() del
     * movimiento realizado, a la interfaz del videojuego.
     *
     * @param torreOrigen torre desde donde se toma el disco.
     * @param torreDestino torre en la que se quiere colocar el disco extraido.
     */
    private void imprimirMovimiento(int torreOrigen, int torreDestino) {
        taMovimientoAnterior.setText(new Movimiento(torreOrigen + 1, torreDestino + 1).toString());
    }

    /**
     * juegoTerminado() es un método sencillo que indica si el juego ha
     * terminado.
     *
     * @return true si el juego terminó, de lo contrario false.
     */
    private boolean juegoTerminado() {
        return torres[2].getTamaño() == cantidadDiscos;
    }

    /**
     * imprimirDatosFinales() se encarga de mostrar los mensajes correspodientes
     * posteriores a que el usuario haya resuelto el puzzle.
     */
    private void imprimirDatosFinales() {
        //Mensaje de felicitación
        JOptionPane.showMessageDialog(null, "\u00A1Felicitaciones! Has completado el reto de las Torres de Hanoi"
                + "\nPresiona \"Aceptar\" para ver los datos de la partida");
        //Datos de la partida
        taMovimientoAnterior.setText("DATOS DE LA PARTIDA:"
                + "\n- Cantidad de movimientos realizados: " + colaMovimientos.getTamaño()
                + "\n- M\u00EDnimo de movimientos necesarios: " + calcularMovimientosMinimos()
                + "\n\nLista de movimientos realizados:\n" + obtenerListaMovimientos());
    }

    /**
     * calcularMovimientosMinimos() se encarga de ejecutar una formula
     * matemática para calcular el minimo de movimientos necesarios para
     * resolver el puzzle, segun la cantidad de discos que se hayan específicado
     * por el usuario.
     *
     * @return cantidad de movimientos minimos para resolver el puzzle.
     */
    private int calcularMovimientosMinimos() {
        return (int) (Math.pow(2, cantidadDiscos) - 1);
    }

    /**
     * obtenerListaMovimientos(), método cuya función es devolver la lista de
     * movimientos realizados durante el juego luego de haberlo completado. Esta
     * recurre a la cola de movimientos que tenemos en la clase, utilizando el
     * método desencolar obtiene los movimientos en el orden realizados.
     *
     * @return String cargada con los movimientos realizados en ese orden.
     */
    private String obtenerListaMovimientos() {
        String lista = "";
        for (int i = 1; !colaMovimientos.estaVacia(); i++) {
            try {
                lista += i + ": " + colaMovimientos.desencolar() + "\n";
            } catch (ExcepcionCola ex) {
            }
        }
        return lista;
    }

    /**
     * solicitarCantidadDiscos() se encarga de solicitarle al usuario la
     * cantidad de discos que quiere (entre 3 y 10) para el juego. En caso de no
     * estar en el rango estipulado se generará una excepción.
     *
     * @return la cantidad de discos que el usuario quiere para el juego.
     * @throws ExcepcionJuego mensaje indicando que no respeto los límites del
     * rango.
     */
    private int solicitarCantidadDiscos() throws ExcepcionJuego {
        int temp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de discos (De 3 a 10 discos)"));
        if (temp < 3 || temp > 10) {
            throw new ExcepcionJuego("La cantidad de discos no puede ser menor que 3 o mayor que 10, intente nuevamente");
        }
        return temp;
    }

    /**
     * obtenerListaSolucion() corresponde al método que me devuelve la lista de
     * movimientos generados por el llamado al método recursivo
     * "generarListaSolución()".
     *
     * @return lista de movimientos generados recursivamente.
     */
    private ArrayList<Integer[]> obtenerListaSolucion() {
        generarListaSolucion(cantidadDiscos, 1, 3, 2); //Metodo recursivo
        cargarListaSolucion(); //Carga la cola con los movimientos generados
        return listaMovimientosGenerados;
    }

    /**
     * generarListaSolucion() metodo RECURSIVO cuya función es generar un lista
     * de movimientos (paso a paso) para resolver el puzzle de manera
     * automática.
     *
     * @param numeroDiscos cantidad de discos del juego.
     * @param torreOrigen torre desde donde parte un disco.
     * @param torreDestino torre a donde llega el disco extraido.
     * @param torreAuxiliar torre en la que se apoya para llegar al destino.
     */
    private void generarListaSolucion(int numeroDiscos, int torreOrigen, int torreDestino, int torreAuxiliar) {
        if (numeroDiscos != 1) {
            generarListaSolucion(numeroDiscos - 1, torreOrigen, torreAuxiliar, torreDestino);
            listaMovimientosGenerados.add(new Integer[]{torreOrigen, torreDestino});
            generarListaSolucion(numeroDiscos - 1, torreAuxiliar, torreDestino, torreOrigen);
            return;
        }
        listaMovimientosGenerados.add(new Integer[]{torreOrigen, torreDestino});
    }

    /**
     * cargarListaSolución() este metodo es utilizado una vez que el metodo
     * recursivo haya generado la lista de movimientos en formato "ArrayList->
     * Integer[]". Por lo tanto, es necesario generar objetos de tipo
     * movimientos para cargarlos a la cola de movimientos realizados.
     */
    private void cargarListaSolucion() {
        for (Integer[] movimiento : listaMovimientosGenerados) {
            guardarMovimiento(movimiento[0] - 1, movimiento[1] - 1);
        }
    }

    /**
     * Simulacion corresponde a una clase que hereda del método Thread (Hilo),
     * la cual, como su nombre lo indica, se encarga de realizar una simulación
     * de los movimientos generados recursivamente por el sistema, interactuando
     * directamente con la interfaz grafica. De esta manera que el usuario
     * sea capaz de observar la solución del juego.
     */
    private class Simulacion extends Thread {

        /**
         * iniciarSimulación() es un método cuya función es desenconlar la cola
         * de movimientos para realizar, en ese orden, los movimientos generados
         * por la máquina. Para ejecutar un movimiento en la interfaz hace uso
         * del método moverDisco(), de esta misma clase.
         */
        private void iniciarSimulacion() {
            Movimiento temp;
            mostrandoSimulacion = true;
            for (int i = 1; !colaMovimientos.estaVacia(); i++) {
                try {
                    temp = colaMovimientos.desencolar();
                    moverDisco(temp.getTorreOrigen(), temp.getTorreDestino());
                    Thread.sleep(1300);
                } catch (ExcepcionCola | ExcepcionJuego | InterruptedException ex) {
                }
            }
            mostrandoSimulacion = false;
        }

        /**
         * run() es un método sobreescrito llamado por el start() del hilo. Este
         * unicamente ejecuata al método iniciarSimulación().
         */
        @Override
        public void run() {
            iniciarSimulacion();
        }
    }

    /**
     * Método de reacción al presionar el botón para iniciar el juego. Este pide
     * la cantidad de discos a usar en la partida y lanza las excepciones
     * apropiadas según el método solicitarCantidadDiscos(). Luego de eso inicia
     * el juego con el método iniciarJuego()
     *
     * @param evt el evento de presionar el botón btIniciarJuego
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        taMovimientoAnterior = new javax.swing.JTextArea();
        pnTorre1 = new javax.swing.JPanel();
        btIniciarJuego = new javax.swing.JButton();
        btMoverDisco = new javax.swing.JButton();
        btSolucion = new javax.swing.JButton();
        pnTorre2 = new javax.swing.JPanel();
        pnTorre3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ventana de juego");

        taMovimientoAnterior.setEditable(false);
        taMovimientoAnterior.setColumns(20);
        taMovimientoAnterior.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        taMovimientoAnterior.setRows(5);
        jScrollPane1.setViewportView(taMovimientoAnterior);

        pnTorre1.setBackground(new java.awt.Color(255, 255, 255));
        pnTorre1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout pnTorre1Layout = new javax.swing.GroupLayout(pnTorre1);
        pnTorre1.setLayout(pnTorre1Layout);
        pnTorre1Layout.setHorizontalGroup(
            pnTorre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );
        pnTorre1Layout.setVerticalGroup(
            pnTorre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        btIniciarJuego.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btIniciarJuego.setText("Iniciar juego");
        btIniciarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIniciarJuegoActionPerformed(evt);
            }
        });

        btMoverDisco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btMoverDisco.setText("Mover disco");
        btMoverDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMoverDiscoActionPerformed(evt);
            }
        });

        btSolucion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btSolucion.setText("Ver solución");
        btSolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSolucionActionPerformed(evt);
            }
        });

        pnTorre2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnTorre2Layout = new javax.swing.GroupLayout(pnTorre2);
        pnTorre2.setLayout(pnTorre2Layout);
        pnTorre2Layout.setHorizontalGroup(
            pnTorre2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        pnTorre2Layout.setVerticalGroup(
            pnTorre2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnTorre3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnTorre3Layout = new javax.swing.GroupLayout(pnTorre3);
        pnTorre3.setLayout(pnTorre3Layout);
        pnTorre3Layout.setHorizontalGroup(
            pnTorre3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        pnTorre3Layout.setVerticalGroup(
            pnTorre3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(pnTorre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(pnTorre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(pnTorre3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(167, 167, 167)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btIniciarJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btMoverDisco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btSolucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(23, Short.MAX_VALUE)
                        .addComponent(btIniciarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btMoverDisco, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(btSolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnTorre1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnTorre2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnTorre3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(48, 48, 48)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btIniciarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIniciarJuegoActionPerformed
        boolean esperar = true;
        while (esperar) {
            try {
                cantidadDiscos = solicitarCantidadDiscos();
                esperar = false;
            } catch (ExcepcionJuego ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        iniciarJuego();
    }//GEN-LAST:event_btIniciarJuegoActionPerformed

    /**
     * Método de reacción al presionar el botón para hacer un movimiento. Este
     * lanza las excepciones apropiadas si se intenta presionar antes de iniciar
     * un juego, o cuando hay una simulación de la solución en proceso. De no
     * ser así, crea y muestra la VentanaMovimiento, donde se pide la torre de
     * origen y destino. Luego, realiza el movimiento con el método moverDisco
     * de no haber una excepción, sino la atrapa, muestra el mensaje y se pide
     * que ingrese el movimiento de nuevo en VentanaMovimiento.
     *
     * @param evt el evento de presionar el botón btMoverDisco
     */
    private void btMoverDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMoverDiscoActionPerformed
        if (!enJuego) {
            JOptionPane.showMessageDialog(null, "Para realizar esta acci\u00F3n primero debes iniciar el juego");
        } else if (mostrandoSimulacion) {
            JOptionPane.showMessageDialog(null, "Debes esperar a que el programa termine de simular la soluci\u00F3n");
        } else {
            VentanaMovimiento movimiento = new VentanaMovimiento((Frame) this.getParent(), true);
            movimiento.setVisible(true);
            boolean esperar = true;

            while (esperar) {
                try {
                    moverDisco(movimiento.getTorreOrigen(), movimiento.getTorreDestino());
                    esperar = false;

                } catch (ExcepcionJuego ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    movimiento.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_btMoverDiscoActionPerformed

    /**
     * Método de reacción al presionar el botón para ver la solución. Este lanza
     * las excepciones apropiadas si se intenta presionar antes de iniciar un
     * juego, o cuando hay una simulación de la solución en proceso. De no ser
     * así se inicia el juego, inicializando la partida con la información
     * anterior. Luego crea y muestra la ventana VentanaListaMovimientos, con la
     * lista de movimientos de la solución, inicializa la simulación a realizar,
     * y la ejecuta.
     *
     * @param evt el evento de presionar el botón btSolucion
     */
    private void btSolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSolucionActionPerformed
        if (!enJuego) {
            JOptionPane.showMessageDialog(null, "Para realizar esta acci\u00F3n primero debes iniciar el juego");
        } else if (mostrandoSimulacion) {
            JOptionPane.showMessageDialog(null, "Debes esperar a que el programa termine de simular la soluci\u00F3n");
        } else {
            iniciarJuego();
            new VentanaListaMovimientos((Frame) this.getParent(), true, obtenerListaSolucion(), calcularMovimientosMinimos()).setVisible(true);
            simulacion = new Simulacion();
            simulacion.start();
        }
    }//GEN-LAST:event_btSolucionActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIniciarJuego;
    private javax.swing.JButton btMoverDisco;
    private javax.swing.JButton btSolucion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnTorre1;
    private javax.swing.JPanel pnTorre2;
    private javax.swing.JPanel pnTorre3;
    private javax.swing.JTextArea taMovimientoAnterior;
    // End of variables declaration//GEN-END:variables
}
