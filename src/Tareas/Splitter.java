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
 * @author chaim
 */
public class Splitter {

    private XPathExpression e;
    private Slot in;
    private Slot out;
    private Document d;

    public Splitter(Slot out, Slot in, XPathExpression e) {
        this.out = out;
        this.in = in;
        this.d = in.Read();
        this.e = e;

    }

    public void Realiza() throws XPathExpressionException, ParserConfigurationException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        NodeList nl = (NodeList) e.evaluate(d, XPathConstants.NODESET);

        for (int i = 0; i < nl.getLength(); i++) {
            Node nNode = nl.item(i);
            Document doc = db.newDocument();
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               
                doc.appendChild( doc.importNode(nNode, true));
                out.Write(doc);
            }
        }

    }

}
