/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Potez;
import model.WrapIgraPotezi;
import transfer.KlijentZahtev;
import transfer.Operacije;
import transfer.ServerOdg;

/**
 *
 * @author USER
 */
public class ObradaZahteva extends Thread {
    private Socket s;

    public ObradaZahteva(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        KlijentZahtev kz;
        while((kz=procitajZahtev())!=null)
        {
            ServerOdg so=new ServerOdg();
            switch (kz.getOperacija()) {
                case Operacije.POGADJA:
                    int[]pog=(int[]) kz.getPar();
                    int []stat=kontroler.Kontroler.getInstance().vratiStatistiku(pog);
                    so.setOdg(stat);
                    break;
                case Operacije.GOTOVA_IGRA:
                    WrapIgraPotezi w=(WrapIgraPotezi) kz.getPar();
                    String[]niz=new String [4];
                    for(int i=0;i<4;i++)
                    {
                        niz[i]=kontroler.Kontroler.getInstance().getKomb()[i]+"";
                    }
                    w.getIgra().setKomb(String.join("-", niz));
                    for(Potez p:w.getPotezi())
                    {
                        p.setI(w.getIgra());
                    }
                    kontroler.Kontroler.getInstance().gotova_igra(w);
                    break;
                default:
                    throw new AssertionError();
            }
            posaljiOdg(so);
        }
        
        if(s!=null && !s.isClosed())
            try {
                s.close();
        } catch (IOException ex) {
            Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(s.isClosed());
    }
    
    public KlijentZahtev procitajZahtev()
    {
        try {
            ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
            return (KlijentZahtev) ois.readObject();
        } catch (IOException ex) {
            System.out.println("klijent odvezan");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void posaljiOdg(ServerOdg so)
    {
        try {
            ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(so);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
