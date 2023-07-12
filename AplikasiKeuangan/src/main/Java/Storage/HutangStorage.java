/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Storage;
import java.sql.SQLException;
import model.Hutang;
import Connector.connectionDatabase;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author DICKY SAPUTRA
 */
public class HutangStorage {
    connectionDatabase connect = new connectionDatabase();
    
    public int addHutang(Hutang hutang) throws SQLException{
        String sql = "INSERT INTO hutang (Id_hutang, Judul_hutang, Jumlah_hutang, Status) VALUES (?, ?, ?, ?)";
        int id_hutang = hutang.getId_hutang();
        String judul_hutang= hutang.getJudul_hutang();
        int jumlah_hutang = hutang.getJumlah_hutang();
        String status = hutang.getStatus();
        int RowsAffect = 0;
            
        try {
            connect.checkConnection();
            RowsAffect = connect.executeQueryDml(sql,
                id_hutang,
                judul_hutang,
                jumlah_hutang,
                status);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            connect.disconnect();
        }
        return RowsAffect;
    }
    
    public List<Hutang> getDataHutang () throws SQLException{
        List<Hutang> listNgutang = new ArrayList<>();
        String sql = "SELECT * FROM hutang";
        
        try {
            connect.checkConnection();
            ResultSet resultSet = connect.executeQueryRead(sql);    
            while (resultSet.next()) {
                int id_hutang = resultSet.getInt("Id_hutang");
                String judul_hutang = resultSet.getString("Judul_hutang");
                int jumlah_hutang = resultSet.getInt("Jumlah_hutang");
                String status = resultSet.getString("Status");
                if(jumlah_hutang == 0){
                    updateStatus(id_hutang);
                    status ="Lunas";
                }
                Hutang hutang = new Hutang(id_hutang, judul_hutang, jumlah_hutang, status);
                listNgutang.add(hutang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            connect.disconnect();
        }
        return listNgutang;
    }
        
    public int updateStatus(int Id_hutang) throws SQLException{
        String sql = "UPDATE hutang SET Status = 'Lunas' WHERE Id_hutang = ? AND Jumlah_hutang = 0";
        int RoswAffect = 0;
            
        try {
            connect.checkConnection();
            RoswAffect = connect.executeQueryDml(sql, Id_hutang);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            connect.disconnect();
        }
        return RoswAffect;
    }
            
    public List<Hutang> getDataHutangByJudul (String Judul_hutang) throws SQLException{
        List<Hutang> listNgutang = new ArrayList<>();
        String sql = "SELECT * FROM hutang WHERE Judul_hutang LIKE ?";
            
        try {
            connect.checkConnection();
            ResultSet resultSet = connect.executeQueryRead(sql, "%" + Judul_hutang + "%");
            while (resultSet.next()) {
                int id_hutang = resultSet.getInt("Id_hutang");
                String judul_hutang = resultSet.getString("Judul_hutang");
                int jumlah_hutang = resultSet.getInt("Jumlah_hutang");
                String status = resultSet.getString("Status");
                listNgutang.add(new Hutang(id_hutang, judul_hutang, jumlah_hutang, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            connect.disconnect();
        }
        return listNgutang;
    }    
    
    public int UpdateHutang(Hutang hutang)throws SQLException{
        String sql = "UPDATE hutang SET Judul_hutang = ?, Jumlah_hutang = ? WHERE Id_hutang = ?";
        int id_hutang = hutang.getId_hutang();
        String judul_hutang = hutang.getJudul_hutang();
        int Jumlah_hutang = hutang.getJumlah_hutang();
        int RowsAffect = 0;
        
        try {
            connect.checkConnection();
            RowsAffect = connect.executeQueryDml(sql,
                judul_hutang,
                Jumlah_hutang,
                id_hutang
                 );
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            connect.disconnect();
        }
        return RowsAffect; 
    }
    
    public int deletePengeluaran(Hutang hutang) throws SQLException{
        String sql = "DELETE FROM hutang WHERE Id_hutang=?";
        int id_hutang = hutang.getId_hutang();
        int RowsAffect = 0;
         
        try {
            connect.checkConnection();
            RowsAffect = connect.executeQueryDml(sql,id_hutang);
        } catch (SQLException e) {
           e.printStackTrace();
        }finally{
            connect.disconnect();
        }
        return RowsAffect;
   }
    
    public int getAllJumlahHutang(){
        String sql ="SELECT Jumlah_hutang FROM hutang";
         
        try {
            connect.checkConnection();
            ResultSet resultSet = connect.executeQueryRead(sql);
            int total_hutang = 0;
            while (resultSet.next()) {
                int jumlah_hutang = resultSet.getInt("Jumlah_hutang");
                total_hutang += jumlah_hutang;
            }
            return total_hutang;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        connect.disconnect();
        }
        return 0;
    }
     
    
}
