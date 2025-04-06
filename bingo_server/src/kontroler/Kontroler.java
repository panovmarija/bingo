/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import baza.DBB;
import forme.ServerForma;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Igra;
import model.Potez;
 import model.WrapIgraPotezi;

/**
 *
 * @author USER
 */
public class Kontroler {

    private DBB dbb;
     private ServerForma sf;
    private int[] komb = new int[4];
    private static Kontroler instance;

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    private Kontroler() {
        dbb=new DBB();
    }

    public int[] getKomb() {
        return komb;
    }

    public void setKomb(int[] komb) {
        this.komb = komb;
    }
//*************************************************************************EPSKA JEBADA*************************************************************************
    public  int prebroj(int br, int[] niz) {
        int brojac=0;
        for (int i : niz) {
            if (i == br) {
                brojac++;
            }
        }
        return brojac;
    }
    public void ukloni(int br, int[] a) {
        for(int i=0;i<4;i++)
        {
            if(a[i]==br)
                a[i]=-1;
        }
    }
    public  int[] vratiStatistiku(int[] pog) {
//        ne menjam originalnu kombinaciju
        int[]a=new int[4],b=new int[4];
        int namestu=0,nije = 0;
        for (int i = 0; i < 4; i++) {
            if (komb[i] == pog[i]) 
            {
                namestu++;
                a[i]=-1;
                b[i]=-1;
            }
            else 
            {
                a[i]=komb[i];
                b[i]=pog[i];
             }
        }
         for(int i:b)
         {
             if(i!=-1)
             {
             nije+=Math.min(prebroj(i, b), prebroj(i, a));
             ukloni(i,a);
             }
         }
        
        int stat[] = new int[]{namestu, nije};
        return stat;
    }
// *************************************************************************EPSKA JEBADA*************************************************************************
    public ServerForma getSf() {
        return sf;
    }

    public void setSf(ServerForma sf) {
        this.sf = sf;
    }

    public void gotova_igra(WrapIgraPotezi w) {
        sf.gotova_igra();
        sf.setW(w);
     }
    public void sacuvaj(WrapIgraPotezi poslednjaIgra) {
        dbb.sacuvaj(poslednjaIgra);
    }

    public List<Igra> vratiIgre() {
        return dbb.vratiIgre();
    }

    public List<Potez> vratiPoteze(Igra i) {
        return dbb.vratiPoteze(i);
    }

}
