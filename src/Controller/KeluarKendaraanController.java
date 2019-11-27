/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * FXML Controller class
 *
 * @author aryz
 */
public class KeluarKendaraanController implements Initializable {
    Koneksi conn;
    @FXML
    private TableView<Data> tabel;
    @FXML
    private TextField notkt;
    @FXML
    private TextField harga;
    @FXML
    private TextField jmklr;
    @FXML
    private TextField jmmsk;
    ObservableList<Data> listdata;
    @FXML
    private TableColumn<Data, String> colnotkt;
    @FXML
    private TableColumn<Data, String> coljmmsk;
    @FXML
    private TableColumn<Data, String> coljmklr;
    @FXML
    private TableColumn<Data, String> colharga;
    Connection con;
    Statement stm;
    ResultSet rs;
    @FXML
    private TableColumn<Data, String> colidptgs;
    ImplementTabelKendaraan it = new ImplementTabelKendaraan();
   
    @FXML
    private TableColumn<Data, String> colno;

    Date tglk = new Date();
    SimpleDateFormat jam = new SimpleDateFormat("dd/MM/YYYY - HH:mm:ss");
    String a=jam.format(tglk);
    Integer urut = 0; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Koneksi db = new Koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
        tabell();
        aksitabel();
        
        // TODO
    }  
    
  /*   private void UpdateTabel() {
        try {
            String sql = "SELECT * FROM ddagang;";
            
            rs = stm.executeQuery(sql);
            table.
        dtm.setRowCount(0);
        String [] data = new String[6];
        int i = 1;
       
        while(rs.next()) {
            data[0] = rs.getString("idbarang");
            data[1] = rs.getString("namabarang");
            data[2] = rs.getString("hargabarang");
            data[3] = rs.getString("stokakhir");
            data[4] = rs.getString("stokmasuk");
            data[5] = rs.getString("stokkeluar");
            dtm.addRow(data);
            i++;
        }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }*/

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
    private void aksitabelsearch() {
        listdata = getDataSearch();
        tabel.setItems(listdata);
    }

    @FXML
    private void ambildata(MouseEvent event) {
        Data ambil = tabel.getSelectionModel().getSelectedItems().get(0);
        harga.setText(ambil.getharga());
        jmklr.setText(ambil.getjamklr());
        jmmsk.setText(ambil.getjammsk());
        notkt.setText(ambil.getnotkt());
        
    }

    @FXML
    private void aksitiket(ActionEvent event) {
        conn = new Koneksi();
        PreparedStatement pss;
        try{
            String sql ="update parkir set "
                    + "jam_keluar = '"+a+"'"
                    + "where no_tiket = '"+notkt.getText()+"';";
            
            pss = conn.connect().prepareStatement(sql);
            pss.executeUpdate();
            
            tabell();
            aksitabel();
            notkt.setText("");
            jmklr.setText("-");
            jmmsk.setText("");
            harga.setText("");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ada Kesalahan");
        }
    }

    @FXML
    private void rilistiket(KeyEvent event) {
        try{
            String sql = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where no_tiket = '"+notkt.getText()+"' and jam_keluar = ''";
            rs = stm.executeQuery(sql);
           if(rs.next()) {
            jmklr.setText(rs.getString("jam_keluar"));
            jmmsk.setText(rs.getString("jam_masuk"));
            harga.setText(rs.getString("harga"));
           tabell();
           aksitabelsearch();}
           else{
            tabell();
            aksitabel();
               jmklr.setText("-");
            jmmsk.setText("");
            harga.setText("");
           }
        }catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex);
                    ex.printStackTrace();
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
             String sql = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where jam_keluar = ''";
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
    public ObservableList<Data> getDataSearch()
     {
         ObservableList<Data> listdata = FXCollections.observableArrayList();
         try
         {
             Koneksi db = new Koneksi();
         db.config();
         con = db.con;
         stm = db.stm;
             String sql = "select * from parkir inner join harga on parkir.kode_harga = harga.kode_harga where jam_keluar = '' and no_tiket = '"+notkt.getText()+"'";
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
    
}
