/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;



import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import static jdk.nashorn.tools.ShellFunctions.input;
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
public class MasukController implements Initializable {
    @FXML
    private ImageView btnmasuk;
    @FXML
    private ImageView btnbantu;
    @FXML
    private ImageView btnerror;
    @FXML
    private PasswordField idmsk;
    @FXML
    private Label notifikasi;
    Connection con;
    Statement stm;
    ResultSet rs;
    Date tgl = new Date();
    SimpleDateFormat jam = new SimpleDateFormat("dd/MM/YYYY - HH:mm:ss");
    String a=jam.format(tgl);
    @FXML
    private Label bantudarurat;
    @FXML
    private Label kodeharga;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Koneksi db = new Koneksi();
        db.config();
        con = db.con;
        stm =db.stm;
        
        
        delay();
        harga();
    }    
    
    
    
    public void harga(){
        
    try{
        Koneksi db = new Koneksi();
        db.config();
        con = db.con;
        stm =db.stm;
        String sql = "select kode_harga from harga";
      rs =  stm.executeQuery(sql);
      if(rs.last())
      {
          kodeharga.setText(rs.getString("kode_harga"));
      }
        
    }catch(Exception e){
        e.printStackTrace();
    }
}

    @FXML
    private void masuk(MouseEvent event) {
    String Masuk = "Insert into parkir(jam_masuk,kode_harga,jam_keluar) values('"+a+"','"+kodeharga.getText()+"', '')";
        try{
            stm.executeUpdate(Masuk);
            cetak2();
            notifikasi.setText("Portal Terbuka");
            
            System.out.printf("data masuk");
        }catch(Exception Ex)
        {
            System.err.println("Tidak Bisa Masuk"+Ex);
        }
        
    }

    @FXML
    private void gabisaketik(KeyEvent event) {
        
    }

    @FXML
    private void masukid(KeyEvent event) {
        
    }



    @FXML
    private void bantuanklik(MouseEvent event) {
        bantudarurat.setText("Silahkan Tekan Tombol Hijau untuk Ambil Tiket Scan Jika Punya Kartu dan Tekan Tombol Merah Untuk Darurat");
    }

    @FXML
    private void daruratklik(MouseEvent event) {
        bantudarurat.setText("Mohon Tunggu Sebentar....");
        
        
    }
    public void delay()
    {
        bantudarurat.setText("");
        try{
            Thread.sleep(1500);
        }catch(Exception e)
        {
            
        }
    }
    public void cetak()
    {
        try{
            
         InputStream inputStream =   getClass().getResourceAsStream( "Parkir.jasper"); 
         String sql = "SELECT MAX(parkir.`no_tiket`) AS parkir_no_tiket, parkir.`jam_masuk` AS parkir_jam_masuk, parkir.id_petugas AS parkir_id_petugas FROM `parkir` parkir";  
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
    public void cetak2()
    {
        try{
            
         InputStream inputStream =   getClass().getResourceAsStream( "Parkir2.jasper"); 
         String sql = "SELECT MAX(parkir.`no_tiket`) AS parkir_no_tiket, parkir.`jam_masuk` AS parkir_jam_masuk FROM `parkir` parkir";  
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

    @FXML
    private void masukpetugas(ActionEvent event) {
        String CekMasukPetugas = "Select * From petugas where id_petugas = '"+idmsk.getText()+"'";
        String MasukPetugas = "Insert into parkir(jam_masuk,id_petugas,kode_harga,jam_keluar) values('"+a+"','"+idmsk.getText()+"','"+kodeharga.getText()+"','')";
        
        
        try{
            rs = stm.executeQuery(CekMasukPetugas);
            if(rs.next())
            {
                stm.executeUpdate(MasukPetugas);
                notifikasi.setText("Portal Terbuka");
                cetak2();
                
            }
            else{
               notifikasi.setText("ID Tidak Terdaftar");
            }
        }
        catch(Exception Ex)
        {
            System.err.printf("Tidak Bisa Masuk "+Ex);
        }
    }
    
    
}
