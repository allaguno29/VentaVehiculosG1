/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.ventavehiculosg1;


import java.util.Scanner;

/**
 *
 * @author Ariana Llaguno
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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



