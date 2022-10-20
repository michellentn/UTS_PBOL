/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts_pbol;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Asus
 */
public class DBDetilTransaksi {

    private modeldetiltransaksi dt = new modeldetiltransaksi();

    public modeldetiltransaksi getmodeldetiltransaksi() {
        return (dt);
    }

    public void setmodeldetiltransaksi(modeldetiltransaksi t) {
        dt = t;
    }

    
    public ObservableList<modeldetiltransaksi> Load(String nomor) {
        try {
            ObservableList<modeldetiltransaksi> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select idtransaksi, idkursi from detiltrans where idtransaksi = '" + nomor + "'");

            int i = 1;
            while (rs.next()) {
                modeldetiltransaksi d = new modeldetiltransaksi();
                d.setIdtransaksi(rs.getString("idtransaksi"));
                d.setIdkursi(rs.getString("idkursi"));
                tableData.add(d);
                i++;
            }
            con.tutupKoneksi();
            return tableData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int validasi(String nomor, String kursi) {
        int val = 0;
        try {
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from detiltrans where idtransaksi = '" + nomor + "' and idkursi = '" + kursi + "'");
            while (rs.next()) {
                val = rs.getInt("jml");
            }
            con.tutupKoneksi();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }

    public boolean insert() {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into detiltrans (idtransaksi, idkursi) values (?,?)");
            con.preparedStatement.setString(1, getmodeldetiltransaksi().getIdtransaksi());           
            con.preparedStatement.setString(2, getmodeldetiltransaksi().getIdkursi());
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
            berhasil = false;
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }
    
    

}
