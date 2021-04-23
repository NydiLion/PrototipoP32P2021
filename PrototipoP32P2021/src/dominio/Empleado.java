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
public class Empleado {
    private String Codigo_Empleado;
    private String Codigo_Tienda;
    private String Nombre_Empleado;
    private String Estado_Empleado;

    public Empleado() {
    }

    public Empleado(String Codigo_Empleado, String Codigo_Tienda, String Nombre_Empleado, String Estado_Empleado) {
        this.Codigo_Empleado = Codigo_Empleado;
        this.Codigo_Tienda = Codigo_Tienda;
        this.Nombre_Empleado = Nombre_Empleado;
        this.Estado_Empleado = Estado_Empleado;
    }

    public String getCodigo_Empleado() {
        return Codigo_Empleado;
    }

    public void setCodigo_Empleado(String Codigo_Empleado) {
        this.Codigo_Empleado = Codigo_Empleado;
    }

    public String getCodigo_Tienda() {
        return Codigo_Tienda;
    }

    public void setCodigo_Tienda(String Codigo_Tienda) {
        this.Codigo_Tienda = Codigo_Tienda;
    }

    public String getNombre_Empleado() {
        return Nombre_Empleado;
    }

    public void setNombre_Empleado(String Nombre_Empleado) {
        this.Nombre_Empleado = Nombre_Empleado;
    }

    public String getEstado_Empleado() {
        return Estado_Empleado;
    }

    public void setEstado_Empleado(String Estado_Empleado) {
        this.Estado_Empleado = Estado_Empleado;
    }

    @Override
    public String toString() {
        return "Empleado{" + "Codigo_Empleado=" + Codigo_Empleado + ", Codigo_Tienda=" + Codigo_Tienda + ", Nombre_Empleado=" + Nombre_Empleado + ", Estado_Empleado=" + Estado_Empleado + '}';
    }
}
