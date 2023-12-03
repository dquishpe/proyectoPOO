/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.arboledaquishperiveradomino;

import java.util.Scanner;

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
    
    public ArrayList<Ficha> getLineaJuego(){
        return jugadores;
    }
    
    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }
    
    public void agregarJugador(String nombre){
        Jugador j = new Jugador(nombre, Utilitaria.crearManoJugador());
        jugadores.add(j);
    }
    
    public int obtenerValorInicioLinea(){
        return lineaJuego.get(0).getLado1();
    }
    
    public int obtenerValorFinLinea(){
        return lineaJuego.get(lineaJuego.size()-1).getLado2();
    }
    
    public void mostrarLinea(){
        if(!lineaJuego.isEmpty()){
            StringBuilder sb = new StringBuilder();
            
            for (int i=0; i < lineaJuego.size()-1; i++){
                sb.append(lineaJuego.get(i).toString()).append(" - ");
            }
            sb.append(lineaJuego.get(lineaJuego.size()-1).toString());
            System.out.println(sb.toString());
        }
    }
    
    public boolean agregarFichaLinea(Ficha f, Jugador j){
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        
        if(j instanceof JugadorMaquina){
            if (f instanceof FichaComodin fComodin){
                if (lineaJuego.isEmpty()){
                
                }
            }
        }
    }
    
}
