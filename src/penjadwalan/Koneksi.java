/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjadwalan;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class Koneksi {
    Connection konek;
    public Connection getConnection() {
        try {
            konek = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/penjadwalan", "root", "123");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Koneksi", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        return konek;
    }
}
