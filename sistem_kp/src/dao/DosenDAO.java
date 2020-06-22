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
public interface DosenDAO {

    public List<Dosen> getAllDosen();

    public Dosen getDosen(int index);

    public void addDosen(Dosen dosen);

    public void updateDosen(Dosen dosen);

    public void deleteDosen(String nip);
}
