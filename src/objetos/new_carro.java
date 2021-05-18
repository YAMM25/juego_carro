
package objetos;


public class new_carro {
      int numeroCarro;
      
    //Inicialializando variables
    public new_carro() {
        this.numeroCarro = -1;
    }
    //asignando valor
    public new_carro(int numero) {
        this.numeroCarro = numero;
    }

    public int getNumeroCarro() {
        return numeroCarro;
    }

    public void setNumeroCarro(int numeroCarro) {
        this.numeroCarro = numeroCarro;
    }
    
    //método para lanzar dado y avance del carro
    public int avanzar(){
        int dado = (int)(Math.random()*6+1);
        int avenceCarro = dado*100;
        return avenceCarro;
    }
    
}
