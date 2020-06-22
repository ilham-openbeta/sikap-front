/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.KP;
import java.util.List;
import model.KPModel;
import view.formKP;

/**
 *
 * @author barokah
 */
public class KPController {

    private final KPModel model;
    private final formKP view;

    public KPController() {
        model = new KPModel();
        view = new formKP();
        initView();
    }

    public KPController(KPModel model, formKP view) {
        this.model = model;
        this.view = view;
        initView();
    }

    private void initView() {
        view.setController(this);
        view.setTableModel(model.getTableModel());
    }

    public formKP getView() {
        return view;
    }

    public List<KP> getAllKP() {
        return model.getAllKP();
    }

    public KP getKP(int index) {
        return model.getKP(index);
    }

    public void updateKP(KP kp) {
        model.updateKP(kp);
    }

    public void deleteKP(String id) {
        model.deleteKP(id);
    }
    
    public void resetTable() {
        model.resetTable();
        view.setTableModel(model.getTableModel());
    }
}
