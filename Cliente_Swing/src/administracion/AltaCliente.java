
package administracion;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import BusinessDelegate.BusinessDelegate;
import dto.SucursalDto;
import exceptions.ApplicationException;
import exceptions.RemoteObjectNotFoundException;

public class AltaCliente extends javax.swing.JFrame {
   
	private static final long serialVersionUID = 1L;
	private ArrayList<SucursalDto> sucursalesDto;
	
	public AltaCliente() {
        
    	initComponents();
    	
    	sucursalesDto= BusinessDelegate.getInstance().GetSucursales();
    	
    	for (SucursalDto sucursalDto : sucursalesDto) {
			comboSucursal.addItem(sucursalDto.getNombre() + " -" + sucursalDto.getNumero());
		}
    }

    private void initComponents() {

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
        cancelar = new javax.swing.JButton();
        labelNroSucursal = new javax.swing.JLabel();
        comboSucursal = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        labelNroSucursal.setText("Sucursal");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNombre)
                            .addComponent(labelCuit)
                            .addComponent(labelCuentaCorriente)
                            .addComponent(formaPagoLabel)
                            .addComponent(limiteCreditoLabel)
                            .addComponent(razonSocialLabel)
                            .addComponent(telefonoLabel)
                            .addComponent(direccionEnvioLabel))
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(aceptar)
                                .addComponent(direccionFacturacionLabel))
                            .addComponent(labelNroSucursal))
                        .addGap(10, 10, 10)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(direccionFacturacionField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(nombreField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cuitField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cuentaCorrienteField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(formaPagoField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(limiteCreditoField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(razonSocialField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(telefonoField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(direccionEnvioField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(comboSucursal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(cancelar)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cuitField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCuit))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCuentaCorriente)
                            .addComponent(cuentaCorrienteField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(formaPagoLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(formaPagoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(limiteCreditoLabel)
                    .addComponent(limiteCreditoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(razonSocialLabel)
                    .addComponent(razonSocialField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(telefonoLabel)
                    .addComponent(telefonoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(direccionEnvioLabel)
                    .addComponent(direccionEnvioField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(direccionFacturacionLabel)
                    .addComponent(direccionFacturacionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNroSucursal)
                    .addComponent(comboSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar)
                    .addComponent(cancelar))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {
       
    	try {
    		
    		if(limiteCreditoField.getText().equals("")|| formaPagoField.getText().equals("")||
			   cuentaCorrienteField.getText().equals("")|| cuitField.getText().equals("")||nombreField.getText().equals("")||
					razonSocialField.getText().equals("")|| telefonoField.getText().equals("")||
					direccionEnvioField.getText().equals("")||direccionFacturacionField.getText().equals(""))
    			
    			JOptionPane.showMessageDialog(null, "Por favor complete todos los campos");
    		
    		else{
    		
	    		BusinessDelegate.getInstance().AltaCliente(Float.parseFloat(limiteCreditoField.getText()), formaPagoField.getText(),
						Float.parseFloat(cuentaCorrienteField.getText()), cuitField.getText(),nombreField.getText(),
						razonSocialField.getText(), telefonoField.getText(), direccionEnvioField.getText(), 
						direccionFacturacionField.getText(), comboSucursal.getSelectedItem()+"");
	    		
	    		atras();
	    		JOptionPane.showMessageDialog(null, "El cliente fue creado");
    		}
		} catch (RemoteObjectNotFoundException | ApplicationException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

    }

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {
    	
        atras();
    }
    
    private void atras(){
    	MainClientes mc=new MainClientes();
        mc.setLocationRelativeTo(null);
        mc.setVisible(true);
        
        setVisible(false);
    }

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
    private javax.swing.JLabel labelNroSucursal;
    private javax.swing.JTextField limiteCreditoField;
    private javax.swing.JLabel limiteCreditoLabel;
    private javax.swing.JTextField nombreField;
    private javax.swing.JComboBox<String> comboSucursal;
    private javax.swing.JTextField razonSocialField;
    private javax.swing.JLabel razonSocialLabel;
    private javax.swing.JTextField telefonoField;
    private javax.swing.JLabel telefonoLabel;
}

