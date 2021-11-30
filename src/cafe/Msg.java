/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cafe;

import java.util.UUID;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 *
 * @author David
 */
public class Msg {
    
    private UUID Id;
    private UUID IdCorrelator;
    private UUID IdFragment;
    private int Tamano;
    private int NumFragmentos;
    private Document DocumentoOriginal;
    private Document body;
    private Node PadreOriginal;

    public Msg(Document body){
        this.Id = UUID.randomUUID();
        this.IdCorrelator = UUID.randomUUID();
        this.body = body;
    }
    
    public Node getPadreOriginal() {
        return PadreOriginal;
    }

    public void setPadreOriginal(Node PadreOriginal) {
        this.PadreOriginal = PadreOriginal;
    }

    public Document getDocumentoOriginal() {
        return DocumentoOriginal;
    }

    public void setDocumentoOriginal(Document DocumentoOriginal) {
        this.DocumentoOriginal = DocumentoOriginal;
    }

    public int getNumFragmentos() {
        return NumFragmentos;
    }

    public void setNumFragmentos(int NumFragmentos) {
        this.NumFragmentos = NumFragmentos;
    }
    
    public UUID getIdCorrelator() {
        return IdCorrelator;
    }

    public void setIdCorrelator(UUID IdCorrelator) {
        this.IdCorrelator = IdCorrelator;
    }

    public UUID getIdFragment() {
        return IdFragment;
    }

    public void setIdFragment(UUID IdFragment) {
        this.IdFragment = IdFragment;
    }

    public int getTamano() {
        return Tamano;
    }

    public void setTamano(int Tamano) {
        this.Tamano = Tamano;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID Id) {
        this.Id = Id;
    }

    public Document getBody() {
        return body;
    }

    public void setBody(Document body) {
        this.body = body;
    }
    
    
    
    
    
    
}
