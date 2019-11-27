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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
 * @author LABKOM2-RPL17
 */
public class ReportController implements Initializable {

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
    @FXML
    private TableView<Data> tabel;
    ObservableList<Data> listdata;
    @FXML
    private TableColumn<Data, String> colnotkt;
    @FXML
    private TableColumn<Data, String> coljmmsk;
    @FXML
    private TableColumn<Data, String> coljmklr;
    @FXML
    private TableColumn<Data, String> colharga;
    @FXML
    private TableColumn<Data, String> colidptgs;

   
    @FXML
    private TableColumn<Data, String> colno;
    Connection con;
    Statement stm;
    ResultSet rs;
    @FXML
    private ComboBox<String> ambildata;
    @FXML
    public Label query;
    @FXML
    public TextField waktu;
    Date tgl = new Date();
    SimpleDateFormat jam = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat jam1 = new SimpleDateFormat("MM/yyyy");
    SimpleDateFormat jam2 = new SimpleDateFormat("yyyy");
    String hari=jam.format(tgl);
    String bulan = jam1.format(tgl);
    String tahun = jam2.format(tgl);
    private Integer urut = 0;
    String sql1;
    String sql2;
    String sql3;
    String sql5;
    @FXML
    private Button btncetak;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        query.setText("SELECT parkir.`no_tiket` AS parkir_no_tiket, parkir.`jam_masuk` AS parkir_jam_masuk, parkir.`jam_keluar` AS parkir_jam_keluar, parkir.`id_petugas` AS parkir_id_petugas, harga.`harga` AS harga_harga FROM `harga` harga INNER JOIN `parkir` parkir ON harga.`kode_harga` = parkir.`kode_harga`");
        Koneksi db = new Koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
        tabell();
        aksitabel();
        String p = this.waktu.getText();
        
        ambildata.getItems().setAll("=======Data=======","Hari Ini","Bulan Ini","Tahun Ini","Pegawai","Bukan Pegawai");
        
        ambildata.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            public void changed(ObservableValue<?extends String> observacle, String oldValue, String newValue){
                waktu.setText(newValue);
                if(newValue.equals("Hari Ini"))
                {
                    query.setText("SELECT parkir.`no_tiket` AS parkir_no_tiket, parkir.`jam_masuk` AS parkir_jam_masuk, parkir.`jam_keluar` AS parkir_jam_keluar, parkir.`id_petugas` AS parkir_id_petugas, harga.`harga` AS harga_harga FROM `harga` harga INNER JOIN `parkir` parkir ON harga.`kode_harga` = parkir.`kode_harga` where jam_masuk like '%"+hari+"%'");
                    tabell();
                      aksitabel1();
                }
                if(newValue.equals("Bulan Ini"))
                {
                    query.setText("SELECT parkir.`no_tiket` AS parkir_no_tiket, parkir.`jam_masuk` AS parkir_jam_masuk, parkir.`jam_keluar` AS parkir_jam_keluar, parkir.`id_petugas` AS parkir_id_petugas, harga.`harga` AS harga_harga FROM `harga` harga INNER JOIN `parkir` parkir ON harga.`kode_harga` = parkir.`kode_harga` where jam_masuk like '%"+bulan+"%'");
                        tabell();
        aksitabel2();
                }
                if(newValue.equals("Tahun Ini"))
                {
                    query.setText("SELECT parkir.`no_tiket` AS parkir_no_tiket, parkir.`jam_masuk` AS parkir_jam_masuk, parkir.`jam_keluar` AS parkir_jam_keluar, parkir.`id_petugas` AS parkir_id_petugas, harga.`harga` AS harga_harga FROM `harga` harga INNER JOIN `parkir` parkir ON harga.`kode_harga` = parkir.`kode_harga` where jam_masuk like '%"+tahun+"%'");
               tabell();
        aksitabel3();
                }
                if(newValue.equals("Pegawai"))
                {
                    query.setText("SELECT parkir.`no_tiket` AS parkir_no_tiket, parkir.`jam_masuk` AS parkir_jam_masuk, parkir.`jam_keluar` AS parkir_jam_keluar, parkir.`id_petugas` AS parkir_id_petugas, harga.`harga` AS harga_harga FROM `harga` harga INNER JOIN `parkir` parkir ON harga.`kode_harga` = parkir.`kode_harga` where id_petugas not in('')");
               tabell();
        aksitabel4();
                }
                if(newValue.equals("Bukan Pegawai"))
                {
                    query.setText("SELECT parkir.`no_tiket` AS parkir_no_tiket, parkir.`jam_masuk` AS parkir_jam_masuk, parkir.`jam_keluar` AS parkir_jam_keluar, parkir.`id_petugas` AS parkir_id_petugas, harga.`harga` AS harga_harga FROM `harga` harga INNER JOIN `parkir` parkir ON harga.`kode_harga` = parkir.`kode_harga` WHERE id_petugas = ''");
                tabell();
        aksitabel5();
                }
                if (newValue.equals("=======Data=======")) {
                    query.setText("SELECT parkir.`no_tiket` AS parkir_no_tiket, parkir.`jam_masuk` AS parkir_jam_masuk, parkir.`jam_keluar` AS parkir_jam_keluar, parkir.`id_petugas` AS parkir_id_petugas, harga.`harga` AS harga_harga FROM `harga` harga INNER JOIN `parkir` parkir ON harga.`kode_harga` = parkir.`kode_harga`");
                    tabell();
        aksitabel();
                }
            }
            
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
    private void tabell() {
        colno.setCellValueFactory((TableColumn.CellDataFeatures<Data, String> celData) ->
                celData.getValue().noProperty());
         colnotkt.setCellValueFactory((TableColumn.CellDataFeatures<Data, String> celData) ->
                celData.getValue().notktProperty());
         coljmmsk.setCellValueFactory((TableColumn.CellDataFeatures<Data, String> celData) ->
                celData.getValue().jammskProperty());
         coljmklr.setCellValueFactory((TableColumn.CellDataFeatures<Data, String> celData) ->
                celData.getValue().jamklrProperty());
         colharga.setCellValueFactory((TableColumn.CellDataFeatures<Data, String> celData) ->
                celData.getValue().hargaProperty());
         colidptgs.setCellValueFactory((TableColumn.CellDataFeatures<Data, String> celData) ->
                celData.getValue().idadminProperty());
       //  col.setCellValueFactory((TableColumn.CellDataFeatures<Data, String> celData) ->
      //          celData.getValue().nohpProperty());
        // colimel.setCellValueFactory((TableColumn.CellDataFeatures<Data, String> celData) ->
      //          celData.getValue().ImelProperty());
         listdata =FXCollections.observableArrayList();
         tabel.getSelectionModel().clearSelection();
    }
    
