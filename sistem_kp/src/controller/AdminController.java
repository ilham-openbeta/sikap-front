/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.AdminModel;

/**
 *
 * @author barokah
 */
public class AdminController {

    private AdminModel model;
//    private Menu_Login view;

    public AdminController(AdminModel model) {
        this.model = model;
//        this.view = view;
    }

    public void addModel(AdminModel model) {
        this.model = model;
    }

//    public void addView(Menu_Login view){
//        this.view = view;
//    }
    public void ubahPassword(String password) {
        model.ubahPassword(password);
    }
}
