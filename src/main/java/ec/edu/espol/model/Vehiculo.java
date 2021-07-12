/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Ariana Llaguno
 */
public class Vehiculo{
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

    public Vehiculo(String placa, String marca, String modelo, String tipomotor, String ano, String recorrido, String color, String tipocomb, String precio, String tipovehi) {
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
        if(this.placa==other.placa) 
            return true ;
        else{
           System.out.println("Placa ya existente");  
           return false;
        }
    }

        public static Vehiculo registrar(Scanner sc, String nomFile){
            System.out.println("Ingrese la placa del vehiculo: ");
            String placa =sc.next();
            System.out.println("Ingrese la marca del vehiculo:");
            String marca=sc.next();
            System.out.println("Ingrese el modelo del vehiculo: ");
            String modelo=sc.next();
            System.out.println("Ingrese el tipo de motor del vehiculo: ");
            String tipomotor=sc.next();
            System.out.println("Ingrese el año del vehiculo:");
            String ano=sc.next();
            System.out.println("Ingrese el recorrido del vehiculo:");
            String recorrido=sc.next();
            System.out.println("Ingrese el color del vehiculo:: ");
            String color=sc.next();
            System.out.println("Ingrese el tipo de combustible del vehiculo:");
            String tipocomb=sc.next();
            System.out.println("Ingrese el precio del vehiculo:");
            String precio=sc.next();
            System.out.println("Ingrese el tipo de vehiculo:");
            String tipovehi=sc.next();
            int id = Util.nextID(nomFile);
            Vehiculo registrar=new Vehiculo(placa,marca,modelo,tipomotor,ano,recorrido,color,tipocomb,precio,tipovehi);
            return registrar; 
        }
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

}
