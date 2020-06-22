/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.AdminDAO;
import dao.AdminDAOREST;

/**
 *
 * @author barokah
 */
public class AdminModel {

    private final AdminDAO adminDao;

    public AdminModel() {
        adminDao = new AdminDAOREST();
    }

    public void ubahPassword(String password) {
        adminDao.ubahPassword(password);
    }
}
