/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Storage;
import Connector.connectionDatabase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pemasukkan;
import model.Pengeluaran;
/**
 *
 * @author DICKY SAPUTRA
 */
public class PemasukkanStorage {
    connectionDatabase connect = new connectionDatabase();
    public int addPemasukkan(Pemasukkan pemasukkan) throws SQLException {
        String sql = "INSERT INTO pemasukkan (Jumlah_pemasukkan, Id_kategori_pemasukkan, Tanggal_pemasukkan, Note)VALUES (?, ?, ?, ?)";
        int jumlah_pemasukkan = pemasukkan.getJumlah_pemasukkan();
        int id_kategori_pemasukkan = pemasukkan.getId_kategori_pemasukkan();
        LocalDate tanggal_pemasukkan = pemasukkan.getTanggal_pemasukkan();
        String note = pemasukkan.getNote();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String tanggalFormatted = tanggal_pemasukkan.format(formatter);
        int RowsAffect = 0;
        connect.checkConnection();
        try{
            RowsAffect = connect.executeQueryDml(sql,
                    jumlah_pemasukkan,
                    id_kategori_pemasukkan,
                    tanggalFormatted,
                    note);
        } catch (SQLException e){
            e.printStackTrace();
        }finally{
            connect.disconnect();
        }
        return RowsAffect;
    }

        public List<Pemasukkan> getdataPemasukkanById () throws SQLException{
        List<Pemasukkan> listPemasukkan = new ArrayList<>();
        String sql = "SELECT pemasukkan.Id_pemasukkan , pemasukkan.Jumlah_pemasukkan, kategori_pemasukkan.Nama_kategori, pemasukkan.Tanggal_pemasukkan, pemasukkan.Note FROM pemasukkan "
                + "INNER JOIN kategori_pemasukkan ON pemasukkan.Id_kategori_pemasukkan=kategori_pemasukkan.Id_kategori_pemasukkan";
        
        connect.checkConnection();
        try {
            ResultSet resultSet = connect.executeQueryRead(sql);
            while(resultSet.next()){
                int id_pemasukkan = resultSet.getInt("Id_pemasukkan");
                int jumlah_pemasukkan = resultSet.getInt("Jumlah_pemasukkan");
                String nama_kategori = resultSet.getString("Nama_kategori");
                LocalDate tanggal_pemasukkan = resultSet.getDate("Tanggal_pemasukkan").toLocalDate();
                String note = resultSet.getString("Note");
               Pemasukkan pemasukkan = new Pemasukkan(id_pemasukkan, jumlah_pemasukkan, nama_kategori, tanggal_pemasukkan, note);
               listPemasukkan.add(pemasukkan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            connect.disconnect();
        }
        return listPemasukkan;
    }

    public int updatePemasukkan(Pemasukkan pemasukkan) throws SQLException {
    String sql = "UPDATE pemasukkan SET Id_kategori_pemasukkan = ?, Jumlah_pemasukkan = ?, Tanggal_pemasukkan = ?, Note = ? WHERE Id_pemasukkan = ?";
    int id_pemasukkan = pemasukkan.getId_pemasukkan();
    int id_kategori_pemasukkan = pemasukkan.getId_kategori_pemasukkan();
    int jumlah_pemasukkan = pemasukkan.getJumlah_pemasukkan();
    LocalDate tanggal_pemasukkan = pemasukkan.getTanggal_pemasukkan();
    String note = pemasukkan.getNote();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String tanggalFormatted = tanggal_pemasukkan.format(formatter);

    int rowsAffected = 0; 
    try {
        connect.checkConnection();
        rowsAffected = connect.executeQueryDml(sql,
                id_kategori_pemasukkan,
                jumlah_pemasukkan,
                tanggalFormatted,
                note,
                id_pemasukkan);
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        connect.disconnect();
    }
    return rowsAffected;
}

     public int deletePengeluaran(Pemasukkan pemasukkan) throws SQLException{
        String sql = "DELETE FROM pemasukkan WHERE Id_pemasukkan=?";
        int id_pemasukkan = pemasukkan.getId_pemasukkan();
        int RowsAffect = 0;
        connect.checkConnection(); 
        try {
            RowsAffect = connect.executeQueryDml(sql,id_pemasukkan);
        } catch (Exception e) {
           e.printStackTrace();
        }finally{
            connect.disconnect();
        }
        return RowsAffect;
   }
//     public static void main(String[] args) {
//        PengeluaranStorage pengeluaranStorage= new PengeluaranStorage();
//        try {
//            List<Pengeluaran> listPengeluaran = pengeluaranStorage.getdataPengeluaran();
//            for(Pengeluaran pengeluaran : listPengeluaran){
//                System.out.println(pengeluaran);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(PengeluaranStorage.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
public List<Pemasukkan> getPemasukkanByNamaKategori(String nama_kategori) throws SQLException {
    List<Pemasukkan> pemasukkanList = new ArrayList<>();
    String sql = "SELECT pemasukkan.Id_pemasukkan, pemasukkan.Jumlah_pemasukkan, kategori_pemasukkan.Nama_kategori, pemasukkan.Tanggal_pemasukkan, pemasukkan.Note FROM pemasukkan "
            + "INNER JOIN kategori_pemasukkan ON pemasukkan.Id_kategori_pemasukkan = kategori_pemasukkan.Id_kategori_pemasukkan WHERE kategori_pemasukkan.Nama_kategori LIKE ? ";
    try {
        connect.checkConnection();
        ResultSet resultSet = connect.executeQueryRead(sql, "%" + nama_kategori + "%");
        while (resultSet.next()) {
            int id_pemasukkan = resultSet.getInt("Id_pemasukkan");
            int jumlah_pemasukkan = resultSet.getInt("Jumlah_pemasukkan");
            LocalDate tanggal_pemasukkan = resultSet.getDate("Tanggal_pemasukkan").toLocalDate();
            String note = resultSet.getString("Note");
            pemasukkanList.add(new Pemasukkan(id_pemasukkan, jumlah_pemasukkan, nama_kategori, tanggal_pemasukkan, note));
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        connect.disconnect();
    }
    return pemasukkanList;
}
public int getAllJumlahPemasukkan(){
    String sql = "SELECT Jumlah_pemasukkan FROM pemasukkan";
    try {
        connect.checkConnection();
        ResultSet resultSet = connect.executeQueryRead(sql);
        int total_pemasukkan =0;
        while (resultSet.next()) {
            int jumlah_pemasukkan = resultSet.getInt("Jumlah_pemasukkan");
            total_pemasukkan = jumlah_pemasukkan;
        }
        return  total_pemasukkan;
    } catch (Exception e) {
        e.printStackTrace();
    }finally{
        connect.disconnect();
    }
    return 0;
}

     public static void main(String[] args) {
        PemasukkanStorage pemasukkanStorage = new PemasukkanStorage();
        int total = pemasukkanStorage.getAllJumlahPemasukkan();
         try {
             System.out.println("total" + total);
         } catch (Exception e) {
         }
         
    }
}
