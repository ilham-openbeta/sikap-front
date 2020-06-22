/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author barokah
 */
public class MahasiswaDAOREST implements MahasiswaDAO {

    List<Mahasiswa> listMhs;

    public MahasiswaDAOREST() {
        listMhs = new ArrayList<>();
        populateMahasiswa();
    }

    @Override
    public Mahasiswa getMahasiswa(int index) {
        return listMhs.get(index);
    }

    @Override
    public List<Mahasiswa> getAllMahasiswa() {
        return listMhs;
    }

    private void populateMahasiswa() {
        try {
            URL url = new URL(LoginDAOREST.ALAMAT + "api/mahasiswa");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.addRequestProperty("Authorization", LoginDAOREST.USER);
            // Ambil value dari Input Stream ubah menjadi String
            char[] buffer = new char[1024];
            StringBuilder sb = new StringBuilder();
            Reader in = new InputStreamReader(conn.getInputStream());
            while (true) {
                int rsz = in.read(buffer, 0, buffer.length);
                if (rsz < 0) {
                    break;
                }
                sb.append(buffer, 0, rsz);
            }
            // Mengubah String menjadi Object JSON kemudian mengubahnya ke Object Mahasiswa
            JSONParser jp = new JSONParser();
            JSONObject jo = (JSONObject) jp.parse(sb.toString());
            JSONArray json = (JSONArray) jo.get("data");
            System.out.println("Jumlah Data Mahasiswa yang diambil: " + jo.get("jumlah").toString());
            listMhs.clear();
            for (int i = 0; i < json.size(); i++) {
                jo = (JSONObject) jp.parse(json.get(i).toString());
                listMhs.add(new Mahasiswa(
                        jo.get("nim").toString(),
                        jo.get("nama").toString(),
                        jo.get("tanggal_lahir").toString(),
                        jo.get("jenis_kelamin").toString(),
                        jo.get("asal").toString(),
                        jo.get("jurusan").toString(),
                        jo.get("angkatan").toString(),
                        jo.get("no_hp").toString()
                ));
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null, e, "Application Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(null, e, "Application Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    @Override
    public void addMahasiswa(Mahasiswa mhs) {
        try {
            URL url = new URL(LoginDAOREST.ALAMAT + "api/mahasiswa/tambah");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.addRequestProperty("Authorization", LoginDAOREST.USER);
            String input = "{"
                    + "\"nim\":\"" + mhs.getNim()
                    + "\",\"nama\":\"" + mhs.getNama()
                    + "\",\"tanggal_lahir\":\"" + mhs.getTanggalLahir()
                    + "\",\"jenis_kelamin\":\"" + mhs.getJenisKelamin()
                    + "\",\"asal\":\"" + mhs.getAsal()
                    + "\",\"jurusan\":\"" + mhs.getJurusan()
                    + "\",\"angkatan\":\"" + mhs.getAngkatan()
                    + "\",\"no_hp\":\"" + mhs.getKontak()
                    + "\"}";
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            conn.disconnect();
            populateMahasiswa();
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null, e, "Application Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e, "Application Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    @Override
    public void updateMahasiswa(Mahasiswa mhs) {
        try {
            URL url = new URL(LoginDAOREST.ALAMAT + "api/mahasiswa/ubah/" + mhs.getNim());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.addRequestProperty("Authorization", LoginDAOREST.USER);
            String input = "{"
                    + "\"nama\":\"" + mhs.getNama()
                    + "\",\"tanggal_lahir\":\"" + mhs.getTanggalLahir()
                    + "\",\"jenis_kelamin\":\"" + mhs.getJenisKelamin()
                    + "\",\"asal\":\"" + mhs.getAsal()
                    + "\",\"jurusan\":\"" + mhs.getJurusan()
                    + "\",\"angkatan\":\"" + mhs.getAngkatan()
                    + "\",\"no_hp\":\"" + mhs.getKontak()
                    + "\"}";
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            conn.disconnect();
            populateMahasiswa();
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null, e, "Application Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e, "Application Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    @Override
    public void deleteMahasiswa(String nim) {
        try {
            URL url = new URL(LoginDAOREST.ALAMAT + "api/mahasiswa/hapus/" + nim);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("DELETE");
            conn.addRequestProperty("Authorization", LoginDAOREST.USER);
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            conn.disconnect();
            populateMahasiswa();
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null, e, "Application Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e, "Application Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
