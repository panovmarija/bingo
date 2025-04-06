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
public class ServerOdg implements Serializable{
    private Object odg; 
    private int operacija;

    public ServerOdg() {
    }

    public ServerOdg(Object odg, int operacija) {
        this.odg = odg;
        this.operacija = operacija;
    }

    public Object getOdg() {
        return odg;
    }

    public void setOdg(Object odg) {
        this.odg = odg;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }
    
}
