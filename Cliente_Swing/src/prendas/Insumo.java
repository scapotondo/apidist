	package prendas;

import javax.swing.JOptionPane;

import BusinessDelegate.BusinessDelegate;
import dto.InsumoDto;
import dto.MateriaPrimaDto;

public abstract class Insumo extends javax.swing.JFrame {

//   protected InsumoDto insumoDto;
    protected InsumoDto insumo;
    
    public Insumo() {
        initComponents();
        
        for (MateriaPrimaDto materiaPrima : BusinessDelegate.getInstance().GetMateriasPrimas()) {
        	comboMateriaPrima.addItem(materiaPrima);
		}
        
        setLocationRelativeTo(null);
        setVisible(true);
    }

    
 // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        comboMateriaPrima = new javax.swing.JComboBox<>();
        labelCantidad = new javax.swing.JLabel();
        fieldCantidad = new javax.swing.JTextField();
        labelDesperdicio = new javax.swing.JLabel();
        fieldDesperdicio = new javax.swing.JTextField();
        labelPrecio = new javax.swing.JLabel();
        fieldPrecio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        comboMateriaPrima.setModel(new javax.swing.DefaultComboBoxModel<>());
       

        labelCantidad.setText("Cantidad");

        labelDesperdicio.setText("Desperdicio");

        labelPrecio.setText("Precio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPrecio)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(aceptar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cancelar))
                        .addComponent(comboMateriaPrima, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelCantidad)
                                .addComponent(labelDesperdicio))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(fieldDesperdicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                .addComponent(fieldCantidad, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(fieldPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)))))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(comboMateriaPrima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCantidad)
                    .addComponent(fieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldDesperdicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDesperdicio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPrecio)
                    .addComponent(fieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar)
                    .addComponent(cancelar))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>  

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {
    	if(fieldCantidad.getText().equals("") || fieldDesperdicio.getText().equals(""))
    		JOptionPane.showMessageDialog(null, "Por favor complete todos los campos");
    	
    	else{
    	
	        MateriaPrimaDto materiaPrima = (MateriaPrimaDto) comboMateriaPrima.getSelectedItem();
	    	
	    	this.insumo= new InsumoDto(Integer.parseInt(fieldCantidad.getText()), Integer.parseInt(fieldDesperdicio.getText()),
	    			materiaPrima,Integer.parseInt(fieldPrecio.getText()));
	    	
	        aceptar();
	        setVisible(false);
    	}
    }

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
    }

    public abstract void aceptar();

    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<MateriaPrimaDto> comboMateriaPrima;
    private javax.swing.JTextField fieldCantidad;
    private javax.swing.JTextField fieldDesperdicio;
    private javax.swing.JTextField fieldPrecio;
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelDesperdicio;
    private javax.swing.JLabel labelPrecio;
}
