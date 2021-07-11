/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.Objects;

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
        final Vehiculo other = (Vehiculo) obj;
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        return true;
    }
    
    
}
