/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjadwalan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class Jadwal extends javax.swing.JInternalFrame {

    DefaultTableModel tabelModel;
    public Jadwal() {
        initComponents();
        tampilData();
        kodeJurusan();
        kodeKelas();
        nip();
        kodeMapel();
        panelDetail.setVisible(false);
    }
    
    public void tampilData() {
        Object [] baris = {
            "Id Jadwal",
            "Tanggal Masuk",
            "Jam Mulai",
            "Jam Akhir",
            "Kode Jurusan",
            "Kode Kelas",
            "NIP",
            "Kode Mapel"
        };
        
        tabelModel = new DefaultTableModel(null, baris);
        tabel.setModel(tabelModel);
        
        String sql = "SELECT * FROM jadwal_sekolah";
        try {
            Connection konek = new Koneksi().getConnection();
            Statement stat = konek.createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()) {
                String id_jadwal = res.getString("id_jadwal");
                String tanggal = res.getString("tanggal");
                String jam_mulai = res.getString("jam_mulai");
                String jam_akhir = res.getString("jam_Akhir");
                String kode_jurusan = res.getString("kode_jurusan");
                String kode_kelas = res.getString("kode_kelas");
                String nip = res.getString("nip");
                String kode_mata_pelajaran = res.getString("kode_mata_pelajaran");
                String [] data = {
                    id_jadwal,
                    tanggal,
                    jam_mulai,
                    jam_akhir,
                    kode_jurusan,
                    kode_kelas,
                    nip,
                    kode_mata_pelajaran
                };
                tabelModel.addRow(data);
                
            } konek.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Tampil", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void detailJurusan() {
        try {
            Connection konek = new Koneksi().getConnection();
            String sql = "SELECT jurusan.nama_jurusan "
                    + "FROM jurusan WHERE kode_jurusan = "
                    + "'" + c_kode_jurusan.getSelectedItem() + "'";
            Statement stat = konek.createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()) {
                Object[]ob = new Object[3];
                ob[1] = res.getString(1);
                namaJurusan.setText((String)ob[1]);
            } res.close();
            
            stat.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Tampil", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void detailKelas() {
        try {
            Connection konek = new Koneksi().getConnection();
            String sql = "SELECT kelas.nama_kelas "
                    + "FROM kelas WHERE kode_kelas = "
                    + "'" + c_kode_kelas.getSelectedItem() + "'";
            Statement stat = konek.createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()) {
                Object[]ob = new Object[3];
                ob[1] = res.getString(1);
                namaKelas.setText((String)ob[1]);
            } res.close();
            
            stat.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Tampil", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void detailGuru() {
        try {
            Connection konek = new Koneksi().getConnection();
            String sql = "SELECT guru.nama "
                    + "FROM guru WHERE nip = "
                    + "'" + c_nip.getSelectedItem() + "'";
            Statement stat = konek.createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()) {
                Object[]ob = new Object[3];
                ob[1] = res.getString(1);
                namaGuru.setText((String)ob[1]);
            } res.close();
            
            stat.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Tampil", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void detailMapel() {
        try {
            Connection konek = new Koneksi().getConnection();
            String sql = "SELECT mata_pelajaran.nama_mata_pelajaran "
                    + "FROM mata_pelajaran WHERE kode_mata_pelajaran = "
                    + "'" + c_kode_mapel.getSelectedItem() + "'";
            Statement stat = konek.createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()) {
                Object[]ob = new Object[3];
                ob[1] = res.getString(1);
                namaMapel.setText((String)ob[1]);
            } res.close();
            
            stat.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Tampil nama Mapel", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    

    
    public void kodeKelas() {
        try {
            Connection konek = new Koneksi().getConnection();
            String sql = "SELECT * FROM kelas";
            Statement stat = konek.createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()) {
                Object[]ob = new Object[3];
                c_kode_kelas.addItem(res.getString("kode_kelas"));
            } 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Tampil Kode", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void kodeJurusan() {
        try {
            Connection konek = new Koneksi().getConnection();
            String sql = "SELECT * FROM jurusan";
            Statement stat = konek.createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()) {
                Object[]ob = new Object[3];
                c_kode_jurusan.addItem(res.getString("kode_jurusan"));
            } 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Tampil Kode", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void nip() {
        try {
            Connection konek = new Koneksi().getConnection();
            String sql = "SELECT * FROM guru";
            Statement stat = konek.createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()) {
                Object[]ob = new Object[3];
                c_nip.addItem(res.getString("nip"));
            } 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Tampil Kode", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void kodeMapel() {
        try {
            Connection konek = new Koneksi().getConnection();
            String sql = "SELECT * FROM mata_pelajaran";
            Statement stat = konek.createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()) {
                Object[]ob = new Object[3];
                c_kode_mapel.addItem(res.getString("kode_mata_pelajaran"));
            } 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Tampil Kode", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
    public void reset() {
        textIdJadwal.setText("");
        c_tgl.setSelectedIndex(0);
        c_bln.setSelectedIndex(0);
        c_thn.setSelectedIndex(0);
        textJamMulai.setText("");
        c_kode_jurusan.setSelectedIndex(0);
        c_nip.setSelectedIndex(0);
        c_kode_mapel.setSelectedIndex(0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textIdJadwal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        c_tgl = new javax.swing.JComboBox<>();
        c_bln = new javax.swing.JComboBox<>();
        c_thn = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        textJamMulai = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        btn_simpan = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_detail = new javax.swing.JButton();
        c_kode_jurusan = new javax.swing.JComboBox<>();
        c_kode_kelas = new javax.swing.JComboBox<>();
        c_kode_mapel = new javax.swing.JComboBox<>();
        c_nip = new javax.swing.JComboBox<>();
        panelDetail = new javax.swing.JPanel();
        namaJurusan = new javax.swing.JLabel();
        namaKelas = new javax.swing.JLabel();
        namaGuru = new javax.swing.JLabel();
        namaMapel = new javax.swing.JLabel();
        namaJurusan1 = new javax.swing.JLabel();
        namaKelas1 = new javax.swing.JLabel();
        namaGuru1 = new javax.swing.JLabel();
        namaMapel1 = new javax.swing.JLabel();
        btn_reset = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        textJamAkhir = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel1.setText("Id Jadwal:");

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel2.setText("Tanggal-Masuk");

        c_tgl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tanggal", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        c_bln.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bulan", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        c_thn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tahun", "2020", "2021", "2022", "2023", "2024", "2025", "2026" }));

        jLabel3.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel3.setText("Jam Mulai");

        jLabel4.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel4.setText("Kode Jurusan");

        jLabel5.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel5.setText("Kode Kelas");

        jLabel6.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel6.setText("NIP");

        jLabel7.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel7.setText("Kode Mata Pelajaran");

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        btn_simpan.setBackground(new java.awt.Color(255, 255, 255));
        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_hapus.setBackground(new java.awt.Color(255, 255, 255));
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_edit.setBackground(new java.awt.Color(255, 255, 255));
        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_detail.setBackground(new java.awt.Color(255, 255, 255));
        btn_detail.setText("Detail");
        btn_detail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_detailActionPerformed(evt);
            }
        });

        c_kode_jurusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_kode_jurusanActionPerformed(evt);
            }
        });

        c_kode_kelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_kode_kelasActionPerformed(evt);
            }
        });

        c_kode_mapel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_kode_mapelActionPerformed(evt);
            }
        });

        c_nip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_nipActionPerformed(evt);
            }
        });

        panelDetail.setBackground(new java.awt.Color(255, 255, 255));

        namaJurusan.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        namaJurusan.setText("Nama-Jurusan");

        namaKelas.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        namaKelas.setText("Nama-Kelas");

        namaGuru.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        namaGuru.setText("Nama-Guru");

        namaMapel.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        namaMapel.setText("Mapel");

        namaJurusan1.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        namaJurusan1.setText("Nama-Jurusan");

        namaKelas1.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        namaKelas1.setText("Kelas");

        namaGuru1.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        namaGuru1.setText("Guru");

        namaMapel1.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        namaMapel1.setText("Mata-Pelajaran");

        javax.swing.GroupLayout panelDetailLayout = new javax.swing.GroupLayout(panelDetail);
        panelDetail.setLayout(panelDetailLayout);
        panelDetailLayout.setHorizontalGroup(
            panelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaJurusan)
                    .addComponent(namaJurusan1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaKelas)
                    .addComponent(namaKelas1))
                .addGap(77, 77, 77)
                .addGroup(panelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaGuru)
                    .addComponent(namaGuru1))
                .addGap(92, 92, 92)
                .addGroup(panelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaMapel1)
                    .addComponent(namaMapel))
                .addGap(90, 90, 90))
        );
        panelDetailLayout.setVerticalGroup(
            panelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDetailLayout.createSequentialGroup()
                .addGroup(panelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaJurusan1)
                    .addComponent(namaKelas1)
                    .addComponent(namaGuru1)
                    .addComponent(namaMapel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(panelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaJurusan)
                    .addComponent(namaKelas)
                    .addComponent(namaGuru)
                    .addComponent(namaMapel)))
        );

        btn_reset.setBackground(new java.awt.Color(255, 255, 255));
        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        jLabel8.setText("Jadwal");

        jLabel9.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jLabel9.setText("Jam Akhir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_detail)
                                .addGap(18, 18, 18)
                                .addComponent(panelDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(c_kode_jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textIdJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(c_tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(c_bln, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(9, 9, 9)
                                                .addComponent(c_thn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel8)))
                                    .addComponent(textJamMulai, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textJamAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(c_kode_kelas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(c_nip, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(c_kode_mapel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_simpan)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_hapus)
                                        .addGap(13, 13, 13)
                                        .addComponent(btn_edit)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_reset)))))
                        .addGap(34, 34, 34))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textIdJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(c_tgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(c_bln, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(c_thn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(textJamMulai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(c_kode_kelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(c_nip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(c_kode_mapel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(textJamAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_simpan)
                        .addComponent(btn_hapus)
                        .addComponent(btn_edit)
                        .addComponent(btn_reset))
                    .addComponent(c_kode_jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_detail)
                    .addComponent(panelDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        String idJadwal = "", tglMasuk = "", tgl = "", bln = "", thn = "", jamMulai = "", jamAkhir = "", kodeJurusan = "", kodeKelas = "", nip = "", kodeMapel = "";
        
        idJadwal = textIdJadwal.getText();
        
        tgl = c_tgl.getSelectedItem().toString();
        bln = c_bln.getSelectedItem().toString();
        thn = c_thn.getSelectedItem().toString();
        
        tglMasuk = thn + "-" +bln+ "-" + tgl;
        
        jamMulai = textJamMulai.getText();
        jamAkhir = textJamAkhir.getText();
        kodeJurusan = c_kode_jurusan.getSelectedItem().toString();
        kodeKelas = c_kode_kelas.getSelectedItem().toString();
        nip = c_nip.getSelectedItem().toString();
        kodeMapel = c_kode_mapel.getSelectedItem().toString();
        
        try {
            Connection konek = new Koneksi().getConnection();
            String sql = "INSERT INTO jadwal_sekolah VALUES('"+ idJadwal +"', '"+ tglMasuk +"', '"+ jamMulai +"', '"+ jamAkhir +"', '"+ kodeJurusan +"', '"+ kodeKelas +"', '"+ nip +"', '"+ kodeMapel +"')";
            PreparedStatement pst = (PreparedStatement)konek.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            tampilData();
            reset();
            konek.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void c_kode_jurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_kode_jurusanActionPerformed

    }//GEN-LAST:event_c_kode_jurusanActionPerformed

    private void c_kode_kelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_kode_kelasActionPerformed

    }//GEN-LAST:event_c_kode_kelasActionPerformed

    private void c_nipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_nipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_nipActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int tabelJadwal = tabel.getSelectedRow();
        textIdJadwal.setText(tabel.getValueAt(tabelJadwal, 0).toString());
        
        c_tgl.setSelectedItem(tabel.getValueAt(tabelJadwal, 1).toString().substring(8, 10));
        c_bln.setSelectedItem(tabel.getValueAt(tabelJadwal, 1).toString().substring(5, 7));
        c_thn.setSelectedItem(tabel.getValueAt(tabelJadwal, 1).toString().substring(0, 4));
        
        textJamMulai.setText(tabel.getValueAt(tabelJadwal, 2).toString());
        textJamAkhir.setText(tabel.getValueAt(tabelJadwal, 3).toString());

        c_kode_jurusan.setSelectedItem(tabel.getValueAt(tabelJadwal, 4).toString());
        c_kode_kelas.setSelectedItem(tabel.getValueAt(tabelJadwal, 5).toString());
        c_nip.setSelectedItem(tabel.getValueAt(tabelJadwal, 6).toString());
        c_kode_mapel.setSelectedItem(tabel.getValueAt(tabelJadwal, 7).toString());
 
    }//GEN-LAST:event_tabelMouseClicked

    private void btn_detailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_detailActionPerformed
        detailJurusan();
        detailKelas();
        detailGuru();
        detailMapel();
        panelDetail.setVisible(true);
    }//GEN-LAST:event_btn_detailActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        String idJadwal = "";
        idJadwal = textIdJadwal.getText();
        
        try {
            Connection konek = new Koneksi().getConnection();
            String sql = "DELETE FROM jadwal_sekolah WHERE id_jadwal = '"+ idJadwal +"' ";
            PreparedStatement pst = (PreparedStatement)konek.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil dihapus", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            tampilData();
            reset();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal dihapus", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        String idJadwal = "", tglMasuk = "", tgl = "", bln = "", thn = "", jamMulai = "", jamAkhir = "", kodeJurusan = "", kodeKelas = "", nip = "", kodeMapel = "";
        
        idJadwal = textIdJadwal.getText();
        
        tgl = c_tgl.getSelectedItem().toString();
        bln = c_bln.getSelectedItem().toString();
        thn = c_thn.getSelectedItem().toString();
        
        tglMasuk = thn + "-" +bln+ "-" + tgl;
        
        jamMulai = textJamMulai.getText();
        jamAkhir = textJamAkhir.getText();
        kodeJurusan = c_kode_jurusan.getSelectedItem().toString();
        kodeKelas = c_kode_kelas.getSelectedItem().toString();
        nip = c_nip.getSelectedItem().toString();
        kodeMapel = c_kode_mapel.getSelectedItem().toString();
        
        try {
            Connection konek = new Koneksi().getConnection();
            String sql = "UPDATE jadwal_sekolah set tanggal = '"+ tglMasuk +"', " + "jam_mulai = '"+ jamMulai +"', " + "jam_Akhir = '"+ jamAkhir +"', " + "kode_jurusan = '"+ kodeJurusan +"', " + "kode_kelas = '"+ kodeKelas +"', " + "nip = '"+ nip +"', " + "kode_mata_pelajaran = '"+ kodeMapel +"' WHERE id_jadwal = '"+ idJadwal +"' "; 
            PreparedStatement pst = (PreparedStatement)konek.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil diedit", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            tampilData();
            reset();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal diedit", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        reset();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void c_kode_mapelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_kode_mapelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_kode_mapelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_detail;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JComboBox<String> c_bln;
    private javax.swing.JComboBox<String> c_kode_jurusan;
    private javax.swing.JComboBox<String> c_kode_kelas;
    private javax.swing.JComboBox<String> c_kode_mapel;
    private javax.swing.JComboBox<String> c_nip;
    private javax.swing.JComboBox<String> c_tgl;
    private javax.swing.JComboBox<String> c_thn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel namaGuru;
    private javax.swing.JLabel namaGuru1;
    private javax.swing.JLabel namaJurusan;
    private javax.swing.JLabel namaJurusan1;
    private javax.swing.JLabel namaKelas;
    private javax.swing.JLabel namaKelas1;
    private javax.swing.JLabel namaMapel;
    private javax.swing.JLabel namaMapel1;
    private javax.swing.JPanel panelDetail;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField textIdJadwal;
    private javax.swing.JTextField textJamAkhir;
    private javax.swing.JTextField textJamMulai;
    // End of variables declaration//GEN-END:variables
}
