/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.Scanner;

/**
 *
 * @author Ariana Llaguno
 */
public class Comprador {
    private String Nombres;
    private String Apellidos;
    private String Organización;
    private String Correo;
    private String Clave;
    
    public Comprador( String Nombres,String Apellidos, String Organización, String Correo,String Clave){
        this.Nombres= Nombres;
        this.Apellidos= Apellidos;
        this.Organización= Organización;
        this.Correo= Correo;
        this.Clave= Clave;
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

    public String getOrganización() {
        return Organización;
    }

    public void setOrganización(String Organización) {
        this.Organización = Organización;
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
    public boolean equals(Object o){
        if(this==o)
            return true;
        if(o==null)
            return false;
        if(this.getClass()!=o.getClass())
            return false;
        Comprador other=(Comprador)o;
        if(this.Correo==other.Correo) 
            return true ;
        else{
           System.out.println("Usted ya se encuentra regsitrado");  
           return false;
        }
    }

        public static Comprador registrar(Scanner sc,  String nomFile){
            
            System.out.println("Ingrese Nombres: ");
            String Nombres=sc.next();
            System.out.println("Ingrese Apellidos: ");
            String Apellidos=sc.next();
            System.out.println("Ingrese Organizacion: ");
            String Organizacion=sc.next();
            System.out.println("Ingrese Correo");
            String Correo=sc.next();
            System.out.println("Ingrese Clave");
            String Clave=sc.next();
            int id = Util.nextID(nomFile);
            Comprador registrar=new Comprador(id,Nombres,Apellidos,Organizacion,Correo,Clave);
            return registrar;   

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
        
        
        public static void saveFile(ArrayList<Comprador> compradores, String nomFile){
            try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File(nomFile),true))){
            for (Comprador c : compradores)
                pw.println(v.id+"|"+v.Correo+"|"+v.Nombres+"|"+v.Apellidos+"|"+ v.Organizacion+"|"+v.Clave );
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        }
         
      
        public static ArrayList<Comprador> readFile(String nomFile) throws FileNotFoundException{
            ArrayList<Comprador> compradores = new ArrayList<>();
            try(Scanner sc = new Scanner(new File(nomFile))){
                while(sc.hasNextLine())
                {
                    String linea = sc.nextLine();
                    String[] tokens = linea.split("\\|");
                    Comprador c = new Comprador(Integer.parseInt(tokens[0]), tokens[1],tokens[2], tokens[3], tokens[4],tokens[5]);
                    compradores.add(v);
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
            return compradores;
        }
}

