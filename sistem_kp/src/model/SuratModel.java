/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.Surat;
import dao.SuratDAO;
import dao.SuratDAOREST;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author barokah
 */
public class SuratModel {

    private final SuratDAO suratDao;
    private AbstractTableModel tableModel;

    public SuratModel() {
        suratDao = new SuratDAOREST();
        tableModel = new SuratTableModel(suratDao);
    }

    public AbstractTableModel getTableModel() {
        return tableModel;
    }

    public List<Surat> getAllSurat() {
        return suratDao.getAllSurat();
    }

    public Surat getSurat(int index) {
        return suratDao.getSurat(index);
    }

    public void addSurat(String nim, String noSurat) {
        suratDao.addSurat(nim, noSurat);
    }

    public void deleteSurat(String id) {
        suratDao.deleteSurat(id);
    }

    public void resetTable() {
        tableModel = new SuratTableModel(suratDao);
    }
}
