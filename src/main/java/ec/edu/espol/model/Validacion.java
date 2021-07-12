
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
public class Validacion {

    Scanner sc = new Scanner(System.in);

    public boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public int validaOpcion(String op) {
        while (true) {
            if (this.isNumeric(op)) {
                int opcion = Integer.parseInt(op);
                if (opcion == 1 | opcion == 2 | opcion == 3) {
                    return opcion;

                } else {
                    System.out.println("Seleccione el tipo de vehiculo:");
                    System.out.println("1.Auto");
                    System.out.println("2.Camioneta");
                    System.out.println("3.Moto");
                    System.out.print("Ingresar Opcion: ");
                    op = sc.nextLine();
                }
            } else {
                System.out.println("Ingrese una opcion valida");
                System.out.println("1.Auto");
                System.out.println("2.Camioneta");
                System.out.println("3.Moto");
                System.out.print("Ingresar Opcion: ");
                op = sc.nextLine();
            }
        }
        }

    }
