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
public class Camionetas extends Vehiculo{
    private String traccion;
    private String vidrios;
    private String transmision;
    
    public Camionetas(int id,String traccion,String placa, String marca, String modelo, String tipomotor, String ano, String recorrido, String color, String tipocomb, String precio, String tipovehi, String vidrios, String transmision){
        super(id,placa, marca,  modelo, tipomotor, ano, recorrido,color, tipocomb,  precio, tipovehi);
        this.traccion = traccion;
        this.transmision = transmision;
        this.vidrios = vidrios;
                
    }
    
}
