/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tareas;

import cafe.Msg;
import cafe.Slot;
import java.util.UUID;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
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
    private Msg m;

    public Splitter(Slot out, Slot in, XPathExpression e){
        this.out = out;
        this.in = in;
        this.e = e;
    }

    public void Realiza() throws XPathExpressionException, ParserConfigurationException {
        
        m = in.Read();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        NodeList nl = (NodeList) e.evaluate(m.getBody(), XPathConstants.NODESET);
        UUID idFrag = UUID.randomUUID();
        
        for (int i = 0; i < nl.getLength(); i++) {
            Document doc = db.newDocument();
            Msg m2 = new Msg(doc);
            Node nNode = nl.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                m2.setIdFragment(idFrag);
                m2.setDocumentoOriginal(m.getBody());
                m2.setPadreOriginal(nNode.getParentNode());
                m2.setNumFragmentos(nl.getLength());
                doc.appendChild(doc.importNode(nNode, true));
                nNode.getParentNode().removeChild(nNode);
                out.Write(m2);
            }
        }

    }

}
