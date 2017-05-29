package administracion;

import exceptions.ApplicationException;
import exceptions.RemoteObjectNotFoundException;
import prendas.AltaPrenda;
import prendas.BuscarPrenda;
import prendas.EliminarPrenda;


public class MainPrendas extends javax.swing.JFrame {

    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MainPrendas() {
        initComponents();
    }

    
    private void initComponents() {

        home = new javax.swing.JButton();
        labelCliente = new javax.swing.JLabel();
        alta = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        baja = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        home.setIcon(new javax.swing.ImageIcon("src/iconos/house_go.png")); // NOI18N
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        labelCliente.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        labelCliente.setText("Prendas");

        alta.setIcon(new javax.swing.ImageIcon("src/iconos/add.png")); // NOI18N
        alta.setText("Alta");
        alta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaActionPerformed(evt);
            }
        });

        modificar.setIcon(new javax.swing.ImageIcon("src/iconos/pencil.png")); // NOI18N
        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        baja.setIcon(new javax.swing.ImageIcon("src/iconos/delete.png")); // NOI18N
        baja.setText("Baja");
        baja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(home)
                        .addGap(129, 129, 129)
                        .addComponent(labelCliente))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alta, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(baja, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(alta, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(baja, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {
        MainAdministracion ma= new MainAdministracion();
        ma.setLocationRelativeTo(null);
        ma.setVisible(true);
        setVisible(false);
    }

    private void altaActionPerformed(java.awt.event.ActionEvent evt) {
        AltaPrenda ap=new AltaPrenda();
        ap.setLocationRelativeTo(null);
        ap.setVisible(true);
        setVisible(false);
    }

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {
        BuscarPrenda bc;
		try {
			bc = new BuscarPrenda();
			bc.setLocationRelativeTo(null);
		    bc.setVisible(true);
		    setVisible(false);
		
		} catch (RemoteObjectNotFoundException e) {
			e.printStackTrace();
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
    }

    private void bajaActionPerformed(java.awt.event.ActionEvent evt) {
        EliminarPrenda ep=new EliminarPrenda();
        ep.setLocationRelativeTo(null);
        ep.setVisible(true);
        setVisible(false);
    }

    
    private javax.swing.JButton alta;
    private javax.swing.JButton baja;
    private javax.swing.JButton home;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JButton modificar;
}
