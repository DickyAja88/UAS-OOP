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
public class PembayaranHutang {
    private int Id_pembayaran;
    private int Id_hutang;
    private String judul_hutang;
    private int Jumlah_Pembayaran;
    private LocalDate Tanggal_pembayaran;


    public String getJudul_hutang() {
        return judul_hutang;
    }

    public void setJudul_hutang(String judul_hutang) {
        this.judul_hutang = judul_hutang;
    }

    public PembayaranHutang(int Id_pembayaran, int Id_hutang, String judul_hutang, int Jumlah_Pembayaran, LocalDate Tanggal_pembayaran) {
        this.Id_pembayaran = Id_pembayaran;
        this.Id_hutang = Id_hutang;
        this.judul_hutang = judul_hutang;
        this.Jumlah_Pembayaran = Jumlah_Pembayaran;
        this.Tanggal_pembayaran = Tanggal_pembayaran;
    }


    public PembayaranHutang(int Id_pembayaran){
        this.Id_pembayaran = Id_pembayaran;
    }
    public PembayaranHutang(int Id_hutang, int Jumlah_Pembayaran, LocalDate Tanggal_pembayaran) {
        this.Id_hutang = Id_hutang;
        this.Jumlah_Pembayaran = Jumlah_Pembayaran;
        this.Tanggal_pembayaran = Tanggal_pembayaran;
    }

    public PembayaranHutang(int Id_pembayaran, int Id_hutang, int Jumlah_Pembayaran, LocalDate Tanggal_pembayaran) {
        this.Id_pembayaran = Id_pembayaran;
        this.Id_hutang = Id_hutang;
        this.Jumlah_Pembayaran = Jumlah_Pembayaran;
        this.Tanggal_pembayaran = Tanggal_pembayaran;
    }

 

    public int getId_hutang() {
        return Id_hutang;
    }

    public void setId_hutang(int Id_hutang) {
        this.Id_hutang = Id_hutang;
    }

    public int getId_pembayaran() {
        return Id_pembayaran;
    }

    public void setId_pembayaran(int Id_pembayaran) {
        this.Id_pembayaran = Id_pembayaran;
    }

    public int getJumlah_Pembayaran() {
        return Jumlah_Pembayaran;
    }

    public void setJumlah_Pembayaran(int Jumlah_Pembayaran) {
        this.Jumlah_Pembayaran = Jumlah_Pembayaran;
    }

    public LocalDate getTanggal_pembayaran() {
        return Tanggal_pembayaran;
    }

    public void setTanggal_pembayaran(LocalDate Tanggal_pembayaran) {
        this.Tanggal_pembayaran = Tanggal_pembayaran;
    }
}
