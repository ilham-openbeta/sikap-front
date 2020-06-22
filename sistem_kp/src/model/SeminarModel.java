/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.Seminar;
import dao.SeminarDAO;
import dao.SeminarDAOREST;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author barokah
 */
public class SeminarModel {

    private final SeminarDAO seminarDao;
    private AbstractTableModel tableModel;

    public SeminarModel() {
        seminarDao = new SeminarDAOREST();
        tableModel = new SeminarTableModel(seminarDao);
    }

    public AbstractTableModel getTableModel() {
        return tableModel;
    }

    public List<Seminar> getAllSeminar() {
        return seminarDao.getAllSeminar();
    }

    public Seminar getSeminar(int index) {
        return seminarDao.getSeminar(index);
    }

    public void addSeminar(String nim1, String nim2, String judul, String tanggal) {
        seminarDao.addSeminar(nim1, nim2, judul, tanggal);
    }

    public void updateSeminar(Seminar seminar) {
        seminarDao.updateSeminar(seminar);
    }

    public void deleteSeminar(String id) {
        seminarDao.deleteSeminar(id);
    }

    public void resetTable() {
        tableModel = new SeminarTableModel(seminarDao);
    }
}
