package gui;

import cliente.Cliente;
import comandos.ComandoIniciarPartidaCliente;
import comandos.ComandoNotificarMesas;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import poker.Constantes;
import poker.Jugador;
import poker.MesaDTO;

public class VentanaInicio extends javax.swing.JFrame {

    public VentanaInicio()
    {
        initComponents();
        conectarServidor();
    }
    
    private void conectarServidor()
    {
        String serverIp = null;
        boolean isConnected = false;
        
        while (!isConnected)
        {
            serverIp = JOptionPane.showInputDialog(this, "Server IP");
            isConnected = Cliente.getInstance().getsocketCliente().establecerConexion(serverIp);
        }
        
        Cliente.getInstance().getsocketCliente().start();
    }

    private String validarDatos()
    {
        if (this.textoIdUsuario.getText().isEmpty())
        {
            return "Ingrese un ID de Usuario";
        }
        return null;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        botonCrearMesa = new javax.swing.JButton();
        botonUnirseMesa = new javax.swing.JButton();
        textoIdUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        botonCrearMesa.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botonCrearMesa.setText("Crear Mesa");
        botonCrearMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearMesaActionPerformed(evt);
            }
        });

        botonUnirseMesa.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botonUnirseMesa.setText("Unirse a Mesa");
        botonUnirseMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonUnirseMesaActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ID de Usuario");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("POKER");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/poker.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textoIdUsuario)
            .addComponent(botonCrearMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(botonUnirseMesa, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textoIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonCrearMesa)
                .addGap(18, 18, 18)
                .addComponent(botonUnirseMesa)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    /*
     * Evento del botón Crear Mesa.
     */
    private void botonCrearMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearMesaActionPerformed
        String error = this.validarDatos();
        if (error == null)
        {
            DialogoCrearMesa dialog = new DialogoCrearMesa(this, true);
            dialog.setVisible(true);

            if (dialog.getEstado() == Constantes.DIALOGO_ACEPTAR)
            {
                this.setVisible(false);
                this.dispose();
                Jugador jugador = new Jugador(this.textoIdUsuario.getText(), 50);//Se crea el jugador.
                VentanaEspera frame = new VentanaEspera(true);
                frame.establecerNombreMesa( dialog.getNombreMesa() );
                //Se establecen los datos a enviar al servidor.
                ArrayList<String> datoEnvio = new ArrayList<>();
                datoEnvio.add(dialog.getNombreMesa());//Nombre de la mesa.

                datoEnvio.add(Integer.toString(dialog.getMaxJugadores()));//Cantidad máxima de juagadores.
                System.out.println(dialog.getMaxJugadores());
                datoEnvio.add(Integer.toString(dialog.getTipoJuego()));//Entero indicando el tipo de juego.
                System.out.println(dialog.getTipoJuego());
                //Se envía la petición al servidor.
                Cliente.getInstance().setJugador(jugador);
                Cliente.getInstance().getsocketCliente().enviarDato(jugador);//Se envía el juagador al servidor.
                Cliente.getInstance().getsocketCliente().enviarComando("crearMesa", datoEnvio);//Pasar arreglo a object
                frame.setVisible(true);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonCrearMesaActionPerformed

    /*
     * Evento del botón Unirse a Mesa.
     */
    private void botonUnirseMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonUnirseMesaActionPerformed
        String error = this.validarDatos();
        if (error == null)
        {
            Jugador jugador = new Jugador(this.textoIdUsuario.getText(), 50);//Se crea el jugador.
            Cliente.getInstance().setJugador(jugador);
            Cliente.getInstance().getsocketCliente().enviarDato(jugador);//Se envía el jugador al servidor.
            DialogoUnirseMesa dialog = new DialogoUnirseMesa(this, true);//Se envía petición al servidor de obtener mesas.
            dialog.setVisible(true);

            if (dialog.getEstado() == Constantes.DIALOGO_ACEPTAR)
            {
                this.setVisible(false);
                this.dispose();
                
                VentanaEspera frame = new VentanaEspera(false);
                MesaDTO mesaSeleccionada = dialog.getMesa();
                Cliente.getInstance().setidMesa(mesaSeleccionada.getId());
                frame.establecerNombreMesa(mesaSeleccionada.getNombre());
                //Se establecen los datos a enviar al servidor.
                ArrayList<String> datoEnvio = new ArrayList<>();
                datoEnvio.add(mesaSeleccionada.getId());//Id de la mesa.
                //Se envía la petición al servidor.
                Cliente.getInstance().getsocketCliente().enviarComando("unirseMesa", datoEnvio);
                frame.setVisible(true);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonUnirseMesaActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                new VentanaInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCrearMesa;
    private javax.swing.JButton botonUnirseMesa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JTextField textoIdUsuario;
    // End of variables declaration//GEN-END:variables
}
