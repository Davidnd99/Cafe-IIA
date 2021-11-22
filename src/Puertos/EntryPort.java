/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Puertos;

import cafe.Slot;
import org.w3c.dom.Document;

/**
 *
 * @author David
 */
public class EntryPort {
    
    private Slot salida;
    private Document doc;
    
    //En el puerto de entrada lo que hacemos es escribir en el documento
    public EntryPort(Slot salida){
        this.salida = salida;
    }
    
    public void Realiza(Document doc){
        this.doc = doc;
        salida.Write(doc);
    }
}
