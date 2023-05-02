package com.thean.ui;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.thean.qr.Qr;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class QrForm extends javax.swing.JFrame implements Runnable, ThreadFactory {

    private WebcamPanel panel = null;
    private Webcam webcam = null;
    List<String> data = new ArrayList<>();

    private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);

    public QrForm() {
        initComponents();
        //initWebcam();
        setResizable(false);
        hr2.setVisible(false);
        pnCreate.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnNav = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        hr1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        hr2 = new javax.swing.JLabel();
        pnCreate = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCreateData = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        pnRead = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        pnImage = new javax.swing.JPanel();
        switchButton1 = new com.hicode.switchbutton.SwitchButton();
        lblStatus = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtData = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QR Code");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnNav.setBackground(new java.awt.Color(255, 255, 255));
        pnNav.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Đọc mã QR");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        pnNav.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 110, 20));

        hr1.setBackground(new java.awt.Color(0, 153, 0));
        hr1.setOpaque(true);
        pnNav.add(hr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 75, 110, 5));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Tạo mã QR");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        pnNav.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 110, 20));

        hr2.setBackground(new java.awt.Color(0, 153, 0));
        hr2.setOpaque(true);
        pnNav.add(hr2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 75, 110, 5));

        getContentPane().add(pnNav, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 110));

        pnCreate.setBackground(new java.awt.Color(255, 255, 255));
        pnCreate.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCreateData.setColumns(20);
        txtCreateData.setRows(5);
        jScrollPane2.setViewportView(txtCreateData);

        pnCreate.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 970, 310));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 51));
        jLabel5.setText("Nội dung:");
        pnCreate.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jButton2.setText("Lưu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnCreate.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 180, 30));

        getContentPane().add(pnCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1150, 510));

        pnRead.setBackground(new java.awt.Color(255, 255, 255));
        pnRead.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnRead.add(lblImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 470, 300));

        pnImage.setBackground(new java.awt.Color(250, 250, 250));
        pnImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnImage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnRead.add(pnImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 470, 300));

        switchButton1.setBackground(new java.awt.Color(0, 153, 51));
        switchButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                switchButton1MouseReleased(evt);
            }
        });
        pnRead.add(switchButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 46, 23));

        lblStatus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(204, 0, 51));
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblStatus.setText("Webcam đã tắt");
        pnRead.add(lblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 170, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 51));
        jLabel2.setText("Camera:");
        pnRead.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        txtData.setColumns(20);
        txtData.setRows(5);
        jScrollPane1.setViewportView(txtData);

        pnRead.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 500, 300));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 51));
        jLabel3.setText("Nội dung:");
        pnRead.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, -1, -1));

        jButton1.setText("Chọn ảnh từ máy tính");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnRead.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 180, 30));

        getContentPane().add(pnRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1150, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void switchButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_switchButton1MouseReleased
        if (switchButton1.isSelected()) {
            switchButton1.setSelected(true);
            if (webcam != null) {
                webcam.close();
            }
            initWebcam();
            pnImage.setVisible(false);
            pnImage.setVisible(true);
            lblStatus.setText("Webcam đã bật");
            lblStatus.setForeground(new Color(0, 153, 51));
            pnImage.setVisible(false);
            pnImage.setVisible(true);
            lblImage.setVisible(false);
        } else {
            switchButton1.setSelected(false);
            System.out.println("wc dong");
            if (webcam == null) {
                initWebcam();
            }
            webcam.close();
            lblStatus.setText("Webcam đã tắt");
            lblStatus.setForeground(Color.red);
            lblImage.setVisible(true);
        }
    }//GEN-LAST:event_switchButton1MouseReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (webcam != null) {
            if (webcam.isOpen()) {
                webcam.close();
                setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
            }
        }
        this.dispose();

    }//GEN-LAST:event_formWindowClosing

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        hr1.setVisible(false);
        hr2.setVisible(true);
        pnRead.setVisible(false);
        pnCreate.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        hr1.setVisible(true);
        hr2.setVisible(false);
        pnRead.setVisible(true);
        pnCreate.setVisible(false);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Qr qr = new Qr();
        if (webcam == null) {
            initWebcam();
        }
        switchButton1.setSelected(false);
        lblStatus.setText("Webcam đã tắt");
        lblStatus.setForeground(Color.red);
        webcam.close();
        // đọc dữ liệu mã QR
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Hình ảnh", "jpg", "jpeg", "png");
        fc.setFileFilter(filter);
        fc.showOpenDialog(null);
        File f = fc.getSelectedFile();
        if (f == null) {
            return;
        }
        String path = f.getAbsoluteFile().toString();
        System.out.println(path);
        //String a = JOptionPane.showInputDialog(this, "Nhập tên tệp tin", "new_qr");

        //in ảnh lên pn2
        try {
            Image img = ImageIO.read(f);
            lblImage.setText("0000");
            int width = lblImage.getWidth();
            int height = lblImage.getHeight();
            lblImage.setIcon(new ImageIcon(img.getScaledInstance(width, height, 0)));
            pnImage.setVisible(false);

            String contentImg = readQR(f);
            data.add(contentImg);
            System.out.println(contentImg);
            txtData.append(contentImg + "\n");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Đường dẫn ảnh không phù hợp");
        }
        lblImage.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Qr qr = new Qr();
        String data = txtCreateData.getText();
        qr.createQR(data);
    }//GEN-LAST:event_jButton2ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QrForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new QrForm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hr1;
    private javax.swing.JLabel hr2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JPanel pnCreate;
    private javax.swing.JPanel pnImage;
    private javax.swing.JPanel pnNav;
    private javax.swing.JPanel pnRead;
    private com.hicode.switchbutton.SwitchButton switchButton1;
    private javax.swing.JTextArea txtCreateData;
    private javax.swing.JTextArea txtData;
    // End of variables declaration//GEN-END:variables

    private void initWebcam() {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0); //0 is default webcam
        webcam.setViewSize(size);

        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);

        pnImage.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 300));

        executor.execute(this);
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Result result = null;
            BufferedImage image = null;
            if (!webcam.isOpen()) {
                return;
            }
            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }

            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException e) {
                //System.out.println("");
            }

            if (result != null) {
                if (!data.contains(result.getText())) {
                    data.add(result.getText());
                    System.out.println(result.getText());
                    txtData.append(result.getText() + "\n");
                }
            }
        } while (true);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }

    public static String readQR(File f) throws IOException {
        Result result = null;
        BufferedImage image = ImageIO.read(f);

        LuminanceSource source = new BufferedImageLuminanceSource(image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        try {
            result = new MultiFormatReader().decode(bitmap);
        } catch (NotFoundException e) {
            //System.out.println("");
        }

        if (result != null) {
            System.out.println(result.getText());
        }
        return result.getText();
    }
}
