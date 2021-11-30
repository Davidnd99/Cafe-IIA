/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tareas;

import cafe.Msg;
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

    public Merger(Slot Entrada1, Slot Entrada2, Slot Salida) {
        this.Entrada1 = Entrada1;
        this.Entrada2 = Entrada2;
        this.Salida = Salida;
    }

    public void Realiza() {
        
        while (!Entrada1.IsEmpty()) {
            Salida.Write(Entrada1.Read());
        }
        while (!Entrada2.IsEmpty()) {
            Salida.Write(Entrada2.Read());
        }
    }

}
