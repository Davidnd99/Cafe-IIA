/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Puertos;

import Conectores.ConectorBC;
import Conectores.ConectorBF;
import Tareas.Translator;
import cafe.Msg;
import cafe.Slot;
import java.util.ArrayList;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.Document;

/**
 *
 * @author David
 */
public class SolPort {
    
    private Translator t;
    private Slot salida;
    private ConectorBC BC;
    private ConectorBF BF;
    
    public SolPort(Translator t, Slot salida){
        this.t = t;
        this.salida = salida;
    }
    
    public ArrayList<String> Realiza1() throws XPathExpressionException, TransformerException{
        //Devuelve la sentencia XPath haciendo uso del traductor
        return t.Realiza();
    }
    
    public void Realiza2(Document doc){
        Msg m = new Msg(doc);
        salida.Write(m);
    }
    
}
