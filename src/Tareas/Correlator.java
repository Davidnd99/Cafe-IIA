/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tareas;

import cafe.Msg;
import cafe.Slot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author David
 */
public class Correlator {
    
    private Slot in;
    private Slot out;
    private Slot in2;
    private Slot out2;
    private Map<UUID, List<Msg>> mapa=new HashMap<>();

    public Correlator(Slot in, Slot out, Slot in2, Slot out2) {
        this.in = in;
        this.out = out;
        this.out2 = out2;
        this.in2 = in2;
    }

    public void Realiza() {
        int nSlots = 2;
        while(!in.IsEmpty()){
            Msg m=in.Read();
            List<Msg> lista=mapa.get(m.getIdCorrelator());
            if(lista==null){
                lista=new ArrayList<>();
                mapa.put(m.getIdCorrelator(), lista);
            }
            lista.add(m);
        }
            
        while(!in2.IsEmpty()){
            Msg m=in2.Read();
            List<Msg> lista=mapa.get(m.getIdCorrelator());
            if(lista==null){
                lista=new ArrayList<>();
                mapa.put(m.getIdCorrelator(), lista);
            }
            lista.add(m);
        }   
        
        for (Map.Entry<UUID, List<Msg>> entry : mapa.entrySet()) {
            UUID key = entry.getKey();
            List<Msg> val = entry.getValue();
            if(2 == val.size()){
                out.Write(val.get(0));
                out2.Write(val.get(1));
            }
        }
            
        out.Write(in.Read());
        out2.Write(in2.Read());
        
    }
    
}
