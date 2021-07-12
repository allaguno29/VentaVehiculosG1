/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.ventavehiculosg1;


import java.util.Scanner;
import ec.edu.espol.model.Autos;
import ec.edu.espol.model.Camionetas;
import ec.edu.espol.model.Comprador;
import ec.edu.espol.model.ListaOfertas;
import ec.edu.espol.model.Motos;
import ec.edu.espol.model.Oferta;
import ec.edu.espol.model.Validacion;
import ec.edu.espol.model.Vehiculo;
import ec.edu.espol.model.Vendedor;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ariana Llaguno
 */
public class Main {
    Scanner sc = new Scanner(System.in);
    Validacion val = new Validacion();

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
        Main m = new Main();
        m.menu();
    }
    
    public static boolean verificarPlaca(String placa){
        String[] placaDividida = placa.split("-");
        boolean e = true;
        if (placaDividida[0].length() != 3) {
            System.out.println("Error de ingreso de placa");
            e = false;
        }
        if (placaDividida[1].length() > 4 && placaDividida[1].length() < 3) {
            System.out.println("Error de ingreso de placa");
            e = false;
        }
        return e;
    }

    public static boolean validarInt(int valor, int max, int min) {
        boolean e = true;
        if (valor < min) {
            System.out.println("Error de ingreso");
            e = false;
        }
        if (valor > max) {
            System.out.println("Error de ingreso");
            e = false;
        }
        return e;
    }

