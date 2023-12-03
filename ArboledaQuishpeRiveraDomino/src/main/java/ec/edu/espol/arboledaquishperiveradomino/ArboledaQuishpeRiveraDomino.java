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
            jugador.posibilidades(juego);
            System.out.println("Posibilidades: " + jugador.posibilidades);
            if (jugador.posibilidades > 0 ){
                for (Ficha f: jugador.manoJugador){
                    if (Jugador.posibleFichaLinea(f, juego)){
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
        System.out.print("Ingrese el nombre del jugador: ");
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
        
        else System.out.println("Empate entre los jugadores: "+ jugador.getNombre()+ " y " + maquina.getNombre);
      
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
