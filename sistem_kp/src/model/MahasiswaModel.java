/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.Mahasiswa;
import dao.MahasiswaDAO;
import dao.MahasiswaDAOREST;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author barokah
 */
public class MahasiswaModel {

    private final MahasiswaDAO mahasiswaDao;
    private AbstractTableModel tableModel;

    public MahasiswaModel() {
        mahasiswaDao = new MahasiswaDAOREST();
        tableModel = new MahasiswaTableModel(mahasiswaDao);
    }

    public AbstractTableModel getTableModel() {
        return tableModel;
    }

    public List<Mahasiswa> getAllMahasiswa() {
        return mahasiswaDao.getAllMahasiswa();
    }

    public Mahasiswa getMahasiswa(int index) {
        return mahasiswaDao.getMahasiswa(index);
    }

    public void addMahasiswa(Mahasiswa mahasiswa) {
        mahasiswaDao.addMahasiswa(mahasiswa);
    }

    public void updateMahasiswa(Mahasiswa mahasiswa) {
        mahasiswaDao.updateMahasiswa(mahasiswa);
    }

    public void deleteMahasiswa(String nim) {
        mahasiswaDao.deleteMahasiswa(nim);
    }

    public void resetTable() {
        tableModel = new MahasiswaTableModel(mahasiswaDao);
    }
}
