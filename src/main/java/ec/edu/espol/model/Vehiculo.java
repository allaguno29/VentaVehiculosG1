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
public class Vehiculo {

    private int id;
    private String placa;
    private String marca;
    private String modelo;
    private String tipomotor;
    private String ano;
    private String recorrido;
    private String color;
    private String tipocomb;
    private String precio;
    private String tipovehi;

    public Vehiculo(int id, String placa, String marca, String modelo, String tipomotor, String ano, String recorrido, String color, String tipocomb, String precio, String tipovehi) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipomotor = tipomotor;
        this.ano = ano;
        this.recorrido = recorrido;
        this.color = color;
        this.tipocomb = tipocomb;
        this.precio = precio;
        this.tipovehi = tipovehi;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.placa);
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
        Vehiculo other = (Vehiculo) obj;
        if (this.placa == other.placa) {
            return true;
        } else {
            System.out.println("Placa ya existente");
            return false;
        }
    }

  

    public static void Vehiculoregistrar(Scanner sc, String nomFile) {
        Validacion val = new Validacion();
        System.out.println("Ingrese la placa del vehiculo: ");
        String placa = sc.next();
        System.out.println("Ingrese la marca del vehiculo:");
        String marca = sc.next();
        System.out.println("Ingrese el modelo del vehiculo: ");
        String modelo = sc.next();
        System.out.println("Ingrese el tipo de motor del vehiculo: ");
        String tipomotor = sc.next();
        System.out.println("Ingrese el año del vehiculo:");
        String ano = sc.next();
        System.out.println("Ingrese el recorrido del vehiculo:");
        String recorrido = sc.next();
        System.out.println("Ingrese el color del vehiculo:: ");
        String color = sc.next();
        System.out.println("Ingrese el tipo de combustible del vehiculo:");
        String tipocomb = sc.next();
        System.out.println("Ingrese el precio del vehiculo:");
        String precio = sc.next();
        System.out.println("Seleccione el tipo de vehiculo:");
        System.out.println("1.Auto");
        System.out.println("2.Camioneta");
        System.out.println("3.Moto");
        System.out.print("Ingresar Opcion: ");
        String tipovehi = sc.next();
        int tipo = val.validaOpcion(tipovehi);
        if (tipo == 1) {
            System.out.println("Ingrese tipo de vidrios del vehiculo:");
            String vidrios = sc.next();
            System.out.println("Ingrese la transmision del vehiculo:");
            String transmision = sc.next();
            int id = Util.nextID(nomFile);
            Vehiculo registrar = new Autos(id, placa, marca, modelo, tipomotor, ano, recorrido, color, tipocomb, precio, tipovehi, vidrios, transmision);
            registrar.saveFile(nomFile);
        }
        if (tipo == 2) {
            System.out.println("Ingrese tipo de vidrios del vehiculo:");
            String vidrios = sc.next();
            System.out.println("Ingrese la transmision del vehiculo:");
            String transmision = sc.next();
            System.out.println("Ingrese la traccion del vehiculo:");
            String traccion = sc.next();
            int id = Util.nextID(nomFile);
            Vehiculo registrar = new Camionetas(id, placa, marca, modelo, tipomotor, ano, recorrido, color, tipocomb, precio, tipovehi, vidrios, transmision, traccion);
            registrar.saveFile(nomFile);
        }
        if (tipo == 3) {

            int id = Util.nextID(nomFile);
            Vehiculo registrar = new Motos(id, placa, marca, modelo, tipomotor, ano, recorrido, color, tipocomb, precio, tipovehi);
            registrar.saveFile(nomFile);
        }

    }

    public void saveFile(String nomFile) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomFile), true))) {
            pw.println(this.id + "|" + this.placa + "|" + this.modelo + "|" + this.tipomotor + "|" + this.ano + "|" + this.recorrido + "|" + this.color + "|" + this.tipocomb + "|" + this.precio + "|" + this.tipovehi);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
<<<<<<< HEAD
    }

    //Consultar informacion
    public static void saveFile(ArrayList<Vehiculo> vehiculos, String nomFile) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomFile), true))) {
            for (Vehiculo vh : vehiculos) {
                pw.println(vh.id + "|" + vh.placa + "|" + vh.modelo + "|" + vh.tipomotor + "|" + vh.ano + "|" + vh.recorrido + "|" + vh.color + "|" + vh.tipocomb + "|" + vh.precio + "|" + vh.tipovehi);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Leer archivo
    public static ArrayList<Vehiculo> readFile(String nomFile) throws FileNotFoundException {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(nomFile))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Vehiculo vh = new Vehiculo(Integer.parseInt(tokens[0]), tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6], tokens[7], tokens[8], tokens[9], tokens[10]);
                vehiculos.add(vh);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return vehiculos;
    }
=======
	public String getPlaca() {
            return placa;
        }

        public String getMarca() {
            return marca;
        }

        public String getModelo() {
            return modelo;
        }

        public String getTipomotor() {
            return tipomotor;
        }

        public String getAno() {
            return ano;
        }

        public String getRecorrido() {
            return recorrido;
        }

        public String getColor() {
            return color;
        }

        public String getTipocomb() {
            return tipocomb;
        }

        public String getPrecio() {
            return precio;
        }

        public String getTipovehi() {
            return tipovehi;
        }

>>>>>>> 80f2b390789e368d18b0a6998c7421d5e8703153
}
