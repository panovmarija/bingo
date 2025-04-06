/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author USER
 */
public class Igra implements Serializable {
    private int id;
    private Date dat;
    private String komb,status;
    private int brpok;

    public Igra() {
    }

    public Igra(int id, Date dat, String komb, String status, int brpok) {
        this.id = id;
        this.dat = dat;
        this.komb = komb;
        this.status = status;
        this.brpok = brpok;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Igra other = (Igra) obj;
        return this.id == other.id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDat() {
        return dat;
    }

    public void setDat(Date dat) {
        this.dat = dat;
    }

    public String getKomb() {
        return komb;
    }

    public void setKomb(String komb) {
        this.komb = komb;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getBrpok() {
        return brpok;
    }

    public void setBrpok(int brpok) {
        this.brpok = brpok;
    }
    
}
