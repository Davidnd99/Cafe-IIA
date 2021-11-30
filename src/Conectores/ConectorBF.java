/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conectores;

import Conectores.Conector;
import cafe.OracleConnection;
import Puertos.SolPort;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author David
 */
public class ConectorBF extends Conector{
    
   private SolPort p;
    private OracleConnection c;

    public ConectorBF(SolPort p) throws ClassNotFoundException, SQLException{
        this.p = p;
        c = new OracleConnection('F');
    }
     
    @Override
    public void Realiza(){
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            ArrayList<String> sql = new ArrayList<>(p.Realiza1());
            for (int i = 0; i < sql.size(); i++) {
                Statement st = c.crears();
                ResultSet rs = st.executeQuery(sql.get(i));
                rs.next();
                Document sal = db.newDocument();
                Element rootElement = sal.createElement("drink");
                sal.appendChild(rootElement);
                String dato = Integer.toString(rs.getInt("Stock"));
                Element stock = sal.createElement("stock");
                stock.appendChild(sal.createTextNode(dato));
                rootElement.appendChild(stock);

                p.Realiza2(sal);
            }
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ConectorBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(ConectorBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConectorBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
           Logger.getLogger(ConectorBF.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    
}
