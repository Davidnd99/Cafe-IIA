/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conectores;

import Conectores.Conector;
import Puertos.ExitPort;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 *
 * @author usuario
 */
public class ConectorCamarero extends Conector {

    private ExitPort p;

    ConectorCamarero(ExitPort p) {
        this.p = p;
    }

    @Override
    public void Realiza() {
        try {
            Document d = p.Realiza();
            if (d.equals(null)) {
                System.out.println("error");
            }
            //Estamos utilizando los transformadores propios de java
            //XML transformer to take a DOM document and print out the resulting XML
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            //Separar las etiquetas para que no salgan en una misma linea
            //enable 'INDENT' and set the indent amount for the transformer
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            Node pdoc;
            //Como fuente XML usaremos la clase DOMSource, que se puede instanciar pasándole nuestro Document. 
            //Como destino de la transformación, usaremos un StreamResult, al que pasaremos un File
            DOMSource domSource = new DOMSource(d);
            StreamResult streamResult = new StreamResult(new File("C:\\Users\\David\\OneDrive\\David\\UNIVERSIDAD\\Curso_4\\CUATRIMESTRE_1\\IIA\\Practicas\\Cafe\\src\\cafe\\test.xml"));
            transformer.transform(domSource, streamResult);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(ConectorCamarero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(ConectorCamarero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

