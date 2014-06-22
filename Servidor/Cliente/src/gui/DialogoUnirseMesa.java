package gui;

import cliente.Cliente;
import comandos.ComandoNotificarMesas;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import poker.Constantes;
import poker.MesaDTO;

public class DialogoUnirseMesa extends javax.swing.JDialog {
    
    public int estado;
    private String nombre;
    private String id;
    private List<MesaDTO> mesas;
    
    public DialogoUnirseMesa(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
        this.mesas = null;
        this.estado = Constantes.DIALOGO_ACEPTAR;
        
        Cliente.getInstance().getsocketCliente().putComando("notificarMesas", new ComandoNotificarMesas(this));
        Cliente.getInstance().getsocketCliente().enviarComando("obtenerMesas", null);//Se le pieden las mesas al servidor.
    }
    
    
    /**
     * Método que carga las mesas en la interfaz.
     */
    private void cargarMesas()
    {
        DefaultListModel model = new DefaultListModel();
        for (MesaDTO mesa : mesas)
        {
            model.addElement(mesa);
        }
        this.listaMesas.setModel(model);
        this.listaMesas.setSelectedIndex(0);
    }
    
    /**
     * Método que establece el valor del atributo mesas.
     * @param mesas Lista de DTO's donde viene la información de las mesas.
     */
    public void setMesas(List<MesaDTO> mesas)
    {
        this.mesas = mesas;
        cargarMesas();
    }
    
    private String validarDatos()
    {
        if (this.getNombreMesa() == null)
        {
            return "Seleccione una mesa.";
        }
        return null;
    }
    
    /**
     *
     * @return Objeto MesaDTO seleccionado.
     */
    public MesaDTO getMesa()
    {
       int index =  this.listaMesas.getSelectedIndex();
       return this.mesas.get(index);
    }
    
    public String getNombreMesa()
    {
        return (String) this.listaMesas.getSelectedValue();
    }
    
    public int getEstado()
    {
        return this.estado;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaMesas = new javax.swing.JList();
        botonAceptar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        listaMesas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaMesas.setToolTipText("");
        jScrollPane1.setViewportView(listaMesas);

        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(173, Short.MAX_VALUE)
                .addComponent(botonCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonAceptar)
                .addGap(6, 6, 6))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCancelar)
                    .addComponent(botonAceptar)))
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

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.estado = Constantes.DIALOGO_CANCELAR;
        this.dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        String error = this.validarDatos();
        if (error == null)
        {
            this.estado = Constantes.DIALOGO_ACEPTAR;
            this.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonAceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaMesas;
    // End of variables declaration//GEN-END:variables
}
