/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts_pbol;

/**
 *
 * @author Asus
 */
public class modeltransaksi {
    private String  idtransaksi,nama, idjadwal;
    private Integer jumlahtiket, totalharga;

    public String getIdtransaksi() {
        return idtransaksi;
    }

    public void setIdtransaksi(String idtransaksi) {
        this.idtransaksi = idtransaksi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getIdjadwal() {
        return idjadwal;
    }

    public void setIdjadwal(String idjadwal) {
        this.idjadwal = idjadwal;
    }

    public Integer getJumlahtiket() {
        return jumlahtiket;
    }

    public void setJumlahtiket(Integer jumlahtiket) {
        this.jumlahtiket = jumlahtiket;
    }

    public Integer getTotalharga() {
        return totalharga;
    }

    public void setTotalharga(Integer totalharga) {
        this.totalharga = totalharga;
    }
   
}
