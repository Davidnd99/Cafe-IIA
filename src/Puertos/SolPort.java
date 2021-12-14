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
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author David
 */
public class SolPort {
    
    private Slot salida;
    private Slot entrada;
    private ConectorBC BC;
    private ConectorBF BF;
    
    public SolPort(Slot entrada, Slot salida){
        this.salida = salida;
        this.entrada = entrada;
    }

    public Slot getSalida() {
        return salida;
    }

    public void setSalida(Slot salida) {
        this.salida = salida;
    }

    public Slot getEntrada() {
        return entrada;
    }

    public void setEntrada(Slot entrada) {
        this.entrada = entrada;
    }

    public ConectorBC getBC() {
        return BC;
    }

    public void setBC(ConectorBC BC) {
        this.BC = BC;
    }

    public ConectorBF getBF() {
        return BF;
    }

    public void setBF(ConectorBF BF) {
        this.BF = BF;
    }
    
    
    
}
