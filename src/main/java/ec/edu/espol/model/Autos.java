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
public class Autos extends Vehiculo{
    private String vidrios;
    private String transmision;
    
    public Autos (int id,String placa, String marca, String modelo, String tipomotor, String ano, String recorrido, String color, String tipocomb, String precio, String tipovehi,String vidrios,String transmision){
        super(id,placa, marca,  modelo,  tipomotor, ano, recorrido, color, tipocomb,  precio,  tipovehi);
        this.vidrios = vidrios;
        this.transmision = transmision;
    }
}
