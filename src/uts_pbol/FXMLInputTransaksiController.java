/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uts_pbol;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLInputTransaksiController implements Initializable {
    private boolean editdata=false;
    String[] Jadwal = {"J001","J002","J003"};
    ArrayList<String> ListKursi = new ArrayList<>();
    ArrayList<modeljadwal> ListJadwal = new ArrayList<>();
    
    @FXML
    private ToggleButton a1;
    @FXML
    private ToggleButton a2;
    @FXML
    private ToggleButton a3;
    @FXML
    private ToggleButton a4;
    @FXML
    private ToggleButton a5;
    @FXML
    private ToggleButton b1;
    @FXML
    private ToggleButton b4;
    @FXML
    private ToggleButton b5;
    @FXML
    private ToggleButton b2;
    @FXML
    private ToggleButton b3;
    @FXML
    private Button btnpesan;
    @FXML
    private ComboBox<String> CBJadwal;
    @FXML
    private Label txtjudul;
    @FXML
    private Label txttgl;
    @FXML
    private Label txtjam;
    @FXML
    private TextField txtnama;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        CBJadwal.getItems().addAll(Jadwal);
    }    
    
    @FXML
    public void check(){
        ListKursi = FXMLDocumentController.dtkursi.CheckStatus(CBJadwal.getSelectionModel().getSelectedItem());
        ListJadwal = FXMLDocumentController.dtjadwal.AmbilData(CBJadwal.getSelectionModel().getSelectedItem());
        
        txtjudul.setText(ListJadwal.get(0).getJudulfilm());
        txttgl.setText(String.valueOf(ListJadwal.get(0).getTanggal()));
        txtjam.setText(String.valueOf(ListJadwal.get(0).getJam()));
        
        if(ListKursi.get(0).equals("true")){
            a1.setDisable(true);
        } else {
            a1.setDisable(false);
        }
        
        if(ListKursi.get(1).equals("true")){
            a2.setDisable(true);
        } else {
            a2.setDisable(false);
        }
        
        if(ListKursi.get(2).equals("true")){
            a3.setDisable(true);
        } else {
            a3.setDisable(false);
        }
        
        if(ListKursi.get(3).equals("true")){
            a4.setDisable(true);
        } else {
            a4.setDisable(false);
        }
        
        if(ListKursi.get(4).equals("true")){
            a5.setDisable(true);
        } else {
            a5.setDisable(false);
        }
        
        if(ListKursi.get(5).equals("true")){
            b1.setDisable(true);
        } else {
            b1.setDisable(false);
        }
        
        if(ListKursi.get(6).equals("true")){
            b2.setDisable(true);
        } else {
            b2.setDisable(false);
        }
        
        if(ListKursi.get(7).equals("true")){
            b3.setDisable(true);
        } else {
            b3.setDisable(false);
        }
        
        if(ListKursi.get(8).equals("true")){
            b4.setDisable(true);
        } else {
            b4.setDisable(false);
        }
        
        if(ListKursi.get(9).equals("true")){
            b5.setDisable(true);
        } else {
            b5.setDisable(false);
        }
    }

    @FXML
    private void a1klik(ActionEvent event) {
    }

    @FXML
    private void a2klik(ActionEvent event) {
    }

    @FXML
    private void a3klik(ActionEvent event) {
    }

    @FXML
    private void a4klik(ActionEvent event) {
    }

    @FXML
    private void a5klik(ActionEvent event) {
    }

    @FXML
    private void b1klik(ActionEvent event) {
    }

    @FXML
    private void b4klik(ActionEvent event) {
    }

    @FXML
    private void b5klik(ActionEvent event) {
    }

    @FXML
    private void b2klik(ActionEvent event) {
    }

    @FXML
    private void b3klik(ActionEvent event) {
    }

    @FXML
    private void pesanklik(ActionEvent event) throws SQLException {
        ArrayList<String> list = FXMLDocumentController.dttransaksi.IDTrans();
        String urutan;
        if(!list.isEmpty()){
           int urut = Integer.valueOf(list.get(list.size()-1).substring(1)) + 1;
           if(urut<10){urutan = "0"+String.valueOf(urut);}
           else {urutan = String.valueOf(urut);}
       } else {
           urutan ="01";
       }
        
        String Kode= "T"+urutan;
        int jumlah=0;
        if(!a1.isDisabled()){
            if(a1.isSelected()){
                update("K01");
                jumlah +=1;
            }
        }
        
        if(!a2.isDisabled()){
            if(a2.isSelected()){
                update("K02");
                jumlah +=1;
            }
        }
        
        if(!a3.isDisabled()){
            if(a3.isSelected()){
                update("K03");
                jumlah +=1;
            }
        }
        
        if(!a4.isDisabled()){
            if(a4.isSelected()){
                update("K04");
                jumlah +=1;
            }
        }
        
        if(!a5.isDisabled()){
            if(a5.isSelected()){
                update("K05");
                jumlah +=1;
            }
        }
        
        if(!b1.isDisabled()){
            if(b1.isSelected()){
                update("K06");
                jumlah +=1;
            }
        }
        
        if(!b2.isDisabled()){
            if(b2.isSelected()){
                update("K07");
                jumlah +=1;
            }
        }
        
        if(!b3.isDisabled()){
            if(b3.isSelected()){
                update("K08");
                jumlah +=1;
            }
        }
        
        if(!b4.isDisabled()){
            if(b4.isSelected()){
                update("K09");
                jumlah +=1;
            }
        }
        
        if(!b5.isDisabled()){
            if(b5.isSelected()){
                update("K10");
                jumlah +=1;
            }
        }
        
        modeltransaksi n = new modeltransaksi();
               n.setIdtransaksi(Kode);
               n.setNama(txtnama.getText());
               n.setIdjadwal(CBJadwal.getSelectionModel().getSelectedItem());
               n.setJumlahtiket(jumlah);
               n.setTotalharga(jumlah*50000);
                FXMLDocumentController.dttransaksi.setmodeltransaksi(n);
        if (editdata) {
            if (FXMLDocumentController.dttransaksi.update()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data Barang Berhasil Diubah", ButtonType.OK);
                a.showAndWait();
                txtnama.setEditable(true);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data Barang Gagal Diubah", ButtonType.OK);
                a.showAndWait();
            }
            
            } else if (FXMLDocumentController.dttransaksi.validasi(n.getIdjadwal()) <= 0) {
            if (FXMLDocumentController.dttransaksi.insert()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data berhasil disimpan", ButtonType.OK);
                a.showAndWait();
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data gagal disimpan", ButtonType.OK);
                a.showAndWait();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data sudah ada", ButtonType.OK);
            a.showAndWait();
            txtnama.requestFocus();
    }
        System.out.println(Kode);
        if(!a1.isDisabled()){
            if(a1.isSelected()){
                updatetrans(Kode,"K01");
            }
        }
        
        if(!a2.isDisabled()){
            if(a2.isSelected()){
                updatetrans(Kode,"K02");
            }
        }
        
        if(!a3.isDisabled()){
            if(a3.isSelected()){
                updatetrans(Kode,"K03");
            }
        }
        
        if(!a4.isDisabled()){
            if(a4.isSelected()){
                updatetrans(Kode,"K04");
            }
        }
        
        if(!a5.isDisabled()){
            if(a5.isSelected()){
                updatetrans(Kode,"K05");
            }
        }
        
        if(!b1.isDisabled()){
            if(b1.isSelected()){
                updatetrans(Kode,"K06");
            }
        }
        
        if(!b2.isDisabled()){
            if(b2.isSelected()){
                updatetrans(Kode,"K07");
            }
        }
        
        if(!b3.isDisabled()){
            if(b3.isSelected()){
                updatetrans(Kode,"K08");
            }
        }
        
        if(!b4.isDisabled()){
            if(b4.isSelected()){
                updatetrans(Kode,"K09");
            }
        }
        
        if(!b5.isDisabled()){
            if(b5.isSelected()){
                updatetrans(Kode,"K10");
            }
        }
        try{  
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLStruk.fxml"));    
            Parent root = (Parent)loader.load();
            Scene scene = new Scene(root);
            Stage stg=new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();        
        } catch (IOException e){   e.printStackTrace();   }
    }
    
    public void update(String kode){
        modeldetilkursi n = new modeldetilkursi();
                n.setIdjadwal(CBJadwal.getSelectionModel().getSelectedItem());
                n.setIdkursi(kode);
                n.setStatus("true");
                FXMLDocumentController.dtkursi.setmodeldetilkursi(n);
                FXMLDocumentController.dtkursi.update();
    }
    
    public void updatetrans(String a, String b){
        modeldetiltransaksi n = new modeldetiltransaksi();
               n.setIdtransaksi(a);
               n.setIdkursi(b);
               
                FXMLDocumentController.dtdetiltransaksi.setmodeldetiltransaksi(n);
        if (FXMLDocumentController.dtdetiltransaksi.validasi(n.getIdtransaksi(),n.getIdkursi()) <= 0) {
            if (FXMLDocumentController.dtdetiltransaksi.insert()) {
                Alert alrt = new Alert(Alert.AlertType.INFORMATION, "Data berhasil disimpan", ButtonType.OK);
                alrt.showAndWait();
            } else {
                Alert alrt = new Alert(Alert.AlertType.ERROR, "Data gagal disimpan", ButtonType.OK);
                alrt.showAndWait();
            }
        } else {
            Alert alrt = new Alert(Alert.AlertType.ERROR, "Data sudah ada", ButtonType.OK);
            alrt.showAndWait();
            txtnama.requestFocus();
    }
    }
}
    


