/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Puertos;

import org.w3c.dom.Document;

/**
 *
 * @author David
 */
public class ExitPort {
    
    private Document doc;

    //En el puerto de salida lo que hacemos es leer del documento 
    
    public ExitPort(){
        
    }
    
    public void SetDocument(Document doc){
        //Colocamos en nuestro documento doc los datos del valor pasado por parametro
        this.doc = doc;
    }
    
    public Document Realiza(){
        return doc;
    }
}
