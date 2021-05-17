
package juego_carro;

import objetos.datos;
import objetos.new_carro;
import objetos.new_conductor;
import objetos.new_jugador;
import objetos.new_pista;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ejecutar {
    public static void main(String[] args){
        
        Scanner s = new Scanner(System.in);
        new_conductor conductor_carro = new new_conductor();
        List<List<String>> listaJugadores = new ArrayList<List<String>>();
        List<List<Integer>> listaCarrera = new ArrayList<List<Integer>>();
        List<List<String>> listaranking = new ArrayList<List<String>>();
        List<List<Integer>> listaContadorAvance = new ArrayList<List<Integer>>();
        new_jugador conductor = new new_jugador();
        datos a = new datos();
        new_carro carro = new new_carro();
        new_pista pista = new new_pista();
        int distPistaMetros = 0;
        boolean band1 = false;
        boolean band2 = false;
        boolean band3 = false;
        int contador = 0,sw=0;
        int totalAvance = 0;
        String Nom1="", Nom2="", Nom3="";
        
        

        
        //menu
        int opcion = -1;
        
        do{
            opcion = menu();
            int contaIntro = 0;
            
            switch(opcion){
                case 1:

                    String nombrejugador = "";
                    int numJugadores = 0;
                            
                    while(numJugadores<3){
                        System.out.print("Numero de jugadores: ");
                        numJugadores = s.nextInt();
                        if(numJugadores<3)
                            System.out.println("El numero de jugadores debe ser mayor o igual a 3");                     
                    }
                    
                    
                    System.out.print("Digite la distancia de la pista (kilometros): ");
                    int distanciaPista = s.nextInt();
                    pista.setDistanciapista(distanciaPista);
                    
                    distPistaMetros = distanciaPista*1000;
                    
                    System.out.println("El numero de carriles a sido configurado de acuerdo al numero de jugadores\n");               
                    
                    for (int i = 0; i < 4; i++) {
                        listaJugadores.add(new ArrayList<String>());
                    }
                    
                    for (int i = 0; i < numJugadores; i++) {
                        
                        System.out.print("Nombre del jugador "+ (i+1) +": ");
                        nombrejugador = s.next();
                        conductor.setNombrejugador(nombrejugador);
                        carro.setNumeroCarro(i+1);
                        pista.setNumeroCarriles(i+1);
                                        
                        listaJugadores.get(0).add(conductor.getNombrejugador());
                        listaJugadores.get(1).add(Integer.toString(carro.getNumeroCarro()));
                        listaJugadores.get(2).add(Integer.toString(pista.getNumeroCarriles()));
                        listaJugadores.get(3).add(Integer.toString(pista.getDistanciapista()));

                    }
                    
                    System.out.println("\nConductore y Posiciones listas\n");
                    System.out.println("================================================================");
                    conductor_carro.asociarConductorCarro(listaJugadores);
                    System.out.println("================================================================");

                    
                    for (int i = 0; i < 3; i++) {
                        listaCarrera.add(new ArrayList<Integer>());
                    }
                    
                    for (int i = 0; i < 2; i++) {
                        listaContadorAvance.add(new ArrayList<Integer>());
                    }
                    
                    for (int i = 0; i < listaJugadores.get(0).size(); i++) {
                        listaContadorAvance.get(0).add(0);
                    }

                    
                    
                    int j ;  
                    while (totalAvance<distPistaMetros) {
                        
                        for (j = 0; j < listaJugadores.get(0).size(); j++) {
                            int contadorAvance = 0;
                            int numCarro = j+1;
                            int avance = carro.avanzar();
                            totalAvance = listaContadorAvance.get(0).get(j)+avance;

                            listaContadorAvance.get(0).set(j,totalAvance);
                            listaCarrera.get(0).add(numCarro);
                            listaCarrera.get(1).add(avance);
                            listaCarrera.get(2).add(totalAvance);
                                                                                  
                        }
                    }
                    System.out.println("\nComienzo y avance de los carros en la pista\n");
                    System.out.println("================================================================");
                    for (int i = 0; i < listaCarrera.get(0).size(); i++) {
                        System.out.println("El carro "+listaCarrera.get(0).get(i)+
                                " hizo un avance de "+listaCarrera.get(1).get(i)+
                                " metros - su avance total es: "+listaCarrera.get(2).get(i)+" metros.");
                    }
                    System.out.println("================================================================");
                    //Buscar

                   for (int k = 0; k < listaCarrera.get(0).size(); k++) {
                        if(contaIntro<=3 && listaCarrera.get(2).get(k) >= distPistaMetros){
                            //String ranking = Integer.toString(listaCarrera.get(2).get(k));
                            contaIntro++;
                            if(contaIntro==1){
                                String lineas = "Primer puesto: carro "+listaCarrera.get(0).get(k)+"";
                                a.escribirArchivo(lineas);
                            }
                            if(contaIntro==2){
                                String lineas = "Segundo puesto: carro "+listaCarrera.get(0).get(k)+"";
                                a.escribirArchivo(lineas);
                            }
                            if(contaIntro==3){
                                String lineas = "Tercer puesto: carro "+listaCarrera.get(0).get(k)+"";
                                a.escribirArchivo(lineas);
                            }

                            //a.escribirArchivo(ranking);
                            //System.out.println("Datos guardados exitosamente");
                        }
                    }
                    a.escribirArchivo("\n");
                    System.out.println("La competencia a terminado, revise los resultados en la opcion 2 del menu.\n");
                    break;
                    
                case 2:
                    a.leeFichero();
                   /* System.out.println("Primer puesto: carro "+Nom1);
                    System.out.println("Segundo puesto: carro "+Nom2);
                    System.out.println("Tercer puesto: carro "+Nom3);*/
                    break;
                    
                case 3:
                    System.out.println("Gracias por jugar");
                    break;
                    
                default:
                    System.out.println("Opcion no valida, intente nuevamente");
                    break;
            }
                   
        }while(opcion!=3);
        
        
        
    }
    
    public static int menu(){
        Scanner s = new Scanner(System.in);
        System.out.println("\n\t BIENVENIDOS AL JUEGO DE CARROS");
        System.out.println("\n MENU DE OPCIONES");
        System.out.println("1. Iniciar carrera");
        System.out.println("2. Mostrar Resultados");
        System.out.println("3. Salir");
        System.out.print("Escriba su opcion: ");
        int opcion = s.nextInt();
        System.out.println("");
        return opcion;
    } 
}
