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
public interface SuratDAO {

    public List<Surat> getAllSurat();

    public Surat getSurat(int index);

    public void addSurat(String nim, String noSurat);

    public void deleteSurat(String nim);
}
