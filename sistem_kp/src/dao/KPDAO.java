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
public interface KPDAO {
    public List<KP> getAllKP();

    public KP getKP(int index);

    public void updateKP(KP kp);

    public void deleteKP(String id);
    
    public void populateKP();
}
