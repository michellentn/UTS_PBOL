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
public class DBdetilkursi {
    private modeldetilkursi dt = new modeldetilkursi();

    public modeldetilkursi getmodeldetilkursi() {
        return (dt);
    }

    public void setmodeldetilkursi(modeldetilkursi s) {
        dt = s;
    }

    public ObservableList<modeldetilkursi> Load() {
        try {
            ObservableList<modeldetilkursi> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select idjadwal, d.idkursi , namakursi, status from detilkursi d "
                    + "join kursi k on (d.idkursi = k.idkursi");
            int i = 1;
       
            while (rs.next()) {
                modeldetilkursi d = new modeldetilkursi();
                d.setIdjadwal(rs.getString("idjadwal"));
                d.setIdkursi(rs.getString("idkursi"));
                d.setNamakursi(rs.getString("namakursi"));
                d.setStatus(rs.getString("status"));

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
            ResultSet rs = con.statement.executeQuery(  "select count(*) as jml from detilkursi d "
                    + "join kursi k on (d.idkursi = k.idkursi");
            while (rs.next()) {                
                val = rs.getInt("jml");            
            }            
            con.tutupKoneksi();
        } catch (SQLException e) {            
            e.printStackTrace();        
        }
        return val;
    }
     
     
    /*
    public boolean delete(String nomor, String kode) {
        boolean berhasil = false;        
        koneksi con = new koneksi();
        try {            
            con.bukaKoneksi();;
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from jual_detil where nojual  = ? and kodebrg = ?");
            con.preparedStatement.setString(1, nomor);
            con.preparedStatement.setString(2, kode);
            con.preparedStatement.executeUpdate();            
            berhasil = true;
        } catch (Exception e) {            
            e.printStackTrace();
        } finally {            
            con.tutupKoneksi();            
            return berhasil;        
        }
    }*/
    
    /*
    public boolean deleteall(String nomor) {
        boolean berhasil = false;        
        koneksi con = new koneksi();
        try {            
            con.bukaKoneksi();;
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from jual_detil where nojual  = ?");
            con.preparedStatement.setString(1, nomor);
            con.preparedStatement.executeUpdate();            
            berhasil = true;
        } catch (Exception e) {            
            e.printStackTrace();
        } finally {            
            con.tutupKoneksi();            
            return berhasil;        
        }
    }*/
    
    public boolean update() {
        boolean berhasil = false;        
        Koneksi con = new Koneksi();
        try {            
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("update detilkursi set status = ? where  idjadwal= ? and idkursi= ?");
            con.preparedStatement.setString(1, getmodeldetilkursi().getStatus());
            con.preparedStatement.setString(2, getmodeldetilkursi().getIdjadwal());
            con.preparedStatement.setString(3, getmodeldetilkursi().getIdkursi());
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
    
    
    public ArrayList<String> CheckStatus(String nomor) {
        ArrayList List = new ArrayList<>();
        try {
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select status from detilkursi where idjadwal = '" + nomor + "'");
       
            while (rs.next()) {
                List.add(rs.getString("status"));
            }
            con.tutupKoneksi();
            return List;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
