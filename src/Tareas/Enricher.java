/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tareas;

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
public class Enricher {

    private Slot in1;
    private Slot in2;
    private Slot out;
    private XPathExpression e;

    public Enricher(Slot in1, Slot in2, Slot out, XPathExpression e) {
        this.in1 = in1;
        this.in2 = in2;
        this.out = out;
        this.e = e;
    }

    public void Realiza() throws ParserConfigurationException, XPathExpressionException {

        String nombre = null;
        String tipo = null;
        String stock = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        while (!in1.IsEmpty() && !in2.IsEmpty()) {
            Document doc = db.newDocument();
            NodeList nl1 = (NodeList) e.evaluate(in1.Read(), XPathConstants.NODESET);
            NodeList nl2 = (NodeList) e.evaluate(in2.Read(), XPathConstants.NODESET);
            Node nNode = (Node) nl1.item(0);
            Node nNodes = (Node) nl2.item(0);
           
            Element rootElement = doc.createElement("drink");
            doc.appendChild(rootElement);
           rootElement.appendChild(doc.importNode(nNode, true));
            rootElement.appendChild(doc.importNode(nNodes, true));

            out.Write(doc);
        }

    }

}