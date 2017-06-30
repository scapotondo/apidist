
package administracion;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import BusinessDelegate.BusinessDelegate;
import dto.ClienteDto;
import dto.SucursalDto;
import exceptions.*;

public class ModificarCliente extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<SucursalDto> sucursalesDto;
	
    public ModificarCliente(ClienteDto cliente) {
        initComponents();
        formasDePagoCombo.addItem("Factura A");
        formasDePagoCombo.addItem("Factura B");
        
        legajoField.setText(cliente.getLegajo()+"");
        cuentaCorrienteField.setText(cliente.getCuentaCorriente()+"");
        cuitField.setText(cliente.getCuit()+"");
        direccionEnvioField.setText(cliente.getDireccionEnvio());
        direccionFacturacionField.setText(cliente.getDireccionFacturacion());
        formasDePagoCombo.setSelectedItem(cliente.getFormaPago());
        limiteCreditoField.setText(cliente.getLimiteCredito()+"");
        nombreField.setText(cliente.getNombre());
        razonSocialField.setText(cliente.getRazonSocial());
        telefonoField.setText(cliente.getTelefono());
        
        sucursalesDto= BusinessDelegate.getInstance().GetSucursales();
    	
    	for (SucursalDto sucursalDto : sucursalesDto) {
    		
			comboSucursal.addItem(sucursalDto.getNombre() + " -" + sucursalDto.getNumero());
			
			if(sucursalDto.getNumero()==cliente.getSucursal().getNumero())
    			comboSucursal.setSelectedItem(sucursalDto.getNombre() + " -" + sucursalDto.getNumero());
		}
    	
    	
    }

    private void initComponents() {

        cancelar = new javax.swing.JButton();
        labelNombre = new javax.swing.JLabel();
        nombreField = new javax.swing.JTextField();
        labelCuit = new javax.swing.JLabel();
        cuitField = new javax.swing.JTextField();
        labelCuentaCorriente = new javax.swing.JLabel();
        cuentaCorrienteField = new javax.swing.JTextField();
        formaPagoLabel = new javax.swing.JLabel();
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
        labelNroSucursal = new javax.swing.JLabel();
        legajoLabel = new javax.swing.JLabel();
        legajoField = new javax.swing.JTextField();
        comboSucursal = new javax.swing.JComboBox<>();
        formasDePagoCombo = new javax.swing.JComboBox<>();

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

        labelNroSucursal.setText("Sucursal");

        legajoLabel.setText("Legajo");

        legajoField.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCuit)
                            .addComponent(labelNombre)
                            .addComponent(formaPagoLabel)
                            .addComponent(limiteCreditoLabel)
                            .addComponent(razonSocialLabel)
                            .addComponent(telefonoLabel)
                            .addComponent(direccionFacturacionLabel)
                            .addComponent(labelNroSucursal)
                            .addComponent(labelCuentaCorriente)
                            .addComponent(direccionEnvioLabel)
                            .addComponent(legajoLabel))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(direccionFacturacionField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addGap(6, 6, 6))
                            .addComponent(cuentaCorrienteField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cuitField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nombreField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(limiteCreditoField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(razonSocialField, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addComponent(telefonoField)
                            .addComponent(direccionEnvioField)
                            .addComponent(legajoField)
                            .addComponent(comboSucursal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(formasDePagoCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aceptar)
                        .addGap(60, 60, 60)
                        .addComponent(cancelar)
                        .addGap(62, 62, 62)))
                .addGap(77, 77, 77))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(legajoLabel)
                    .addComponent(legajoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formaPagoLabel)
                    .addComponent(formasDePagoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(limiteCreditoLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(limiteCreditoField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNroSucursal)
                    .addComponent(comboSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar)
                    .addComponent(cancelar)))
        );

        pack();
    }// </editor-fold>                        


    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {
        atras();
    }

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {
    	try {
    		if(limiteCreditoField.getText().equals("")|| direccionFacturacionField.getText().equals("")||
    				   cuentaCorrienteField.getText().equals("")|| cuitField.getText().equals("")||nombreField.getText().equals("")||
    						razonSocialField.getText().equals("")|| telefonoField.getText().equals("")||
    						direccionEnvioField.getText().equals(""))
    	    			
    	    	JOptionPane.showMessageDialog(null, "Por favor complete todos los campos");
    	    		
    	   else{
    		
				BusinessDelegate.getInstance().ModificarCliente(Float.parseFloat(limiteCreditoField.getText()), formasDePagoCombo.getSelectedItem()+"",
						Float.parseFloat(cuentaCorrienteField.getText()), cuitField.getText(),nombreField.getText(),
						razonSocialField.getText(), telefonoField.getText(), direccionEnvioField.getText(), 
						direccionFacturacionField.getText(), comboSucursal.getSelectedItem()+"",
						Integer.parseInt(legajoField.getText()));
				
				JOptionPane.showMessageDialog(null, "El cliente fue modificado");
				atras();
    	   }
		} catch (RemoteObjectNotFoundException | ApplicationException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
    	
    }

    private void atras(){
    	MainClientes mc =new MainClientes();
    	mc.setLocationRelativeTo(null);
    	mc.setVisible(true);
        setVisible(false);
    }

    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<String> comboSucursal;
    private javax.swing.JTextField cuentaCorrienteField;
    private javax.swing.JTextField cuitField;
    private javax.swing.JTextField direccionEnvioField;
    private javax.swing.JLabel direccionEnvioLabel;
    private javax.swing.JTextField direccionFacturacionField;
    private javax.swing.JLabel direccionFacturacionLabel;
    private javax.swing.JLabel formaPagoLabel;
    private javax.swing.JComboBox<String> formasDePagoCombo;
    private javax.swing.JLabel labelCuentaCorriente;
    private javax.swing.JLabel labelCuit;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelNroSucursal;
    private javax.swing.JTextField legajoField;
    private javax.swing.JLabel legajoLabel;
    private javax.swing.JTextField limiteCreditoField;
    private javax.swing.JLabel limiteCreditoLabel;
    private javax.swing.JTextField nombreField;
    private javax.swing.JTextField razonSocialField;
    private javax.swing.JLabel razonSocialLabel;
    private javax.swing.JTextField telefonoField;
    private javax.swing.JLabel telefonoLabel;
}
