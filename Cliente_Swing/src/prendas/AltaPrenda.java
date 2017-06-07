package prendas;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import BusinessDelegate.BusinessDelegate;
import administracion.MainPrendas;
import dto.ConfeccionDto;
import dto.PrendaDto;
import dto.StockPrendaDto;
import exceptions.ApplicationException;
import exceptions.RemoteObjectNotFoundException;

public class AltaPrenda extends javax.swing.JFrame {

    private ArrayList<ConfeccionDto> confeccionesDto = new ArrayList<>();
    private DefaultListModel model = new DefaultListModel();
    
    public AltaPrenda() {
        initComponents();
        
        listaConfecciones.setModel(this.model);
        
        refresh();
        
        listaConfecciones.setModel(model);
    }
    
    private void initComponents() {

        labelNombre = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();
        labelDescripcion = new javax.swing.JLabel();
        fieldDescripcion = new javax.swing.JTextField();
        labelCantidad = new javax.swing.JLabel();
        fieldCantidadProducir = new javax.swing.JTextField();
        labelGanancia = new javax.swing.JLabel();
        fieldPorcentajeGanancias = new javax.swing.JTextField();
        labeldiscontinuo = new javax.swing.JLabel();
        comboBoxDiscontinuo = new javax.swing.JComboBox<>();
        labeTalles = new javax.swing.JLabel();
        labelColores = new javax.swing.JLabel();
        checkXS = new javax.swing.JCheckBox();
        checkS = new javax.swing.JCheckBox();
        checkM = new javax.swing.JCheckBox();
        checkL = new javax.swing.JCheckBox();
        checkXL = new javax.swing.JCheckBox();
        checkAzul = new javax.swing.JCheckBox();
        checkRojo = new javax.swing.JCheckBox();
        checkAmarillo = new javax.swing.JCheckBox();
        checkVerde = new javax.swing.JCheckBox();
        checkNegro = new javax.swing.JCheckBox();
        checkBlanco = new javax.swing.JCheckBox();
        confecciones = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaConfecciones = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelNombre.setText("Nombre");

        labelDescripcion.setText("Descripcion");

        labelCantidad.setText("Cantidad a producir");

        labelGanancia.setText("Porcentaje ganancias");

        labeldiscontinuo.setText("Es discontinuo");

        comboBoxDiscontinuo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        comboBoxDiscontinuo.setSelectedIndex(1);

        labeTalles.setText("Talles validos");

        labelColores.setText("Colores validos");

        checkXS.setText("XS");

        checkS.setText("S");

        checkM.setText("M");

        checkL.setText("L");

        checkXL.setText("XL");

        checkAzul.setText("Azul");

        checkRojo.setText("Rojo");

        checkAmarillo.setText("Amarillo");

        checkVerde.setText("Verde");

        checkNegro.setText("Negro");

        checkBlanco.setText("Blanco");

        confecciones.setText("Agregar confeccion");
        confecciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confeccionesActionPerformed(evt);
            }
        });

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

      
        jScrollPane1.setViewportView(listaConfecciones);

        jButton1.setIcon(new javax.swing.ImageIcon("src/iconos/arrow_refresh.png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(confecciones)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDescripcion)
                            .addComponent(labelNombre)
                            .addComponent(labelCantidad)
                            .addComponent(labelGanancia)
                            .addComponent(labeldiscontinuo)
                            .addComponent(labeTalles)
                            .addComponent(labelColores)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(aceptar)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(fieldCantidadProducir)
                                        .addComponent(fieldPorcentajeGanancias)
                                        .addComponent(comboBoxDiscontinuo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(checkXS)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(checkS)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(checkM)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(checkL)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(checkXL))
                                        .addComponent(fieldNombre)
                                        .addComponent(fieldDescripcion))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(checkVerde)
                                            .addComponent(checkBlanco))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(checkAmarillo)
                                            .addComponent(checkAzul))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(checkNegro)
                                            .addComponent(checkRojo)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(cancelar)))))
                .addGap(0, 75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDescripcion)
                    .addComponent(fieldDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCantidad)
                    .addComponent(fieldCantidadProducir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelGanancia)
                    .addComponent(fieldPorcentajeGanancias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labeldiscontinuo)
                    .addComponent(comboBoxDiscontinuo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labeTalles)
                    .addComponent(checkXS)
                    .addComponent(checkS)
                    .addComponent(checkM)
                    .addComponent(checkL)
                    .addComponent(checkXL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelColores)
                    .addComponent(checkBlanco)
                    .addComponent(checkAmarillo)
                    .addComponent(checkRojo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkVerde)
                    .addComponent(checkAzul)
                    .addComponent(checkNegro))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confecciones)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar)
                    .addComponent(cancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confeccionesActionPerformed(java.awt.event.ActionEvent evt) {
       
       new Confeccion() {
           @Override
           public void aceptar() {
               
                confeccionesDto.add(confeccionDto);
           }
       };  
      
    }

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {
    	try {
	    	ArrayList<String> tallesValidos = new ArrayList<String>();
	    	ArrayList<String> coloresValidos = new ArrayList<String>();
	    	boolean discontinuo=false;
	    	
	    	//controlo si no escribio nada
	    	if(fieldCantidadProducir.getText().equals("") || fieldDescripcion.getText().equals("") ||
	    			fieldNombre.getText().equals("") || fieldPorcentajeGanancias.getText().equals(""))
	    		
	    		JOptionPane.showMessageDialog(null, "Por favor complete todos los campos");
	    	
	    	//controlo si dejo todos los checkbox de colores sin seleccionar
	    	else if(checkAmarillo.isSelected()==false && checkAzul.isSelected()==false && checkBlanco.isSelected()==false && 
	    			checkNegro.isSelected()==false && checkRojo.isSelected()==false && checkVerde.isSelected()==false)
	    		
	    		JOptionPane.showMessageDialog(null, "Por favor seleccione como minimo 1 color");
	    	
	    	//controlo si dejo todos los checkbox de talels vacios
	    	else if(checkL.isSelected()==false && checkM.isSelected()==false && checkS.isSelected()==false && 
	    			checkXL.isSelected()==false && checkXS.isSelected()==false )
	    		
	    		JOptionPane.showMessageDialog(null, "Por favor seleccione como minimo 1 talle");
	    	
	    	else if (confeccionesDto.size()==0)
	    		JOptionPane.showMessageDialog(null, "Por favor agregue una confeccion como minimo");
	    	
	    	else{
		    	if((comboBoxDiscontinuo.getSelectedItem()+"").equals("Si"))
		    		discontinuo=true;
		    	
		    	CargarTalles(tallesValidos);
		    	CargarColores(coloresValidos);
		    	
		        PrendaDto prenda = new PrendaDto(tallesValidos, coloresValidos,0,discontinuo,
		        		Integer.parseInt(fieldCantidadProducir.getText()),fieldNombre.getText(),fieldDescripcion.getText(),
		        		Float.parseFloat(fieldPorcentajeGanancias.getText()),confeccionesDto,new ArrayList<StockPrendaDto>());
		        	        
				BusinessDelegate.getInstance().AltaPrenda(prenda);
				
				JOptionPane.showMessageDialog(null, "La prenda fue dada de alta");
				Atras();
				
	    	}
		} catch (RemoteObjectNotFoundException e) {
			e.printStackTrace();
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
        
    }

    
    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {
        Atras();
    }
    

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        refresh();
    }

    private void refresh(){
        model.removeAllElements();
        for(ConfeccionDto confeccion : confeccionesDto){
            model.addElement(confeccion);
        }
    }
    
    private void Atras(){
        MainPrendas mp = new MainPrendas();
        mp.setLocationRelativeTo(null);
        mp.setVisible(true);
        setVisible(false);
    }
  
    private void CargarTalles(ArrayList<String> tallesValidos){
    	if(checkXS.isSelected() == true)
    		tallesValidos.add("xs");
    	
    	if(checkS.isSelected() == true)
    		tallesValidos.add("s");
    	
    	if(checkM.isSelected() == true)
    		tallesValidos.add("m");
    	
    	if(checkL.isSelected() == true)
    		tallesValidos.add("l");
    	
    	if(checkXL.isSelected() == true)
    		tallesValidos.add("xl");
    	
    }
    
    private void CargarColores(ArrayList<String> coloresValidos){
    	if(checkAmarillo.isSelected()==true)
    		coloresValidos.add("amarillo");
    	
    	if(checkAzul.isSelected()==true)
    		coloresValidos.add("azul");
    	
    	if(checkBlanco.isSelected()==true)
    		coloresValidos.add("blanco");
    	
    	if(checkNegro.isSelected()==true)
    		coloresValidos.add("negro");
    	
    	if(checkVerde.isSelected()==true)
    		coloresValidos.add("verde");
    	
    	if(checkRojo.isSelected()==true)
    		coloresValidos.add("rojo");
    	
    }

    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    private javax.swing.JCheckBox checkAmarillo;
    private javax.swing.JCheckBox checkAzul;
    private javax.swing.JCheckBox checkBlanco;
    private javax.swing.JCheckBox checkL;
    private javax.swing.JCheckBox checkM;
    private javax.swing.JCheckBox checkNegro;
    private javax.swing.JCheckBox checkRojo;
    private javax.swing.JCheckBox checkS;
    private javax.swing.JCheckBox checkVerde;
    private javax.swing.JCheckBox checkXL;
    private javax.swing.JCheckBox checkXS;
    private javax.swing.JComboBox<String> comboBoxDiscontinuo;
    private javax.swing.JButton confecciones;
    private javax.swing.JTextField fieldCantidadProducir;
    private javax.swing.JTextField fieldDescripcion;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JTextField fieldPorcentajeGanancias;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labeTalles;
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelColores;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelGanancia;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labeldiscontinuo;
    private javax.swing.JList<String> listaConfecciones;
}
