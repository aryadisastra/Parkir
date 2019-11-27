/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Controller.EditPetugasController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.swing.JOptionPane;

/**
 *
 * @author LABKOM 2-RPL 25
 */

public class ImplementTabelKendaraan {
    Connection con;
    Statement stm;
    ResultSet rs;
    private Integer urut = 0;
    
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
