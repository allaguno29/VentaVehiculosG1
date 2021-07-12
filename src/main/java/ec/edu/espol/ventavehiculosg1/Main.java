/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.ventavehiculosg1;

import ec.edu.espol.model.Autos;
import ec.edu.espol.model.Camionetas;
import ec.edu.espol.model.Comprador;
import ec.edu.espol.model.ListaOfertas;
import ec.edu.espol.model.Motos;
import ec.edu.espol.model.Oferta;
import ec.edu.espol.model.Vehiculo;

import java.util.Scanner;

/**
 *
 * @author Ariana Llaguno
 */
public class Main {
    Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    public static boolean verificarPlaca(String placa){
        String[] placaDividida = placa.split("-");
        boolean e = true;
        if (placaDividida[0].length()!=3){
            System.out.println("Error de ingreso de placa");
            e = false;
        }
        if (placaDividida[1].length()>4 && placaDividida[1].length()<3){
            System.out.println("Error de ingreso de placa");
            e  = false;
        }
        return e;
     }
     public static boolean validarInt(int valor,int max, int min){
        boolean e = true;
        if (valor<min){
            System.out.println("Error de ingreso");
            e = false;
        }
        if (valor>max){
            System.out.println("Error de ingreso");
            e = false;
        }
        return e;
    }
    public void menu(){
        String opcion="";
	
       
        while(!opcion.equals("3")){
              System.out.println("╔                Menu                  ╗");
              System.out.println("║ 1. Vendedor                          ║");
              System.out.println("║ 2. Comprador                         ║");
              System.out.println("║ 3. Salir                             ║");
              System.out.println("╚                                      ╝");
              System.out.print("Ingrese opcion: ");      
              opcion = sc.nextLine();
            switch (opcion){
                case "1":
                    String opcion1 = "";
                     while(!opcion1.equals("4")){
                         System.out.println("╔                Menu                         ╗");
                         System.out.println("║ 1. Registrar un nuevo vendedor              ║");
                         System.out.println("║ 2. Ingresar un nuevo vehículo               ║");
                         System.out.println("║ 3. Aceptar oferta                           ║");
                         System.out.println("║ 4. Regresar                                 ║");
                         System.out.println("╚                                             ╝");
                         System.out.print("Ingrese opcion: ");      
                         opcion1 = sc.nextLine();
                        switch (opcion1){
                            case "1":
                                
                                System.out.println("Nuevo Vendedor Registrado!");
                                break;
                            case "2":
                                System.out.println("Nuevo Vehiculo Ingresado!");
                                break;
                            case "3":
				    Scanner sc = new Scanner(System.in);
                                    System.out.println("Ingrese su correo: ");
                                    String mail = sc.nextLine();
                                    System.out.println("Ingrese su clave: ");
                                    String clave = sc.nextLine();
                                    // verificar clave
                                    ListaOfertas ofertasParaVendedor = lista.filtarOfertasPorVendedor(mail);
                                    System.out.println("Ingrese la placa (formato AAA-000): ");
                                    String placa = sc.nextLine();
                                    verificarPlaca(placa);
                                    ListaOfertas ofertasPorPlaca = ofertasParaVendedor.filtarOfertasPorPlaca(placa);
                                    if (verificarPlaca(placa)){  
                                        System.out.println(ofertasPorPlaca.getOfertas().get(0).getModelo() +"Precio: ");            
                                        System.out.println("Se han realizado "+ ofertasPorPlaca.getOfertas().size()+ " ofertas");
                                        for(int i=0; i< ofertasPorPlaca.getOfertas().size();){
                                            System.out.println("Oferta "+ (i+1));
                                            System.out.println("Correo: "+ ofertasPorPlaca.getOfertas().get(i).getCorreo());
                                            System.out.println("Precio Ofertado: "+ ofertasPorPlaca.getOfertas().get(i).getValor());
                                            if(i<=0){
                                                System.out.println("1. Siguiente Oferta\n2. Aceptar Oferta");
                                                int ingreso = sc.nextInt();
                                                if(ingreso == 1 && validarInt(ingreso,2,1)){
                                                    i++;
                                                }
                                                if(ingreso == 2 && validarInt(ingreso,2,1)){
                                                    //mandar correo
                                                    //elimnar vehiculo del sistema
                                                    lista.removerOfertas(placa);

                                                }                    
                                            }
                                            else {
                                                System.out.println("1. Siguiente Oferta\n2. Anterior Oferta\n3. Aceptar Oferta");
                                                int ingreso = sc.nextInt();
                                                if(ingreso == 1 && validarInt(ingreso,3,1)){
                                                    i++;
                                                }
                                                if(ingreso == 2 && validarInt(ingreso,3,1)){
                                                    i--;
                                                }
                                                if(ingreso == 3 && validarInt(ingreso,3,1)){
                                                    //mandar correo 
                                                    //eliminar vehiculo
                                                    lista.removerOfertas(placa);
                                                }
                                            }

                                        }
                                    }
                                }
                                System.out.println("Oferta Aceptada");
                                break;
                            case "4":   
                                break;
                        }
                     }
                    break;
                    
                case "2":
                     String opcion2 = "";
                     while(!opcion2.equals("2")){
                         System.out.println("╔                Menu                         ╗");
                         System.out.println("║ 1. Registrar un nuevo comprador             ║");
                         System.out.println("║ 2. Oferta por un vehículo                   ║");
                         System.out.println("╚                                             ╝");
                         System.out.print("Ingrese opcion: ");      
                         opcion2 = sc.nextLine();
                        switch (opcion2){
                            case "1":
                                System.out.println("Nuevo Comprador Registrado!");
                                break;
                            case "2":
				
                                System.out.println("Oferta Aceptada");
                                break;
                        }
                     }
                     break;
                case"3":
                    System.out.println("Gracias por elegirnos");
                    break;
   
                default:
                    System.out.println("Opcion No valida!!");
            }
        }
        sc.close();
    }
}



