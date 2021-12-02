/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cafe;
import Conectores.ConectorBC;
import Conectores.ConectorBF;
import Conectores.ConectorCamarero;
import Conectores.ConectorComanda;
import Puertos.EntryPort;
import Puertos.ExitPort;
import Puertos.SolPort;
import Tareas.*;
import Tareas.Aggregator;
import Tareas.Correlator;
import Tareas.Distributor;
import Tareas.Enricher;
import Tareas.Merger;
import Tareas.Replicator;
import Tareas.Splitter;
import Tareas.Translator;
import cafe.Msg;
import java.io.File;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import sun.jvm.hotspot.code.AdapterBlob;

/**
 *
 * @author David
 */
public class Cafe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws XPathExpressionException, ClassNotFoundException, SQLException, ParserConfigurationException, SAXException, IOException {
        // TODO code application logic here
        
        Slot s1 = new Slot();
        Slot s2 = new Slot();
        Slot s3 = new Slot();
        Slot s4 = new Slot();
        Slot s5 = new Slot();
        Slot s6 = new Slot();
        Slot s7 = new Slot();
        Slot s8 = new Slot();
        Slot s9 = new Slot();
        Slot s10 = new Slot();
        Slot s11 = new Slot();
        Slot s12 = new Slot();
        Slot s13 = new Slot();
        
        XPath XPath = XPathFactory.newInstance().newXPath();
            //Buscamos la expresion XPath drink
            //Compila la version XPath especificada
            //y devuelve un objeto XPathExpression que representa la expresion XPath
       
        
        //Definir las carpetas de la comanda y el camarero
        //Comanda
        File DirComanda = new File("C:\\Users\\David\\OneDrive\\David\\UNIVERSIDAD\\Curso_4\\CUATRIMESTRE_1\\IIA\\Practicas\\comandas");
        if (!DirComanda.exists()) {
            if (DirComanda.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
        //Camarero
        File DirCamarero = new File("C:\\Users\\David\\OneDrive\\David\\UNIVERSIDAD\\Curso_4\\CUATRIMESTRE_1\\IIA\\Practicas\\camarero");
        if (!DirCamarero.exists()) {
            if (DirCamarero.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
        
        //Crear conexion MySQL bebida caliente 
        OracleConnection con = new OracleConnection('C');
        
        //Crear conexion MySQL bebida fria
        OracleConnection con2 = new OracleConnection('F');
        
        XPathExpression e = XPath.compile("/cafe_order/drinks/drink");
        Splitter sp = new Splitter(s2, s1, e);
        
        //XPathExpression e2 = XPath.compile();
        //Distributor dis = new Distributor(s2, s3, s4, e2);
        
        Replicator r = new Replicator(s3, s5, s6);
        
        //Translator t = new Translator(s5, s7, );
        
        //Correlator c = new Correlator();
        
        //Enricher e = new Enricher(s7, s8, s9);
        
        Merger m = new Merger(s10, s11, s12);
        
        Aggregator ag = new Aggregator(s13);
        
        //Declaraciones 
        /*Slot s1 = new Slot();
        Slot s2 = new Slot();
        Slot s3 = new Slot();
        Slot s4 = new Slot();
        Slot s5 = new Slot();
        Slot s6 = new Slot();
        Slot s7 = new Slot();
        Slot s8 = new Slot();
        Slot s9 = new Slot();
        Slot s10 = new Slot();
        Slot s11 = new Slot();
        Slot s12 = new Slot();
        Slot s13 = new Slot();
        Slot s14 = new Slot();
        Slot s15 = new Slot();
        Slot s16 = new Slot();
        Slot s17 = new Slot();
        Distributor dis = new Distributor(s2, s3, s4, e);
        EntryPort ep = new EntryPort(s1);
        ConectorComanda cc = new ConectorComanda(ep);
        Replicator RC = new Replicator(s3, s5, s6);
        Replicator RF = new Replicator(s4, s7, s8);
        Translator TC = new Translator(s6);
        Translator TF = new Translator(s8);
        SolPort pf = new SolPort(TF, s9);
        SolPort pc = new SolPort(TC, s10);
        ConectorBC conbc = new ConectorBC(pc);
        ConectorBF conbf = new ConectorBF(pf);
        Correlator Correlatorc = new Correlator(s5, s11, s10, s12);
        Correlator Correlatorf = new Correlator(s7, s13, s9, s14);
        Enricher cec = new Enricher(s11, s12, s15, e);
        Enricher cef = new Enricher(s13, s14, s16, e);
        Merger merg = new Merger(s15, s16, s17);
        ExitPort sal = new ExitPort();
        Aggregator agregador = new Aggregator(s17, sal, e);
        ConectorCamarero ccam = new ConectorCamarero(sal);
        //Arranca
        cc.Realiza();
        Splitter split = new Splitter(s2, s1, e);
        split.Realiza();
        dis.Realiza();
        RC.Realiza();
        RF.Realiza();
        conbf.Realiza();
        conbc.Realiza();
        Correlatorc.Realiza();
        Correlatorf.Realiza();
        cec.Realiza();
        cef.Realiza();
        merg.Realiza();
        agregador.Realiza();
        ccam.Realiza();*/
        
        /*Tareas reunidor = p.createTask(MERGER);
        Task arrejuntador = p.createTask(AGGREGATOR, new String[]{"cafe_order", "drinks"});
        
        p.connect(pComandas, divisor);
        p.connect(divisor, encauzador);
        p.connect(encauzador, replicadorFrio);
        p.connect(encauzador, replicadorCaliente);
        
        p.connect(replicadorFrio, traductorQuerryFrio);
        p.connect(traductorQuerryFrio, pBarmanFrio);
        p.connect(replicadorFrio, juntadorFrio);
        p.connect(pBarmanFrio, traductorResultadoFrio);
        p.connect(traductorResultadoFrio, juntadorFrio);
        p.connect(juntadorFrio, combinadorFrio);
        p.connect(juntadorFrio, combinadorFrio);
        p.connect(combinadorFrio, reunidor);
        
        p.connect(replicadorCaliente, traductorQuerryCaliente);
        p.connect(traductorQuerryCaliente, pBarmanCaliente);
        p.connect(replicadorCaliente, juntadorCaliente);
        p.connect(pBarmanCaliente, traductorResultadoCaliente);
        p.connect(traductorResultadoCaliente, juntadorCaliente);
        p.connect(juntadorCaliente, combinadorCaliente);
        p.connect(juntadorCaliente, combinadorCaliente);
        p.connect(combinadorCaliente, reunidor);
        
        p.connect(reunidor, arrejuntador);
        p.connect(arrejuntador, pCamarero);
        
        
        p.validate();
        p.execute();
        p.waitToEnd();*/
        
    }
    
}
