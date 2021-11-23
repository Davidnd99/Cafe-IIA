/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tareas;

import cafe.Slot;
import org.w3c.dom.Document;

/**
 *
 * @author David
 */
public class Merger {

    private Slot Entrada1;
    private Slot Entrada2;
    private Slot Salida;

    Merger(Slot Entrada1, Slot Entrada2, Slot Salida) {
        this.Entrada1 = Entrada1;
        this.Entrada2 = Entrada2;
        this.Salida = Salida;
    }

    public void Realiza() {
        Document doc1;
        Document doc2;
        while (!Entrada1.IsEmpty()) {
            doc1 = Entrada1.Read();
            Salida.Write(doc1);
        }
        while (!Entrada2.IsEmpty()) {
            doc2 = Entrada2.Read();
            Salida.Write(doc2);
        }
    }

}
