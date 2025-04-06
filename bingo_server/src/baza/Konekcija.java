/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author USER
 */
public class Konekcija {
    private static Konekcija instace;
    private Connection conn;
    public static Konekcija getInstace() {
        if(instace==null)
            instace=new Konekcija();
        return instace;
    }

    private Konekcija() {
        try {
            String url="jdbc:mysql://localhost:3316/knjiga";
            conn=DriverManager.getConnection(url,"root","root");
            conn.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(Konekcija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConn() {
        return conn;
    }
    
}
