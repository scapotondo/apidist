
package administracion;


public class ModificarCliente extends javax.swing.JFrame {

    /**
     * Creates new form ModificarCliente
     */
    public ModificarCliente() {
        initComponents();
        // agregar como parametro un cliente y setear valores a los textfields
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancelar = new javax.swing.JButton();
        labelNombre = new javax.swing.JLabel();
        nombreField = new javax.swing.JTextField();
        labelCuit = new javax.swing.JLabel();
        cuitField = new javax.swing.JTextField();
        labelCuentaCorriente = new javax.swing.JLabel();
        cuentaCorrienteField = new javax.swing.JTextField();
        formaPagoLabel = new javax.swing.JLabel();
        formaPagoField = new javax.swing.JTextField();
        limiteCreditoLabel = new javax.swing.JLabel();
        limiteCreditoField = new javax.swing.JTextField();
        razonSocialLabel = new javax.swing.JLabel();
        razonSocialField = new javax.swing.JTextField();
        telefonoLabel = new javax.swing.JLabel();
        telefonoField = new javax.swing.JTextField();
        direccionEnvioLabel = new javax.swing.JLabel();
        direccionEnvioField = new javax.swing.JTextField();
        direccionFacturacionLabel = new javax.swing.JLabel();
        direccionFacturacionField = new javax.swing.JTextField();
        aceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        labelNombre.setText("Nombre");

        labelCuit.setText("Cuit");

        labelCuentaCorriente.setText("Cuenta corriente");

        formaPagoLabel.setText("Forma de pago");

        limiteCreditoLabel.setText("Limite credito");

        razonSocialLabel.setText("Razon social");

        telefonoLabel.setText("Telefono");

        direccionEnvioLabel.setText("Direccion envio");

        direccionFacturacionLabel.setText("Direccion facturacion");

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCuentaCorriente)
                            .addComponent(labelCuit)
                            .addComponent(labelNombre)
                            .addComponent(formaPagoLabel)
                            .addComponent(limiteCreditoLabel)
                            .addComponent(razonSocialLabel)
                            .addComponent(telefonoLabel)
                            .addComponent(direccionEnvioLabel)
                            .addComponent(direccionFacturacionLabel))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(direccionFacturacionField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addGap(6, 6, 6))
                            .addComponent(cuentaCorrienteField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cuitField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nombreField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(formaPagoField)
                            .addComponent(limiteCreditoField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(razonSocialField, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addComponent(telefonoField)
                            .addComponent(direccionEnvioField)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aceptar)
                        .addGap(59, 59, 59)
                        .addComponent(cancelar)
                        .addGap(62, 62, 62)))
                .addGap(77, 77, 77))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCuit)
                    .addComponent(cuitField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCuentaCorriente)
                    .addComponent(cuentaCorrienteField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formaPagoLabel)
                    .addComponent(formaPagoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limiteCreditoLabel)
                    .addComponent(limiteCreditoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(razonSocialLabel)
                    .addComponent(razonSocialField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonoLabel)
                    .addComponent(telefonoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(direccionEnvioLabel)
                    .addComponent(direccionEnvioField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(direccionFacturacionLabel)
                    .addComponent(direccionFacturacionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aceptar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cancelar)))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        BuscarCliente bc =new BuscarCliente();
        bc.setLocationRelativeTo(null);
        bc.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_cancelarActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aceptarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField cuentaCorrienteField;
    private javax.swing.JTextField cuitField;
    private javax.swing.JTextField direccionEnvioField;
    private javax.swing.JLabel direccionEnvioLabel;
    private javax.swing.JTextField direccionFacturacionField;
    private javax.swing.JLabel direccionFacturacionLabel;
    private javax.swing.JTextField formaPagoField;
    private javax.swing.JLabel formaPagoLabel;
    private javax.swing.JLabel labelCuentaCorriente;
    private javax.swing.JLabel labelCuit;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JTextField limiteCreditoField;
    private javax.swing.JLabel limiteCreditoLabel;
    private javax.swing.JTextField nombreField;
    private javax.swing.JTextField razonSocialField;
    private javax.swing.JLabel razonSocialLabel;
    private javax.swing.JTextField telefonoField;
    private javax.swing.JLabel telefonoLabel;
    // End of variables declaration//GEN-END:variables
}
