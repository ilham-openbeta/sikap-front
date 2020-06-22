/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.Seminar;
import dao.SeminarDAO;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author barokah
 */
public class SeminarTableModel extends AbstractTableModel {
    private final String[] columnNames = { "Nama Mahasiswa", "Nama Perusahaan", "Judul Seminar", "Tanggal Seminar"};
    private final SeminarDAO dataSeminar;

    public SeminarTableModel(SeminarDAO dataSeminar) {
        this.dataSeminar = dataSeminar;
    }

    public int getRowCount() {
        int jumlahbaris = dataSeminar.getAllSeminar().size();
        return jumlahbaris;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int column) {
        Seminar seminar = dataSeminar.getSeminar(row);
        switch (column) {
            case 0:
                return seminar.getNama();
            case 1:
                return seminar.getPerusahaan();
            case 2:
                return seminar.getJudul();
            case 3:
                return seminar.getTanggal();
            default:
                return "";
        }
    }
}
