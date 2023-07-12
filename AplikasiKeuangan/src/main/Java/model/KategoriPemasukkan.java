/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DICKY SAPUTRA
 */
public class KategoriPemasukkan {
    private int Id_kategori_pemasukkan;
    private int Nama_kategori;

    public int getId_kategori_pemasukkan() {
        return Id_kategori_pemasukkan;
    }

    public void setId_kategori_pemasukkan(int Id_kategori_pemasukkan) {
        this.Id_kategori_pemasukkan = Id_kategori_pemasukkan;
    }

    public int getNama_kategori() {
        return Nama_kategori;
    }

    public void setNama_kategori(int Nama_kategori) {
        this.Nama_kategori = Nama_kategori;
    }

    public KategoriPemasukkan(int Id_kategori_pemasukkan, int Nama_kategori) {
        this.Id_kategori_pemasukkan = Id_kategori_pemasukkan;
        this.Nama_kategori = Nama_kategori;
    }
    
}
