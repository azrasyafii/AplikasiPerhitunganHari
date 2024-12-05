/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.toedter.calendar.JCalendar;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class PerhitunganHariGUI extends javax.swing.JFrame {

   
    
    public PerhitunganHariGUI() {
        initComponents();
        // Hapus koma dari spnTahun
        JSpinner.NumberEditor editor = new JSpinner.NumberEditor(spnTahun, "#");
        spnTahun.setEditor(editor);
    
        updateJCalendar(); // Sinkronisasi awal
        hitungJumlahHari(); // Hitung jumlah hari awal

     // Tambahkan listener ke combo box
        cmbBulan.addActionListener(e -> {
            updateJCalendar();
            hitungJumlahHari(); // Perbarui jumlah hari
        });

        // Tambahkan listener ke spinner tahun
        spnTahun.addChangeListener(e -> {
            updateJCalendar();
            hitungJumlahHari(); // Perbarui jumlah hari
        });
        
        // Tambahkan listener ke JCalendar
        jCalendar.addPropertyChangeListener("calendar", evt -> {
            Calendar selectedDate = jCalendar.getCalendar(); // Ambil tanggal yang dipilih
            int bulan = selectedDate.get(Calendar.MONTH);    // Ambil bulan (0 = Januari)
            int tahun = selectedDate.get(Calendar.YEAR);     // Ambil tahun

            // Update cmbBulan dan spnTahun
            cmbBulan.setSelectedIndex(bulan);
            spnTahun.setValue(tahun);

            // Hitung jumlah hari di bulan yang dipilih
            hitungJumlahHari();
        });
    }
    
    private void updateJCalendar() {
    int bulan = cmbBulan.getSelectedIndex(); // Ambil bulan dari ComboBox
    int tahun = (int) spnTahun.getValue();   // Ambil tahun dari Spinner

    // Buat Calendar untuk mengatur JCalendar
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, tahun);
    calendar.set(Calendar.MONTH, bulan);
    calendar.set(Calendar.DAY_OF_MONTH, 1); // Set hari ke 1 untuk konsistensi

    // Periksa apakah tanggal di JCalendar perlu diperbarui
    if (!calendar.getTime().equals(jCalendar.getDate())) {
        jCalendar.setDate(calendar.getTime()); // Set tanggal pada JCalendar
    }
}

private void hitungJumlahHari() {
    int bulan = cmbBulan.getSelectedIndex(); // Ambil bulan dari ComboBox
    int tahun = (int) spnTahun.getValue();   // Ambil tahun dari Spinner

    // Buat Calendar untuk menghitung jumlah hari
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, tahun);
    calendar.set(Calendar.MONTH, bulan);

    int jumlahHari = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); // Hitung jumlah hari
    txtJumlahHari.setText(String.valueOf(jumlahHari)); // Tampilkan jumlah hari
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbBulan = new javax.swing.JComboBox<>();
        spnTahun = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jCalendar = new com.toedter.calendar.JCalendar();
        jLabel4 = new javax.swing.JLabel();
        txtJumlahHari = new javax.swing.JTextField();
        btnHitung = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(820, 750));
        setPreferredSize(new java.awt.Dimension(900, 750));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("APLIKASI PERHITUNGAN HARI");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 320, 40));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("PILIH BULAN");

        cmbBulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JANUARI", "FEBRUARI", "MARET", "APRIL", "MEI", "JUNI", "JULI", "AGUSTUS", "SEPTEMBER", "OKTOBER", "NOVEMBER", "DESEMBER" }));
        cmbBulan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBulanActionPerformed(evt);
            }
        });

        spnTahun.setModel(new javax.swing.SpinnerNumberModel(2024, 1, 9999, 1));
        spnTahun.setAlignmentX(0.0F);
        spnTahun.setAlignmentY(0.0F);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("MASUKKAN TAHUN");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("JUMLAH HARI");

        btnHitung.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnHitung.setText("HITUNG");
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cmbBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(400, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(spnTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(118, 118, 118))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(txtJumlahHari, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(110, 110, 110))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbBulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(40, 40, 40)
                        .addComponent(jCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(btnHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtJumlahHari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(182, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 790, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
    hitungJumlahHari();
    // Ambil bulan dari JComboBox
    int bulan = cmbBulan.getSelectedIndex(); // 0 untuk Januari
    // Ambil tahun dari JSpinner
    int tahun = (int) spnTahun.getValue();

    // Gunakan Calendar untuk menghitung jumlah hari
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, tahun);
    calendar.set(Calendar.MONTH, bulan);
    int jumlahHari = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

    // Tampilkan hasil di JTextField
    txtJumlahHari.setText(String.valueOf(jumlahHari));
    }//GEN-LAST:event_btnHitungActionPerformed

    private void cmbBulanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBulanActionPerformed

    }//GEN-LAST:event_cmbBulanActionPerformed

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
            java.util.logging.Logger.getLogger(PerhitunganHariGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerhitunganHariGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerhitunganHariGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerhitunganHariGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerhitunganHariGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHitung;
    private javax.swing.JComboBox<String> cmbBulan;
    private com.toedter.calendar.JCalendar jCalendar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner spnTahun;
    private javax.swing.JTextField txtJumlahHari;
    // End of variables declaration//GEN-END:variables
}
