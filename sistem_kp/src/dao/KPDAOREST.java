/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.*;
import java.net.*;
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
public class KPDAOREST implements KPDAO {

    List<KP> listKP;

    public KPDAOREST() {
        listKP = new ArrayList<>();
        populateKP();
    }

    @Override
    public KP getKP(int index) {
        return listKP.get(index);
    }

    @Override
    public List<KP> getAllKP() {
        return listKP;
    }

    public void populateKP() {
        try {
            URL url = new URL(LoginDAOREST.ALAMAT + "api/kp");
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
            // Mengubah String menjadi Object JSON kemudian mengubahnya ke Object KP
            JSONParser jp = new JSONParser();
            JSONObject jo = (JSONObject) jp.parse(sb.toString());
            JSONArray json = (JSONArray) jo.get("data");
            System.out.println("Jumlah Data KP yang diambil: " + jo.get("jumlah").toString());
            listKP.clear();
            for (int i = 0; i < json.size(); i++) {
                jo = (JSONObject) jp.parse(json.get(i).toString());
                listKP.add(new KP(
                        jo.get("id").toString(),
                        jo.get("nim").toString(),
                        jo.get("nama").toString(),
                        jo.get("jurusan").toString(),
                        jo.get("perusahaan").toString(),
                        jo.get("alamat").toString(),
                        jo.get("kontak").toString(),
                        jo.get("tanggal_mulai").toString(),
                        jo.get("tanggal_selesai").toString(),
                        jo.get("status").toString(),
                        (jo.get("nip") == null) ? "" : jo.get("nip").toString(),
                        (jo.get("dosen") == null) ? "" : jo.get("dosen").toString(),
                        (jo.get("tanggal") == null) ? "" : jo.get("tanggal").toString(),
                        (jo.get("no_surat") == null) ? "" : jo.get("no_surat").toString(),
                        (jo.get("tanggal_surat") == null) ? "" : jo.get("tanggal_surat").toString(),
                        jo.get("tanggal_diubah").toString()));
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
    public void updateKP(KP kp) {
        try {
            URL url = new URL(LoginDAOREST.ALAMAT + "api/kp/ubah/" + kp.getId());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.addRequestProperty("Authorization", LoginDAOREST.USER);
            String input = "{"
                    + "\"nip\":\"" + kp.getNip()
                    + "\",\"status\":\"" + kp.getStatus()
                    + "\",\"no_surat\":\"" + kp.getNoSurat()
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
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null, e, "Application Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e, "Application Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    @Override
    public void deleteKP(String nip) {
        try {
            URL url = new URL(LoginDAOREST.ALAMAT + "api/kp/hapus/" + nip);
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
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null, e, "Application Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e, "Application Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
