/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author USER
 */
public class KlijentZahtev implements Serializable {
    private Object par;
    private int operacija;

    public KlijentZahtev() {
    }

    public KlijentZahtev(Object par, int operacija) {
        this.par = par;
        this.operacija = operacija;
    }

    public Object getPar() {
        return par;
    }

    public void setPar(Object par) {
        this.par = par;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }
    
}
