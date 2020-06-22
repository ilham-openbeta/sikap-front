/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.Dosen;
import dao.DosenDAO;
import dao.DosenDAOREST;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author barokah
 */
public class DosenModel {

    private final DosenDAO dosenDao;
    private AbstractTableModel tableModel;

    public DosenModel() {
        dosenDao = new DosenDAOREST();
        tableModel = new DosenTableModel(dosenDao);
    }

    public AbstractTableModel getTableModel() {
        return tableModel;
    }

    public List<Dosen> getAllDosen() {
        return dosenDao.getAllDosen();
    }

    public Dosen getDosen(int index) {
        return dosenDao.getDosen(index);
    }

    public void addDosen(Dosen dosen) {
        dosenDao.addDosen(dosen);
    }

    public void updateDosen(Dosen dosen) {
        dosenDao.updateDosen(dosen);
    }

    public void deleteDosen(String nip) {
        dosenDao.deleteDosen(nip);
    }
    
    public void resetTable() {
        tableModel = new DosenTableModel(dosenDao);
    }
}
