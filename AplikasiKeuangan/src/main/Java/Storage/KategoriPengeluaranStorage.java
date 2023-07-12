/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Storage;
import Connector.connectionDatabase;
import java.sql.ResultSet;
import java.sql.SQLException;
import GUI.TambahPengeluaranGUIFORM;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author DICKY SAPUTRA
 */
public class KategoriPengeluaranStorage {
    connectionDatabase connect = new connectionDatabase();
   
    public int getKategoriId(String nama_kategori) throws SQLException {
    String sql = "SELECT Id_kategori_pengeluaran FROM kategori_pengeluaran WHERE Nama_kategori = ?";
    int id_kategori_pengeluaran = 0;
    try {
        ResultSet resultSet = connect.executeQueryRead(sql, nama_kategori);
        if (resultSet.next()) {
            id_kategori_pengeluaran = resultSet.getInt("Id_kategori_pengeluaran");
        }
    } catch (SQLException e) {
        throw new SQLException("Failed to retrieve kategori ID", e);
    }
    return id_kategori_pengeluaran;
}

   




        
//    private int getIdKategoriPengeluaran(KategoriPengeluaran kategori, String nama_kategori)throws SQLException {
//        String sql = "SELECT Id_kategori_pengeluaran FROM kategori_pengeluaran WHERE Nama_kategori = '" + nama_kategori + "'";
//      
//        try{
//            connect.checkConnection();
//            ResultSet resultSet = connect.executeQueryRead(sql, nama_kategori);
//            if(resultSet.next()){
//                return resultSet.getInt(sql);
//            }
//        } catch (SQLException e){    
//            e.printStackTrace();
//        }finally{    
//            connect.disconnect();
//        }
//        return 0;
//    }

 

    
}
