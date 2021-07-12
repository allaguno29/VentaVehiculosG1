/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ListaOfertas {
    private List<Oferta> ofertas = new ArrayList<>();

    public List<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<Oferta> ofertas) {
        this.ofertas = ofertas;
    }
    
    public ListaOfertas filtarOfertasPorVendedor(String correoVendedor){
        ListaOfertas filtrada = new ListaOfertas();
        for(int i=0; i<this.ofertas.size();i++){
            if(this.ofertas.get(i).getCorreo().equals(correoVendedor))
                filtrada.ofertas.add(this.ofertas.get(i));
        }
        return filtrada;
    } 
    public ListaOfertas filtarOfertasPorPlaca(String placa){
        ListaOfertas filtrada = new ListaOfertas();
        for(int i=0; i<this.ofertas.size();i++){
            if(this.ofertas.get(i).getPlaca().equals(placa))
                filtrada.ofertas.add(this.ofertas.get(i));
        }
        return filtrada;
    }
    public void removerOfertas(String placa){
        for(int i=0; i<this.ofertas.size();i++){
            if(this.ofertas.get(i).getPlaca().equals(placa))
                this.ofertas.remove(i);
        }
    }
     
}
