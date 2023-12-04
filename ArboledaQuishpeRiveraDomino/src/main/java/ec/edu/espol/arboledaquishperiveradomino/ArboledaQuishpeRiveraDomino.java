/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.arboledaquishperiveradomino;

import java.util.Scanner;

/**
 *
 * @author spupi
 */
public class ArboledaQuishpeRiveraDomino {
    
    public static void turno(Jugador jugador, Juego juego, Scanner sc){
        
        if (jugador instanceof JugadorMaquina){
            System.out.print("Jugador " + jugador.getNombre()+ ": Mano -> ");
            jugador.imprimirMano();
            System.out.print("Línea de juego: ");
            juego.mostrarLinea();
            jugador.posibilidades= 0;
            jugador.posibilidades(juego);
            System.out.println("Posibilidades: " + jugador.posibilidades);
            if (jugador.posibilidades > 0 ){
                for (Ficha f: jugador.manoJugador){
                    if (Jugador.posibleFichaALinea(f, juego)){
                        juego.agregarFichaLinea(f,jugador);
                        System.out.println("Movimiento válido");
                        break;
                    }
                }
            } 
            else System.out.println("Movimiento no válido");
            System.out.print("Nueva Línea de juego: ");
            juego.mostrarLinea();
        }
        else {
            System.out.print("Jugador " + jugador.getNombre()+ ": Mano -> ");
            jugador.imprimirMano();
            System.out.print("Línea de juego: ");
            juego.mostrarLinea();
            jugador.posibilidades= 0;
            jugador.posibilidades(juego);
            System.out.println("Posibilidades: " + jugador.posibilidades);
            System.out.print("Índice de ficha para jugar (0 es el primero): ");
            int indice= sc.nextInt();
            boolean valido= false;
            if (indice < jugador.manoJugador.size()){
                valido = juego.agregarFichaLinea(jugador.getFicha(indice), jugador);           
            }
            if (valido) System.out.println("Movimiento válido");
            else System.out.println("Movimiento no válido");
            System.out.print("Nueva Línea de juego: ");
            juego.mostrarLinea();          
        }
        
    }
    
    public static void modo1(Juego juego, Scanner sc){
        System.out.print("Ingrese el nombre del jugador #1: ");
        String nombrej= sc.next();
        juego.setJugadores(nombrej);
        Jugador jugador= juego.getJugadores().get(0);
        JugadorMaquina maquina = new JugadorMaquina();
        juego.setJugadores(maquina);
        jugador.posibilidades = 6;
        maquina.posibilidades = 6;
        
        while (!jugador.manoJugador.isEmpty()&&!maquina.manoJugador.isEmpty()&&(!((jugador.posibilidades==0)&&(maquina.posibilidades==0)))){
            turno(jugador, juego, sc);
            turno(maquina,juego, sc);
        }
        
        if (jugador.manoJugador.size() < maquina.manoJugador.size())
            System.out.println("Ganó el jugador #1: "+ jugador.getNombre());
        
        else if (jugador.manoJugador.size() > maquina.manoJugador.size())
            
            System.out.println("Ganó el jugador #2: "+ maquina.getNombre());
        
        else System.out.println("Empate entre los jugadores: "+ jugador.getNombre()+ " y " + maquina.getNombre());
      
    }
    
    public static void modo2(Juego juego, Scanner sc){
        System.out.print("Ingrese el nombre del jugador #1: ");
        String nombrej1= sc.next();
        juego.setJugadores(nombrej1);
        System.out.print("Ingrese el nombre del jugador #2: ");
        String nombrej2= sc.next();
        juego.setJugadores(nombrej2);
        
        Jugador jugador1= juego.getJugadores().get(0);
        Jugador jugador2= juego.getJugadores().get(1);
        
        jugador1.posibilidades =6;
        jugador2.posibilidades= 6;
        
        while (!jugador1.manoJugador.isEmpty()&&!jugador2.manoJugador.isEmpty()&&(!((jugador1.posibilidades==0)&&(jugador2.posibilidades==0)))){
            turno(jugador1, juego, sc);
            turno(jugador2,juego, sc);
        }
        
        if (jugador1.manoJugador.size() < jugador2.manoJugador.size())
            System.out.println("Ganó el jugador #1: "+ jugador1.getNombre());
        
        else if (jugador1.manoJugador.size() > jugador2.manoJugador.size())
            System.out.println("Ganó el jugador #2: "+ jugador2.getNombre());
        
        else System.out.println("Empate entre los jugadores: "+ jugador1.getNombre()+ " y " + jugador2.getNombre());     
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        sc.useDelimiter("\n");
        Juego juego= new Juego();
        System.out.print("Bienvenido al juego DOMINO\n Escoja el modo de juego (escriba 1 o 2) \n 1. Jugador vs Máquina \n 2. Jugador 1 vs Jugador 2\n Modo: ");
        int modo = sc.nextInt();
        
        while (!(modo==1 || modo ==2)){
            System.out.print("Opción no válida. (Escriba 1 o 2): ");
            modo= sc.nextInt();
        }
        
        if (modo==1){
            ArboledaQuishpeRiveraDomino.modo1(juego, sc);
        }
        
        else if (modo==2){
            ArboledaQuishpeRiveraDomino.modo2(juego, sc);
        }
    }
}
