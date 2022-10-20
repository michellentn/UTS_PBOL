/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uts_pbol;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLStrukController implements Initializable {

    @FXML
    private Label txtnama;
    @FXML
    private Label txtjudulfilm;
    @FXML
    private Label txttgl;
    @FXML
    private Label txtjam;
    @FXML
    private Label txttotaltiket;
    @FXML
    private Label txttotalbayar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        modeltransaksi n = new modeltransaksi();
        n = FXMLDocumentController.dttransaksi.getmodeltransaksi();
        modeljadwal j = new modeljadwal();
        try {
            j = FXMLDocumentController.dttransaksi.AmbilTransaksi(n.getIdjadwal());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLStrukController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        txtnama.setText(n.getNama());
        txtjudulfilm.setText(n.getIdjadwal());
        txttgl.setText(String.valueOf(j.getTanggal()));
        txtjam.setText(String.valueOf(j.getJam()));
        txttotaltiket.setText(String.valueOf(n.getJumlahtiket()));
        txttotalbayar.setText(String.valueOf(n.getTotalharga()));
    }    
    
}
