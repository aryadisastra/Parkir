/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author aryz
 */
public class LoginAdminController implements Initializable {
    Connection con;
    Statement stm;
    ResultSet rs;
    ResultSet res;
    Statement st;
    String nama;
    @FXML
    private PasswordField idadmin;
    Stage closeStage =new Stage();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    public void masuk(KeyEvent event) {
        


        
        
    }

    @FXML
    public void input(KeyEvent event) {
        final KeyCombination keyComb1 = new KeyCodeCombination(KeyCode.M,
                                  KeyCombination.CONTROL_DOWN);
      idadmin.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler() {

           @Override
         public void handle(Event event) {
               if (keyComb1.match((KeyEvent) event)) {

                    String idmnj =   JOptionPane.showInputDialog("ID Anda ?");
                    try{
                                String sql = "SELECT * FROM petugas WHERE id_petugas = '"+idmnj+"' AND kode_level = 'MNJ001' ";
                                rs = stm.executeQuery(sql);
                        if(rs.next())
                       {
                FXMLLoader fxmlloader= new
                FXMLLoader(getClass().getResource("/FXML/Index.fxml"));
                Parent root=(Parent) fxmlloader.load();
                Node node = (Node)event.getSource();
                closeStage =(Stage) node.getScene().getWindow();
                closeStage.close();
                IndexController in = fxmlloader.getController();
                in.setNama(rs.getString("nama"));
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.setFullScreen(true);
                stage.setFullScreenExitHint("Layar Anda Akan Otomatis Full Screen");
              //  stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
                stage.show();
                idadmin.setText("");
                
                
            }
                        else{
         JOptionPane.showMessageDialog(null, "Anda Tidak Memiliki Hak Akses");
    }
                        
                    }catch(Exception Ex)
                    {
                        Ex.printStackTrace();
                    }

                    }            }

     });
    
       
    }
    

    @FXML
    private void entermasuk(KeyEvent event) {
         
    }

    @FXML
    private void aksimasuk(ActionEvent event) {
        Koneksi db = new Koneksi();
         db.config();
        con = db.con;
        stm = db.stm;
        st = db.stm;
        try{            
            res = st.executeQuery("SELECT * FROM petugas WHERE id_petugas = '"+idadmin.getText()+"' AND kode_level ='ADM002'");
            if(res.next())
            {
                 FXMLLoader fxmlloader= new
                    FXMLLoader(getClass().getResource("/FXML/KeluarKendaraan.fxml"));
                Parent root=(Parent) fxmlloader.load();
                Node node = (Node)event.getSource();
                closeStage =(Stage) node.getScene().getWindow();
                closeStage.close();
                KeluarKendaraanController ken = fxmlloader.getController();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.setFullScreen(true);
                stage.setFullScreenExitHint("Layar Anda Akan Otomatis Full Screen");
                stage.show();
                nama = res.getString("nama");
                idadmin.setText("");
                
            }
            
            else{
                JOptionPane.showMessageDialog(null, "Anda Tidak Memiliki Hak Akses");            }
            idadmin.setText("");
        }catch(Exception Ex){
           
        }
        
        
    
}}