/**
     * @param tipo
     * @param parametro
     * @param lista
     * @param args the command line arguments
     * @return 
     */
    public static List filtrar(String tipo, String parametro, List<Vehiculo> lista){
        List filtrada = new ArrayList<>();
        for(int i=0; i<lista.size();i++){
            if (tipo.equals("marca") && !"0".equals(parametro))
                if(lista.get(i).getMarca().equals(parametro))
                    filtrada.add(lista.get(i));
            if (tipo.equals("recorrido") && !"0".equals(parametro))
                if(lista.get(i).getRecorrido().equals(parametro))
                    filtrada.add(lista.get(i));
            if (tipo.equals("año") && !"0".equals(parametro))
                if(lista.get(i).getAno().equals(parametro))
                    filtrada.add(lista.get(i));
            if (tipo.equals("precio") && !"0".equals(parametro))
                if(lista.get(i).getPrecio().equals(parametro))
                    filtrada.add(lista.get(i));
        }
        return filtrada;
    }
     public static List crearLista(String archivo) throws FileNotFoundException, IOException{
        String vehiculo;
        List<Vehiculo> vehiculos = new ArrayList<>();
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((vehiculo = b.readLine())!=null) {
            String[] v = vehiculo.split(",");
            Vehiculo vH = new Vehiculo(v[0], v[1], v[2],v[3],v[4],v[5],v[6],v[7],v[8],v[9],v[10]);
            vehiculos.add(vH);
        }
        b.close();
        return vehiculos;
    }
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
                    while (!opcion1.equals("4")) {
                        System.out.println("╔                Menu                         ╗");
                        System.out.println("║ 1. Registrar un nuevo vendedor              ║");
                        System.out.println("║ 2. Ingresar un nuevo vehículo               ║");
                        System.out.println("║ 3. Aceptar oferta                           ║");
                        System.out.println("║ 4. Regresar                                 ║");
                        System.out.println("╚                                             ╝");
                        System.out.print("Ingrese opcion: ");
                        opcion1 = sc.nextLine();
                        switch (opcion1) {
                            case "1":
                                Vendedor.Vendedoregistrar(sc, "vendedor,txt");
                                System.out.println("Nuevo Vendedor Registrado!");
                                break;
                            case "2":
                                Vehiculo.Vehiculoregistrar(sc,"Vehiculo,txt");
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
                                if (verificarPlaca(placa)) {
                                    System.out.println(ofertasPorPlaca.getOfertas().get(0).getModelo() + "Precio: ");
                                    System.out.println("Se han realizado " + ofertasPorPlaca.getOfertas().size() + " ofertas");
                                    for (int i = 0; i < ofertasPorPlaca.getOfertas().size();) {
                                        System.out.println("Oferta " + (i + 1));
                                        System.out.println("Correo: " + ofertasPorPlaca.getOfertas().get(i).getCorreo());
                                        System.out.println("Precio Ofertado: " + ofertasPorPlaca.getOfertas().get(i).getValor());
                                        if (i <= 0) {
                                            System.out.println("1. Siguiente Oferta\n2. Aceptar Oferta");
                                            int ingreso = sc.nextInt();
                                            if (ingreso == 1 && validarInt(ingreso, 2, 1)) {
                                                i++;
                                            }
                                            if (ingreso == 2 && validarInt(ingreso, 2, 1)) {
                                                //mandar correo
                                                //elimnar vehiculo del sistema
                                                lista.removerOfertas(placa);

                                            }
                                        } else {
                                            System.out.println("1. Siguiente Oferta\n2. Anterior Oferta\n3. Aceptar Oferta");
                                            int ingreso = sc.nextInt();
                                            if (ingreso == 1 && validarInt(ingreso, 3, 1)) {
                                                i++;
                                            }
                                            if (ingreso == 2 && validarInt(ingreso, 3, 1)) {
                                                i--;
                                            }
                                            if (ingreso == 3 && validarInt(ingreso, 3, 1)) {
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
                                Comprador.Compradoregistrar(sc,"comprador,txt");
                                System.out.println("Nuevo Comprador Registrado!");
                                break;
                            case "2":
				String archivo = "archivoVehiculos.txt";
                                    List<Vehiculo> vehiculos = crearLista(archivo);
                                    Scanner sc = new Scanner(System.in);
                                    System.out.println("Ingrese criterios de busqueda del carro que desea\n (Si el criterio no es necesario ingrese 0)");
                                    System.out.println("Tipo de vehiculo (Marca): ");
                                    String marca = sc.nextLine();
                                    vehiculos = filtrar("marca",marca,vehiculos);
                                    System.out.println("Recorrido:");
                                    String recorridoMax = sc.nextLine();
                                    vehiculos = filtrar("recorrido",recorridoMax,vehiculos);
                                    System.out.println("Año: ");
                                    String añoMax = sc.nextLine();
                                    vehiculos = filtrar("año",añoMax,vehiculos);
                                    System.out.println("Precio: ");
                                    String precioMax = sc.nextLine();
                                    vehiculos = filtrar("recorrido",precioMax,vehiculos);
                                    //
                                    for(int i=0; i< vehiculos.size();){
                                        System.out.println("Vehiculo 1 "+ (i+1));
                                        //System.out.println("Correo: "+ ofertasPorPlaca.getOfertas().get(i).getCorreo());
                                        //System.out.println("Precio Ofertado: "+ ofertasPorPlaca.getOfertas().get(i).getValor());
                                        if(i<=0){
                                            System.out.println("1. Siguiente Oferta\n2. Aceptar Oferta");
                                            if(sc.nextInt()== 1){
                                                i++;
                                            }
                                            if(sc.nextInt()==2){
                                                //mandar correo
                                                //elimnar vehiculo del sistema
                                                lista.removerOfertas(placa);

                                            }                    
                                        }
                                        else {
                                            System.out.println("1. Siguiente Oferta\n2. Anterior Oferta\n3. Aceptar Oferta");
                                            if(sc.nextInt()== 1){
                                                i++;
                                            }
                                            if(sc.nextInt()==2){
                                                i--;
                                            }
                                            if(sc.nextInt()==3){
                                                //mandar correo 
                                                //eliminar vehiculo
                                                lista.removerOfertas(placa);
                                            }
                                        }
                                    //}
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
    sc.close ();
}
