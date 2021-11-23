/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tareas;

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
        
        Document d;
        String dato ="";
        while (!Entrada.IsEmpty()) {
            
            d = Entrada.Read();
           
            NodeList nl = (NodeList) e.evaluate(d, XPathConstants.NODESET);
            Node nNode = (Node) nl.item(0);
            Element datoe = (Element) nNode;

            dato = new String(datoe.getElementsByTagName("type").item(0).getTextContent());
            if (dato.equals("hot")) {
                Salida1.Write(d);
            } else if (dato.equals("cold")) {
                Salida2.Write(d);
            } else {
                System.out.println("Error en el tipo");
            }
        }
       
    }
}
