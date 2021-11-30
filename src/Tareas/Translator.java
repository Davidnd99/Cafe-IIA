/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tareas;

import cafe.Msg;
import cafe.Slot;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author David
 */
public class Translator {
    
    private Slot entrada;
    private Slot salida;
    private String estilo;
    
    public Translator(Slot entrada, Slot salida, String estilo){
        this.entrada = entrada;
        this.estilo = estilo;
    }
    
    public void Realiza() throws XPathExpressionException, TransformerException, ParserConfigurationException, SAXException, IOException{
        
        while(!entrada.IsEmpty()){
            
            Msg m = entrada.Read();
            Source xslt = new StreamSource(new StringReader(estilo));
            Source xml = new StreamSource(new StringReader(Serializador.serialize(m.getBody()))); //Dónde body es el Document serializado

            StringWriter outWriter = new StringWriter();
            StreamResult out = new StreamResult(outWriter);
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(xslt);
            transformer.transform(xml, out);
            StringBuffer sb = outWriter.getBuffer();
            sb.toString(); // El String de salda que debe ser parseado a Document.
            
            m.setBody(Parsear.parse(sb.toString()));
            salida.Write(m);
        }
    }
}
