/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.Objects;

/**
 *
 * @author Ariana Llaguno
 */
public class Vendedor {
    private String Nombres;
    private String Apellidos;
    private String Organizacion;
    private String Correo;
    private String Clave;

    public Vendedor(String Nombres, String Apellidos, String Organizacion, String Correo, String Clave) {
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Organizacion = Organizacion;
        this.Correo = Correo;
        this.Clave = Clave;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getOrganizacion() {
        return Organizacion;
    }

    public void setOrganizacion(String Organizacion) {
        this.Organizacion = Organizacion;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "Nombres=" + Nombres + ", Apellidos=" + Apellidos + ", Organizacion=" + Organizacion + ", Correo=" + Correo + ", Clave=" + Clave + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.Clave);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vendedor other = (Vendedor) obj;
        if (!Objects.equals(this.Correo, other.Correo)) {
            return false;
        }
        return true;
    }
    
    
   
}
