/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tareas;

import Puertos.ExitPort;
import cafe.Msg;
import cafe.Slot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
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
    private Slot Salida;
    private ExitPort ep;
    private XPathExpression e;
    private Map<UUID, List<Msg>> mapa=new HashMap<>();

    public Aggregator(Slot s, ExitPort p, XPathExpression e) {
        Entrada = s;
        ep = p;
        this.e=e;
    }

    public void Realiza() throws ParserConfigurationException, XPathExpressionException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();
        Element rootElement = doc.createElement("cafe_order");
        doc.appendChild(rootElement);
        while(!Entrada.IsEmpty()){
            
            Msg m=Entrada.Read();
            List<Msg> lista=mapa.get(m.getIdFragment());
            if(lista==null){
                lista=new ArrayList<>();
                mapa.put(m.getIdFragment(), lista);
            }
            lista.add(m);
        }
        
        for (Map.Entry<UUID, List<Msg>> entry : mapa.entrySet()) {
            UUID key = entry.getKey();
            List<Msg> val = entry.getValue();
            if(val.get(0).getNumFragmentos() == val.size()){
                ep.Realiza(Unir.join(val.toArray(new Msg[0])));
            }
        }
        
    }
    
}
