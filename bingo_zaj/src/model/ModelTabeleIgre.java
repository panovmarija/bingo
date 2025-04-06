/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class ModelTabeleIgre extends AbstractTableModel {
    private List<Igra> igre;
    private String[]kol=new String[]{"Datum","Zadata kombinacija", "Broj pokusaja", "Rezultat"};
    public ModelTabeleIgre(List<Igra> igre)
    {
        this.igre=igre;
    }
    @Override
    public int getRowCount() {
        return igre.size();
    }

    @Override
    public int getColumnCount() {
        return kol.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Igra i=igre.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return new SimpleDateFormat("dd-MM-yyyy hh:mm").format(i.getDat());
            case 1:
                return i.getKomb();
            case 2:
                return i.getBrpok();
            case 3:
                return i.getStatus();
             default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        return kol[column];
    }

    public List<Igra> getIgre() {
        return igre;
    }

    public void setIgre(List<Igra> igre) {
        this.igre = igre;
    }
    
    
}
