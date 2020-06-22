/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Mahasiswa;
import java.util.List;
import model.MahasiswaModel;
import view.formDataMhs;

/**
 *
 * @author barokah
 */
public class MahasiswaController {

    private final MahasiswaModel model;
    private final formDataMhs view;

    public MahasiswaController() {
        model = new MahasiswaModel();
        view = new formDataMhs();
        initView();
    }

    public MahasiswaController(MahasiswaModel model, formDataMhs view) {
        this.model = model;
        this.view = view;
        initView();
    }

    private void initView() {
        view.setController(this);
        view.setTableModel(model.getTableModel());
    }

    public formDataMhs getView() {
        return view;
    }

    public List<Mahasiswa> getAllMahasiswa() {
        return model.getAllMahasiswa();
    }

    public Mahasiswa getMahasiswa(int index) {
        return model.getMahasiswa(index);
    }

    public void addMahasiswa(Mahasiswa mahasiswa) {
        model.addMahasiswa(mahasiswa);
    }

    public void updateMahasiswa(Mahasiswa mahasiswa) {
        model.updateMahasiswa(mahasiswa);
    }

    public void deleteMahasiswa(String nim) {
        model.deleteMahasiswa(nim);
    }

    public void resetTable() {
        model.resetTable();
        view.setTableModel(model.getTableModel());
    }
}
