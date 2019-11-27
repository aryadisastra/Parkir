/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
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
public class TambahPetugasController implements Initializable {
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
    private TextField idbaru;
    @FXML
    private ComboBox<String> lvl;
    @FXML
    private TextField nama;
    @FXML
    private RadioButton laki;
    @FXML
    private ToggleGroup gender;
    @FXML
    private RadioButton cewe;
    @FXML
    private DatePicker ttl;
    @FXML
    private TextField nohp;
    @FXML
    private TextArea alamat;
    @FXML
    private TextField email;
    @FXML
    private ComboBox<String> domain;
    @FXML
    private Button reset;
    Statement stm;
    Connection con;
    ResultSet rs;
    @FXML
    private Button save;
    @FXML
    private Label lbl;
    @FXML
    private TextField idlvl;
    @FXML
    private Label gndr;
    @FXML
    private Label tgl;
    @FXML
    private Label lbldmn;
    Stage closeStage =new Stage();
    @FXML
    private AnchorPane tambahpetugas;
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
        db.config();
        stm = db.stm;
        con = db.con;
        lvl.getItems().setAll("=======Level=======","Manager","Administrator","Karyawan");
        
        lvl.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            public void changed(ObservableValue<?extends String> observacle, String oldValue, String newValue){
                lbl.setText(newValue);
                if(newValue.equals("Manager"))
                {
                    idlvl.setText("MNJ001");
                }
                if(newValue.equals("Administrator"))
                {
                    idlvl.setText("ADM002");
                }
                if(newValue.equals("Karyawan"))
                {
                    idlvl.setText("KRY003");
                }
            }
        });
        domain.getItems().setAll("yahoo", "gmail");
        domain.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
                {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                lbldmn.setText(newValue);
            }
                    
                });
        idlvl.setDisable(true);
        idlvl.setText("ID Level");
       
            ttl.setOnAction(event -> {
                String date = ttl.getValue().toString();
                tgl.setText(date);
            });
    }   
    

    @FXML
    private void kliktmbh(ActionEvent event) {
       try{
        FXMLLoader fxmlloader= new
                    FXMLLoader(getClass().getResource("/FXML/TambahPetugas.fxml"));
                Parent root=(Parent) fxmlloader.load();
              ///  Node node = (Node)event.getSource();
              //  closeStage =(Stage) node.getScene().getWindow();
              //  closeStage.close();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.setFullScreen(true);
                stage.show();
       }catch(Exception Ex)
       {
           JOptionPane.showMessageDialog(null,"Terjadi Kesalahan!!");
       }
    }

    @FXML
    private void klikubah(ActionEvent event) {
        try{
        FXMLLoader fxmlloader= new
                    FXMLLoader(getClass().getResource("/FXML/EditPetugas.fxml"));
                Parent root=(Parent) fxmlloader.load();
              /// Node node = (Node)event.getSource();
              //  closeStage =(Stage) node.getScene().getWindow();
              //  closeStage.close();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.setFullScreen(true);
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
             //   Node node = (Node)event.getSource();
            //    closeStage =(Stage) node.getScene().getWindow();
            //    closeStage.close();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.setFullScreen(true);
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

   

    @FXML
    private void save(ActionEvent event) {
        try{
            String sql = "insert into petugas values"
                    + "('"+idbaru.getText()+"',"
                    + " '"+nama.getText()+"',"
                    + " '"+idlvl.getText()+"',"
                    + " '"+gndr.getText()+"',"
                    + " '"+tgl.getText()+"', "
                    + " '"+nohp.getText()+"',"
                    + " '"+email.getText()+"@"+lbldmn.getText()+".com',"
                    + " '"+alamat.getText()+"')";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Berhasil input data");
            segar();
        }catch(Exception EX)
        {
            JOptionPane.showMessageDialog(null,"Tidak Bisa Tambah Data"+EX);
        }
    }

    @FXML
    private void refresh(ActionEvent event) {
        segar();
    }

    @FXML
    private void rbkliklk(ActionEvent event) {
        gndr.setText("Laki-Laki");
    }

    @FXML
    private void rbklikcw(ActionEvent event) {
                gndr.setText("Perempuan");

    }
    public void segar()
    {
         alamat.setText("");
        email.setText("");
        idbaru.setText("");
        idlvl.setText("ID Level");
        lvl.getSelectionModel().selectFirst();
        nama.setText("");
        nohp.setText("");
        cewe.setSelected(false);
        laki.setSelected(false);
        ttl.setValue(null);
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