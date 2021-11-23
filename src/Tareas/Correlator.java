/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tareas;

import cafe.Slot;

/**
 *
 * @author David
 */
public class Correlator {
    
    private Slot in;
    private Slot out;
    private Slot in2;
    private Slot out2;

    public Correlator(Slot in, Slot out, Slot in2, Slot out2) {
        this.in = in;
        this.out = out;
        this.out2 = out2;
        this.in2 = in2;
    }

    public void Realiza() {
        while (!in.IsEmpty() && !in2.IsEmpty()) {
            out.Write(in.Read());
            out2.Write(in2.Read());
        }
    }
    
}
