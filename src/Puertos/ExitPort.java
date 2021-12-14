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

    private ConectorCamarero conector;

    //En el puerto de salida lo que hacemos es leer del documento 
    
    public ExitPort(ConectorCamarero cc){
        this.conector = cc;
    }
    
    
    public void Realiza(Msg m){
       conector.Realiza(m.getBody());
    }
}
