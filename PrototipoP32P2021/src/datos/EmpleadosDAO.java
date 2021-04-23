/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Conexion;
import dominio.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Nay Ale
 */
public class EmpleadosDAO {
    private static final String sql_select = "SELECT Codigo_Empleado, Codigo_Tienda, Nombre_Empleado,Estado_Empleado FROM Empleados";
    private static final String sql_insert = "INSERT INTO Empleados VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE Empleados SET Codigo_Empleado=?, Codigo_Tienda=?, Nombre_Empleado=?,Estado_Empleado=? WHERE Codigo_Empleado = ?";
    private static final String sql_delete = "DELETE FROM Empleados WHERE Codigo_Empleado=?";
    private static final String sql_query = "SELECT Codigo_Empleado, Codigo_Tienda, Nombre_Empleado,Estado_Empleado FROM Empleados WHERE Codigo_Empleado=?";

    public List<Empleado> select() throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Empleado cuenta = null;
        List<Empleado> tipo1 = new ArrayList<Empleado>();

        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql_select);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String Codigo_Empleado = rs.getString("Codigo_Empleado");
                String Codigo_Tienda = rs.getString("Codigo_Tienda");
                String Nombre_Empleado = rs.getString("Nombre_Empleado");
                String Estado_Empleado = rs.getString("Estado_Empleado");
 
                cuenta = new Empleado();
               cuenta.setCodigo_Empleado(Codigo_Empleado);
                cuenta.setCodigo_Tienda(Codigo_Tienda);
                cuenta.setNombre_Empleado(Nombre_Empleado);
                cuenta.setEstado_Empleado(Estado_Empleado);
             

                tipo1.add(cuenta);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(con);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return tipo1;
    }

    public int insert(Empleado cuenta) {
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql_insert);
            stmt.setString(1, cuenta.getCodigo_Empleado());
            stmt.setString(2, cuenta.getCodigo_Tienda());
            stmt.setString(3, cuenta.getNombre_Empleado());
            stmt.setString(4, cuenta.getEstado_Empleado());
            rows = stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(con);
            Conexion.close(stmt);
        }
        return rows;
    }

      public int update(Empleado cuenta){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            //System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
          stmt.setString(1, cuenta.getCodigo_Empleado());
          stmt.setString(2, cuenta.getCodigo_Tienda());
          stmt.setString(3, cuenta.getNombre_Empleado());
          stmt.setString(4, cuenta.getEstado_Empleado());
          stmt.setString(5, cuenta.getCodigo_Empleado());
 
            rows = stmt.executeUpdate();
            //System.out.println("Registros actualizado:" + rows);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }

    public int delete(Empleado cuenta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql_delete);
             stmt.setString(1, cuenta.getCodigo_Empleado());
            rows = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, " Eliminado Con Exito");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public Empleado query(Empleado cuenta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Empleado> tipotr = new ArrayList<Empleado>();
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql_query);
            stmt.setString(1, cuenta.getCodigo_Empleado());
            rs = stmt.executeQuery();
              while (rs.next()) {
                String Codigo_Empleado = rs.getString("Codigo_Empleado");
                String Codigo_Tienda = rs.getString("Codigo_Tienda");
                String Nombre_Empleado = rs.getString("Nombre_Empleado");
                String Estado_Empleado = rs.getString("Estado_Empleado");
 
                cuenta = new Empleado();
               cuenta.setCodigo_Empleado(Codigo_Empleado);
                cuenta.setCodigo_Tienda(Codigo_Tienda);
                cuenta.setNombre_Empleado(Nombre_Empleado);
                cuenta.setEstado_Empleado(Estado_Empleado);
                rows++;
            }

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cuenta;
    }


}
