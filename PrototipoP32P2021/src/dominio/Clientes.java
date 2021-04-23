/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author Nay Ale
 */
public class Clientes {
    
  private String Numero_Tarjeta;
  private String Nombre_Cliente;
  private String Dpi_Cliente;
  private String Telefono_Cliente;
  private String Dirreccion_Cliente;       
  private String Correo_Cliente; 

    public Clientes() {
    }

    public Clientes(String Numero_Tarjeta, String Nombre_Cliente, String Dpi_Cliente, String Telefono_Cliente, String Dirreccion_Cliente, String Correo_Cliente) {
        this.Numero_Tarjeta = Numero_Tarjeta;
        this.Nombre_Cliente = Nombre_Cliente;
        this.Dpi_Cliente = Dpi_Cliente;
        this.Telefono_Cliente = Telefono_Cliente;
        this.Dirreccion_Cliente = Dirreccion_Cliente;
        this.Correo_Cliente = Correo_Cliente;
    }

    public String getNumero_Tarjeta() {
        return Numero_Tarjeta;
    }

    public void setNumero_Tarjeta(String Numero_Tarjeta) {
        this.Numero_Tarjeta = Numero_Tarjeta;
    }

    public String getNombre_Cliente() {
        return Nombre_Cliente;
    }

    public void setNombre_Cliente(String Nombre_Cliente) {
        this.Nombre_Cliente = Nombre_Cliente;
    }

    public String getDpi_Cliente() {
        return Dpi_Cliente;
    }

    public void setDpi_Cliente(String Dpi_Cliente) {
        this.Dpi_Cliente = Dpi_Cliente;
    }

    public String getTelefono_Cliente() {
        return Telefono_Cliente;
    }

    public void setTelefono_Cliente(String Telefono_Cliente) {
        this.Telefono_Cliente = Telefono_Cliente;
    }

    public String getDirreccion_Cliente() {
        return Dirreccion_Cliente;
    }

    public void setDirreccion_Cliente(String Dirreccion_Cliente) {
        this.Dirreccion_Cliente = Dirreccion_Cliente;
    }

    public String getCorreo_Cliente() {
        return Correo_Cliente;
    }

    public void setCorreo_Cliente(String Correo_Cliente) {
        this.Correo_Cliente = Correo_Cliente;
    }

    @Override
    public String toString() {
        return "Clientes{" + "Numero_Tarjeta=" + Numero_Tarjeta + ", Nombre_Cliente=" + Nombre_Cliente + ", Dpi_Cliente=" + Dpi_Cliente + ", Telefono_Cliente=" + Telefono_Cliente + ", Dirreccion_Cliente=" + Dirreccion_Cliente + ", Correo_Cliente=" + Correo_Cliente + '}';
    }
    
}
