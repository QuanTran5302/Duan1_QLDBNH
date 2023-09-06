package View;

import DAO.KhachHangDAO;
import DAO.TaiKhoanKHDAO;
import Helper.DateHelper;
import Helper.DialogHelper;
import Helper.utilityHelper;
import Model.KhachHang;
import Model.TaiKhoanKH;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import static java.awt.Color.pink;
import static java.awt.Color.white;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Date;
import javax.swing.JTextField;

public class DangKy extends javax.swing.JFrame {

    public DangKy() {
        initComponents();
        init();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupGT = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtHoTen = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        txtSDT = new javax.swing.JTextField();
        btnDangKy = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        checkHienMK = new javax.swing.JCheckBox();
        txtMatKhau = new javax.swing.JPasswordField();
        lblDangNhap = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(220, 204, 255));

        lblTitle.setFont(new java.awt.Font("Georgia", 1, 26)); // NOI18N
        lblTitle.setText("Đăng ký");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("_____");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(lblTitle)
                .addGap(1, 1, 1)
                .addComponent(jLabel2)
                .addContainerGap(217, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtHoTen.setForeground(new java.awt.Color(153, 153, 153));
        txtHoTen.setText("Họ tên");
        txtHoTen.setName("Họ tên"); // NOI18N
        txtHoTen.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHoTenFocusGained(evt);
            }
        });
        txtHoTen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtHoTenMouseClicked(evt);
            }
        });

        btnGroupGT.add(rdoNam);
        rdoNam.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");

        btnGroupGT.add(rdoNu);
        rdoNu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdoNu.setText("Nữ");

        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSDT.setForeground(new java.awt.Color(153, 153, 153));
        txtSDT.setText("Số điện thoại");
        txtSDT.setName("Số điện thoại"); // NOI18N
        txtSDT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSDTFocusGained(evt);
            }
        });
        txtSDT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSDTMouseClicked(evt);
            }
        });

        btnDangKy.setBackground(new java.awt.Color(255, 255, 255));
        btnDangKy.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDangKy.setForeground(new java.awt.Color(150, 150, 255));
        btnDangKy.setText("Đăng ký");
        btnDangKy.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnDangKyFocusGained(evt);
            }
        });
        btnDangKy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDangKyMouseClicked(evt);
            }
        });
        btnDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKyActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Trở về form");

        checkHienMK.setText("Hiện mật khẩu");
        checkHienMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkHienMKActionPerformed(evt);
            }
        });

        txtMatKhau.setForeground(new java.awt.Color(153, 153, 153));
        txtMatKhau.setText("Mật khẩu");
        txtMatKhau.setName("Mật khẩu"); // NOI18N
        txtMatKhau.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMatKhauFocusGained(evt);
            }
        });
        txtMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMatKhauMouseClicked(evt);
            }
        });

        lblDangNhap.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDangNhap.setText("Đăng Nhập");
        lblDangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDangNhapMouseClicked(evt);
            }
        });

        txtUserName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtUserName.setForeground(new java.awt.Color(153, 153, 153));
        txtUserName.setText("Tên đăng nhập");
        txtUserName.setName("UserName"); // NOI18N
        txtUserName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserNameFocusGained(evt);
            }
        });
        txtUserName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUserNameMouseClicked(evt);
            }
        });

        txtNgaySinh.setDateFormatString("dd/MM/yyyy");
        txtNgaySinh.setName("Ngày sinh"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdoNam)
                        .addGap(18, 18, 18)
                        .addComponent(rdoNu))
                    .addComponent(txtSDT)
                    .addComponent(txtMatKhau)
                    .addComponent(txtHoTen)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnDangKy, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(checkHienMK, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                    .addComponent(txtUserName)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdoNu)
                    .addComponent(rdoNam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkHienMK)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void txtHoTenFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoTenFocusGained
        txtHoTen.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                
            }

            @Override
            public void focusLost(FocusEvent e) {
                txtHoTen.setBackground(new java.awt.Color(255,255,255));
                if (txtHoTen.getText().equals("")) {
                    txtHoTen.setText("Họ tên");
                    txtHoTen.setForeground(Color.GRAY);
                }
            }
        });
    }//GEN-LAST:event_txtHoTenFocusGained

    private void txtSDTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSDTFocusGained
        txtSDT.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                txtSDT.setBackground(new java.awt.Color(255,255,255));
                if (txtSDT.getText().equals("")) {
                    txtSDT.setText("Số điện thoại");
                    txtSDT.setForeground(Color.GRAY);
                }
            }
        });
    }//GEN-LAST:event_txtSDTFocusGained

    private void txtMatKhauFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMatKhauFocusGained
        txtMatKhau.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                txtMatKhau.setBackground(new java.awt.Color(255,255,255));
                if (txtMatKhau.getText().equals("")) {
                    txtMatKhau.setText("Mật khẩu");
                    txtMatKhau.setEchoChar((char) 0);
                    txtMatKhau.setForeground(Color.GRAY);
                }
            }
        });
    }//GEN-LAST:event_txtMatKhauFocusGained

    private void checkHienMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkHienMKActionPerformed
        if (checkHienMK.isSelected()) {
            txtMatKhau.setEchoChar((char) 0);
        } else {
            if (txtMatKhau.getText().equals("Mật khẩu")) {
                txtMatKhau.setEchoChar((char) 0);
            } else {
                txtMatKhau.setEchoChar('*');
            }
        }
    }//GEN-LAST:event_checkHienMKActionPerformed

    private void txtHoTenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHoTenMouseClicked
        txtHoTen.setBackground(new java.awt.Color(220,204,255));
        if (txtHoTen.getText().equals("Họ tên")) {
            txtHoTen.setText("");
            txtHoTen.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtHoTenMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        txtMatKhau.setEchoChar((char) 0);
    }//GEN-LAST:event_formWindowOpened

    private void txtSDTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSDTMouseClicked
        txtSDT.setBackground(new java.awt.Color(220,204,255));
        if (txtSDT.getText().equals("Số điện thoại")) {
            txtSDT.setText("");
            txtSDT.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtSDTMouseClicked

    private void txtMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMatKhauMouseClicked
        txtMatKhau.setBackground(new java.awt.Color(220,204,255));
        if (txtMatKhau.getText().equals("Mật khẩu")) {
            txtMatKhau.setEchoChar('*');
            if (checkHienMK.isSelected()) {
                txtMatKhau.setEchoChar((char) 0);
            } else {
                txtMatKhau.setEchoChar('*');
            }
            txtMatKhau.setText("");
            txtMatKhau.setForeground(Color.BLACK);
        } else {
            if (checkHienMK.isSelected()) {
                txtMatKhau.setEchoChar((char) 0);
            } else {
                txtMatKhau.setEchoChar('*');
            }
        }
    }//GEN-LAST:event_txtMatKhauMouseClicked

    private void btnDangKyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnDangKyFocusGained
        btnDangKy.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                
            }

            @Override
            public void focusLost(FocusEvent e) {
                btnDangKy.setBackground(new java.awt.Color(255,255,255));
                btnDangKy.setForeground(new java.awt.Color(150,150,255));

            }
        });
    }//GEN-LAST:event_btnDangKyFocusGained

    private void btnDangKyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDangKyMouseClicked
        btnDangKy.setBackground(new java.awt.Color(150,150,255));
        btnDangKy.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnDangKyMouseClicked

    private void lblDangNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangNhapMouseClicked
        lblDangNhap.setForeground(new java.awt.Color(150,150,255));
        new Login_KH().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblDangNhapMouseClicked

    private void txtUserNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserNameFocusGained
        txtUserName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                txtUserName.setBackground(new java.awt.Color(255,255,255));
                if (txtUserName.getText().equals("")) {
                    txtUserName.setText("Tên đăng nhập");
                    txtUserName.setForeground(Color.GRAY);
                }
            }
        });
    }//GEN-LAST:event_txtUserNameFocusGained

    private void txtUserNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserNameMouseClicked
        txtUserName.setBackground(new java.awt.Color(220,204,255));
        if (txtUserName.getText().equals("Tên đăng nhập")) {
            txtUserName.setText("");
            txtUserName.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtUserNameMouseClicked

    private void btnDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKyActionPerformed
        if (utilityHelper.checkNullTextDK(txtHoTen)
                && utilityHelper.checkNullText(txtNgaySinh)
                && utilityHelper.checkNullTextDK(txtSDT)
                && utilityHelper.checkNullTextDK(txtUserName)
                && utilityHelper.checkNullTextDK(txtMatKhau)) {
            if (utilityHelper.checkName(txtHoTen)
                    && checkTuoi(txtNgaySinh)
                    && utilityHelper.checkSDT(txtSDT)
                    && utilityHelper.checkUser(txtUserName)) {
                if(checkTrungMa(txtUserName)){
                    dangky();
                }
            }
        }
        
    }//GEN-LAST:event_btnDangKyActionPerformed
    public boolean checkTuoi(JDateChooser txt) {
        txt.setBackground(white);
        //SimpleDateFormat fm = new SimpleDateFormat("HH:mm");
        //SimpleDateFormat date_fm = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date = new java.util.Date();
        Date dateChooser = txt.getDate();
        long diff = date.getTime() - dateChooser.getTime();
//        long diffSeconds = diff / 1000 % 60;
//        long diffMinutes = diff / (60 * 1000) % 60;
//        long diffHours = diff / (60 * 60 * 1000) % 24;
        long diffDays = diff / (24 * 60 * 60 * 1000);
        long diffYears = diffDays / 365;

        if (diffYears > 16) {
            return true;
        } else {
            txt.setBackground(pink);
            DialogHelper.alert(this, "Tuổi phải lớn hơn 16");
            return false;
        }
    }

    public boolean checkTrungMa(JTextField txt) {
        txt.setBackground(white);
        if (dao.findById(txt.getText()) == null) {
            return true;
        } else {
            txt.setBackground(pink);
            DialogHelper.alert(this, txt.getName() + " đã bị tồn tại.");
            return false;
        }
    }
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
            java.util.logging.Logger.getLogger(DangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangKy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangKy;
    private javax.swing.ButtonGroup btnGroupGT;
    private javax.swing.JCheckBox checkHienMK;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblDangNhap;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JPasswordField txtMatKhau;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
    TaiKhoanKHDAO tkdao = new TaiKhoanKHDAO();
    KhachHangDAO dao = new KhachHangDAO();
    
    public void init() {
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(220,204,255));
    }
    void dangky(){
        TaiKhoanKH model = getModel();
        KhachHang modelKH = getModelKH();
        try {
            tkdao.insert(model);
            dao.insert(modelKH);
            DialogHelper.alert(this, "Đăng ký thành công!");
        } catch (Exception e) {
            DialogHelper.alert(this, "Đăng ký thất bại!");
            e.printStackTrace();
        }
    }
    TaiKhoanKH getModel(){
        TaiKhoanKH model = new TaiKhoanKH();
        model.setUsername(txtUserName.getText());
        model.setPass(new String(txtMatKhau.getPassword()));
        return model;        
    }
    
    KhachHang getModelKH(){
        KhachHang model = new KhachHang();        
        model.setHoTen(txtHoTen.getText());
        if (rdoNam.isSelected()) {
            model.setGioiTinh(true);
        } else {
            model.setGioiTinh(false);
        }
        model.setNgaySinh(txtNgaySinh.getDate());
        model.setSdt(txtSDT.getText());
        model.setUsername(txtUserName.getText());
        return model;
    }
    
}
