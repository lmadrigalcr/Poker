package gui;

import java.util.List;
import javax.swing.JLabel;

public class VentanaJuego extends javax.swing.JFrame {

    public VentanaJuego()
    {
        initComponents();
        
        for (JLabel label : this.getCartasMesa())
        {
            label.setVisible(false);
        }
        for (JLabel label : this.getCartasJugador())
        {
            label.setVisible(false);
        }
    }
    
    public List<Integer> getCartasCambiadas()
    {
        DialogoCambiarCarta dialog = new DialogoCambiarCarta(this, true);
        dialog.establecerCartas(this.getCartasJugador());
        dialog.setVisible(true);
        
        return dialog.obtenerCartasCambiadas();
    }
    
    public final JLabel[] getCartasMesa()
    {
        return new JLabel[] { this.cartaMesa1, this.cartaMesa2, this.cartaMesa3, this.cartaMesa4, this.cartaMesa5 };
    }

    public final JLabel[] getCartasJugador()
    {
        return new JLabel[] { this.cartaJugador1, this.cartaJugador2, this.cartaJugador3, this.cartaJugador4, this.cartaJugador5 };
    }
    
    /*
     * Método que retorna el label donde se muestra el resultado de las apuestas.
     */
    public JLabel getLabelApuestas()
    {
        return this.labelApuestas;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonIgualar = new javax.swing.JButton();
        botonRetirarse = new javax.swing.JButton();
        botonPasar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labelFichas = new javax.swing.JLabel();
        panelCartasMesa = new javax.swing.JPanel();
        cartaMesa1 = new javax.swing.JLabel();
        cartaMesa2 = new javax.swing.JLabel();
        cartaMesa3 = new javax.swing.JLabel();
        cartaMesa4 = new javax.swing.JLabel();
        cartaMesa5 = new javax.swing.JLabel();
        panelCartasJugador = new javax.swing.JPanel();
        cartaJugador1 = new javax.swing.JLabel();
        cartaJugador2 = new javax.swing.JLabel();
        cartaJugador3 = new javax.swing.JLabel();
        cartaJugador4 = new javax.swing.JLabel();
        cartaJugador5 = new javax.swing.JLabel();
        panelApuestas = new javax.swing.JPanel();
        labelApuestas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonIgualar.setText("Igualar");
        botonIgualar.setEnabled(false);
        botonIgualar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIgualarActionPerformed(evt);
            }
        });

        botonRetirarse.setText("Retirarse");
        botonRetirarse.setEnabled(false);
        botonRetirarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRetirarseActionPerformed(evt);
            }
        });

        botonPasar.setText("Pasar");
        botonPasar.setEnabled(false);
        botonPasar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPasarActionPerformed(evt);
            }
        });

        jLabel1.setText("Fichas");

        labelFichas.setText("50");

        cartaMesa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/cards/B-2.png"))); // NOI18N

        cartaMesa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/cards/B-2.png"))); // NOI18N

        cartaMesa3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/cards/B-2.png"))); // NOI18N

        cartaMesa4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/cards/B-2.png"))); // NOI18N

        cartaMesa5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/cards/B-2.png"))); // NOI18N

        javax.swing.GroupLayout panelCartasMesaLayout = new javax.swing.GroupLayout(panelCartasMesa);
        panelCartasMesa.setLayout(panelCartasMesaLayout);
        panelCartasMesaLayout.setHorizontalGroup(
            panelCartasMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCartasMesaLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(cartaMesa1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartaMesa2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartaMesa3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartaMesa4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartaMesa5)
                .addContainerGap(140, Short.MAX_VALUE))
        );
        panelCartasMesaLayout.setVerticalGroup(
            panelCartasMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCartasMesaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCartasMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cartaMesa1)
                    .addComponent(cartaMesa2)
                    .addComponent(cartaMesa3)
                    .addComponent(cartaMesa4)
                    .addComponent(cartaMesa5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cartaJugador1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/cards/B-2.png"))); // NOI18N

        cartaJugador2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/cards/B-2.png"))); // NOI18N

        cartaJugador3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/cards/B-2.png"))); // NOI18N

        cartaJugador4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/cards/B-2.png"))); // NOI18N

        cartaJugador5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/cards/B-2.png"))); // NOI18N

        javax.swing.GroupLayout panelCartasJugadorLayout = new javax.swing.GroupLayout(panelCartasJugador);
        panelCartasJugador.setLayout(panelCartasJugadorLayout);
        panelCartasJugadorLayout.setHorizontalGroup(
            panelCartasJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCartasJugadorLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(cartaJugador1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartaJugador2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartaJugador3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartaJugador4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartaJugador5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCartasJugadorLayout.setVerticalGroup(
            panelCartasJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCartasJugadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCartasJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cartaJugador1)
                    .addComponent(cartaJugador2)
                    .addComponent(cartaJugador3)
                    .addComponent(cartaJugador4)
                    .addComponent(cartaJugador5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelApuestas.setText("Apuestas");

        javax.swing.GroupLayout panelApuestasLayout = new javax.swing.GroupLayout(panelApuestas);
        panelApuestas.setLayout(panelApuestasLayout);
        panelApuestasLayout.setHorizontalGroup(
            panelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelApuestasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelApuestas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelApuestasLayout.setVerticalGroup(
            panelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelApuestasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelApuestas)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelApuestas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelFichas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(botonPasar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonRetirarse, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonIgualar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
            .addComponent(panelCartasMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelCartasJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonIgualar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonPasar)
                        .addGap(5, 5, 5)
                        .addComponent(botonRetirarse))
                    .addComponent(panelApuestas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelFichas))
                .addGap(43, 43, 43)
                .addComponent(panelCartasMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(panelCartasJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonIgualarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIgualarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonIgualarActionPerformed

    private void botonPasarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPasarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonPasarActionPerformed

    private void botonRetirarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRetirarseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonRetirarseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIgualar;
    private javax.swing.JButton botonPasar;
    private javax.swing.JButton botonRetirarse;
    private javax.swing.JLabel cartaJugador1;
    private javax.swing.JLabel cartaJugador2;
    private javax.swing.JLabel cartaJugador3;
    private javax.swing.JLabel cartaJugador4;
    private javax.swing.JLabel cartaJugador5;
    private javax.swing.JLabel cartaMesa1;
    private javax.swing.JLabel cartaMesa2;
    private javax.swing.JLabel cartaMesa3;
    private javax.swing.JLabel cartaMesa4;
    private javax.swing.JLabel cartaMesa5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelApuestas;
    private javax.swing.JLabel labelFichas;
    private javax.swing.JPanel panelApuestas;
    private javax.swing.JPanel panelCartasJugador;
    private javax.swing.JPanel panelCartasMesa;
    // End of variables declaration//GEN-END:variables
}