    private void aksitabel() {
        listdata = getDataAll();
        tabel.setItems(listdata);
    }
    private void aksitabel1() {
        listdata = getDataAll1();
        tabel.setItems(listdata);
    }
    private void aksitabel2() {
        listdata = getDataAll2();
        tabel.setItems(listdata);
    }
    private void aksitabel3() {
        listdata = getDataAll3();
        tabel.setItems(listdata);
    }
    private void aksitabel4() {
        listdata = getDataAll4();
        tabel.setItems(listdata);
    }
    private void aksitabel5() {
        listdata = getDataAll5();
        tabel.setItems(listdata);
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
             String sql = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga";
             String sql1 = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where jam_masuk like '%"+hari+"%'";
             String sql2 = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where jam_masuk like '%"+bulan+"%'";
             String sql3 = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where jam_masuk like '%"+tahun+"%'";
             String sql4 = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where id_petugas not in('')";
             String sql5 = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where id_petugas = ''";
        
             rs = stm.executeQuery(sql);
         
         while(rs.next())
         {
             urut = urut + 1;
             String nomer = urut.toString();
             Data d = new Data();
             d.setNo(nomer);
             d.setnotkt(rs.getString("no_tiket"));
             d.setjammsk(rs.getString("jam_masuk"));
             d.setjamklr(rs.getString("jam_keluar"));
             d.setidadmin(rs.getString("id_petugas"));
             d.setharga(rs.getString("harga"));
          //   d.setAdress(rs.getString("alamat"));
           //  d.setNohp(rs.getString("no_hp"));
           //  d.setImel(rs.getString("email"));
             listdata.add(d);
            
             
         }
         
         urut = 0;
         }catch(Exception Ex)
         {
             JOptionPane.showMessageDialog(null, "Data Tidak Tampil"+Ex);
         }
         return listdata;
     }

    @FXML
    private void cetakk(ActionEvent event) {
        cetak();
    }
    
    public class Data {
    private final StringProperty no = new SimpleStringProperty()  ;
       private final StringProperty notkt = new SimpleStringProperty()  ;
       private final StringProperty jammsk = new SimpleStringProperty()  ;
       private final StringProperty jamklr = new SimpleStringProperty() ;
       private final StringProperty idadmin = new SimpleStringProperty() ;
       private final StringProperty harga = new SimpleStringProperty()  ;
     //  private final StringProperty addres = new SimpleStringProperty()  ;
     //  private final StringProperty nohp = new SimpleStringProperty() ;
     //  private final StringProperty imel = new SimpleStringProperty()  ;
     //  private final StringProperty level = new SimpleStringProperty();
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
    public String getnotkt()
    {
        return notkt.get();
    }
    public void setnotkt(String nilai)
    {
        notkt.set(nilai);
    }
    public StringProperty notktProperty()
    {
        return notkt;
    }
    public String getjammsk()
    {
        return jammsk.get();
    }
    public void setjammsk(String nilai)
    {
        jammsk.set(nilai);
    }
    public StringProperty jammskProperty()
    {
        return jammsk;
    }
    public String getjamklr()
    {
        return jamklr.get();
    }
    public void setjamklr(String nilai)
    {
        jamklr.set(nilai);
    }
    public StringProperty jamklrProperty()
    {
        return jamklr;
    }
    public String getidadmin()
    {
        return idadmin.get();
    }
    public void setidadmin(String nilai)
    {
        idadmin.set(nilai);
    }
    public StringProperty idadminProperty()
    {
        return idadmin;
    }
    public String getharga()
    {
        return harga.get();
    }
    public void setharga(String nilai)
    {
        harga.set(nilai);
    }
    public StringProperty hargaProperty()
    {
        return harga;
    }
  /*  public String getAdress()
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
        return no;
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
    }*/
        }
    public ObservableList<Data> getDataAll1()
     {
         ObservableList<Data> listdata = FXCollections.observableArrayList();
         try
         {
             Koneksi db = new Koneksi();
         db.config();
         con = db.con;
         stm = db.stm;
             String sql = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga";
             String sql1 = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where jam_masuk like '%"+hari+"%'";
             String sql2 = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where jam_masuk like '%"+bulan+"%'";
             String sql3 = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where jam_masuk like '%"+tahun+"%'";
             String sql4 = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where id_petugas not in('')";
             String sql5 = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where id_petugas = ''";
           
        
             rs = stm.executeQuery(sql1);
         
         while(rs.next())
         {
             urut = urut + 1;
             String nomer = urut.toString();
             Data d = new Data();
             d.setNo(nomer);
             d.setnotkt(rs.getString("no_tiket"));
             d.setjammsk(rs.getString("jam_masuk"));
             d.setjamklr(rs.getString("jam_keluar"));
             d.setidadmin(rs.getString("id_petugas"));
             d.setharga(rs.getString("harga"));
          //   d.setAdress(rs.getString("alamat"));
           //  d.setNohp(rs.getString("no_hp"));
           //  d.setImel(rs.getString("email"));
             listdata.add(d);
            
             
         }
         
         urut = 0;
         }catch(Exception Ex)
         {
             JOptionPane.showMessageDialog(null, "Data Tidak Tampil"+Ex);
         }
         return listdata;
     }
    public ObservableList<Data> getDataAll2()
     {
         ObservableList<Data> listdata = FXCollections.observableArrayList();
         try
         {
             Koneksi db = new Koneksi();
         db.config();
         con = db.con;
         stm = db.stm;
             String sql = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga";
             String sql1 = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where jam_masuk like '%"+hari+"%'";
             String sql2 = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where jam_masuk like '%"+bulan+"%'";
             String sql3 = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where jam_masuk like '%"+tahun+"%'";
             String sql4 = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where id_petugas not in('')";
             String sql5 = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where id_petugas = ''";
          
        
             rs = stm.executeQuery(sql2);
         
         while(rs.next())
         {
             urut = urut + 1;
             String nomer = urut.toString();
             Data d = new Data();
             d.setNo(nomer);
             d.setnotkt(rs.getString("no_tiket"));
             d.setjammsk(rs.getString("jam_masuk"));
             d.setjamklr(rs.getString("jam_keluar"));
             d.setidadmin(rs.getString("id_petugas"));
             d.setharga(rs.getString("harga"));
          //   d.setAdress(rs.getString("alamat"));
           //  d.setNohp(rs.getString("no_hp"));
           //  d.setImel(rs.getString("email"));
             listdata.add(d);
            
             
         }
         
         urut = 0;
         }catch(Exception Ex)
         {
             JOptionPane.showMessageDialog(null, "Data Tidak Tampil"+Ex);
         }
         return listdata;
     }
    public ObservableList<Data> getDataAll3()
     {
         ObservableList<Data> listdata = FXCollections.observableArrayList();
         try
         {
             Koneksi db = new Koneksi();
         db.config();
         con = db.con;
         stm = db.stm;
             String sql = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga";
             String sql1 = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where jam_masuk like '%"+hari+"%'";
             String sql2 = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where jam_masuk like '%"+bulan+"%'";
             String sql3 = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where jam_masuk like '%"+tahun+"%'";
             String sql4 = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where id_petugas not in('')";
             String sql5 = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where id_petugas = ''";
          
        
             rs = stm.executeQuery(sql3);
         
         while(rs.next())
         {
             urut = urut + 1;
             String nomer = urut.toString();
             Data d = new Data();
             d.setNo(nomer);
             d.setnotkt(rs.getString("no_tiket"));
             d.setjammsk(rs.getString("jam_masuk"));
             d.setjamklr(rs.getString("jam_keluar"));
             d.setidadmin(rs.getString("id_petugas"));
             d.setharga(rs.getString("harga"));
          //   d.setAdress(rs.getString("alamat"));
           //  d.setNohp(rs.getString("no_hp"));
           //  d.setImel(rs.getString("email"));
             listdata.add(d);
            
             
         }
         
         urut = 0;
         }catch(Exception Ex)
         {
             JOptionPane.showMessageDialog(null, "Data Tidak Tampil"+Ex);
         }
         return listdata;
     }
    public ObservableList<Data> getDataAll4()
     {
         ObservableList<Data> listdata = FXCollections.observableArrayList();
         try
         {
             Koneksi db = new Koneksi();
         db.config();
         con = db.con;
         stm = db.stm;
             String sql = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga";
             String sql1 = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where jam_masuk like '%"+hari+"%'";
             String sql2 = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where jam_masuk like '%"+bulan+"%'";
             String sql3 = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where jam_masuk like '%"+tahun+"%'";
             String sql4 = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where id_petugas not in('')";
             String sql5 = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where id_petugas = ''";
          
        
             rs = stm.executeQuery(sql4);
         
         while(rs.next())
         {
             urut = urut + 1;
             String nomer = urut.toString();
             Data d = new Data();
             d.setNo(nomer);
             d.setnotkt(rs.getString("no_tiket"));
             d.setjammsk(rs.getString("jam_masuk"));
             d.setjamklr(rs.getString("jam_keluar"));
             d.setidadmin(rs.getString("id_petugas"));
             d.setharga(rs.getString("harga"));
          //   d.setAdress(rs.getString("alamat"));
           //  d.setNohp(rs.getString("no_hp"));
           //  d.setImel(rs.getString("email"));
             listdata.add(d);
            
             
         }
         
         urut = 0;
         }catch(Exception Ex)
         {
             JOptionPane.showMessageDialog(null, "Data Tidak Tampil"+Ex);
         }
         return listdata;
     }
    public ObservableList<Data> getDataAll5()
     {
         ObservableList<Data> listdata = FXCollections.observableArrayList();
         try
         {
             Koneksi db = new Koneksi();
         db.config();
         con = db.con;
         stm = db.stm;
             String sql = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga";
             String sql1 = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where jam_masuk like '%"+hari+"%'";
             String sql2 = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where jam_masuk like '%"+bulan+"%'";
             String sql3 = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where jam_masuk like '%"+tahun+"%'";
             String sql4 = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where id_petugas not in('')";
             String sql5 = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where id_petugas = ''";

        
             rs = stm.executeQuery(sql5);
         
         while(rs.next())
         {
             urut = urut + 1;
             String nomer = urut.toString();
             Data d = new Data();
             d.setNo(nomer);
             d.setnotkt(rs.getString("no_tiket"));
             d.setjammsk(rs.getString("jam_masuk"));
             d.setjamklr(rs.getString("jam_keluar"));
             d.setidadmin(rs.getString("id_petugas"));
             d.setharga(rs.getString("harga"));
          //   d.setAdress(rs.getString("alamat"));
           //  d.setNohp(rs.getString("no_hp"));
           //  d.setImel(rs.getString("email"));
             listdata.add(d);
            
             
         }
         
         urut = 0;
         }catch(Exception Ex)
         {
             JOptionPane.showMessageDialog(null, "Data Tidak Tampil"+Ex);
         }
         return listdata;
     }
    
    public void cetak()
    {
        try{
            
         InputStream inputStream =   getClass().getResourceAsStream( "Lporan.jasper"); 
         String sql = query.getText();  
       rs = stm.executeQuery(sql);
       
         JRDataSource dataSource = new JRResultSetDataSource(rs);
        JasperPrint jasperPrint = JasperFillManager.fillReport( inputStream, new HashMap(), dataSource); 
        JasperViewer viewer = new JasperViewer(jasperPrint); 
        viewer.setVisible(true); 
       }catch(Exception Ex)
       {
          Ex.printStackTrace();
           
       }
    }
}
