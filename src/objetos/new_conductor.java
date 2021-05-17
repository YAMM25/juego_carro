
package objetos;

import java.util.ArrayList;
import java.util.List;

public class new_conductor {
     private new_jugador condutor;
    private new_carro carroConductor;
    private new_pista pistaCarrera;

    public new_conductor() {
        this.condutor = new new_jugador();
        this.carroConductor = new new_carro();
        this.pistaCarrera = new new_pista();
    }
    
    public void asociarConductorCarro(List<List<String>> a){

        for (int i = 0; i < a.get(0).size(); i++) {
            System.out.println("Jugador "+(i+1)+": nombre: "+a.get(0).get(i)+" - Carro numero: "+a.get(1).get(i)+" - Carril: "+a.get(2).get(i));
        }

    }   
}
