
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
    	
    	formaDePagoCombo.addItem("Factura A");
    	formaDePagoCombo.addItem("Factura B");
    	
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
        formaDePagoCombo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        usuarioField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordField = new javax.swing.JTextField();

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

        jLabel1.setText("Usuario");

        jLabel2.setText("Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(aceptar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelNroSucursal)
                                .addComponent(direccionFacturacionLabel)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNombre)
                            .addComponent(labelCuit)
                            .addComponent(labelCuentaCorriente)
                            .addComponent(formaPagoLabel)
                            .addComponent(limiteCreditoLabel)
                            .addComponent(razonSocialLabel)
                            .addComponent(telefonoLabel)
                            .addComponent(direccionEnvioLabel))
                        .addGap(41, 41, 41)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(direccionFacturacionField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(nombreField)
                    .addComponent(cuitField)
                    .addComponent(cuentaCorrienteField)
                    .addComponent(limiteCreditoField)
                    .addComponent(razonSocialField)
                    .addComponent(telefonoField)
                    .addComponent(direccionEnvioField)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(cancelar))
                    .addComponent(comboSucursal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(formaDePagoCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usuarioField)
                    .addComponent(passwordField))
                .addContainerGap(83, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCuentaCorriente)
                    .addComponent(cuentaCorrienteField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formaPagoLabel)
                    .addComponent(formaDePagoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNroSucursal, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuarioField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar)
                    .addComponent(cancelar))
                .addGap(23, 23, 23))
        );

        pack();
    }

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {
       
    	try {
    		
    		if(limiteCreditoField.getText().equals("")|| cuentaCorrienteField.getText().equals("")||
    				cuitField.getText().equals("")||nombreField.getText().equals("")|| razonSocialField.getText().equals("")||
    				telefonoField.getText().equals("")|| direccionEnvioField.getText().equals("") || 
    				direccionFacturacionField.getText().equals("") || usuarioField.getText().equals("") ||
    				passwordField.getText().equals(""))
    			
    			JOptionPane.showMessageDialog(null, "Por favor complete todos los campos");
    		
    		else{
    			String formaDePago = formaDePagoCombo.getSelectedItem() + "";
	    		BusinessDelegate.getInstance().AltaCliente(Float.parseFloat(limiteCreditoField.getText()), formaDePago,
						Float.parseFloat(cuentaCorrienteField.getText()), cuitField.getText(),nombreField.getText(),
						razonSocialField.getText(), telefonoField.getText(), direccionEnvioField.getText(), 
						direccionFacturacionField.getText(), comboSucursal.getSelectedItem()+"" , usuarioField.getText(), 
						passwordField.getText());
	    		
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
    private javax.swing.JComboBox<String> comboSucursal;
    private javax.swing.JTextField cuentaCorrienteField;
    private javax.swing.JTextField cuitField;
    private javax.swing.JTextField direccionEnvioField;
    private javax.swing.JLabel direccionEnvioLabel;
    private javax.swing.JTextField direccionFacturacionField;
    private javax.swing.JLabel direccionFacturacionLabel;
    private javax.swing.JComboBox<String> formaDePagoCombo;
    private javax.swing.JLabel formaPagoLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelCuentaCorriente;
    private javax.swing.JLabel labelCuit;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelNroSucursal;
    private javax.swing.JTextField limiteCreditoField;
    private javax.swing.JLabel limiteCreditoLabel;
    private javax.swing.JTextField nombreField;
    private javax.swing.JTextField passwordField;
    private javax.swing.JTextField razonSocialField;
    private javax.swing.JLabel razonSocialLabel;
    private javax.swing.JTextField telefonoField;
    private javax.swing.JLabel telefonoLabel;
    private javax.swing.JTextField usuarioField;
}

