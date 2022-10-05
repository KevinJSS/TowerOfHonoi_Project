package vistas;

import cola.Movimiento;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 * La VentanaListaMovimientos muestra la lista de movimientos que genera el
 * programa al mostrar la solución, además de los movimientos mínimos
 * necesarios para realizar tal solución.
 * 
 * @author Kevin Alvarado.
 * @author Alina Rodriguez.
 */
public class VentanaListaMovimientos extends javax.swing.JDialog {

    private DefaultListModel lista;
    
    /**
     * El constructor que crea a la ventana donde corresponde, la posiciona en
     * el medio de la pantalla, inicializa la lista de movimientos, y carga
     * estos movimientos al JList, y los movimientos mínimos al JLabel, 
     * los cuales se muestran al usuario.
     */
    public VentanaListaMovimientos(java.awt.Frame parent, boolean modal, ArrayList<Integer[]> listaMovimientos, int minimoMovimientos) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        lista = new DefaultListModel();
        cargarListaMovimientos(listaMovimientos);
        cargarMinimoMovimientos(minimoMovimientos);
    }
    
    /**
     * Método que carga la lista de movimientos al JList ltListaMovimientos. 
     * Lo hace mediante el uso de un ciclo que obtiene las posiciones de origen 
     * y destino del movimiento de un ArrayList con vectores de enteros, y crea
     * ese movimiento para agregarlo a la lista, y al terminar carga esa lista
     * al JList.
     * @param listaMovimientos es el ArrayList con vectores de enteros, que son 
     * las posiciones de origen y destino del movimiento.
     */
    private void cargarListaMovimientos(ArrayList<Integer[]> listaMovimientos) {
        Integer[] temp;
        for (int i = 0; i < listaMovimientos.size(); i++) {
            temp = listaMovimientos.get(i);
            lista.addElement((i + 1) + ": " + new Movimiento(temp[0], temp[1]));
        }
        ltListaMovimientos.setModel(lista);
    }
    
    /**
     * Método para cargar el mensaje y los movimientos mínimos en sí al 
     * JLabel lbMovimientosMinimos.
     * @param minimoMovimientos los movimientos mínimos necesarios para
     * resolver el juego de las torres
     */
    public void cargarMinimoMovimientos(int minimoMovimientos) {
        lbMovimientosMinimos.setText("Movimientos m\u00EDnimos necesarios: " + minimoMovimientos);
    }

    /**
     * Método llamado en el constructor para inicializar la ventana, generado
     * por el Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lbMovimientosMinimos = new javax.swing.JLabel();
        btCerrar = new javax.swing.JButton();
        lbTitulo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ltListaMovimientos = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de movimientos generados");

        lbMovimientosMinimos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbMovimientosMinimos.setText("Movimientos mínimos necesarios:");

        btCerrar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btCerrar.setText("Cerrar");
        btCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarActionPerformed(evt);
            }
        });

        lbTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTitulo.setText("Lista de movimientos generados");

        jScrollPane2.setViewportView(ltListaMovimientos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbMovimientosMinimos, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(lbTitulo))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(btCerrar)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lbTitulo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lbMovimientosMinimos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btCerrar)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que cierra la ventana al presionar el botón de cerrar en la misma
     * @param evt el evento de presionar el botón btCerrar.
     */
    private void btCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btCerrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCerrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbMovimientosMinimos;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JList<String> ltListaMovimientos;
    // End of variables declaration//GEN-END:variables
}
