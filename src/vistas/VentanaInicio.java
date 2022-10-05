
package vistas;

/**
 * La ventana inicio da la bienvenida al usuario, es la primera que se muestra,
 * contiene el botón iniciar, que pasa a la ventana de juego.
 * 
 * @author Kevin Alvarado.
 * @author Alina Rodriguez.
 */
public class VentanaInicio extends javax.swing.JFrame {

    /**
     * El constructor que crea a la ventana y la
     * posiciona en el medio de la pantalla.
     */
    public VentanaInicio() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * Método llamado en el constructor para inicializar la ventana,
     * generado por el Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logo = new javax.swing.JLabel();
        estudiantes = new javax.swing.JLabel();
        btIniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana de inicio");
        setBackground(new java.awt.Color(204, 204, 204));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/intro.png"))); // NOI18N

        estudiantes.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 24)); // NOI18N
        estudiantes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        estudiantes.setText("Kevin Alvarado, Alina Rodríguez");

        btIniciar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btIniciar.setText("Ingresar");
        btIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(logo)
                .addGap(93, 93, 93))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(btIniciar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(estudiantes)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(estudiantes)
                .addGap(18, 18, 18)
                .addComponent(btIniciar)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que responde cuando el ususario presiona el botón iniciar, creando
     * y mostrando la vantana siguiente, la ventana de juego.
     * @param evt es el evento de presionar el botón iniciar
     */
    private void btIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIniciarActionPerformed
       VentanaDeJuego juego = new VentanaDeJuego(this, true);
       setVisible(false);
       juego.setVisible(true);
       dispose();
    }//GEN-LAST:event_btIniciarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIniciar;
    private javax.swing.JLabel estudiantes;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}
