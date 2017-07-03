
package prendas;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import BusinessDelegate.BusinessDelegate;
import dto.AreaProduccionDto;
import dto.ConfeccionDto;
import dto.InsumoDto;


public abstract class Confeccion extends javax.swing.JFrame {
	
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private DefaultListModel model = new DefaultListModel();
    private ArrayList<InsumoDto> insumosDto = new ArrayList<InsumoDto>();
    
    protected ConfeccionDto confeccionDto;
  
    
    @SuppressWarnings("unchecked")
	public Confeccion() {
        initComponents(); 
        refresh();

        listaInsumos.setModel(model);
        
       	for (AreaProduccionDto areaProduccion : BusinessDelegate.getInstance().GetAreasProduccion()) {
       		comboAreas.addItem(areaProduccion);
		}
       	
        setLocationRelativeTo(null);
        setVisible(true);
    }

  
    private void initComponents() {

        labelDetalle = new javax.swing.JLabel();
        fieldDetalle = new javax.swing.JTextField();
        labelTiempo = new javax.swing.JLabel();
        fieldTiempo = new javax.swing.JTextField();
        labelArea = new javax.swing.JLabel();
        comboAreas = new javax.swing.JComboBox<>();
        aceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaInsumos = new javax.swing.JList<>();
        cancelar = new javax.swing.JButton();
        agregarInsumo = new javax.swing.JButton();
        refresh = new javax.swing.JButton();

        labelDetalle.setText("Detalle");

        labelTiempo.setText("Tiempo produccion");

        labelArea.setText("Area de produccion");

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listaInsumos);

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        agregarInsumo.setText("Agregar insumo");
        agregarInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarInsumoActionPerformed(evt);
            }
        });

        refresh.setIcon(new javax.swing.ImageIcon("src/iconos/arrow_refresh.png")); // NOI18N
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTiempo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelDetalle)
                            .addComponent(labelArea, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboAreas, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(agregarInsumo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refresh)))
                .addGap(68, 68, 68))
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(aceptar)
                .addGap(64, 64, 64)
                .addComponent(cancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDetalle)
                    .addComponent(fieldDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTiempo)
                    .addComponent(fieldTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelArea)
                    .addComponent(comboAreas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(agregarInsumo)
                    .addComponent(refresh))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar)
                    .addComponent(cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {

    	if(fieldDetalle.getText().equals("") || fieldTiempo.getText().equals(""))
    		JOptionPane.showMessageDialog(null, "Por favor complete todos los campos");
    	
    	else if (insumosDto.size()==0)
    		JOptionPane.showMessageDialog(null, "Por favor agregue un insumo como minimo");
    	
    	else{
    		
	    	AreaProduccionDto areaProduccion = (AreaProduccionDto) comboAreas.getSelectedItem();
	    	
	        ConfeccionDto confeccion = new ConfeccionDto(Float.parseFloat(fieldTiempo.getText()), fieldDetalle.getText(), 
	        		areaProduccion, insumosDto);
	    	
	        this.confeccionDto=confeccion;
	        
	        aceptar();
	        setVisible(false);
    	}
    }

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
    }

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {
        refresh();
    }

    private void agregarInsumoActionPerformed(java.awt.event.ActionEvent evt) {
        new Insumo() {
			private static final long serialVersionUID = 1L;

			@Override
            public void aceptar() {
                insumosDto.add(insumo);
            }
        };
    }

    public abstract void aceptar();
   
    @SuppressWarnings("unchecked")
	private void refresh(){
        model.removeAllElements();
        for(InsumoDto insumo : insumosDto){
            model.addElement(insumo);
        }
    }

    private javax.swing.JButton aceptar;
    private javax.swing.JButton agregarInsumo;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<AreaProduccionDto> comboAreas;
    private javax.swing.JTextField fieldDetalle;
    private javax.swing.JTextField fieldTiempo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelArea;
    private javax.swing.JLabel labelDetalle;
    private javax.swing.JLabel labelTiempo;
    private javax.swing.JList<InsumoDto> listaInsumos;
    private javax.swing.JButton refresh;
}
