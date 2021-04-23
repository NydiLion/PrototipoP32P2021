
package vista;

import datos.EmpleadosDAO;
import datos.TiendasDAO;
import dominio.Empleado;
import dominio.Tiendas;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nay Ale
 */
public class Mantenimiento_Empleado extends javax.swing.JInternalFrame {

    public void llenadoDeCombos() throws SQLException  {
       TiendasDAO tipodao = new TiendasDAO();
      List<Tiendas> tipo = tipodao.select();
      Cbox_CTienda.addItem("Seleccione una opción");
      for (int i = 0; i < tipo.size(); i++) {
           Cbox_CTienda.addItem(tipo.get(i).getCodigo_Tienda());
       }
 }
        public void limpiar() {   //metodo de Limpiar automaticamente las cajas de textos 
        txtCodigoE.setText("");
        txtNombreE.setText("");
        txtEstadoEmpleado.setText("");
        Txtbuscar.setText("");
    }   
      public void llenadoDeTablas() throws SQLException {
       DefaultTableModel modelo = new DefaultTableModel();
       modelo.addColumn("Codigo Empleado");
       modelo.addColumn("Codigo Tienda");
       modelo.addColumn("Nombre Empleado");
       modelo.addColumn("Estado Empleado");
       EmpleadosDAO cuentaDao = new EmpleadosDAO();
       List<Empleado> cuenta = cuentaDao.select();
       TablaEmpleados.setModel(modelo);
       String[] dato = new String[4];
       for (int i = 0; i < cuenta.size(); i++) {
           dato[0] = cuenta.get(i).getCodigo_Empleado();
           dato[1] = cuenta.get(i).getCodigo_Tienda();
           dato[2] = cuenta.get(i).getNombre_Empleado();
           dato[3] = cuenta.get(i).getEstado_Empleado();
           modelo.addRow(dato);
       }
    }
      public void buscarEmpleado(){
        Empleado ConsultarT = new Empleado();
    EmpleadosDAO consultarDao = new EmpleadosDAO();
    ConsultarT.setCodigo_Tienda((Txtbuscar.getText()));
    //-------------------------------------------------------------------
    ConsultarT = consultarDao.query(ConsultarT);
    txtCodigoE.setText(String.valueOf(ConsultarT.getCodigo_Empleado()));
    //Cbox_CTienda.getSelectedItem ConsultarT.getCodigo_Tienda();
    txtNombreE.setText(ConsultarT.getNombre_Empleado());
    txtEstadoEmpleado.setText(ConsultarT.getEstado_Empleado());

}
    /**
     * Creates new form Mantenimiento_Empleado
     */
    public Mantenimiento_Empleado() {
        initComponents();  
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotonEmpleado = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigoE = new javax.swing.JTextField();
        txtNombreE = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        Txtbuscar = new javax.swing.JTextField();
        Cbox_CTienda = new javax.swing.JComboBox<>();
        txtEstadoEmpleado = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        TxtCuenta = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEmpleados = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Mantenimiento_Empleados");
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel1.setText("Codigo Empleado:");

        jLabel2.setText("Codigo Tienda:");

        jLabel3.setText("Nombre Empleado:");

        jLabel4.setText("Estado Empleado:");

        btnGuardar.setBackground(new java.awt.Color(204, 204, 204));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(204, 204, 204));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(204, 204, 204));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jButton3.setText("?");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        TxtCuenta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodigoE, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(Cbox_CTienda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEstadoEmpleado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(216, 216, 216)
                                .addComponent(jButton3))
                            .addComponent(txtNombreE, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnEliminar)
                            .addComponent(btnBuscar)
                            .addComponent(Txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TxtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cbox_CTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3)
                            .addComponent(btnModificar)
                            .addComponent(TxtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(txtNombreE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtEstadoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle"));

        TablaEmpleados.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle"));
        TablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Empleado", "Codigo Tienda", "Nombre Empleado", "Estado Empleado"
            }
        ));
        jScrollPane1.setViewportView(TablaEmpleados);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 589, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        EmpleadosDAO empleadodao = new EmpleadosDAO();
        Empleado insertarEmpleado = new Empleado();
        insertarEmpleado.setCodigo_Empleado(txtCodigoE.getText());
        insertarEmpleado.setCodigo_Tienda(Cbox_CTienda.getSelectedItem().toString());
        insertarEmpleado.setNombre_Empleado(txtNombreE.getText());
        insertarEmpleado.setEstado_Empleado(txtEstadoEmpleado.getText());
        empleadodao.insert(insertarEmpleado);
       try {
       llenadoDeTablas();
       } catch (SQLException ex) {
           Logger.getLogger(Mantenimiento_Empleado.class.getName()).log(Level.SEVERE, null, ex);
       }
        JOptionPane.showMessageDialog(null, "Empleado Ingresado Exitosamente");
       limpiar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        EmpleadosDAO empleadodao = new EmpleadosDAO();
        Empleado EmpleadoModificar = new Empleado();
       
        EmpleadoModificar.setCodigo_Empleado(txtCodigoE.getText());
        EmpleadoModificar.setCodigo_Tienda(Cbox_CTienda.getSelectedItem().toString());
        EmpleadoModificar.setNombre_Empleado(txtNombreE.getText());
        EmpleadoModificar.setEstado_Empleado(txtEstadoEmpleado.getText());        
        empleadodao.update(EmpleadoModificar);
         try {
       llenadoDeTablas();
       } catch (SQLException ex) {
           Logger.getLogger(Mantenimiento_Empleado.class.getName()).log(Level.SEVERE, null, ex);
       }
         JOptionPane.showMessageDialog(null, "Empleado Modificado Exitosamente");
        limpiar();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
         EmpleadosDAO tipodAO = new EmpleadosDAO();
        Empleado tipoEliminar = new Empleado();
        //Metodo Eliminar utilizando el codigo de empleado para eliminarlo de la bd
        tipoEliminar.setCodigo_Empleado((Txtbuscar.getText()));
        tipodAO.delete(tipoEliminar);
       try {
           llenadoDeTablas();
       } catch (SQLException ex) {
           Logger.getLogger(Mantenimiento_Empleado.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        limpiar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarEmpleado();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String val =Cbox_CTienda.getSelectedItem().toString();
        TiendasDAO perfilDAO = new TiendasDAO();
        Tiendas consultar = new Tiendas();
        consultar.setCodigo_Tienda(val);
        consultar=perfilDAO.query(consultar);

        TxtCuenta.setText(consultar.getNombre_Tienda());
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BotonEmpleado;
    private javax.swing.JComboBox<String> Cbox_CTienda;
    public javax.swing.JTable TablaEmpleados;
    private javax.swing.JTextField TxtCuenta;
    private javax.swing.JTextField Txtbuscar;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnModificar;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCodigoE;
    private javax.swing.JTextField txtEstadoEmpleado;
    private javax.swing.JTextField txtNombreE;
    // End of variables declaration//GEN-END:variables
}
