/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Oferta {
    private String correo;
    private int valor;
    private String placa;
    private String modelo;
    private String correoComprador;
    
    public Oferta(String correo, int valor, String placa, String modelo, String correoComprador) {
        this.correo = correo;
        this.valor = valor;
        this.placa = placa;
        this.modelo = modelo;
        this.correoComprador = correoComprador;
    }

    public String getCorreo() {
        return correo;
    }

    public int getValor() {
        return valor;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }
    
    
}
