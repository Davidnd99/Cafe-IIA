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
 * @author chaim
 */
public class Replicator {

    private Slot Salida1;
    private Slot Salida2;
    private Slot Entrada;

    Replicator(Slot Entrada, Slot Salida1, Slot Salida2) {
        this.Entrada = Entrada;
        this.Salida1 = Salida1;
        this.Salida2 = Salida2;
    }

    public void Realiza() {
        Document d;
        while (!Entrada.IsEmpty()) {
            d = Entrada.Read();
            Salida1.Write(d);
            Salida2.Write(d);
        }
    }
}

