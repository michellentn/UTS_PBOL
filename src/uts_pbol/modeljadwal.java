/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts_pbol;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Asus
 */
public class modeljadwal {
    private String idjadwal, judulfilm;
    private Date tanggal;
    private Time jam;

    public String getIdjadwal() {
        return idjadwal;
    }

    public void setIdjadwal(String idjadwal) {
        this.idjadwal = idjadwal;
    }

    public String getJudulfilm() {
        return judulfilm;
    }

    public void setJudulfilm(String judulfilm) {
        this.judulfilm = judulfilm;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Time getJam() {
        return jam;
    }

    public void setJam(Time jam) {
        this.jam = jam;
    }
    
    
    
    
}
