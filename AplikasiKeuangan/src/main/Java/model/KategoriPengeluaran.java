/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DICKY SAPUTRA
 */
public class KategoriPengeluaran {
    private int Id_kategori_pengeluaran;
    private String Nama_kategori;
    
    public KategoriPengeluaran(int id_kategori_pengeluaran, String nama_kategori) {
        this.Id_kategori_pengeluaran = id_kategori_pengeluaran;
        this.Nama_kategori = nama_kategori;
    }

    public int getId_kategori_pengeluaran() {
        return Id_kategori_pengeluaran;
    }

    public void setId_kategori_pengeluaran(int Id_kategori_pengeluaran) {
        this.Id_kategori_pengeluaran = Id_kategori_pengeluaran;
    }

    public String getNama_kategori() {
        return Nama_kategori;
    }

    public void setNama_kategori(String Nama_kategori) {
        this.Nama_kategori = Nama_kategori;
    }

}

