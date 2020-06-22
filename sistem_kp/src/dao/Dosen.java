/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author barokah
 */
public class Dosen {

    private String nip;
    private String nama;
    private String kontak;

    public Dosen() {
    }

    public Dosen(String nip, String nama, String kontak) {
        this.nip = nip;
        this.nama = nama;
        this.kontak = kontak;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }

}
