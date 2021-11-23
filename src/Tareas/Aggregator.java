/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tareas;

import Puertos.ExitPort;
import cafe.Slot;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
public class Aggregator {
    
    private Slot Entrada;
    private ExitPort ep;
     private XPathExpression e;

    Aggregator(Slot s, ExitPort p, XPathExpression e) {
        Entrada = s;
        ep = p;
        this.e=e;
    }

    public void doWork() throws ParserConfigurationException, XPathExpressionException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();
        Element rootElement = doc.createElement("cafe_order");
        doc.appendChild(rootElement);
        while (!Entrada.IsEmpty()) {
            NodeList nl = (NodeList) e.evaluate(Entrada.Read(), XPathConstants.NODESET);
            Node nNode = nl.item(0);
            rootElement.appendChild(doc.importNode(nNode, true));
        }

        ep.SetDocument(doc);
    }
    
}
