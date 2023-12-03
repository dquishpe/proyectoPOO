/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.arboledaquishperiveradomino;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author PERSONAL
 */
public class Utilitaria {
    public static ArrayList<Ficha> crearManoJugador(){
        ArrayList<Ficha> mano= new ArrayList<>();
        for (int i=0; i<5; i++){
            Random rd = new Random();
            int lado1= rd.nextInt(7);
            int lado2= rd.nextInt(7);
            Ficha f= new Ficha(lado1, lado2);
            mano.add(f);           
        }
        mano.add(new FichaComodin());
        return mano;
    }
}
