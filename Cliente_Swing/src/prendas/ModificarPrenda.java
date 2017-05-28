package prendas;

import administracion.MainPrendas;
import dto.PrendaDto;

public class ModificarPrenda extends javax.swing.JFrame {
    
    public ModificarPrenda(PrendaDto prendaModificar) {
        initComponents();
        
        
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
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

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
                .addGap(75, 75, 75)
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
                        .addComponent(cancelar)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar)
                    .addComponent(cancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {
        //TODO: conectar con BusinessDelegate
        
        Atras();
    }

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {
        Atras();
    }

   
    private void Atras(){
        MainPrendas mp = new MainPrendas();
        mp.setLocationRelativeTo(null);
        mp.setVisible(true);
        setVisible(false);
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
    private javax.swing.JTextField fieldCantidadProducir;
    private javax.swing.JTextField fieldDescripcion;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JTextField fieldPorcentajeGanancias;
    private javax.swing.JLabel labeTalles;
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelColores;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelGanancia;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labeldiscontinuo;
}
