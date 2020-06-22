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
public interface MahasiswaDAO {

    public List<Mahasiswa> getAllMahasiswa();

    public Mahasiswa getMahasiswa(int index);

    public void addMahasiswa(Mahasiswa mahasiswa);

    public void updateMahasiswa(Mahasiswa mahasiswa);

    public void deleteMahasiswa(String nim);

}
