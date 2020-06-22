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
public class Surat {

    private String noSurat;
    private String tanggalSurat;
    private String nim;
    private String nama;
    private String tanggalLahir;
    private String asal;
    private String jurusan;
    private String nip;
    private String dosen;
    private String perusahaan;
    private String tanggalMulai;
    private String tanggalSelesai;

    public Surat() {
    }

    public Surat(String noSurat, String tanggalSurat, String nim, String nama, String tanggalLahir, String asal, String jurusan, String nip, String dosen, String perusahaan, String tanggalMulai, String tanggalSelesai) {
        this.noSurat = noSurat;
        this.tanggalSurat = tanggalSurat;
        this.nim = nim;
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.asal = asal;
        this.jurusan = jurusan;
        this.nip = nip;
        this.dosen = dosen;
        this.perusahaan = perusahaan;
        this.tanggalMulai = tanggalMulai;
        this.tanggalSelesai = tanggalSelesai;
    }

    public String getNoSurat() {
        return noSurat;
    }

    public void setNoSurat(String noSurat) {
        this.noSurat = noSurat;
    }

    public String getTanggalSurat() {
        return tanggalSurat;
    }

    public void setTanggalSurat(String tanggalSurat) {
        this.tanggalSurat = tanggalSurat;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

    public String getPerusahaan() {
        return perusahaan;
    }

    public void setPerusahaan(String perusahaan) {
        this.perusahaan = perusahaan;
    }

    public String getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(String tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public String getTanggalSelesai() {
        return tanggalSelesai;
    }

    public void setTanggalSelesai(String tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }

}
