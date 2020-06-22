/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Dosen;
import java.util.List;
import model.DosenModel;
import view.formDataDosen;

/**
 *
 * @author barokah
 */
public class DosenController {

    private final DosenModel model;
    private final formDataDosen view;

    public DosenController() {
        model = new DosenModel();
        view = new formDataDosen();
        initView();
    }

    public DosenController(DosenModel model, formDataDosen view) {
        this.model = model;
        this.view = view;
        initView();
    }

    private void initView() {
        view.setController(this);
        view.setTableModel(model.getTableModel());
    }

    public formDataDosen getView() {
        return view;
    }

    public List<Dosen> getAllDosen() {
        return model.getAllDosen();
    }

    public Dosen getDosen(int index) {
        return model.getDosen(index);
    }

    public void addDosen(Dosen dosen) {
        model.addDosen(dosen);
    }

    public void updateDosen(Dosen dosen) {
        model.updateDosen(dosen);
    }

    public void deleteDosen(String nip) {
        model.deleteDosen(nip);
    }

    public void resetTable() {
        model.resetTable();
        view.setTableModel(model.getTableModel());
    }
}
