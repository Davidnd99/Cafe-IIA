/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Puertos;

import Conectores.ConectorCamarero;
import cafe.Msg;
import cafe.Slot;
import org.w3c.dom.Document;

/**
 *
 * @author David
 */
public class ExitPort {
    
    private Msg m;
    private ConectorCamarero conector;
    private Slot entrada;

    //En el puerto de salida lo que hacemos es leer del documento 
    
    public ExitPort(){
        
    }
    
    public void SetMsg(Msg m){
        //Colocamos en nuestro documento doc los datos del valor pasado por parametro
        this.m = m;
    }
    
    public Msg Realiza(){
        m = entrada.Read();
        return m;
    }
}
