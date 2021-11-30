/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tareas;

import cafe.Msg;
import cafe.Slot;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author David
 */
public class Distributor {
    private Slot Entrada;
    private Slot Salida1;
    private Slot Salida2;
     private XPathExpression e;

    public Distributor(Slot ent, Slot s1, Slot s2, XPathExpression e) {
        
        Entrada = ent;
        Salida1 = s1;
        Salida2 = s2;
        this.e=e;
    }
    
    public void Realiza() throws XPathExpressionException{
        
        
        while (!Entrada.IsEmpty()) {
             
            Msg m = Entrada.Read();
            
            NodeList nl = (NodeList) e.evaluate(m.getBody(), XPathConstants.NODESET);
            Node nNode = (Node) nl.item(0);
            
            String dato = nNode.getTextContent();

            //Me puedo ahorrar esta linea si en el main hago en la expresion xpath /drink/type
            //dato = new String(datoe.getElementsByTagName("type").item(0).getTextContent());
            if (dato.equals("hot")) {
                Salida1.Write(m);
            } else if (dato.equals("cold")) {
                Salida2.Write(m);
            } else {
                System.out.println("Error en el tipo");
            }
        }
       
    }
}
