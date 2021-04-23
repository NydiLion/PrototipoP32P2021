/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Clientes;
import dominio.Conexion;
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
public class ClienteDAO {
    
    
    private static final String sql_select = "SELECT Numero_Tarjeta, Nombre_Cliente, Dpi_Cliente,Dirreccion_Cliente,Correo_Cliente FROM Clientes";
    private static final String sql_insert = "INSERT INTO Clientes VALUES(?,?,?,?,?,?)";
    private static final String sql_update = "UPDATE Clientes SET Numero_Tarjeta=?, Nombre_Cliente=?, Dpi_Cliente=?, Dirreccion_Cliente=?, Correo_Cliente=? WHERE Numero_Tarjeta=?";
    private static final String sql_delete = "DELETE FROM Clientes WHERE Numero_Tarjeta=?";
    private static final String sql_query = "SELECT Numero_Tarjeta, Nombre_Cliente, Dpi_Cliente,Dirreccion_Cliente,Correo_Cliente FROM Clientes WHERE Numero_Tarjeta=?";

    public List<Clientes> select() throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Clientes clientes = null;
        List<Clientes> clientes1 = new ArrayList<Clientes>();

        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql_select);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String Numero_Tarjeta = rs.getString("Numero_Tarjeta");
                String Nombre_Cliente = rs.getString("Nombre_Cliente");
                String Dpi_Cliente = rs.getString("Dpi_Cliente");
                String Telefono_Cliente = rs.getString("Telefono_Cliente");
                String Dirreccion_Cliente = rs.getString("Dirreccion_Cliente");
                String Correo_Cliente = rs.getString("Correo_Cliente");

                clientes = new Clientes();
               clientes.setNumero_Tarjeta(Numero_Tarjeta);
                clientes.setNombre_Cliente(Nombre_Cliente);
                clientes.setDpi_Cliente(Dpi_Cliente);
                clientes.setTelefono_Cliente(Telefono_Cliente);
                clientes.setDirreccion_Cliente(Dirreccion_Cliente);
                clientes.setCorreo_Cliente(Correo_Cliente);
             

                clientes1.add(clientes);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(con);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return clientes1;
    }

    public int insert(Clientes clientes) {
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql_insert);
              stmt.setString(1, clientes.getNumero_Tarjeta());
            stmt.setString(2, clientes.getNombre_Cliente());
            stmt.setString(3, clientes.getDpi_Cliente());
            stmt.setString(4, clientes.getTelefono_Cliente());
            stmt.setString(5, clientes.getDirreccion_Cliente());
            stmt.setString(6, clientes.getCorreo_Cliente());


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

    public int update(Clientes clientes) {
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            con = Conexion.getConnection();
            System.out.println("ejecutando query: " + sql_update);
            stmt = con.prepareStatement(sql_update);
             stmt.setString(1, clientes.getNumero_Tarjeta());
             stmt.setString(2, clientes.getNombre_Cliente());
             stmt.setString(3, clientes.getDpi_Cliente());
            stmt.setString(4, clientes.getTelefono_Cliente());
             stmt.setString(5, clientes.getDirreccion_Cliente());
            stmt.setString(6, clientes.getCorreo_Cliente());

            rows = stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Actualizacion exitosa ");
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(con);
            Conexion.close(stmt);
        }
        return rows;
    }

    public int delete(Clientes clientes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql_delete);
             stmt.setString(1, clientes.getNumero_Tarjeta());
            rows = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alumno Eliminado Con Exito");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public Clientes query(Clientes clientes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Clientes> alumnoss = new ArrayList<Clientes>();
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql_query);
            stmt.setString(1, clientes.getNumero_Tarjeta());
            rs = stmt.executeQuery();
            while (rs.next()) {
              String Numero_Tarjeta = rs.getString("Numero_Tarjeta");
                String Nombre_Cliente = rs.getString("Nombre_Cliente");
                String Dpi_Cliente = rs.getString("Dpi_Cliente");
                String Telefono_Cliente = rs.getString("Telefono_Cliente");
                String Dirreccion_Cliente = rs.getString("Dirreccion_Cliente");
                String Correo_Cliente = rs.getString("Correo_Cliente");

                clientes = new Clientes();
               clientes.setNumero_Tarjeta(Numero_Tarjeta);
                clientes.setNombre_Cliente(Nombre_Cliente);
                clientes.setDpi_Cliente(Dpi_Cliente);
                clientes.setTelefono_Cliente(Telefono_Cliente);
                clientes.setDirreccion_Cliente(Dirreccion_Cliente);
                clientes.setCorreo_Cliente(Correo_Cliente);
                rows++;
            }

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return clientes;
    }
}
