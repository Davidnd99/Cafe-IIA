/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tareas;

import cafe.Msg;
import cafe.Slot;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author chaim
 */
public class Replicator {

    private Slot Salida1;
    private Slot Salida2;
    private Slot Entrada;

    public Replicator(Slot Entrada, Slot Salida1, Slot Salida2) {
        this.Entrada = Entrada;
        this.Salida1 = Salida1;
        this.Salida2 = Salida2;
    }

    public void Realiza() throws ParserConfigurationException, SAXException, IOException{
        
        while (!Entrada.IsEmpty()) {
            Document d1;
            Document d2;
            Msg aux = Entrada.Read();
            String c = Serializador.serialize(aux.getBody());
            d1 = Parsear.parse(c);
            d2 = Parsear.parse(c);
            Msg m = new Msg(d1);
            m.setIdCorrelator(aux.getIdCorrelator());
            m.setIdFragment(aux.getIdFragment());
            m.setNumFragmentos(aux.getNumFragmentos());
            m.setPadreOriginal(aux.getPadreOriginal());
            m.setDocumentoOriginal(aux.getDocumentoOriginal());
            Msg m2 = new Msg(d2);
            m2.setIdCorrelator(aux.getIdCorrelator());
            m2.setIdFragment(aux.getIdFragment());
            m2.setNumFragmentos(aux.getNumFragmentos());
            m2.setPadreOriginal(aux.getPadreOriginal());
            m2.setDocumentoOriginal(aux.getDocumentoOriginal());
            Salida1.Write(m);
            Salida2.Write(m2);
        }
    }
}

