/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author aryz
 */
public class IndexController implements Initializable {
    Koneksi conn;
    @FXML
    private MenuItem tambahptgs;
    @FXML
    private MenuItem ubhptgs;
    @FXML
    private MenuItem editdata;
    @FXML
    private MenuItem cetak;
    @FXML
    private Menu keluar;
    @FXML
    private Label namapetugas;
    @FXML
    private TableView<ImplementTabel.Data> tabel;
    ObservableList<ImplementTabel.Data> listdata;
    @FXML
    private TableColumn<ImplementTabel.Data, String> colno;
    @FXML
    private TableColumn<ImplementTabel.Data, String> colnama;
    @FXML
    private TableColumn<ImplementTabel.Data, String> collvl;
    @FXML
    private TableColumn<ImplementTabel.Data, String> colgndr;
    @FXML
    private TableColumn<ImplementTabel.Data, String> colttl;
    @FXML
    private TableColumn<ImplementTabel.Data, String> colalamat;
    @FXML
    private TableColumn<ImplementTabel.Data, String> colnohp;
    @FXML
    private TableColumn<ImplementTabel.Data, String> colimel;
    @FXML
    private TableColumn<ImplementTabel.Data, String> colid;
    Connection con;
    ResultSet rs = null;
    Statement stm;
    ImplementTabel it = new ImplementTabel();
    @FXML
    private TableView<ImplementTabelKendaraan.Data> tabelkend;
    ObservableList<ImplementTabelKendaraan.Data> listdatak;
    @FXML
    private TableColumn<ImplementTabelKendaraan.Data, String> colnotkt;
    @FXML
    private TableColumn<ImplementTabelKendaraan.Data, String> coljmmsk;
    @FXML
    private TableColumn<ImplementTabelKendaraan.Data, String> coljmklr;
    @FXML
    private TableColumn<ImplementTabelKendaraan.Data, String> colharga;
    @FXML
    private TableColumn<ImplementTabelKendaraan.Data, String> colidptgs;
    ImplementTabelKendaraan itk = new ImplementTabelKendaraan();
   
