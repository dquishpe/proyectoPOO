/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.arboledaquishperiveradomino;

import java.util.ArrayList;

/**
 *
 * @author PERSONAL
 */
class Jugador {
    String nombre;
    ArrayList<Ficha> manoJugador;
    int posibilidades;
    
    public Jugador(){}
    
    public Jugador(String nombre, ArrayList<Ficha> manoJugador){
        this.nombre = nombre;
        this.manoJugador = manoJugador;
    }
    
    public Jugador(String nombre){
        this(nombre, Utilitaria.crearManoJugador());
    }
    
    public Ficha getFicha(int indice){
        if (indice >= 0 && indice < manoJugador.size()){
            return manoJugador.get(indice);
        }
        else return null;
    }
    
    public void removerFicha(Ficha f){
        if (manoJugador.contains(f)){
            manoJugador.remove(f);
        }
    }

    public String getNombre() {
        return nombre;
    }
    
    public void imprimirMano(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < manoJugador.size()-1; i++ ){
            Ficha f = manoJugador.get(i);
            sb.append(f.getLado1()).append(":").append(f.getLado2()).append(" - ");
        }
        Ficha fFinal = manoJugador.get(manoJugador.size()-1);
        sb.append(fFinal.getLado1()).append(":").append(fFinal.getLado2());
        System.out.println(sb.toString());
    }
    
    /*
    public static boolean posibleFichaAFicha(Ficha f1, Ficha f2){
       return (f1.getLado1() == f2.getLado2() || f1.getLado2() == f2.getLado1());
    }
    */
    
    public static boolean posibleFichaALinea(Ficha f, Juego j){
        if (j.getLineaJuego().isEmpty()) return true;
        else if (f instanceof FichaComodin) return true;
        else return (f.getLado1() == j.obtenerValorFinLinea() || f.getLado2() == j.obtenerValorInicioLinea());           
    }
    
    public void posibilidades(Juego j){     
        for (Ficha fJugador : manoJugador){
            if (posibleFichaALinea(fJugador, j)){
                    posibilidades += 1;
                }
            }
        }
       
}


