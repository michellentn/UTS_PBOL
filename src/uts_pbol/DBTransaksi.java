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
public class DBTransaksi {
    private modeltransaksi dt = new modeltransaksi();
    public modeltransaksi getmodeltransaksi() {
        return (dt);}
    public void setmodeltransaksi(modeltransaksi t) {
        dt = t;
    }

    public ObservableList<modeltransaksi> Load() {
        try {
            ObservableList<modeltransaksi> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select idtransaksi, nama, idjadwal, jumlahtiket, totalharga from transaksi");

            int i = 1;
            while (rs.next()) {
                modeltransaksi d = new modeltransaksi();
                d.setIdtransaksi(rs.getString("idtransaksi"));
                d.setNama(rs.getString("nama"));
                d.setIdjadwal(rs.getString("idjadwal"));
                d.setJumlahtiket(rs.getInt("jumlahtiket"));
                d.setTotalharga(rs.getInt("totalharga"));
                
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
            ResultSet rs = con.statement.executeQuery(  "select count(*) as jml from transaksi where idtransaksi = '" + nomor + "'");
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into transaksi (idtransaksi, nama, idjadwal, jumlahtiket, totalharga) values (?,?,?,?,?)");
            con.preparedStatement.setString(1, getmodeltransaksi().getIdtransaksi());           
            con.preparedStatement.setString(2, getmodeltransaksi().getNama());
            con.preparedStatement.setString(3, getmodeltransaksi().getIdjadwal());           
            con.preparedStatement.setInt(4, getmodeltransaksi().getJumlahtiket());        
            con.preparedStatement.setInt(5, getmodeltransaksi().getTotalharga());  
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
    public boolean delete(String nomor) {
        boolean berhasil = false;        
        Koneksi con = new Koneksi();
        try {            
            con.bukaKoneksi();;
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from transaksi where idtransaksi  = ? ");
            con.preparedStatement.setString(1, nomor);
            con.preparedStatement.executeUpdate();            
            berhasil = true;
        } catch (Exception e) {            
            e.printStackTrace();
        } finally {            
            con.tutupKoneksi();            
            return berhasil;        
        }
    }
    public boolean update() {
        boolean berhasil = false;        
        Koneksi con = new Koneksi();
        try {            
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("update customer set idtransaksi = ?, nama = ?, idjadwal = ?, jumlahtiket = ?, totalharga = ?  where  idtransaksi = ? ");
            con.preparedStatement.setString(1, getmodeltransaksi().getIdtransaksi());           
            con.preparedStatement.setString(2, getmodeltransaksi().getNama());
            con.preparedStatement.setString(3, getmodeltransaksi().getIdjadwal());           
            con.preparedStatement.setInt(4, getmodeltransaksi().getJumlahtiket());        
            con.preparedStatement.setInt(5, getmodeltransaksi().getTotalharga());
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
    
    public ObservableList<modeltransaksi>  CariTransaksi(String nama) {
        try {    
            ObservableList<modeltransaksi> 	tableData;
            tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi(); 
            con.bukaKoneksi();
            con.statement = (Statement) con.dbKoneksi.createStatement();
            ResultSet rs = (ResultSet) con.statement.executeQuery("select * from transaksi WHERE nama LIKE '" + nama + "%'");
        int i = 1;
        while(rs.next()){
            modeltransaksi d = new modeltransaksi();
            d.setIdtransaksi(rs.getString("idtransaksi"));
            d.setIdjadwal(rs.getString("idjadwal"));
            d.setNama(rs.getString("nama"));
            d.setJumlahtiket(rs.getInt("jumlahtiket"));
            d.setTotalharga(rs.getInt("totalharga"));
            tableData.add(d);
            i++;
        }
        con.tutupKoneksi();
        return tableData;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    } 
    
    public modeljadwal AmbilTransaksi(String nomor) throws SQLException{
        
        modeljadwal n = new modeljadwal();
        Koneksi con = new Koneksi();
        con.bukaKoneksi();
        con.statement = con.dbKoneksi.createStatement();
        ResultSet rs = con.statement.executeQuery("Select haritayang, jamtayang from jadwalfilm where idjadwal = '" + nomor + "'");
        while(rs.next()){
            n.setTanggal(rs.getDate("haritayang"));
            n.setJam(rs.getTime("jamtayang"));
        }
        
        return n;
    }
    
    public ArrayList<String> IDTrans() throws SQLException{
        ArrayList List = new ArrayList<>();
        modeltransaksi n = new modeltransaksi();
        Koneksi con = new Koneksi();
        con.bukaKoneksi();
        con.statement = con.dbKoneksi.createStatement();
        ResultSet rs = con.statement.executeQuery("Select idtransaksi from transaksi");
        while(rs.next()){
            List.add(rs.getString("idtransaksi"));
        }
        
        return List;
    }
}
