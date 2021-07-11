/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Ariana Llaguno
 */
public class Usuario {
    private String Nombres;
    private String Apellidos;
    private String Organizacion;
    private String Correo;
    private String Clave;
    

    public Usuario(int id, String Nombres, String Apellidos, String Organizacion, String Correo) {
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Organizacion = Organizacion;
        this.Correo = Correo;
    }

    public boolean validarUsuario(String Clave){
        return (this.Clave.equals(Clave));
    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.Clave);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.Correo, other.Correo)) {
            return false;
        }
        return true;
    }
    
    public static void nextUsuario(Scanner sc, String nomfile){
        System.out.println("Ingresar Nombres:");
        String nombres = sc.next();
        System.out.println("Ingresar Apellidos:");
        String apellidos = sc.next();
        System.out.println("Ingresar Correo Electronico:");
        String correo = sc.next();
        System.out.println("Ingresar Clave:");
        String clave = sc.next();
        int id = Util.nextID(nomfile);
        Usuario us = new Usuario(id,clave,nombres,apellidos,correo);
        us.saveFile(nomfile);
    
    }
    public void saveFile(String nomfile){
        try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File(nomfile),true))){
            pw.println(this.id+"|"+this.Clave +"|"+this.Correo+"|"+this.Apellidos+"|"+this.Nombres+"|"+this.Organizacion);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            
        }
    }
  
}
