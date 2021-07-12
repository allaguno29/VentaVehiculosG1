/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Ariana Llaguno
 */
public class Vendedor {
    private int id;
    private String Nombres;
    private String Apellidos;
    private String Organizacion;
    private String Correo;
    private String Clave;

    public Vendedor(int id, String Nombres, String Apellidos, String Organizacion, String Correo, String Clave) {
        this.id = id;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Organizacion = Organizacion;
        this.Correo = Correo;
        this.Clave = Clave;
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
        Vendedor other = (Vendedor) obj;
        if (this.Correo==other.Correo)
            return true;
        else {
            System.out.println("Usted ya se encuentra Registrado:");
            return false;
        }
        
    }
    
        public static void Vendedoregistrar(Scanner sc, String nomFile){
            System.out.println("Ingrese Nombres: ");
            String Nombres=sc.next();
            System.out.println("Ingrese Apellidos: ");
            String Apellidos=sc.next();
            System.out.println("Ingrese Correo electronico: ");
            String CorreoElectronico=sc.next();
            System.out.println("Ingrese Organizacion: ");
            String Organizacion=sc.next();
            System.out.println("Ingrese Correo");
            String Correo=sc.next();
            System.out.println("Ingrese Clave");
            String Clave=sc.next();
            int id = Util.nextID(nomFile);
            Vendedor registrar=new Vendedor(id,Nombres,Apellidos,Organizacion,Correo,Clave);
            registrar.saveFile(nomFile);
        }
        public static boolean verificador(String nomfile,String correo,String password){
        ArrayList<Vendedor> vendedores = Vendedor.readFile(nomfile);
        String c=null;
        try 
        {
            password = Util.toHexString(Util.getSHA(password));
            password = Util.toHexString(Util.getSHA(password));
        }
        catch (NoSuchAlgorithmException e) { 
            System.out.println("Algoritmo Incorrecto: " + e); 
        }
            for(Vendedor vend: vendedores){
                if(vend.Correo.equals(correo)){
                    c=vend.Clave;
                }
            } 
        return password.equals(c);
        }   
        
        //Escribir el archivo
        public void saveFile(String nomFile){
            try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File(nomFile),true))){
            pw.println(this.id+"|"+this.Correo+"|"+this.Nombres+"|"+this.Apellidos+"|"+ this.Organizacion+"|"+this.Clave );
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            
        }
        }
        
        //Consultar informacion
        public static void saveFile(ArrayList<Vendedor> vendedores, String nomFile){
            try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File(nomFile),true))){
            for (Vendedor v : vendedores)
                pw.println(v.id+"|"+v.Correo+"|"+v.Nombres+"|"+v.Apellidos+"|"+ v.Organizacion+"|"+v.Clave );
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        }
         
        //Leer archivo
        public static ArrayList<Vendedor> readFile(String nomFile) throws FileNotFoundException{
            ArrayList<Vendedor> vendedores = new ArrayList<>();
            try(Scanner sc = new Scanner(new File(nomFile))){
                while(sc.hasNextLine())
                {
                    String linea = sc.nextLine();
                    String[] tokens = linea.split("\\|");
                    Vendedor v = new Vendedor(Integer.parseInt(tokens[0]), tokens[1],tokens[2], tokens[3], tokens[4],tokens[5]);
                    vendedores.add(v);
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
            return vendedores;
        }
   
}
