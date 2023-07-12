/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Storage;

import Connector.connectionDatabase;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DICKY SAPUTRA
 */
public class KategoriPemasukkanStorage {
      connectionDatabase connect = new connectionDatabase();
   
    public int getKategoriId(String nama_kategori) throws SQLException {
        String sql = "SELECT Id_kategori_pemasukkan FROM kategori_pemasukkan WHERE Nama_kategori = ?";
        int id_kategori_pemasukkan = 0;
        try {
            ResultSet resultSet = connect.executeQueryRead(sql, nama_kategori);
            if (resultSet.next()) {
                id_kategori_pemasukkan = resultSet.getInt("Id_kategori_pemasukkan");
            }
        } catch (SQLException e) {
            throw new SQLException("Failed to retrieve kategori ID", e);
        }
        return id_kategori_pemasukkan;
    }
    
}
