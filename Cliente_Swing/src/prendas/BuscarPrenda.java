package prendas;

import java.util.ArrayList;

import javax.swing.ComboBoxEditor;

import BusinessDelegate.BusinessDelegate;
import administracion.MainPrendas;
import dto.PrendaDto;
import exceptions.ApplicationException;
import exceptions.RemoteObjectNotFoundException;

public class BuscarPrenda extends javax.swing.JFrame {

    private ArrayList<PrendaDto> prendas = new ArrayList<>();
    
    public BuscarPrenda() throws RemoteObjectNotFoundException, ApplicationException {
    	
        initComponents();
        
        prendas = BusinessDelegate.getInstance().getPrendas();
        
        for (PrendaDto prendaDto : prendas) {
        	comboPrendas.addItem(prendaDto.getNombre() + " - "+prendaDto.getCodigo());
		}
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        comboPrendas = new javax.swing.JComboBox<>();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Seleccione una prenda");

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
                        .addGap(93, 93, 93)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(aceptar)
                        .addGap(55, 55, 55)
                        .addComponent(cancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(comboPrendas, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(comboPrendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar)
                    .addComponent(cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
			PrendaDto prendaModificar = BusinessDelegate.getInstance().buscarPrendaPorCodigo(comboPrendas.getSelectedItem()+"");
		
			ModificarPrenda mp  = new ModificarPrenda(prendaModificar);
	        mp.setLocationRelativeTo(null);
	        mp.setVisible(true);
	        setVisible(false);
	        
        } catch (RemoteObjectNotFoundException e) {
			e.printStackTrace();
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
    }

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {
        MainPrendas mp = new MainPrendas();
        mp.setLocationRelativeTo(null);
        mp.setVisible(true);
        setVisible(false);
    }

    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<String> comboPrendas;
    private javax.swing.JLabel jLabel1;
}
