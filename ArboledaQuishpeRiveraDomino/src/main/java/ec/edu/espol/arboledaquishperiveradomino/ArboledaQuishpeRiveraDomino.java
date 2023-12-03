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

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
