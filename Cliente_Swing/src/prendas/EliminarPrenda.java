package prendas;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import BusinessDelegate.BusinessDelegate;
import administracion.MainPrendas;
import dto.PrendaDto;
import exceptions.ApplicationException;
import exceptions.RemoteObjectNotFoundException;

public class EliminarPrenda extends javax.swing.JFrame {
	
	private ArrayList<PrendaDto> prendas = new ArrayList<>();

    public EliminarPrenda() {
        try {
        	
        	initComponents();
        	
			prendas = BusinessDelegate.getInstance().getPrendas();
			
			for (PrendaDto prendaDto : prendas) {
	        	comboPrendas.addItem(prendaDto.getNombre() + "-"+prendaDto.getCodigo());
			}
		
        } catch (RemoteObjectNotFoundException | ApplicationException e) {
			e.printStackTrace();
		}
    }


    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        comboPrendas = new javax.swing.JComboBox<>();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Seleccione prenda a eliminar");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(aceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelar))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboPrendas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(comboPrendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aceptar)
                    .addComponent(cancelar))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {

    	try {
			BusinessDelegate.getInstance().EliminarPrenda(comboPrendas.getSelectedItem()+"");
			
			JOptionPane.showMessageDialog(null, "La prenda fue eliminada");
			atras();
		} catch (RemoteObjectNotFoundException e) {
			e.printStackTrace();
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
    	
    }

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {
        atras();
    }

    public void atras(){
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
