/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author YAMMOK
 */
public class new_pista {
    int numeroCarriles;
    int distanciapista;

    public new_pista() {
        this.numeroCarriles = 0;
        this.distanciapista = 0;
    }

    public new_pista(int numeroCarriles, int distanciapista) {
        this.numeroCarriles = numeroCarriles;
        this.distanciapista = distanciapista;
    }

    public int getNumeroCarriles() {
        return numeroCarriles;
    }

    public void setNumeroCarriles(int numeroCarriles) {
        this.numeroCarriles = numeroCarriles;
    }

    public int getDistanciapista() {
        return distanciapista;
    }

    public void setDistanciapista(int distanciapista) {
        this.distanciapista = distanciapista;
    } 
}
