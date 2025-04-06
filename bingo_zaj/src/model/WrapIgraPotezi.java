/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author USER
 */
public class WrapIgraPotezi implements Serializable{
    private Igra igra;
    private List<Potez>potezi;

    public WrapIgraPotezi() {
    }

    public WrapIgraPotezi(Igra igra, List<Potez> potezi) {
        this.igra = igra;
        this.potezi = potezi;
    }

    public Igra getIgra() {
        return igra;
    }

    public void setIgra(Igra igra) {
        this.igra = igra;
    }

    public List<Potez> getPotezi() {
        return potezi;
    }

    public void setPotezi(List<Potez> potezi) {
        this.potezi = potezi;
    }
    
    
    
}
