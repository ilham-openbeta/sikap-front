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
public class SuratDAOREST implements SuratDAO {

    List<Surat> listSurat;

    public SuratDAOREST() {
        listSurat = new ArrayList<>();
        populateSurat();
    }

    @Override
    public Surat getSurat(int index) {
        return listSurat.get(index);
    }

    @Override
    public List<Surat> getAllSurat() {
        return listSurat;
    }

    private void populateSurat() {
        try {
            URL url = new URL(LoginDAOREST.ALAMAT + "api/surat");
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
            // Mengubah String menjadi Object JSON kemudian mengubahnya ke Object Surat
            JSONParser jp = new JSONParser();
            JSONObject jo = (JSONObject) jp.parse(sb.toString());
            JSONArray json = (JSONArray) jo.get("data");
            System.out.println("Jumlah Data Surat yang diambil: " + jo.get("jumlah").toString());
            listSurat.clear();
            for (int i = 0; i < json.size(); i++) {
                jo = (JSONObject) jp.parse(json.get(i).toString());
                listSurat.add(new Surat(
                        jo.get("no_surat").toString(),
                        jo.get("tanggal_surat").toString(),
                        jo.get("nim").toString(),
                        jo.get("nama").toString(),
                        jo.get("tanggal_lahir").toString(),
                        jo.get("asal").toString(),
                        jo.get("jurusan").toString(),
                        (jo.get("nip") == null) ? "" : jo.get("nip").toString(),
                        (jo.get("dosen") == null) ? "" : jo.get("dosen").toString(),
                        jo.get("perusahaan").toString(),
                        jo.get("tanggal_mulai").toString(),
                        jo.get("tanggal_selesai").toString()));
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
    public void addSurat(String nim, String noSurat) {
        try {
            URL url = new URL(LoginDAOREST.ALAMAT + "api/surat/tambah/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.addRequestProperty("Authorization", LoginDAOREST.USER);
            String input = "{"
                    + "\"nim\":\"" + nim
                    + "\",\"no_surat\":\"" + noSurat
                    + "\"}";
            System.out.println(input);
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            conn.disconnect();
            populateSurat();
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null, e, "Application Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e, "Application Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    @Override
    public void deleteSurat(String nim) {
        try {
            URL url = new URL(LoginDAOREST.ALAMAT + "api/surat/hapus/" + nim);
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
            populateSurat();
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null, e, "Application Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e, "Application Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
