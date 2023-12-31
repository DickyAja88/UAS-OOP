/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.PembayaranHutang;
import Storage.PembayaranHutangStorage;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 *
 * @author DICKY SAPUTRA
 */
public class HistoriPembayaranHutangGUI extends javax.swing.JFrame {
int row;
PembayaranHutangStorage pembayaranHutangStorage = new PembayaranHutangStorage();




    /**
     * Creates new form PengeluaranGUI
     */
    public HistoriPembayaranHutangGUI()  {
        initComponents();
        getAllHistoriPembayaran();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        hapusbtn = new javax.swing.JButton();
        caribtn = new javax.swing.JButton();
        cariField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        refreshbtn = new javax.swing.JButton();
        backbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHistori = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Histori Pembayaran Hutang");

        hapusbtn.setBackground(new java.awt.Color(0, 153, 255));
        hapusbtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\DICKY SAPUTRA\\Documents\\NetBeansProjects\\AplikasiKeuangan\\src\\main\\Java\\gambar\\delete.png")); // NOI18N
        hapusbtn.setBorder(null);
        hapusbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusbtnActionPerformed(evt);
            }
        });

        caribtn.setBackground(new java.awt.Color(0, 153, 255));
        caribtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\DICKY SAPUTRA\\Documents\\NetBeansProjects\\AplikasiKeuangan\\src\\main\\Java\\gambar\\cari.png")); // NOI18N
        caribtn.setBorder(null);
        caribtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caribtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cari");

        refreshbtn.setBackground(new java.awt.Color(0, 153, 255));
        refreshbtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\DICKY SAPUTRA\\Documents\\NetBeansProjects\\AplikasiKeuangan\\src\\main\\Java\\gambar\\refresh.png")); // NOI18N
        refreshbtn.setBorder(null);
        refreshbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshbtnActionPerformed(evt);
            }
        });

        backbtn.setText("Back");
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cariField, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(caribtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hapusbtn)
                .addGap(36, 36, 36))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(backbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshbtn)
                .addGap(76, 76, 76)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refreshbtn)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backbtn))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(hapusbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(caribtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cariField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        tableHistori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Judul Hutang", "Jumlah Pembayaran", "Tanggal Pembayaran", "ID Hutang"
            }
        ));
        jScrollPane1.setViewportView(tableHistori);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hapusbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusbtnActionPerformed
        // TODO add your handling code here:
       int selectedRow = tableHistori.getSelectedRow();
    if (selectedRow >= 0) {
        int id_pembayaran = (int) tableHistori.getValueAt(selectedRow, 0);
        try {
            PembayaranHutang pembayaranHutang = new PembayaranHutang(id_pembayaran);
            pembayaranHutang.setId_pembayaran(id_pembayaran);
            int rowsAffected = pembayaranHutangStorage.deletePembayaran(pembayaranHutang);
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Histori pembayaran berhasil dihapus");
            } else {
                JOptionPane.showMessageDialog(null, "Gagal menghapus histori Pembayaran");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal menghapus histori Pembayaran: " + e.getMessage());
        }
        getAllHistoriPembayaran();
    } else {
        JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dihapus");
    }
    }//GEN-LAST:event_hapusbtnActionPerformed
    
    private void caribtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caribtnActionPerformed
        // TODO add your handling code here:
        String keyword = cariField.getText();
        DefaultTableModel model = (DefaultTableModel) tableHistori.getModel();
        model.setRowCount(0);
        try {
            List<PembayaranHutang> listBayar = pembayaranHutangStorage.getAllPembayaranHutangByJudulHutang(keyword);
            if(!listBayar.isEmpty()){
                for(PembayaranHutang pembayaranHutang: listBayar){
                Object [] row = {
                pembayaranHutang.getId_pembayaran(),
                pembayaranHutang.getJudul_hutang(),
                pembayaranHutang.getJumlah_Pembayaran(),
                pembayaranHutang.getTanggal_pembayaran(),
                pembayaranHutang.getId_hutang()
                };
                model.addRow(row);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Data tidak ada");
            }

        } catch (Exception e) {
            e.printStackTrace();
    }
        
        
   
    }//GEN-LAST:event_caribtnActionPerformed

    private void refreshbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshbtnActionPerformed
        // TODO add your handling code here:
        getAllHistoriPembayaran();
    }//GEN-LAST:event_refreshbtnActionPerformed

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        // TODO add your handling code here:
        new HutangGUI().setVisible(true);
        dispose();
    }//GEN-LAST:event_backbtnActionPerformed
    public void getAllHistoriPembayaran() {
        try {
            NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
            List<PembayaranHutang> listPembayaran = pembayaranHutangStorage.getAllPembayaran();
        
            DefaultTableModel model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID","Judul Hutang", "Jumlah Pembayaran", "Tanggal pembayaran", "ID Hutang"}
            );
        
            for (PembayaranHutang pembayaranHutang : listPembayaran) {
                int id_pembayaran = pembayaranHutang.getId_pembayaran();
                String judul_hutang = pembayaranHutang.getJudul_hutang();
                int jumlah_pembayaran = pembayaranHutang.getJumlah_Pembayaran();
                String format_jumlah_pembayaran = formatter.format(jumlah_pembayaran);
                LocalDate tanggal_pembayaran = pembayaranHutang.getTanggal_pembayaran();
                DateTimeFormatter refactorDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String tanggalFormatted = tanggal_pembayaran.format(refactorDateTimeFormatter);
                int id_hutang = pembayaranHutang.getId_hutang();
            
                model.addRow(new Object[]{id_pembayaran, judul_hutang, format_jumlah_pembayaran, tanggalFormatted, id_hutang});
            }
        
            tableHistori.setModel(model);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//        try {
//        int selectedRow = tableHistori.getSelectedRow();
//        int id_pembayaran = Integer.parseInt(tableHistori.getValueAt(selectedRow, 0).toString());
//        String jumlahPembayaranString = tableHistori.getValueAt(selectedRow, 2).toString();
//        String jumlahPembayaranCleaned = jumlahPembayaranString.replaceAll("[^\\d]", ""); 
//        int jumlah_pembayaran = Integer.parseInt(jumlahPembayaranCleaned);
//        String tanggalString = tableHistori.getValueAt(selectedRow, 3).toString();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate tanggal_pembayaran = LocalDate.parse(tanggalString, formatter);
//        int Id_hutang = Integer.parseInt(tableHistori.getValueAt(selectedRow, 4).toString());
//        EditHistoriGUIFORM edit = new EditHistoriGUIFORM(id_pembayaran, jumlah_pembayaran, tanggal_pembayaran, Id_hutang);
//        edit.setVisible(true);
//        edit.addWindowListener(new WindowAdapter(){public void windowClosed(WindowEvent e){getAllHistoriPembayaran();}});
//        } catch (Exception e) {
//            e.printStackTrace();

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HistoriPembayaranHutangGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoriPembayaranHutangGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoriPembayaranHutangGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoriPembayaranHutangGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistoriPembayaranHutangGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbtn;
    private javax.swing.JTextField cariField;
    private javax.swing.JButton caribtn;
    private javax.swing.JButton hapusbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshbtn;
    private javax.swing.JTable tableHistori;
    // End of variables declaration//GEN-END:variables
}
