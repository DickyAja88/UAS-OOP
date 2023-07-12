/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Storage;

import java.sql.SQLException;
import Connector.connectionDatabase;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import Connector.connectionDatabase;
import model.KategoriPengeluaran;
import model.Pengeluaran;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.standard.PageRanges;
/**
 *
 * @author DICKY SAPUTRA
 */
public class PengeluaranStorage {
    connectionDatabase connect = new connectionDatabase();
    public int addPengeluaran(Pengeluaran pengeluaran) throws SQLException {
        String sql = "INSERT INTO pengeluaran (Jumlah_pengeluaran, Id_kategori_pengeluaran, Tanggal_pengeluaran, Note)VALUES (?, ?, ?, ?)";
        int jumlah_Pengeluaran = pengeluaran.getJumlah_pengeluaran();
        int id_kategori_pengeluaran = pengeluaran.getId_kategori_pengeluaran();
        LocalDate tanggal_pengeluaran = pengeluaran.getTanggal_pengeluaran();
        String note = pengeluaran.getNote();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String tanggalFormatted = tanggal_pengeluaran.format(formatter);
        int RowsAffect = 0;
        connect.checkConnection();
        try{
            RowsAffect = connect.executeQueryDml(
                    sql,
                    jumlah_Pengeluaran,
                    id_kategori_pengeluaran,
                    tanggalFormatted,
                    note);
        } catch (SQLException e){
            e.printStackTrace();
        }finally{
            connect.disconnect();
        }
        return RowsAffect;
    }
    



