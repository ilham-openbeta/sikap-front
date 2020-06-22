/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Surat;
import java.util.List;
import model.SuratModel;
import view.formSurat;

/**
 *
 * @author barokah
 */
public class SuratController {

    private final SuratModel model;
    private final formSurat view;

    public SuratController() {
        model = new SuratModel();
        view = new formSurat();
        initView();
    }

    public SuratController(SuratModel model, formSurat view) {
        this.model = model;
        this.view = view;
        initView();
    }

    private void initView() {
        view.setController(this);
        view.setTableModel(model.getTableModel());
    }

    public formSurat getView() {
        return view;
    }

    public List<Surat> getAllSurat() {
        return model.getAllSurat();
    }

    public Surat getSurat(int index) {
        return model.getSurat(index);
    }

    public void addSurat(String nim, String noSurat) {
        model.addSurat(nim, noSurat);
    }

    public void deleteSurat(String id) {
        model.deleteSurat(id);
    }

    public void resetTable() {
        model.resetTable();
        view.setTableModel(model.getTableModel());
    }
}
