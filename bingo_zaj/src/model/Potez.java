/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author USER
 */
public class Potez implements Serializable{
    private Igra i;
    private int rb, namestu, nije;
    private String komb;

    public Potez() {
    }

    public Potez(Igra i, int rb, int namestu, int nije, String komb) {
        this.i = i;
        this.rb = rb;
        this.namestu = namestu;
        this.nije = nije;
        this.komb = komb;
    }
     
    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public int getNamestu() {
        return namestu;
    }

    public void setNamestu(int namestu) {
        this.namestu = namestu;
    }

    public int getNije() {
        return nije;
    }

    public void setNije(int nije) {
        this.nije = nije;
    }

    public String getKomb() {
        return komb;
    }

    public void setKomb(String komb) {
        this.komb = komb;
    }

    public void setI(Igra i) {
        this.i = i;
    }

    public Igra getI() {
        return i;
    }
    
    
}
