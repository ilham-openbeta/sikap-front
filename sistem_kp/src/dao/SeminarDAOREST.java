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
public class SeminarDAOREST implements SeminarDAO {

    List<Seminar> listSeminar;

    public SeminarDAOREST() {
        listSeminar = new ArrayList<>();
        populateSeminar();
    }

    @Override
    public Seminar getSeminar(int index) {
        return listSeminar.get(index);
    }

    @Override
    public List<Seminar> getAllSeminar() {
        return listSeminar;
    }

    private void populateSeminar() {
        try {
            URL url = new URL(LoginDAOREST.ALAMAT + "api/seminar");
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
            // Mengubah String menjadi Object JSON kemudian mengubahnya ke Object Seminar
            JSONParser jp = new JSONParser();
            JSONObject jo = (JSONObject) jp.parse(sb.toString());
            JSONArray json = (JSONArray) jo.get("data");
            System.out.println("Jumlah Data Seminar yang diambil: " + jo.get("jumlah").toString());
            listSeminar.clear();
            for (int i = 0; i < json.size(); i++) {
                jo = (JSONObject) jp.parse(json.get(i).toString());
                listSeminar.add(new Seminar(
                        jo.get("id").toString(),
                        jo.get("nama").toString(),
                        jo.get("perusahaan").toString(),
                        jo.get("judul").toString(),
                        jo.get("tanggal").toString()));
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
    public void addSeminar(String nim1, String nim2, String judul, String tanggal) {
        try {
            URL url = new URL(LoginDAOREST.ALAMAT + "api/seminar/tambah/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.addRequestProperty("Authorization", LoginDAOREST.USER);
            String input = "{"
                    + "\"nim1\":\"" + nim1
                    + "\",\"nim2\":\"" + nim2
                    + "\",\"judul\":\"" + judul
                    + "\",\"tanggal\":\"" + tanggal
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
            populateSeminar();
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null, e, "Application Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e, "Application Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    @Override
    public void updateSeminar(Seminar seminar) {
        try {
            URL url = new URL(LoginDAOREST.ALAMAT + "api/seminar/ubah/" + seminar.getId());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.addRequestProperty("Authorization", LoginDAOREST.USER);
            String input = "{"
                    + "\"judul\":\"" + seminar.getJudul()
                    + "\",\"tanggal\":\"" + seminar.getTanggal()
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
            populateSeminar();
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null, e, "Application Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e, "Application Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    @Override
    public void deleteSeminar(String nip) {
        try {
            URL url = new URL(LoginDAOREST.ALAMAT + "api/seminar/hapus/" + nip);
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
            populateSeminar();
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null, e, "Application Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e, "Application Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
