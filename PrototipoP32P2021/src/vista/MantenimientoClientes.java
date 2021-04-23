
package vista;
import datos.ClienteDAO;
import dominio.Clientes;
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
public class MantenimientoClientes extends javax.swing.JInternalFrame {

    /**
     * Creates new form MantenimientoClientes
     */
    
    public void llenadoDeTablas() {
      try {
          DefaultTableModel modelo = new DefaultTableModel();
          modelo.addColumn("Tarjeta");
          modelo.addColumn("Nombre");
          modelo.addColumn("Dpi");
          modelo.addColumn("Telefono"); 
          modelo.addColumn("Dirrecion"); 
          modelo.addColumn("Correo"); 
          
          ClienteDAO TipoTDAO = new ClienteDAO();
          List<Clientes> tipot = TipoTDAO.select();
          TablaClientes.setModel(modelo);
          String[] dato = new String[6];
          for (int i = 0; i < tipot.size(); i++) {
              dato[0] = tipot.get(i).getNumero_Tarjeta();
              dato[1] = tipot.get(i).getNombre_Cliente();
              dato[2] = tipot.get(i).getDpi_Cliente();
              dato[3] = tipot.get(i).getTelefono_Cliente();
              dato[4] = tipot.get(i).getDirreccion_Cliente();
              dato[5] = tipot.get(i).getCorreo_Cliente();
              modelo.addRow(dato);
          }
      } catch (SQLException ex) {
          Logger.getLogger(MantenimientoClientes.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
       public void buscarcliente() {
        Clientes clienteconsultar = new Clientes();
        ClienteDAO clientedao = new ClienteDAO();
        clienteconsultar.setNumero_Tarjeta(Txtbuscar.getText());
        clienteconsultar = clientedao.query(clienteconsultar);
        txtNumTarjeta.setText(clienteconsultar.getNumero_Tarjeta());
        txtNombreC.setText(clienteconsultar.getNombre_Cliente());
        txtDpiC.setText(clienteconsultar.getDpi_Cliente());
        txtTelefonoC.setText(clienteconsultar.getTelefono_Cliente());
        txtDireccionC.setText(clienteconsultar.getDirreccion_Cliente());
        txtCorreoC.setText(clienteconsultar.getCorreo_Cliente());
       
       }
       public void limpiar() {   //metodo de Limpiar automaticamente las cajas de textos 
        txtNumTarjeta.setText("");
        txtNombreC.setText("");
        txtDpiC.setText("");
        txtTelefonoC.setText("");
        txtDireccionC.setText("");
        txtCorreoC.setText("");
        Txtbuscar.setText("");
    }
    public MantenimientoClientes() {
        initComponents();
    

       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNumTarjeta = new javax.swing.JTextField();
        txtNombreC = new javax.swing.JTextField();
        txtDpiC = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        Txtbuscar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTelefonoC = new javax.swing.JTextField();
        txtDireccionC = new javax.swing.JTextField();
        txtCorreoC = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaClientes = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Mantenimiento_Clientes");
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel1.setText("Numero Tarjeta Cliente");

        jLabel2.setText("Nombre Cliente:");

        jLabel3.setText("Dpi Cliente:");

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

        jLabel5.setText("Telefono Cliente:");

        jLabel6.setText("Dirreccion Cliente:");

        jLabel7.setText("Correo Cliente:");

        txtCorreoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNumTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNombreC, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDpiC, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTelefonoC, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(txtDireccionC)
                            .addComponent(txtCorreoC))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardar)
                            .addComponent(btnModificar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar)
                            .addComponent(btnEliminar)
                            .addComponent(Txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNumTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtTelefonoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtDireccionC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDpiC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtCorreoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addGap(18, 18, 18)
                .addComponent(Txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle"));

        TablaClientes.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle"));
        TablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero Tarjeta", "Nombre Cliente", "Dpi Cliente", "Telefono Cliente", "Direccion Cliente", "Correo Cliente"
            }
        ));
        jScrollPane1.setViewportView(TablaClientes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        ClienteDAO clientedao = new ClienteDAO();
        Clientes clienteinsertar = new Clientes();
        
        clienteinsertar.setNumero_Tarjeta(txtNumTarjeta.getText());
        clienteinsertar.setNombre_Cliente(txtNombreC.getText());
        clienteinsertar.setDpi_Cliente(txtDpiC.getText());
        clienteinsertar.setTelefono_Cliente(txtTelefonoC.getText());
        clienteinsertar.setDirreccion_Cliente(txtDireccionC.getText());
        clienteinsertar.setCorreo_Cliente(txtCorreoC.getText());
        clientedao.insert(clienteinsertar);
        llenadoDeTablas();
        limpiar();
        JOptionPane.showMessageDialog(null, "Cliente Ingresado Exitosamente");
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        ClienteDAO clienitedao = new ClienteDAO();
        Clientes clienitemodificar = new Clientes();

        clienitemodificar.setNumero_Tarjeta(Txtbuscar.getText());

        clienitemodificar.setNumero_Tarjeta(txtNumTarjeta.getText());
        clienitemodificar.setNombre_Cliente(txtNombreC.getText());
        clienitemodificar.setDpi_Cliente(txtDpiC.getText());
        clienitemodificar.setTelefono_Cliente(txtTelefonoC.getText());
        clienitemodificar.setDirreccion_Cliente(txtDireccionC.getText());
        clienitemodificar.setCorreo_Cliente(txtCorreoC.getText());
        clienitedao.update(clienitemodificar);
        llenadoDeTablas();
        JOptionPane.showMessageDialog(null, "Cliente Modificado Exitosamente");
        llenadoDeTablas();
        limpiar();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        ClienteDAO clienitedao = new ClienteDAO();
        Clientes clienteelminar = new Clientes();
        clienteelminar.setNumero_Tarjeta((Txtbuscar.getText()));
        clienitedao.delete(clienteelminar);
        llenadoDeTablas();
        limpiar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarcliente();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtCorreoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TablaClientes;
    private javax.swing.JTextField Txtbuscar;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCorreoC;
    private javax.swing.JTextField txtDireccionC;
    private javax.swing.JTextField txtDpiC;
    private javax.swing.JTextField txtNombreC;
    private javax.swing.JTextField txtNumTarjeta;
    private javax.swing.JTextField txtTelefonoC;
    // End of variables declaration//GEN-END:variables
}
