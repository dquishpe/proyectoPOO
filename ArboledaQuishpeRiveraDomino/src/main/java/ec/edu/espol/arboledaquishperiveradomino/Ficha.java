/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.arboledaquishperiveradomino;

/**
 *
 * @author domen
 */
public class Ficha {
      protected int lado1;
    protected int lado2;
    
    public Ficha(int lado1, int lado2){
        this.lado1 = lado1;
        this.lado2 = lado2;
    }
    
    public int getLado1(){
        return lado1;
    }
    
    public int getLado2(){
        return lado2;
    }
    
    @Override
    public String toString(){
        return lado1 + ":" + lado2;
    }    
    
}
