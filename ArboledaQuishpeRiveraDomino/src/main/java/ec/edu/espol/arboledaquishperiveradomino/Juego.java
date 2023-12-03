/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.arboledaquishperiveradomino;

/**
 *
 * @author spupi
 */
public class Juego {
    private ArrayList<Ficha> lineaJuego;
    private ArrayList<Jugador> jugadores;
    
    public Juego(){
        lineaJuego = new ArrayList<>();
        jugadores = new ArrayList<>();
    }
    
    public void setLineaJuego(ArrayList<Ficha> lineaJuego){
        this.lineaJuego = lineaJuego;
    }
    
    public void setJugadores(JugadorMaquina maquina){
        if (jugadores.size() < 2){
            jugadores.add(maquina);
        }
    }
    
    public void setJugadores (String nombre){
        if (jugadores.size() < 2){
            jugadores.add(new Jugador(nombre));
        }      
    }
}
