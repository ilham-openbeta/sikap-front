/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Seminar;
import java.util.List;
import model.SeminarModel;
import view.formSeminar;

/**
 *
 * @author barokah
 */
public class SeminarController {

    private final SeminarModel model;
    private final formSeminar view;

    public SeminarController() {
        model = new SeminarModel();
        view = new formSeminar();
        initView();
    }

    public SeminarController(SeminarModel model, formSeminar view) {
        this.model = model;
        this.view = view;
        initView();
    }

    private void initView() {
        view.setController(this);
        view.setTableModel(model.getTableModel());
    }

    public formSeminar getView() {
        return view;
    }

    public List<Seminar> getAllSeminar() {
        return model.getAllSeminar();
    }

    public Seminar getSeminar(int index) {
        return model.getSeminar(index);
    }

    public void addSeminar(String nim1, String nim2, String judul, String tanggal) {
        model.addSeminar(nim1, nim2, judul, tanggal);
    }

    public void updateSeminar(Seminar seminar) {
        model.updateSeminar(seminar);
    }

    public void deleteSeminar(String id) {
        model.deleteSeminar(id);
    }

    public void resetTable() {
        model.resetTable();
        view.setTableModel(model.getTableModel());
    }
}
