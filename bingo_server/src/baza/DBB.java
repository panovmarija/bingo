/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import com.mysql.cj.protocol.Resultset;
import model.WrapIgraPotezi;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Igra;
import model.Potez;
/**
 *
 * @author USER
 */
public class DBB {

    
    public void sacuvaj(WrapIgraPotezi w) {
        try {
             Igra i=w.getIgra();
            int id=vratiid();
            List<Potez>potezi=w.getPotezi();
            String u1="insert into igra  values(?,?,?,?,?)";
            PreparedStatement ps1=Konekcija.getInstace().getConn().prepareStatement(u1);
            ps1.setInt(1, id);
            ps1.setTimestamp(2, new java.sql.Timestamp(i.getDat().getTime()));
            ps1.setString(3, i.getKomb());
            ps1.setString(4, i.getStatus());
            ps1.setInt(5, i.getBrpok());
            ps1.executeUpdate();

            String u2="insert into potez values(?,?,?,?,?)";
            PreparedStatement ps2=Konekcija.getInstace().getConn().prepareStatement(u2);
            for(Potez p:potezi)
            {
            ps2.setInt(1, id);
            ps2.setInt(2, p.getRb());
            ps2.setInt(3, p.getNamestu());
            ps2.setInt(4, p.getNije());
            ps2.setString(5, p.getKomb());
            ps2.addBatch();
            }
            ps2.executeBatch();
            Konekcija.getInstace().getConn().commit();
        } catch (SQLException ex) {
            try {
                Konekcija.getInstace().getConn().rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(DBB.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DBB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int vratiid() {
            int id=1;
        try {
            String u="select case when max(id) is null then 1 else max(id)+1 end as id from igra";
            Statement s=Konekcija.getInstace().getConn().createStatement();
            ResultSet rs=s.executeQuery(u);
            while(rs.next())
            {
                id=rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBB.class.getName()).log(Level.SEVERE, null, ex);
        }
            return id;
    }

    public List<Igra> vratiIgre() {
        List<Igra> l=new LinkedList<>();
        try {
            String u="select * from igra";
            Statement s=Konekcija.getInstace().getConn().createStatement();
            ResultSet rs=s.executeQuery(u);
            while(rs.next())
            {
                Igra i=new Igra(rs.getInt("id"), new java.sql.Date(rs.getTimestamp("dat").getTime()), rs.getString("komb"), rs.getString("stat"), rs.getInt("brpok"));
                l.add(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public List<Potez> vratiPoteze(Igra i) {
        List<Potez> l=new LinkedList<>();
        try {
            String u="select * from potez where igra="+i.getId();
            Statement s=Konekcija.getInstace().getConn().createStatement();
            ResultSet rs=s.executeQuery(u);
            while(rs.next())
            {
                Potez p=new Potez(i, rs.getInt("rb"), rs.getInt("nam"), rs.getInt("nije"), rs.getString("komb"));
                l.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }
    
}
