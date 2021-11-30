/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tareas;

import cafe.Msg;
import com.sun.org.apache.xml.internal.security.utils.XMLUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 *
 * @author David
 */
public class Unir {
    
    public static Msg join(Msg[] messages){
        
        Document doc = messages[0].getDocumentoOriginal();
        for (Msg message : messages) {
            Node newChild = message.getBody().getFirstChild();
            Node imported = doc.importNode(newChild, true);
            message.getPadreOriginal().appendChild(imported);
        }
        
        Msg message = new Msg(doc);
       
        return message;
    }

}
