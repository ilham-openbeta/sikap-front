/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.Mahasiswa;
import dao.MahasiswaDAO;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author barokah
 */
public class MahasiswaTableModel extends AbstractTableModel {

    private final String[] columnNames = {"NIM", "Nama", "Tanggal Lahir", "Jenis Kelamin", "Asal", "Jurusan", "Angkatan", "No HP"};
    private final MahasiswaDAO dataMhs;

    public MahasiswaTableModel(MahasiswaDAO dataMhs) {
        this.dataMhs = dataMhs;
    }

    public int getRowCount() {
        int jumlahbaris = dataMhs.getAllMahasiswa().size();
        return jumlahbaris;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int column) {
        Mahasiswa mhs = dataMhs.getMahasiswa(row);
        switch (column) {
            case 0:
                return mhs.getNim();
            case 1:
                return mhs.getNama();
            case 2:
                return mhs.getTanggalLahir();
            case 3:
                return mhs.getJenisKelamin();
            case 4:
                return mhs.getAsal();
            case 5:
                return mhs.getJurusan();
            case 6:
                return mhs.getAngkatan();
            case 7:
                return mhs.getKontak();
            default:
                return "";
        }
    }
}
