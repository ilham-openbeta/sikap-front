/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author barokah
 */
public interface SeminarDAO {

    public List<Seminar> getAllSeminar();

    public Seminar getSeminar(int index);

    public void addSeminar(String nim1, String nim2, String judul, String tanggal);

    public void updateSeminar(Seminar seminar);

    public void deleteSeminar(String id);
}
