/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.LoginDAO;
import dao.LoginDAOREST;

/**
 *
 * @author barokah
 */
public class LoginModel {

    private final LoginDAO loginDao;

    public LoginModel() {
        loginDao = new LoginDAOREST();
    }

    public boolean login(String username, String password) {
        return loginDao.login(username, password);
    }
}
