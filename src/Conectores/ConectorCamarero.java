/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conectores;
import Tareas.*;
import Conectores.Conector;
import Puertos.ExitPort;
import cafe.Msg;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
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

    @Override
    public Document Realiza(Document doc){
        
        String c = Serializador.serialize(doc);
        try {
            FileWriter w = new FileWriter("C:\\Users\\David\\OneDrive\\David\\UNIVERSIDAD\\Curso_4\\CUATRIMESTRE_1\\IIA\\Practicas\\Cafe\\src\\cafe\\test.xml");
            w.write(c);
            w.close();
        } catch (IOException ex) {
            Logger.getLogger(ConectorCamarero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

