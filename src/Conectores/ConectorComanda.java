/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conectores;

import Conectores.Conector;
import Puertos.EntryPort;
import cafe.Msg;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author David
 */
public class ConectorComanda extends Conector{
    
    private EntryPort p;

    public ConectorComanda(EntryPort p) {
        this.p = p;
    }
    
    @Override
    public void Realiza() throws ParserConfigurationException, SAXException, IOException {
        
        File inputFile = new File("C:\\Users\\David\\OneDrive\\David\\UNIVERSIDAD\\Curso_4\\CUATRIMESTRE_1\\IIA\\Practicas\\Cafe\\src\\cafe\\order1.xml");

        //Defines a factory API that enables applications to obtain a parser that produces DOM object trees from XML documents.
        //Con este objeto podemos obtener una instacia de document builder el cual nos permite crear el document 
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        //Cambiamos el formato de XML a DOC con el parse
        Document doc = (Document) db.parse(inputFile);
        
        doc.getDocumentElement().normalize();
        Msg m = new Msg(doc);
        p.Realiza(m);
    }
}
