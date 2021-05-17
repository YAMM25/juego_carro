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
public class new_jugador {
    String nombrejugador;

    public new_jugador(){
        this.nombrejugador = "";
    }
    
    public new_jugador(String nombre){
        this.nombrejugador = nombre;
    }

    public String getNombrejugador() {
        return nombrejugador;
    }

    public void setNombrejugador(String nombrejugador) {
        this.nombrejugador = nombrejugador;
    }
}
