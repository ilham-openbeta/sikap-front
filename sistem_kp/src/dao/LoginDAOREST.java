/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author barokah
 */
public class LoginDAOREST implements LoginDAO {

    public static String USER;
    public static String ALAMAT;

    public boolean login(String username, String password) {
        try {
            BufferedReader cfg = new BufferedReader(new FileReader("server.cfg"));
            ALAMAT = cfg.readLine();
        } catch (FileNotFoundException ex) {
//            Logger.getLogger(LoginDAOREST.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Application Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException ex) {
//            Logger.getLogger(LoginDAOREST.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Application Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        try {
            URL url = new URL(ALAMAT + "api/check");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            String userpass = username + ":" + password;
            USER = "Basic " + DatatypeConverter.printBase64Binary(userpass.getBytes());
            conn.setRequestProperty("Authorization", USER);
            if (conn.getResponseCode() == HttpURLConnection.HTTP_UNAUTHORIZED) {
                return false;
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            conn.disconnect();
            return true;
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null, e, "Application Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e, "Application Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return false;
    }
}