    public List<Pengeluaran> getdataPengeluaran () throws SQLException{
        List<Pengeluaran> listPengeluaran = new ArrayList<>();
        String sql = "SELECT pengeluaran.Jumlah_pengeluaran, kategori_pengeluaran.Nama_kategori, pengeluaran.Tanggal_pengeluaran, pengeluaran.Note FROM pengeluaran "
                + "INNER JOIN kategori_pengeluaran ON pengeluaran.Id_kategori_pengeluaran=kategori_pengeluaran.Id_kategori_pengeluaran";
        
        connect.checkConnection();
        try {
            ResultSet resultSet = connect.executeQueryRead(sql);
            while(resultSet.next()){
                int jumlah_pengeluaran = resultSet.getInt("Jumlah_pengeluaran");
                String nama_kategori = resultSet.getString("Nama_kategori");
                LocalDate tanggal_pengeluaran = resultSet.getDate("Tanggal_pengeluaran").toLocalDate();
                String note = resultSet.getString("Note");
                Pengeluaran pengeluaran = new Pengeluaran(jumlah_pengeluaran, nama_kategori, tanggal_pengeluaran, note);
                listPengeluaran.add(pengeluaran);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            connect.disconnect();
        }
        return listPengeluaran;
    }
        public List<Pengeluaran> getdataPengeluaranById () throws SQLException{
        List<Pengeluaran> listPengeluaran = new ArrayList<>();
        String sql = "SELECT pengeluaran.Id_pengeluaran, pengeluaran.Jumlah_pengeluaran, kategori_pengeluaran.Nama_kategori, pengeluaran.Tanggal_pengeluaran, pengeluaran.Note FROM pengeluaran "
                + "INNER JOIN kategori_pengeluaran ON pengeluaran.Id_kategori_pengeluaran=kategori_pengeluaran.Id_kategori_pengeluaran";
        
        connect.checkConnection();
        try {
            ResultSet resultSet = connect.executeQueryRead(sql);
            while(resultSet.next()){
                int id_pengeluaran = resultSet.getInt("Id_pengeluaran");
                int jumlah_pengeluaran = resultSet.getInt("Jumlah_pengeluaran");
                String nama_kategori = resultSet.getString("Nama_kategori");
                LocalDate tanggal_pengeluaran = resultSet.getDate("Tanggal_pengeluaran").toLocalDate();
                String note = resultSet.getString("Note");
                Pengeluaran pengeluaran = new Pengeluaran(id_pengeluaran, jumlah_pengeluaran, nama_kategori, tanggal_pengeluaran, note);
                listPengeluaran.add(pengeluaran);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            connect.disconnect();
        }
        return listPengeluaran;
    }

    public int updatePengeluaran(Pengeluaran pengeluaran) throws SQLException {
    String sql = "UPDATE pengeluaran SET Id_kategori_pengeluaran = ?, Jumlah_pengeluaran = ?, Tanggal_pengeluaran = ?, Note = ? WHERE Id_pengeluaran = ?";
    int id_pengeluaran = pengeluaran.getId_pengeluaran();
    int id_kategori_pengeluaran = pengeluaran.getId_kategori_pengeluaran();
    int jumlah_pengeluaran = pengeluaran.getJumlah_pengeluaran();
    LocalDate tanggal_pengeluaran = pengeluaran.getTanggal_pengeluaran();
    String note = pengeluaran.getNote();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String tanggalFormatted = tanggal_pengeluaran.format(formatter);

    int rowsAffected = 0; 
    try {
        connect.checkConnection();
        rowsAffected = connect.executeQueryDml(sql,
                id_kategori_pengeluaran,
                jumlah_pengeluaran,
                tanggalFormatted,
                note,
                id_pengeluaran);
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        connect.disconnect();
    }
    return rowsAffected;
}

     public int deletePengeluaran(Pengeluaran pengeluaran) throws SQLException{
        String sql = "DELETE FROM pengeluaran WHERE Id_pengeluaran=?";
        int id_pengeluaran = pengeluaran.getId_pengeluaran();
        int RowsAffect = 0;
        connect.checkConnection(); 
        try {
            RowsAffect = connect.executeQueryDml(
            sql,id_pengeluaran);
        } catch (Exception e) {
           e.printStackTrace();
        }finally{
            connect.disconnect();
        }
        return RowsAffect;
   }
public List<Pengeluaran> getPengeluaranByNamaKategori(String nama_kategori) throws SQLException {
    List<Pengeluaran> pengeluaranList = new ArrayList<>();
    String sql = "SELECT pengeluaran.Id_pengeluaran, pengeluaran.Jumlah_pengeluaran, kategori_pengeluaran.Nama_kategori, pengeluaran.Tanggal_pengeluaran, pengeluaran.Note FROM pengeluaran "
            + "INNER JOIN kategori_pengeluaran ON pengeluaran.Id_kategori_pengeluaran=kategori_pengeluaran.Id_kategori_pengeluaran WHERE kategori_pengeluaran.Nama_kategori LIKE ? ";
    try {
        connect.checkConnection();
        ResultSet resultSet = connect.executeQueryRead(sql, "%" + nama_kategori + "%");
        while (resultSet.next()) {
            int id_pengeluaran = resultSet.getInt("Id_pengeluaran");
            int jumlah_pengeluaran = resultSet.getInt("Jumlah_pengeluaran");
            LocalDate tanggal_pengeluaran = resultSet.getDate("Tanggal_pengeluaran").toLocalDate();
            String note = resultSet.getString("Note");
            pengeluaranList.add(new Pengeluaran(id_pengeluaran, jumlah_pengeluaran, nama_kategori, tanggal_pengeluaran, note));
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        connect.disconnect();
    }
    return pengeluaranList;
}
public int getTotalPengeluaran() {
    String sq = "SELECT Jumlah_pengeluaran FROM pengeluaran";
    try {
        connect.checkConnection();
        ResultSet resultSet = connect.executeQueryRead(sq);
        int totalPengeluaran = 0;
        while (resultSet.next()) {
            int jumlah_pengeluaran = resultSet.getInt("Jumlah_pengeluaran");
            totalPengeluaran += jumlah_pengeluaran;
        }
        return totalPengeluaran;
    } catch (SQLException e) {
        e.printStackTrace();
    }finally{
        connect.disconnect();
    }
    return 0; 
}
}
