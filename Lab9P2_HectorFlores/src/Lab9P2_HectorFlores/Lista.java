/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab9P2_HectorFlores;

/**
 *
 * @author hecto
 */
public class Lista {
    Nodo cabeza;
    
    public Lista (){
        cabeza = null;
    }
    
    public void add(Cancion cancion){
        
        
        
        
        Nodo nuevo = new Nodo (cancion);
        
        if (cabeza == null){
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null){
                actual = actual.siguiente;
            }
            
            actual.siguiente = nuevo;
        }
    }
    
    public String printInfo(){
        Nodo actual = cabeza;
        
        String accum = "Lista:\n";
        
        while (actual != null){
            accum += actual.cancion.toString() + "\n";
            actual = actual.siguiente;
        }
        
        return accum;
    }
    
    public String printName(){
        Nodo actual = cabeza;
        
        String accum = "Lista:\n";
        
        while (actual != null){
            accum += actual.cancion.getSongName() + "\n";
            actual = actual.siguiente;
        }
        
        return accum;
    }
    
    public Cancion buscarNodo(String cancion){
        Nodo actual = cabeza;
        while (actual != null){
            if (actual.cancion.songName.equals(cancion)){
                return actual.cancion;
            }
            
            actual = actual.siguiente;
        }
        
        return null;
    }
}
