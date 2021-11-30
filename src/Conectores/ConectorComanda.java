/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conectores;

import Conectores.Conector;
import Puertos.EntryPort;
import Tareas.Parsear;
import cafe.Msg;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
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
    private String dir;
    
    public ConectorComanda(EntryPort p, String dir) {
        this.p = p;
        this.dir = dir;
    }
    
    @Override
    public Document Realiza(Document doc) throws ParserConfigurationException, SAXException, IOException {
        
        File directory = new File(dir);
        File[] files = directory.listFiles();
        
        if(files.length > 0){
            File file = files[0];
            String c = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
            file.delete();
            return Parsear.parse(c);
        }
        
        return null;
    }
}
