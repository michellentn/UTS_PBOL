/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts_pbol;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Asus
 */
public class DBJadwal {

    private modeljadwal dt = new modeljadwal();

    public modeljadwal getmodeljadwal() {
        return (dt);
    }

    public void setmodeljadwal(modeljadwal s) {
        dt = s;
    }

    public ObservableList<modeljadwal> Load() {
        try {
            ObservableList<modeljadwal> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select idjadwal, judulfilm, haritayang, jamtayang from jadwalfilm j "
                    + "join film f on (j.idfilm = f.idfilm)");

            int i = 1;
            while (rs.next()) {
                modeljadwal d = new modeljadwal();
                d.setIdjadwal(rs.getString("idjadwal"));
                d.setJudulfilm(rs.getString("judulfilm"));
                d.setTanggal(rs.getDate("haritayang"));
                d.setJam(rs.getTime("jamtayang"));

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

    public int validasi(String nomor) {
        int val = 0;
        try {
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from jadwalfilm j "
                    + "join film f on (j.idfilm = f.idfilm) where idjadwal = '" + nomor + "'");
            while (rs.next()) {
                val = rs.getInt("jml");
            }
            con.tutupKoneksi();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }

      public ArrayList<modeljadwal> AmbilData(String nomor) {
        try {
            ArrayList List = new ArrayList<>();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select idjadwal, judulfilm, haritayang, jamtayang from jadwalfilm j "
                    + "join film f on (j.idfilm = f.idfilm) where idjadwal = '" + nomor + "'");

            int i = 1;
            while (rs.next()) {
                modeljadwal d = new modeljadwal();
                d.setIdjadwal(rs.getString("idjadwal"));
                d.setJudulfilm(rs.getString("judulfilm"));
                d.setTanggal(rs.getDate("haritayang"));
                d.setJam(rs.getTime("jamtayang"));

                List.add(d);
                i++;
            }
            con.tutupKoneksi();
            return List;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

   
}
