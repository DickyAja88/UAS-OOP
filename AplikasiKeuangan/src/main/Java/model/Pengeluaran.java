/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.time.LocalDate;

/**
 *
 * @author DICKY SAPUTRA
 */
public class Pengeluaran {
    private int Id_pengeluaran;
    private int Id_kategori_pengeluaran;
    private int Jumlah_pengeluaran;
    private String nama_kategori;
    private LocalDate Tanggal_pengeluaran;
    private String note;

    public Pengeluaran(int Id_kategori_pengeluaran, int Jumlah_pengeluaran, LocalDate Tanggal_pengeluaran, String note) {
        this.Id_kategori_pengeluaran = Id_kategori_pengeluaran;
        this.Jumlah_pengeluaran = Jumlah_pengeluaran;
        this.Tanggal_pengeluaran = Tanggal_pengeluaran;
        this.note = note;
    }
    public Pengeluaran( int Jumlah_pengeluaran, String nama_kategori,LocalDate Tanggal_pengeluaran, String note) {
        this.Jumlah_pengeluaran = Jumlah_pengeluaran;
        this.nama_kategori = nama_kategori;
        this.Tanggal_pengeluaran = Tanggal_pengeluaran;
        this.note = note;
    }

    public Pengeluaran(int Id_pengeluaran) {
        this.Id_pengeluaran = Id_pengeluaran;
    }
    


    public Pengeluaran(int Id_pengeluaran, int Id_kategori_pengeluaran, int Jumlah_pengeluaran, LocalDate Tanggal_pengeluaran, String note) {
        this.Id_pengeluaran = Id_pengeluaran;
        this.Id_kategori_pengeluaran = Id_kategori_pengeluaran;
        this.Jumlah_pengeluaran = Jumlah_pengeluaran;
        this.Tanggal_pengeluaran = Tanggal_pengeluaran;
        this.note = note;
    }

    public Pengeluaran(int Id_pengeluaran, int Jumlah_pengeluaran, String nama_kategori, LocalDate Tanggal_pengeluaran, String note) {
        this.Id_pengeluaran = Id_pengeluaran;
        this.Jumlah_pengeluaran = Jumlah_pengeluaran;
        this.nama_kategori = nama_kategori;
        this.Tanggal_pengeluaran = Tanggal_pengeluaran;
        this.note = note;
    }
    

    public int getId_pengeluaran() {
        return Id_pengeluaran;
    }

    public void setId_pengeluaran(int Id_pengeluaran) {
        this.Id_pengeluaran = Id_pengeluaran;
    }

    public int getId_kategori_pengeluaran() {
        return Id_kategori_pengeluaran;
    }

    public void setId_kategori_pengeluaran(int Id_kategori_pengeluaran) {
        this.Id_kategori_pengeluaran = Id_kategori_pengeluaran;
    }

    public int getJumlah_pengeluaran() {
        return Jumlah_pengeluaran;
    }

    public void setJumlah_pengeluaran(int Jumlah_pengeluaran) {
        this.Jumlah_pengeluaran = Jumlah_pengeluaran;
    }

    public LocalDate getTanggal_pengeluaran() {
        return Tanggal_pengeluaran;
    }

    public void setTanggal_pengeluaran(LocalDate Tanggal_pengeluaran) {
        this.Tanggal_pengeluaran = Tanggal_pengeluaran;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }
    
    
    
 
}
