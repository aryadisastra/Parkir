/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.ImplementTabel.Data;
import java.io.InputStream;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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
public class EditPetugasController implements Initializable {
    Koneksi conn;
    @FXML
    private TableView<Data> tabel;
    @FXML
    private TableColumn<Data, String> colid;
    @FXML
    private TextField id;
    @FXML
    private TextField nama;
    @FXML
    private DatePicker ttl;
    @FXML
    private TextField nohp;
    @FXML
    private TextField lvl;
    @FXML
    private TextField email;
    @FXML
    private TextArea alamat;
    @FXML
    private Button edit;
    @FXML
    private Button delete;
    @FXML
    private Button refresh;
    
    ObservableList<Data> listdata;
    @FXML
    private TableColumn<Data, String> colno;
    @FXML
    private TableColumn<Data, String> colnama;
    @FXML
    private TableColumn<Data, String> collvl;
    @FXML
    private TableColumn<Data, String> colgndr;
    @FXML
    private TableColumn<Data, String> colttl;
    @FXML
    private TableColumn<Data, String> colalamat;
    @FXML
    private TableColumn<Data, String> colnohp;
    @FXML
    private TableColumn<Data, String> colimel;
    Connection con;
    ResultSet rs;
    Statement stm;
    
    @FXML
    private Label tgl;
    @FXML
    private Label idlvl;
    Stage closeStage =new Stage();
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
    private MenuItem exit;
    @FXML
    private MenuItem logout;
    Integer urut =0;
    

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
        ttl.setOnAction(event -> {
                String date = ttl.getValue().toString();
                
                DateTimeFormatter ff = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                tgl.setText(date);
            });
        if(lvl.getText().equals("Manager"))
        {
            idlvl.setText("MNJ001");
        }
    }    

    @FXML
    private void kliktmbh(ActionEvent event) {
       try{
        FXMLLoader fxmlloader= new
                    FXMLLoader(getClass().getResource("/FXML/TambahPetugas.fxml"));
                Parent root=(Parent) fxmlloader.load();
           //     Node node = (Node)event.getSource();
           //     closeStage =(Stage) node.getScene().getWindow();
           //     closeStage.close();
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
            ////    Node node = (Node)event.getSource();
             //   closeStage =(Stage) node.getScene().getWindow();
              //  closeStage.close();
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
    private void klikapus(ActionEvent event) {
        try{
            conn = new Koneksi();
        PreparedStatement pss;
            String sql = "DELETE FROM petugas WHERE id_petugas = '"+id.getText()+"'";
          int opsi =  JOptionPane.showConfirmDialog(null, "Hapus Data?");
          switch(opsi)
          {
              case JOptionPane.YES_OPTION:
              pss = conn.connect().prepareStatement(sql);
            pss.executeUpdate();
              break;
             
          }
            
        }catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, "Tidak Bisa Hapus Data");
                }
    }

    @FXML
    private void klikbersih(ActionEvent event) {
        
        bersih();
        aksitabel();
        getDataAll();
        id.setEditable(true);
    }
    
    
    
    
    
    public void tabell()
     {
         colno.setCellValueFactory((TableColumn.CellDataFeatures<Data, String> celData) ->
                celData.getValue().noProperty());
         colid.setCellValueFactory((TableColumn.CellDataFeatures<Data, String> celData) ->
                celData.getValue().IdPetProperty());
         collvl.setCellValueFactory((TableColumn.CellDataFeatures<Data, String> celData) ->
                celData.getValue().idlvlProperty());
         colnama.setCellValueFactory((TableColumn.CellDataFeatures<Data, String> celData) ->
                celData.getValue().nameProperty());
         colgndr.setCellValueFactory((TableColumn.CellDataFeatures<Data, String> celData) ->
                celData.getValue().gndrProperty());
         colttl.setCellValueFactory((TableColumn.CellDataFeatures<Data, String> celData) ->
                celData.getValue().LahirProperty());
         colalamat.setCellValueFactory((TableColumn.CellDataFeatures<Data, String> celData) ->
                celData.getValue().adressProperty());
         colnohp.setCellValueFactory((TableColumn.CellDataFeatures<Data, String> celData) ->
                celData.getValue().nohpProperty());
         colimel.setCellValueFactory((TableColumn.CellDataFeatures<Data, String> celData) ->
                celData.getValue().ImelProperty());
         listdata =FXCollections.observableArrayList();
         tabel.getSelectionModel().clearSelection();
     }
    
    public void aksitabel()
    {
        listdata = getDataAll();
        tabel.setItems(listdata);
    }
    public void aksitabelsearch()
    {
        listdata = getDataSearch();
        tabel.setItems(listdata);
    }

    @FXML
    private void ambildata(MouseEvent event) {
        ambil();
    }
    public void ambil()
    {
        Data ambil = tabel.getSelectionModel().getSelectedItems().get(0);
        alamat.setText(ambil.getAdress());
        email.setText(ambil.getImel());
        nama.setText(ambil.getNama());
        lvl.setText(ambil.getIdlvl());
        nohp.setText(ambil.getNohp());
        id.setText(ambil.getIdpet());
        id.setEditable(false);
        ttl.setValue(LocalDate.parse(ambil.getLahir()));
    }

    @FXML
    private void klikbtnedit(ActionEvent event) {
        conn = new Koneksi();
        PreparedStatement pss;
        try{
            String sql ="update petugas set "
                    + "no_hp = '"+nohp.getText()+"',"
                    + "nama = '"+nama.getText()+"',"
                    + "email = '"+email.getText()+"',"
                    + "ttl = '"+tgl.getText()+"',"
                    + "alamat = '"+alamat.getText()+"'"
                    + "where id_petugas = '"+id.getText()+"';";
            
            pss = conn.connect().prepareStatement(sql);
            pss.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Data Tersimpan!!!");
            aksitabel();
            tabell();
            bersih();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ada Kesalahan Saat Mengedit");
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
    private void bersih()
    {
        alamat.setText("");
        email.setText("");
        id.setText("");
        lvl.setText("");
        nama.setText("");
        nohp.setText(""); 
        ttl.setValue(null);
    }

    @FXML
    private void search(KeyEvent event) {
        try{
            String cari = "SELECT * FROM petugas INNER JOIN level ON petugas.kode_level = level.kode_level WHERE id_petugas = '"+id.getText()+"'";
            rs = stm.executeQuery(cari);
            if (rs.next()) {
                alamat.setText(rs.getString("alamat"));
                email.setText(rs.getString("email"));
                 nama.setText(rs.getString("nama"));
                lvl.setText(rs.getString("level"));
                nohp.setText(rs.getString("no_hp"));
                 id.setText(rs.getString("id_petugas"));
                 ttl.setValue(LocalDate.parse(rs.getString("ttl")));
                aksitabelsearch();
                getDataSearch();
            }
            else
            {
                aksitabel();
                getDataAll();
            }
        }catch(Exception e)
        {
            
        }
        
    }
    public ObservableList<Data> getDataAll()
     {
         ObservableList<Data> listdata = FXCollections.observableArrayList();
         try
         {
             Koneksi db = new Koneksi();
         db.config();
         con = db.con;
         stm = db.stm;
             String sql = "select * from petugas inner join level on petugas.kode_level = level.kode_level";
         rs = stm.executeQuery(sql);
         while(rs.next())
         {
             urut = urut + 1;
             String nomer = urut.toString();
             Data d = new Data();
             d.setNo(nomer);
             d.setIdpet(rs.getString("id_petugas"));
             d.setIdlvl(rs.getString("level"));
             d.setNama(rs.getString("nama"));
             d.setGndr(rs.getString("gender"));
             d.setLahir(rs.getString("ttl"));
             d.setAdress(rs.getString("alamat"));
             d.setNohp(rs.getString("no_hp"));
             d.setImel(rs.getString("email"));
             listdata.add(d);
             
         }
         urut = 0;
         }catch(Exception Ex)
         {
             JOptionPane.showMessageDialog(null, "Data Tidak Tampil"+Ex);
             Ex.printStackTrace();
         }
         return listdata;
     }
    
    public class Data {
    private final StringProperty no = new SimpleStringProperty()  ;
       private final StringProperty idpet = new SimpleStringProperty()  ;
       private final StringProperty idlvl = new SimpleStringProperty()  ;
       private final StringProperty name = new SimpleStringProperty() ;
       private final StringProperty gndr = new SimpleStringProperty() ;
       private final StringProperty lahir = new SimpleStringProperty()  ;
       private final StringProperty addres = new SimpleStringProperty()  ;
       private final StringProperty nohp = new SimpleStringProperty() ;
       private final StringProperty imel = new SimpleStringProperty()  ;
       private final StringProperty level = new SimpleStringProperty();
    int urut = 0;
    
    
    
    public String getNo()
    {
        return no.get();
    }
    public void setNo(String nilai)
    {
        no.set(nilai);
    }
    public StringProperty noProperty()
    {
        return no;
    }
    public String getIdpet()
    {
        return idpet.get();
    }
    public void setIdpet(String nilai)
    {
        idpet.set(nilai);
    }
    public StringProperty IdPetProperty()
    {
        return idpet;
    }
    public String getIdlvl()
    {
        return idlvl.get();
    }
    public void setIdlvl(String nilai)
    {
        idlvl.set(nilai);
    }
    public StringProperty idlvlProperty()
    {
        return idlvl;
    }
    public String getNama()
    {
        return name.get();
    }
    public void setNama(String nilai)
    {
        name.set(nilai);
    }
    public StringProperty nameProperty()
    {
        return name;
    }
    public String getGndr()
    {
        return gndr.get();
    }
    public void setGndr(String nilai)
    {
        gndr.set(nilai);
    }
    public StringProperty gndrProperty()
    {
        return gndr;
    }
    public String getLahir()
    {
        return lahir.get();
    }
    public void setLahir(String nilai)
    {
        lahir.set(nilai);
    }
    public StringProperty LahirProperty()
    {
        return lahir;
    }
    public String getAdress()
    {
        return addres.get();
    }
    public void setAdress(String nilai)
    {
        addres.set(nilai);
    }
    public StringProperty adressProperty()
    {
        return addres;
    }
    public String getNohp()
    {
        return nohp.get();
    }
    public void setNohp(String nilai)
    {
        nohp.set(nilai);
    }
    public StringProperty nohpProperty()
    {
        return nohp;
    }
    public String getImel()
    {
        return imel.get();
    }
    public void setImel(String nilai)
    {
        imel.set(nilai);
    }
    public StringProperty ImelProperty()
    {
        return imel;
    }
    public String getLevel()
    {
        return level.get();
    }
    public void setLevel(String nilai)
    {
        level.set(nilai);
    }
    public StringProperty levelProperty()
    {
        return level;
    }

        private void setaddres(String string) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
     public ObservableList<Data> getDataSearch()
     {
         ObservableList<Data> listdata = FXCollections.observableArrayList();
         try
         {
             Koneksi db = new Koneksi();
         db.config();
         con = db.con;
         stm = db.stm;
             String sql = "select * from petugas inner join level on petugas.kode_level = level.kode_level where id_petugas = '"+id.getText()+"'";
         rs = stm.executeQuery(sql);
         while(rs.next())
         {
             urut = urut + 1;
             String nomer = urut.toString();
             Data d = new Data();
             d.setNo(nomer);
             d.setIdpet(rs.getString("id_petugas"));
             d.setIdlvl(rs.getString("level"));
             d.setNama(rs.getString("nama"));
             d.setGndr(rs.getString("gender"));
             d.setLahir(rs.getString("ttl"));
             d.setAdress(rs.getString("alamat"));
             d.setNohp(rs.getString("no_hp"));
             d.setImel(rs.getString("email"));
             listdata.add(d);
             
         }
         urut = 0;
         }catch(Exception Ex)
         {
             JOptionPane.showMessageDialog(null, "Data Tidak Tampil"+Ex);
             Ex.printStackTrace();
         }
         return listdata;
     }
}
