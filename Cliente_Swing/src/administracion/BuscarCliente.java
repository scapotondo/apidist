
package administracion;

import java.util.ArrayList;

import controller.ControllerSwing;
import dto.ClienteDto;

public class BuscarCliente extends javax.swing.JFrame {

    
    public BuscarCliente() {
        initComponents();
        ArrayList<ClienteDto> clientes = ControllerSwing.getInstance().BuscarClientes();
        for (ClienteDto clienteDto : clientes) {
			clientesComboBox.addItem(clienteDto.getNombre()+"-"+clienteDto.getLegajo());
		}
    }
    private void initComponents() {

        texto = new javax.swing.JLabel();
        clientesComboBox = new javax.swing.JComboBox<>();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        texto.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        texto.setText("Seleccione 1 cliente");

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(texto))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(clientesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(aceptar)
                        .addGap(51, 51, 51)
                        .addComponent(cancelar)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(texto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clientesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar)
                    .addComponent(cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {
    	ClienteDto cliente =ControllerSwing.getInstance().BuscarClientePorId(clientesComboBox.getSelectedItem()+"");
        ModificarCliente mc = new ModificarCliente(cliente);
        mc.setLocationRelativeTo(null);
        mc.setVisible(true);
        setVisible(false);
    }

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {
        MainClientes mc = new MainClientes();
        mc.setLocationRelativeTo(null);
        mc.setVisible(true);
        setVisible(false);
    }

    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<String> clientesComboBox;
    private javax.swing.JLabel texto;
}
