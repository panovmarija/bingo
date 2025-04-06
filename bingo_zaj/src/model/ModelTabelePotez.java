/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class ModelTabelePotez extends AbstractTableModel {
    private List<Potez> potezi;
    private String[]kol=new String[]{"rb","Kombinacija","Pogodjenih NA MESTU", "Pogodjenih NISU NA MESTU"};
    public ModelTabelePotez(List<Potez> igre)
    {
        this.potezi=igre;
    }
    @Override
    public int getRowCount() {
        return potezi.size();
    }

    @Override
    public int getColumnCount() {
        return kol.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Potez i=potezi.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return i.getRb();
            case 1:
                return i.getKomb();
            case 2:
                return i.getNamestu();
            case 3:
                return i.getNije();
             default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        return kol[column];
    }

    public List<Potez> getPotezi() {
        return potezi;
    }

    public void setPotezi(List<Potez> igre) {
        this.potezi = igre;
    }
    
    
}
