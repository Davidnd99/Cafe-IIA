/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Puertos;

import Conectores.ConectorComanda;
import cafe.Msg;
import cafe.Slot;
import org.w3c.dom.Document;

/**
 *
 * @author David
 */
public class EntryPort {
    
    private Slot salida;
    private ConectorComanda conector;
    private Msg m;
    
    //En el puerto de entrada lo que hacemos es escribir en el documento
    public EntryPort(Slot salida){
        this.salida = salida;
    }
    
    public void Realiza(Msg m){
        this.m = m;
        salida.Write(m);
    }
    
    public ConectorComanda GetConector(){
        return conector;
    }
}