    @FXML
    private TableColumn<ImplementTabelKendaraan.Data, String> colnok;
    Stage closeStage =new Stage();
    @FXML
    private AnchorPane index;
    @FXML
    private MenuItem exit;
    @FXML
    private MenuItem logout;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Koneksi db = new Koneksi();
        con = db.con;
        stm = db.stm;
        tabell();
        aksitabel();
        tabellk();
        aksitabelk();
    }    

    @FXML
    private void kliktmbh(ActionEvent event) {
       try{
       FXMLLoader fxmlloader= new
                    FXMLLoader(getClass().getResource("/FXML/TambahPetugas.fxml"));
                Parent root=(Parent) fxmlloader.load();
                MenuItem node = (MenuItem) event.getSource();
 //               Node node = (Node)event.getSource();
  //              closeStage =(Stage) node.getClass();
   //             closeStage.close();
                Stage stage = new Stage();
                stage.setFullScreen(true);
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.show();
                
       }catch(Exception Ex)
       {
           JOptionPane.showMessageDialog(null,"Terjadi Kesalahan!!"+Ex);
       }
    }

    @FXML
    private void klikubah(ActionEvent event) {
        try{
        FXMLLoader fxmlloader= new
                    FXMLLoader(getClass().getResource("/FXML/EditPetugas.fxml"));
                Parent root=(Parent) fxmlloader.load();
             //   Node node = (Node)event.getSource();
            // /   closeStage =(Stage) node.getScene().getWindow();
            //    closeStage.close();
                Stage stage = new Stage();
              //  stage.setFullScreen(true);
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.show();
       }catch(Exception Ex)
       {
           JOptionPane.showMessageDialog(null,"Terjadi Kesalahan!!");
       }
    }

    @FXML
    private void klikedit(ActionEvent event) {
        try{
        FXMLLoader fxmlloader= new
                    FXMLLoader(getClass().getResource("/FXML/EditData.fxml"));
                Parent root=(Parent) fxmlloader.load();
           //     Node node = (Node)event.getSource();
          // /     closeStage =(Stage) node.getScene().getWindow();
         // /  //    closeStage.close();
                Stage stage = new Stage();
                stage.setFullScreen(true);
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.show();
       }catch(Exception Ex)
       {
           JOptionPane.showMessageDialog(null,"Terjadi Kesalahan!!");
       }
    }

    

    @FXML
    private void klikcetak(ActionEvent event) {
        try{
        FXMLLoader fxmlloader= new
                    FXMLLoader(getClass().getResource("/FXML/Report.fxml"));
                Parent root=(Parent) fxmlloader.load();
           //     Node node = (Node)event.getSource();
          // /     closeStage =(Stage) node.getScene().getWindow();
         // /  //    closeStage.close();
                Stage stage = new Stage();
                stage.setFullScreen(true);
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.show();
       }catch(Exception Ex)
       {
           JOptionPane.showMessageDialog(null,"Terjadi Kesalahan!!");
       }
    }

    public void setNama(String nama)
    {
        this.namapetugas.setText(nama);
        namapetugas.setTextAlignment(TextAlignment.CENTER);
    }

    @FXML
    private void ambildata(MouseEvent event) {
    }

    private void tabell() {
     colno.setCellValueFactory((TableColumn.CellDataFeatures<ImplementTabel.Data, String> celData) ->
                celData.getValue().noProperty());
         colid.setCellValueFactory((TableColumn.CellDataFeatures<ImplementTabel.Data, String> celData) ->
                celData.getValue().IdPetProperty());
         collvl.setCellValueFactory((TableColumn.CellDataFeatures<ImplementTabel.Data, String> celData) ->
                celData.getValue().idlvlProperty());
         colnama.setCellValueFactory((TableColumn.CellDataFeatures<ImplementTabel.Data, String> celData) ->
                celData.getValue().nameProperty());
         colgndr.setCellValueFactory((TableColumn.CellDataFeatures<ImplementTabel.Data, String> celData) ->
                celData.getValue().gndrProperty());
         colalamat.setCellValueFactory((TableColumn.CellDataFeatures<ImplementTabel.Data, String> celData) ->
                celData.getValue().adressProperty());
         colnohp.setCellValueFactory((TableColumn.CellDataFeatures<ImplementTabel.Data, String> celData) ->
                celData.getValue().nohpProperty());
         colimel.setCellValueFactory((TableColumn.CellDataFeatures<ImplementTabel.Data, String> celData) ->
                celData.getValue().ImelProperty());
         listdata =FXCollections.observableArrayList();
         tabel.getSelectionModel().clearSelection();
    }
    
    private void aksitabel() {
        listdata = it.getDataAll();
        tabel.setItems(listdata);
    }
    private void tabellk() {
        colnok.setCellValueFactory((TableColumn.CellDataFeatures<ImplementTabelKendaraan.Data, String> celData) ->
                celData.getValue().noProperty());
         colnotkt.setCellValueFactory((TableColumn.CellDataFeatures<ImplementTabelKendaraan.Data, String> celData) ->
                celData.getValue().notktProperty());
         coljmmsk.setCellValueFactory((TableColumn.CellDataFeatures<ImplementTabelKendaraan.Data, String> celData) ->
                celData.getValue().jammskProperty());
         coljmklr.setCellValueFactory((TableColumn.CellDataFeatures<ImplementTabelKendaraan.Data, String> celData) ->
                celData.getValue().jamklrProperty());
         colharga.setCellValueFactory((TableColumn.CellDataFeatures<ImplementTabelKendaraan.Data, String> celData) ->
                celData.getValue().hargaProperty());
         colidptgs.setCellValueFactory((TableColumn.CellDataFeatures<ImplementTabelKendaraan.Data, String> celData) ->
                celData.getValue().idadminProperty());
       //  col.setCellValueFactory((TableColumn.CellDataFeatures<ImplementTabelKendaraan.Data, String> celData) ->
      //          celData.getValue().nohpProperty());
        // colimel.setCellValueFactory((TableColumn.CellDataFeatures<ImplementTabelKendaraan.Data, String> celData) ->
      //          celData.getValue().ImelProperty());
         listdatak =FXCollections.observableArrayList();
         tabelkend.getSelectionModel().clearSelection();
    }
    private void aksitabelk() {
        listdatak = itk.getDataAll();
        tabelkend.setItems(listdatak);
    }

    @FXML
    private void kliklogout(ActionEvent event) {
        try{
        FXMLLoader fxmlloader= new
                    FXMLLoader(getClass().getResource("/FXML/LoginAdmin.fxml"));
                Parent root=(Parent) fxmlloader.load();
              //  Node node = (Node)event.getSource();
             //   closeStage =(Stage) node.getScene().getWindow();
              //  closeStage.close();
                Stage stage = new Stage();
                stage.setFullScreen(true);
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.show();
                
       }catch(Exception Ex)
       {
           JOptionPane.showMessageDialog(null,"Terjadi Kesalahan!!"+Ex);
       }
    }
    @FXML
    private void klikkluar(ActionEvent event) {
      System.exit(0);
            
    }
}
