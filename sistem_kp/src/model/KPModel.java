/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.KP;
import dao.KPDAO;
import dao.KPDAOREST;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author barokah
 */
public class KPModel {

    private final KPDAO kpDao;
    private AbstractTableModel tableModel;

    public KPModel() {
        kpDao = new KPDAOREST();
        tableModel = new KPTableModel(kpDao);
    }

    public AbstractTableModel getTableModel() {
        return tableModel;
    }

    public List<KP> getAllKP() {
        return kpDao.getAllKP();
    }

    public KP getKP(int index) {
        return kpDao.getKP(index);
    }

    public void updateKP(KP kp) {
        kpDao.updateKP(kp);
    }

    public void deleteKP(String id) {
        kpDao.deleteKP(id);
    }

    public void resetTable() {
        kpDao.populateKP();
        tableModel = new KPTableModel(kpDao);
    }
}
