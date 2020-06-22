/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.LoginModel;
import view.Menu_Login;
import view.Menu_Utama;

/**
 *
 * @author barokah
 */
public class LoginController {

    private LoginModel model;
    private Menu_Login view;

    public LoginController(LoginModel model, Menu_Login view) {
        this.model = model;
        this.view = view;
    }

    public void addModel(LoginModel model) {
        this.model = model;
    }
    
    public void addView(Menu_Login view){
        this.view = view;
    }

    public void login(String username, String password) {
        if(model.login(username, password)){
            Menu_Utama home = new Menu_Utama();
            view.dispose();
            home.setVisible(true);
        } else {
            view.loginGagal();
        }
    }
}
