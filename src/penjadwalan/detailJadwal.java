/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjadwalan;

/**
 *
 * @author ACER
 */
public class detailJadwal extends javax.swing.JInternalFrame {

    /**
     * Creates new form detailJadwal
     */
    public detailJadwal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kelas = new javax.swing.JLabel();
        jurusan = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        mapel = new javax.swing.JLabel();

        kelas.setText("Kelas");

        jurusan.setText("Jurusan");

        jLabel3.setText("Guru");

        mapel.setText("Mata Pelajaran");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mapel)
                    .addComponent(jLabel3)
                    .addComponent(jurusan)
                    .addComponent(kelas))
                .addContainerGap(430, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jurusan)
                .addGap(31, 31, 31)
                .addComponent(kelas)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(mapel)
                .addContainerGap(238, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jurusan;
    private javax.swing.JLabel kelas;
    private javax.swing.JLabel mapel;
    // End of variables declaration//GEN-END:variables
}
