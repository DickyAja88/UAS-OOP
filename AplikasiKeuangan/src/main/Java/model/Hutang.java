/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DICKY SAPUTRA
 */
public class Hutang {
    private int Id_hutang;
    private int Id_pembayaran;
    private String Judul_hutang;
    private int Jumlah_hutang;
    private String Status;

    public Hutang(int Id_hutang, String Judul_hutang, int Jumlah_hutang) {
        this.Id_hutang = Id_hutang;
        this.Judul_hutang = Judul_hutang;
        this.Jumlah_hutang = Jumlah_hutang;
    }

    public Hutang(int Id_hutang, String Judul_hutang, int jumlah_hutang, String Status) {
        this.Id_hutang = Id_hutang;
        this.Judul_hutang = Judul_hutang;
        this.Jumlah_hutang = jumlah_hutang;
        this.Status = Status;
    }

    public Hutang(int Id_hutang) {
        this.Id_hutang = Id_hutang;
    }

    public Hutang(int Id_hutang, int Id_pembayaran, int Jumlah_hutang) {
        this.Id_hutang = Id_hutang;
        this.Id_pembayaran = Id_pembayaran;
        this.Jumlah_hutang = Jumlah_hutang;
    }

    public int getId_pembayaran() {
        return Id_pembayaran;
    }

    public void setId_pembayaran(int Id_pembayaran) {
        this.Id_pembayaran = Id_pembayaran;
    }
    
    public int getId_hutang() {
        return Id_hutang;
    }

    public void setId_hutang(int Id_hutang) {
        this.Id_hutang = Id_hutang;
    }

    public String getJudul_hutang() {
        return Judul_hutang;
    }

    public void setJudul_hutang(String Judul_hutang) {
        this.Judul_hutang = Judul_hutang;
    }

    public int getJumlah_hutang() {
        return Jumlah_hutang;
    }

    public void setJumlah_hutang(int jumlah_hutang) {
        this.Jumlah_hutang = Jumlah_hutang;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
}
