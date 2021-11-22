/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cafe;

import java.util.LinkedList;
import java.util.Queue;
import org.w3c.dom.Document;

/**
 *
 * @author David
 */
public class Slot {
    
    private Queue<Document> buffer;
    
    Slot(){
        //Lista doblemente enlazada
        buffer = new LinkedList<>();
    }
    
    public void Write(Document doc){
        buffer.add(doc);
    }
    
    public Document Read(){
        //Devolvemos el primer elemento de la cola
        return buffer.poll();
    }
    
    public boolean IsEmpty(){
        return buffer.isEmpty();
    }
    
}
