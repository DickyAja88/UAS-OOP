/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Storage;
import Connector.connectionDatabase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.PembayaranHutang;
/**
 *
 * @author DICKY SAPUTRA
 */
public class PembayaranHutangStorage {
    connectionDatabase connect = new connectionDatabase();
    public int addPembayaran (PembayaranHutang pembayaranHutang) throws SQLException{
        String sql = "INSERT INTO pembayaran_hutang (Id_hutang, Jumlah_pembayaran, Tanggal_pembayaran) VALUES (?, ?, ?)";
        int id_hutang = pembayaranHutang.getId_hutang();
        int jumlah_pembayaran = pembayaranHutang.getJumlah_Pembayaran();
        LocalDate tanggal_pembayaran = pembayaranHutang.getTanggal_pembayaran();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String tanggalFormatted = tanggal_pembayaran.format(formatter);
        int RowsAffect = 0;
        connect.checkConnection();
        try {
            RowsAffect = connect.executeQueryDml(sql, id_hutang, jumlah_pembayaran, tanggalFormatted);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            connect.disconnect();
        }
        return RowsAffect;
    }
    public List<PembayaranHutang> getAllPembayaran () throws SQLException{
        List<PembayaranHutang> listBayar = new ArrayList<>();
        String sql ="SELECT pembayaran_hutang.Id_pembayaran, hutang.Judul_hutang, pembayaran_hutang.Jumlah_pembayaran, pembayaran_hutang.Tanggal_pembayaran, pembayaran_hutang.Id_hutang "
                + "FROM pembayaran_hutang INNER JOIN hutang ON pembayaran_hutang.Id_hutang = hutang.Id_hutang";
        connect.checkConnection();
        try {
            ResultSet resultSet = connect.executeQueryRead(sql);
            while (resultSet.next()) {
                int id_pembayaran = resultSet.getInt("Id_pembayaran");
                int id_hutang = resultSet.getInt("Id_hutang");
                String judul_hutang = resultSet.getString("Judul_hutang");
                int jumlah_pembayaran = resultSet.getInt("Jumlah_pembayaran");
                LocalDate tanggal_pembayaran= resultSet.getDate("Tanggal_pembayaran").toLocalDate();
                PembayaranHutang pembayaranHutang = new PembayaranHutang(id_pembayaran, id_hutang, judul_hutang, jumlah_pembayaran, tanggal_pembayaran);
                listBayar.add(pembayaranHutang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            connect.disconnect();
        }
        return listBayar;
    }
public int updatePembayaran(PembayaranHutang pembayaranHutang) throws SQLException {

    String sql = "UPDATE pembayaran_hutang SET Id_hutang = ?, Jumlah_pembayaran = ?, Tanggal_pembayaran = ? WHERE Id_pembayaran = ?";
    int id_hutang = pembayaranHutang.getId_hutang();
    int jumlah_pembayaran = pembayaranHutang.getJumlah_Pembayaran();
    LocalDate tanggal_pembayaran = pembayaranHutang.getTanggal_pembayaran();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String tanggalFormatted = tanggal_pembayaran.format(formatter);
    int rowsAffected = 0;

    connect.checkConnection();

    try {
        rowsAffected = connect.executeQueryDml(sql, id_hutang, jumlah_pembayaran, tanggalFormatted, pembayaranHutang.getId_pembayaran());
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        connect.disconnect();
    }

    return rowsAffected;
}


public int deletePembayaran(PembayaranHutang pembayaranHutang) throws SQLException {
    String sql = "DELETE FROM pembayaran_hutang WHERE Id_pembayaran = ?";
    int Id_pembayaran = pembayaranHutang.getId_pembayaran();
    int RowsAffected = 0;
    connect.checkConnection();
    try {
        RowsAffected = connect.executeQueryDml(sql, Id_pembayaran);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        connect.disconnect();
    }
    return RowsAffected;
}


    public int allJumlahPembayaran(PembayaranHutang pembayaranHutang) throws SQLException {
    String sql = "SELECT COALESCE(SUM(Jumlah_pembayaran), 0) FROM pembayaran_hutang WHERE Id_hutang=?";
    int id_hutang = pembayaranHutang.getId_hutang();
    connect.checkConnection();
    try {
        ResultSet resultSet = connect.executeQueryRead(sql, id_hutang);
        while (resultSet.next()) {
            int total_pembayaran = resultSet.getInt(1);
            return total_pembayaran;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return 0;
}
    public int getjumlahHutang(PembayaranHutang pembayaranHutang) throws SQLException{
        String sql = "SELECT Jumlah_hutang FROM hutang WHERE Id_hutang=?";
        int id_hutang = pembayaranHutang.getId_hutang();
        connect.checkConnection();
        try {
            ResultSet resultSet = connect.executeQueryRead(sql, id_hutang);
            while (resultSet.next()) {
                int jumlah_hutang = resultSet.getInt("Jumlah_hutang");
                return jumlah_hutang;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

public int bayarHutang(PembayaranHutang pembayaranHutang) throws SQLException {
    String sql = "UPDATE hutang SET Jumlah_hutang = ? WHERE Id_hutang=?";
    int id_hutang = pembayaranHutang.getId_hutang();
    int jumlah_hutang = getjumlahHutang(pembayaranHutang);
    int total_pembayaran = allJumlahPembayaran(pembayaranHutang);
    int total_hutang = jumlah_hutang - total_pembayaran;
    total_hutang = Math.max(total_hutang, 0);
    connect.checkConnection();
    int rowsAffected = 0;
    
    try {
            rowsAffected = connect.executeQueryDml(sql, total_hutang, id_hutang);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.disconnect();
        }
    
    return rowsAffected;
}



     public List <PembayaranHutang> getAllPembayaranHutangByJudulHutang (String judul_hutang){
         List <PembayaranHutang> listBayar = new ArrayList<>();
         String sql = "SELECT pembayaran_hutang.Id_pembayaran, hutang.Judul_hutang, pembayaran_hutang.Jumlah_pembayaran, pembayaran_hutang.Tanggal_pembayaran, pembayaran_hutang.Id_hutang "
                 + "FROM pembayaran_hutang "
                 + "INNER JOIN hutang ON pembayaran_hutang.Id_hutang = hutang.Id_hutang "
                 + "WHERE hutang.Judul_hutang LIKE ?";
         try {
             connect.checkConnection();
             ResultSet resultSet = connect.executeQueryRead(sql, "%"+judul_hutang+"%");
             while (resultSet.next()) {
                 int id_pembayaran = resultSet.getInt("Id_pembayaran");
                 int jumlah_pembayaran = resultSet.getInt("Jumlah_pembayaran");
                 LocalDate tanggal_pembayaran = resultSet.getDate("Tanggal_pembayaran").toLocalDate();
                 int id_hutang = resultSet.getInt("Id_hutang");
                 
                 PembayaranHutang pembayaranHutang = new PembayaranHutang(
                         id_pembayaran, 
                         id_hutang, 
                         judul_hutang, 
                         jumlah_pembayaran, 
                         tanggal_pembayaran);
                 
                 listBayar.add(pembayaranHutang);
                 
             }
         } catch (Exception e) {
             e.printStackTrace();
         }finally{
             connect.disconnect();
         }
         return listBayar;
     }
     
    
    

}
