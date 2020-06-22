/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.Surat;
import dao.SuratDAO;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author barokah
 */
public class SuratTableModel extends AbstractTableModel {
    private final String[] columnNames = { "NIM", "Nama Mahasiswa", "Nama Perusahaan", "No Surat"};
    private final SuratDAO dataSurat;

    public SuratTableModel(SuratDAO dataSurat) {
        this.dataSurat = dataSurat;
    }

    public int getRowCount() {
        int jumlahbaris = dataSurat.getAllSurat().size();
        return jumlahbaris;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int column) {
        Surat surat = dataSurat.getSurat(row);
        switch (column) {
            case 0:
                return surat.getNim();
            case 1:
                return surat.getNama();
            case 2:
                return surat.getPerusahaan();
            case 3:
                return surat.getNoSurat();
            default:
                return "";
        }
    }
}
