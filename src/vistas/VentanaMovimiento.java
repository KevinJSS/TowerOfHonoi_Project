package vistas;

/**
 * La VentanaMovimiento es la ventana que se muestra al realizar un movimiento
 * en el juego. Se obtiene la torre de origen, y la torre de destino hacia la
 * cual se mueve un disco.
 * 
 * @author Kevin Alvarado.
 * @author Alina Rodriguez.
 */
public class VentanaMovimiento extends javax.swing.JDialog {
    
    private int torreOrigen;
    private int torreDestino;
    
    /**
     * El constructor que crea a la ventana donde corresponde,
     * y la posiciona en el medio de la pantalla.
     */
    public VentanaMovimiento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }
    
    /**
     * Método que devuelve la torre de origen que se obtiene en la ventana
     * 
     * @return el valor de la torre de origen
     */
    public int getTorreOrigen() {
        return torreOrigen;
    }
    
    /**
     * Método que devuelve la torre de destino que se obtiene en la ventana
     * 
     * @return el valor de la torre de destino 
     */
    public int getTorreDestino() {
        return torreDestino;
    }

    /**
     * Método llamado en el constructor para inicializar la ventana, generado
     * por el Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbTorreOrigen = new javax.swing.JComboBox<>();
        cbTorreDestino = new javax.swing.JComboBox<>();
        lbTorreOrigen = new javax.swing.JLabel();
        lbTorreDestino = new javax.swing.JLabel();
        btAceptar = new javax.swing.JButton();
        lbTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ventana de movimiento");

        cbTorreOrigen.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbTorreOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        cbTorreDestino.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbTorreDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        lbTorreOrigen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTorreOrigen.setText("Torre origen: ");

        lbTorreDestino.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTorreDestino.setText(":Torre destino");

        btAceptar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btAceptar.setText("Aceptar");
        btAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptarActionPerformed(evt);
            }
        });

        lbTitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTitle.setText("Para realizar un movimiento ingrese los datos solicitados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 54, Short.MAX_VALUE)
                .addComponent(lbTitle)
                .addGap(50, 50, 50))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(lbTorreOrigen)
                        .addGap(18, 18, 18)
                        .addComponent(cbTorreOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(cbTorreDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbTorreDestino))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(btAceptar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(lbTitle)
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTorreOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTorreDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTorreOrigen)
                    .addComponent(lbTorreDestino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(btAceptar)
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método de reacción al presionar el botón de aceptar. Almacena la torre de
     * origen y destino ingresadas por el ususario y esconde la ventana.
     * 
     * @param evt el evento de presionar el botón btAceptar
     */
    private void btAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptarActionPerformed
        torreOrigen = Integer.parseInt((String) cbTorreOrigen.getSelectedItem());
        torreDestino = Integer.parseInt((String) cbTorreDestino.getSelectedItem());
        setVisible(false);
    }//GEN-LAST:event_btAceptarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAceptar;
    private javax.swing.JComboBox<String> cbTorreDestino;
    private javax.swing.JComboBox<String> cbTorreOrigen;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbTorreDestino;
    private javax.swing.JLabel lbTorreOrigen;
    // End of variables declaration//GEN-END:variables
}
