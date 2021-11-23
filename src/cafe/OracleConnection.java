/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cafe;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author David
 */
public class OracleConnection {
    
    private Connection conn = null;
    private static String ip = "b0ve.com";
    private static int puerto = 3306;
    private static String extraConf = "";
    
    public OracleConnection(char tipo) throws ClassNotFoundException, SQLException{
        if (tipo == 'F') {
            // Librería de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "cafe-04";
            String db = "cafe04";
            String pass = "pass";
            conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + puerto + "/" + db + extraConf, user, pass);
            System.out.println("Conexion Fria");
            //1+conn = (OracleConnection) DriverManager.getConnection("jdbc:mysql://:3306/bebidacaliente?", "chaimadavid", "cafeintegracion");//Esto hay que cambiarlo por nuestras bases de datos 
            System.out.println(conn.getMetaData().getUserName());
        } else {
           // Librería de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "cafe-03";
            String db = "cafe03";
            String pass = "pass";
            conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + puerto + "/" + db + extraConf, user, pass);
            System.out.println("Conexion Caliente");
            //1+conn = (OracleConnection) DriverManager.getConnection("jdbc:mysql://:3306/bebidacaliente?", "chaimadavid", "cafeintegracion");//Esto hay que cambiarlo por nuestras bases de datos 
            System.out.println(conn.getMetaData().getUserName());
        }
    }
    
    public void desconexion() throws SQLException {
        conn.close();
    }

    public Connection getc() {
        return conn;
    }

    public Statement crears() throws SQLException {
        return conn.createStatement();
    }

    public CallableStatement prepareCall(String sql) throws SQLException {
        return conn.prepareCall(sql);
    }
}
