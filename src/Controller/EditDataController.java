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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
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
public class EditDataController implements Initializable {
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
    private Button simpan;
    @FXML
    private TextField kodebaru;
    @FXML
    private TextField harga;
    Stage closeStage =new Stage();
    Connection con;
    Statement stm;
    ResultSet rs;
    @FXML
    private MenuItem exit;
    @FXML
    private MenuItem logout;
    @FXML
    private TableColumn<?, ?> colkode;
    @FXML
    private TableColumn<?, ?> colharga;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Koneksi db = new Koneksi();
        db.config();
        stm = db.stm;
        con = db.con;
    }    

     @FXML
    private void kliktmbh(ActionEvent event) {
       try{
        FXMLLoader fxmlloader= new
                    FXMLLoader(getClass().getResource("/FXML/TambahPetugas.fxml"));
                Parent root=(Parent) fxmlloader.load();
             //   Node node = (Node)event.getSource();
             //   closeStage =(Stage) node.getScene().getWindow();
             //   closeStage.close();
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
    private void klikubah(ActionEvent event) {
        try{
        FXMLLoader fxmlloader= new
                    FXMLLoader(getClass().getResource("/FXML/EditPetugas.fxml"));
                Parent root=(Parent) fxmlloader.load();
              //  Node node = (Node)event.getSource();
                //closeStage =(Stage) node.getScene().getWindow();
                //closeStage.close();
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
    private void klikedit(ActionEvent event) {
        try{
        FXMLLoader fxmlloader= new
                    FXMLLoader(getClass().getResource("/FXML/EditData.fxml"));
                Parent root=(Parent) fxmlloader.load();
             //   Node node = (Node)event.getSource();
             //   closeStage =(Stage) node.getScene().getWindow();
            //    closeStage.close();
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

    

    @FXML
    private void simpan(ActionEvent event) {
        try{
            
         int jawab =   JOptionPane.showOptionDialog(null, 
                        "Jadikan sebagai harga", 
                     
                        "tidak",
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.QUESTION_MESSAGE, null, null, null);
          if(jawab == JOptionPane.YES_OPTION)
          {
             String sql = "insert into harga values ("
                    + " '"+kodebaru.getText()+"',"
                    + " '"+harga.getText()+"')";
            stm.executeUpdate(sql); 
            
          }
   }catch(Exception Ex)
        {
            JOptionPane.showMessageDialog(null, "Kesalahan Saat Menyimpan");
        }
        
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
