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
public class KP {

    private String id;
    private String nim;
    private String nama;
    private String jurusan;
    private String namaPerusahaan;
    private String alamatPerusahaan;
    private String kontakPerusahaan;
    private String tanggalMulai;
    private String tanggalSelesai;
    private String status;
    private String nip;
    private String dosenPembimbing;
    private String tanggalSeminar;
    private String noSurat;
    private String tanggalSurat;
    private String tanggalDiubah;

    public KP() {
    }

    public KP(String id, String nim, String nama, String jurusan, String namaPerusahaan, String alamatPerusahaan, String kontakPerusahaan, String tanggalMulai, String tanggalSelesai, String status, String nip, String dosenPembimbing, String tanggalSeminar, String noSurat, String tanggalSurat, String tanggalDiubah) {
        this.id = id;
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
        this.namaPerusahaan = namaPerusahaan;
        this.alamatPerusahaan = alamatPerusahaan;
        this.kontakPerusahaan = kontakPerusahaan;
        this.tanggalMulai = tanggalMulai;
        this.tanggalSelesai = tanggalSelesai;
        this.status = status;
        this.nip = nip;
        this.dosenPembimbing = dosenPembimbing;
        this.tanggalSeminar = tanggalSeminar;
        this.noSurat = noSurat;
        this.tanggalSurat = tanggalSurat;
        this.tanggalDiubah = tanggalDiubah;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public void setNamaPerusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }

    public String getAlamatPerusahaan() {
        return alamatPerusahaan;
    }

    public void setAlamatPerusahaan(String alamatPerusahaan) {
        this.alamatPerusahaan = alamatPerusahaan;
    }

    public String getKontakPerusahaan() {
        return kontakPerusahaan;
    }

    public void setKontakPerusahaan(String kontakPerusahaan) {
        this.kontakPerusahaan = kontakPerusahaan;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getDosenPembimbing() {
        return dosenPembimbing;
    }

    public void setDosenPembimbing(String dosenPembimbing) {
        this.dosenPembimbing = dosenPembimbing;
    }

    public String getTanggalSeminar() {
        return tanggalSeminar;
    }

    public void setTanggalSeminar(String tanggalSeminar) {
        this.tanggalSeminar = tanggalSeminar;
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

    public String getTanggalDiubah() {
        return tanggalDiubah;
    }

    public void setTanggalDiubah(String tanggalDiubah) {
        this.tanggalDiubah = tanggalDiubah;
    }
    
}
