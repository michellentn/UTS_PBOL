/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uts_pbol;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLDisplayTransaksiController implements Initializable {

    @FXML
    private TableView<modeltransaksi> tbvtransaksi;
    @FXML
    private Button btnawal;
    @FXML
    private Button btnakhir;
    @FXML
    private Button btnsebelum;
    @FXML
    private Button btnsesudah;
    @FXML
    private TableView<modeldetiltransaksi> tbvdetiltransaksi;
    @FXML
    private TextField txtcaridata;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showdata();
        
    }    

    public void showdata() {
        ObservableList<modeltransaksi> data = FXMLDocumentController.dttransaksi.Load();
        if (data != null) {
            tbvtransaksi.getColumns().clear();
            tbvtransaksi.getItems().clear();

            TableColumn col = new TableColumn("idtransaksi");
            col.setCellValueFactory(new PropertyValueFactory<modeltransaksi, String>("idtransaksi"));
            tbvtransaksi.getColumns().addAll(col);
            
            col = new TableColumn("nama");
            col.setCellValueFactory(new PropertyValueFactory<modeltransaksi, String>("nama"));
            tbvtransaksi.getColumns().addAll(col);
            
            col = new TableColumn("idjadwal");
            col.setCellValueFactory(new PropertyValueFactory<modeltransaksi, String>("idjadwal"));
            tbvtransaksi.getColumns().addAll(col);
            
            col = new TableColumn("jumlahtiket");
            col.setCellValueFactory(new PropertyValueFactory<modeltransaksi, String>("jumlahtiket"));
            tbvtransaksi.getColumns().addAll(col);
            
            col = new TableColumn("totalharga");
            col.setCellValueFactory(new PropertyValueFactory<modeltransaksi, String>("totalharga"));
            tbvtransaksi.getColumns().addAll(col);
            
            tbvtransaksi.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvtransaksi.getScene().getWindow().hide();;
        }
    }

    @FXML
    private void cariData(KeyEvent event) {
        modeltransaksi s = new modeltransaksi();
        String key = txtcaridata.getText();
        if(key!=""){
        ObservableList<modeltransaksi> data=FXMLDocumentController.dttransaksi.CariTransaksi(key);
        if(data!=null){            
            tbvtransaksi.getColumns().clear();
            tbvtransaksi.getItems().clear();
            
            TableColumn col = new TableColumn("idtransaksi");
            col.setCellValueFactory(new PropertyValueFactory<modeltransaksi, String>("idtransaksi"));
            tbvtransaksi.getColumns().addAll(col);
            
            col = new TableColumn("nama");
            col.setCellValueFactory(new PropertyValueFactory<modeltransaksi, String>("nama"));
            tbvtransaksi.getColumns().addAll(col);
            
            col = new TableColumn("idjadwal");
            col.setCellValueFactory(new PropertyValueFactory<modeltransaksi, String>("idjadwal"));
            tbvtransaksi.getColumns().addAll(col);
            
            col = new TableColumn("jumlahtiket");
            col.setCellValueFactory(new PropertyValueFactory<modeltransaksi, String>("jumlahtiket"));
            tbvtransaksi.getColumns().addAll(col);
            
            col = new TableColumn("totalharga");
            col.setCellValueFactory(new PropertyValueFactory<modeltransaksi, String>("totalharga"));
            tbvtransaksi.getColumns().addAll(col);
            
            tbvtransaksi.setItems(data);
            
        }else {
            Alert a=new Alert(Alert.AlertType.ERROR,"Data kosong",ButtonType.OK);
            a.showAndWait();
            tbvtransaksi.getScene().getWindow().hide();;
        }            
            } else{
               showdata();
            }        
    }
    

    @FXML
    private void akhirklik(ActionEvent event) {
        tbvtransaksi.getSelectionModel().selectLast();
        tbvtransaksi.requestFocus();
    }

    @FXML
    private void sesudahklik(ActionEvent event) {
        tbvtransaksi.getSelectionModel().selectBelowCell();
        tbvtransaksi.requestFocus();
    }

    @FXML
    private void sebelumklik(ActionEvent event) {
        tbvtransaksi.getSelectionModel().selectAboveCell();
        tbvtransaksi.requestFocus();
    }

    @FXML
    private void awalklik(ActionEvent event) {
        tbvtransaksi.getSelectionModel().selectFirst();
        tbvtransaksi.requestFocus();
    }

 
    @FXML
    public void setdata(){
        showdatadetil();
    }
    
    public void showdatadetil() {
        ObservableList<modeldetiltransaksi> data = FXMLDocumentController.dtdetiltransaksi.Load(tbvtransaksi.getSelectionModel().getSelectedItem().getIdtransaksi());
        if (data != null) {
            tbvdetiltransaksi.getColumns().clear();
            tbvdetiltransaksi.getItems().clear();

            TableColumn col = new TableColumn("idtransaksi");
            col.setCellValueFactory(new PropertyValueFactory<modeldetiltransaksi, String>("idtransaksi"));
            tbvdetiltransaksi.getColumns().addAll(col);
            
            col = new TableColumn("idkursi");
            col.setCellValueFactory(new PropertyValueFactory<modeldetiltransaksi, String>("idkursi"));
            tbvdetiltransaksi.getColumns().addAll(col);
            
            
            tbvdetiltransaksi.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvdetiltransaksi.getScene().getWindow().hide();;
        }
    }
}
