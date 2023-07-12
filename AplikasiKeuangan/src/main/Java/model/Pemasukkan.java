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
public class Pemasukkan {
    private int Id_pemasukkan;
    private int Id_kategori_pemasukkan;
    private int Jumlah_pemasukkan;
    private String nama_kategori;
    private LocalDate Tanggal_pemasukkan;
    private String Note;

    public Pemasukkan(int Id_pemasukkan, int Jumlah_pemasukkan, String nama_kategori, LocalDate Tanggal_pemasukkan, String Note) {
        this.Id_pemasukkan = Id_pemasukkan;
        this.Jumlah_pemasukkan = Jumlah_pemasukkan;
        this.nama_kategori = nama_kategori;
        this.Tanggal_pemasukkan = Tanggal_pemasukkan;
        this.Note = Note;
    }

    public Pemasukkan(int Id_kategori_pemasukkan, int Jumlah_pemasukkan, LocalDate Tanggal_pemasukkan, String Note) {
        this.Id_kategori_pemasukkan = Id_kategori_pemasukkan;
        this.Jumlah_pemasukkan = Jumlah_pemasukkan;
        this.Tanggal_pemasukkan = Tanggal_pemasukkan;
        this.Note = Note;
    }

    public Pemasukkan(int Id_pemasukkan) {
        this.Id_pemasukkan = Id_pemasukkan;
    }
    


 

    public Pemasukkan(int Id_pemasukkan, int Id_kategori_pemasukkan, int Jumlah_pemasukkan, LocalDate Tanggal_pemasukkan, String Note) {
        this.Id_pemasukkan = Id_pemasukkan;
        this.Id_kategori_pemasukkan = Id_kategori_pemasukkan;
        this.Jumlah_pemasukkan = Jumlah_pemasukkan;
        this.Tanggal_pemasukkan = Tanggal_pemasukkan;
        this.Note = Note;
    }

    public int getId_pemasukkan() {
        return Id_pemasukkan;
    }

    public void setId_pemasukkan(int Id_pemasukkan) {
        this.Id_pemasukkan = Id_pemasukkan;
    }

    public int getId_kategori_pemasukkan() {
        return Id_kategori_pemasukkan;
    }

    public void setId_kategori_pemasukkan(int Id_kategori_pemasukkan) {
        this.Id_kategori_pemasukkan = Id_kategori_pemasukkan;
    }

    public int getJumlah_pemasukkan() {
        return Jumlah_pemasukkan;
    }

    public void setJumlah_pemasukkan(int Jumlah_pemasukkan) {
        this.Jumlah_pemasukkan = Jumlah_pemasukkan;
    }

    public LocalDate getTanggal_pemasukkan() {
        return Tanggal_pemasukkan;
    }

    public void setTanggal_pemasukkan(LocalDate Tanggal_pemasukkan) {
        this.Tanggal_pemasukkan = Tanggal_pemasukkan;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }
    
    
}
