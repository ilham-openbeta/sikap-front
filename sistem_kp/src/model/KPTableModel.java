/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.KP;
import dao.KPDAO;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author barokah
 */
public class KPTableModel extends AbstractTableModel {

    private final String[] columnNames = {"NIM", "Nama Mahasiswa", "Jurusan", "Nama Perusahaan", "Tanggal Mulai", "Tanggal Selesai", "Dosen Pembimbing", "Status", "No Surat", "Tanggal Diubah"};
    private final KPDAO dataKP;

    public KPTableModel(KPDAO dataKP) {
        this.dataKP = dataKP;
    }

    public int getRowCount() {
        int jumlahbaris = dataKP.getAllKP().size();
        return jumlahbaris;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int column) {
        KP kp = dataKP.getKP(row);
        switch (column) {
            case 0:
                return kp.getNim();
            case 1:
                return kp.getNama();
            case 2:
                return kp.getJurusan();
            case 3:
                return kp.getNamaPerusahaan();
            case 4:
                return kp.getTanggalMulai();
            case 5:
                return kp.getTanggalSelesai();
            case 6:
                return kp.getDosenPembimbing();
            case 7:
                return kp.getStatus();
            case 8:
                return kp.getNoSurat();
            case 9:
                return kp.getTanggalDiubah();
            default:
                return "";
        }
    }
}
