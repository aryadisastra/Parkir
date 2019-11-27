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

public class ImplementTabel {
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
    
}
