/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

/**
 *
 * @author Ariana Llaguno
 */
public class Comprador {
    private String Nombres;
    private String Apellidos;
    private String CorreoElectrónico;
    private String Organización;
    private String Correo;
    private String Clave;
    
    public Comprador( String Nombres,String Apellidos,String CorreoElectrónico, String Organización, String Correo,String Clave){
        this.Nombres= Nombres;
        this.Apellidos= Apellidos;
        this.CorreoElectrónico= CorreoElectrónico;
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

    public String getCorreoElectrónico() {
        return CorreoElectrónico;
    }

    public void setCorreoElectrónico(String CorreoElectrónico) {
        this.CorreoElectrónico = CorreoElectrónico;
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

        public static Comprador registrar(Scanner sc){
            
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
            Comprador registrar=new Comprador(Nombres,Apellidos,CorreoElectronico,Organizacion,Correo,Clave);
            return registrar;   

        }
}

