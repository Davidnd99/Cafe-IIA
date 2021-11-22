/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tareas;

import cafe.Slot;
import java.util.ArrayList;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author David
 */
public class Translator {
    
    private Slot entrada;
    private XPathExpression e;
    
    Translator(Slot entrada, XPathExpression e){
        this.entrada = entrada;
        this.e=e;
    }
    
    public ArrayList<String> Realiza() throws XPathExpressionException{
        String dato;
        ArrayList<String> salida = new ArrayList<>();
        while(!entrada.IsEmpty()){
            dato = "";
            //Consultamos
            NodeList nodos = (NodeList) e.evaluate(entrada.Read(), XPathConstants.NODESET);
            //Nos quedamos con el primer elemento de la consulta
            Element elemento = (Element) nodos.item(0);
            //En dato guardamos el nombre del elemento que estamos consultando
            dato = new String(elemento.getElementsByTagName("name").item(0).getTextContent());
            //Lanzamos la consulta
            salida.add(new String("SELECT * FROM Bebidas WHERE Nombre = '" + dato + "'"));
        }
        return salida;
    }
}
