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
import javax.xml.transform.TransformerException;
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
    public static void main(String[] args) throws XPathExpressionException, ClassNotFoundException, SQLException, ParserConfigurationException, SAXException, IOException, TransformerException {
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
        Slot s14 = new Slot();
        Slot s15 = new Slot();
        Slot s16 = new Slot();
        Slot s17 = new Slot();
        Slot s18 = new Slot();
        Slot s19 = new Slot();
        
        XPath XPath = XPathFactory.newInstance().newXPath();
        
        //Definir las carpetas de la comanda y el camarero
        //Comanda
        File DirComanda = new File("C:\\Users\\David\\Desktop\\comandas");
        String dir = DirComanda.toString();
        if (!DirComanda.exists()) {
            if (DirComanda.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
        //Camarero
        File DirCamarero = new File("C:\\Users\\David\\Desktop\\camarero");
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
        
        EntryPort ep = new EntryPort(s1);
        ConectorComanda cc = new ConectorComanda(ep, dir);
        ep.GetConector();
        /*XPathExpression e = XPath.compile("/cafe_order/drinks/drink");
        Splitter sp = new Splitter(s2, s1, e);*/
        
        XPathExpression e2 = XPath.compile("/drink/type");
        Distributor dis = new Distributor(s2, s3, s4, e2);
        
        //PARTE BEBIDA CALIENTE
        Replicator r = new Replicator(s3, s5, s6);
        
        //Para hacer la Query 
        Translator t = new Translator(s5, s7, "<?xml version=\"1.0\"?><xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\"><xsl:template match=\"/drink\">"
                + "<sql>SELECT `Stock` FROM `HotDrinks` WHERE `Name` = '<xsl:value-of select=\"name\"/>'</sql>"
                + "</xsl:template></xsl:stylesheet>");
        
        SolPort sp1 = new SolPort(s7, s18);
        ConectorBC conbc = new ConectorBC(sp1);
        
        Correlator c = new Correlator(s6, s8, s18, s9);
        
        XPathExpression e3 = XPath.compile("drink");
        Enricher en = new Enricher(s8, s9, s10, e3);
        
        
        //PARTE BEBIDA FRIA
        Replicator r2 = new Replicator(s4, s11, s12);
        
        //Para hacer la Query 
        Translator t2 = new Translator(s11, s13, "<?xml version=\"1.0\"?><xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\"><xsl:template match=\"/drink\">"
                + "<sql>SELECT `Stock` FROM `ColdDrinks` WHERE `Name` = '<xsl:value-of select=\"name\"/>'</sql>"
                + "</xsl:template></xsl:stylesheet>");
        
        SolPort sp2 = new SolPort(s13, s19);
        ConectorBF conbf = new ConectorBF(sp2);
        
        Correlator c2 = new Correlator(s12, s14, s19, s15);
        
        XPathExpression e4 = XPath.compile("drink");
        Enricher en2 = new Enricher(s14, s15, s16, e4);
        
        Merger m = new Merger(s10, s16, s17);
        
        ConectorCamarero ccam = new ConectorCamarero();
        ExitPort p = new ExitPort(ccam);
        XPathExpression e5 = XPath.compile("drink");
        Aggregator ag = new Aggregator(s17, p, e5);
        
        XPathExpression e = XPath.compile("/cafe_order/drinks/drink");
        
        cc.Realiza(null);
        Splitter sp = new Splitter(s2, s1, e);
        sp.Realiza();
        dis.Realiza();
        r.Realiza();
        r2.Realiza();
        t.Realiza();
        t2.Realiza();
        conbf.Realiza(null);
        conbc.Realiza(null);
        c.Realiza();
        c2.Realiza();
        en.Realiza();
        en2.Realiza();
        m.Realiza();
        ag.Realiza();
        
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
