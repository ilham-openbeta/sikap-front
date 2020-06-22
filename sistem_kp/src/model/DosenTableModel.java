/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.Dosen;
import dao.DosenDAO;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author barokah
 */
public class DosenTableModel extends AbstractTableModel {

    private final String[] columnNames = {"NIP", "Nama", "No HP"};
    private final DosenDAO dataDosen;

    public DosenTableModel(DosenDAO dataDosen) {
        this.dataDosen = dataDosen;
    }

    public int getRowCount() {
        int jumlahbaris = dataDosen.getAllDosen().size();
        return jumlahbaris;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int column) {
        Dosen dosen = dataDosen.getDosen(row);
        switch (column) {
            case 0:
                return dosen.getNip();
            case 1:
                return dosen.getNama();
            case 2:
                return dosen.getKontak();
            default:
                return "";
        }
    }
}
