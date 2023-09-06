/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.CTHoaDonDAO1;
import DAO.HoaDonDAO1;
import DAO.PhieuDatDAO;
import Helper.DateHelper;
import Helper.DialogHelper;
import Helper.JdbcHelper;
import Model.CTHoaDon1;
import Model.HoaDon1;
import Model.PhieuDat;
import com.itextpdf.text.Anchor;
import java.awt.Color;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;


/**
 *
 * @author ADMIN
 */
public class HoaDonThanhToan extends javax.swing.JFrame {

    /**
     * Creates new form GoiMon
     */
    PhieuDatDAO PDDao = new PhieuDatDAO();
    CTHoaDonDAO1 CTHDDao = new CTHoaDonDAO1();
    HoaDonDAO1 HDDao = new HoaDonDAO1();
    private List<CTHoaDon1> lst;
    private DefaultTableModel model;
    SimpleDateFormat fm = new SimpleDateFormat("HH:mm");
    SimpleDateFormat date_fm = new SimpleDateFormat("dd/MM/yyyy");
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
    Font.BOLD);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 13);

    public HoaDonThanhToan() {
        initComponents();
        this.model = (DefaultTableModel) tbl_Mon.getModel();
        LoadTableMeNu(MaHD);
        TongTien();
        LoadText();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white);
    }
    Integer MaHD ;

    HoaDonThanhToan(Integer ID) {
        initComponents();
        MaHD = ID;
        this.model = (DefaultTableModel) tbl_Mon.getModel();
        LoadTableMeNu(MaHD);
        TongTien();
        LoadText();
    }

    private void LoadTableMeNu(int MaHD) {
        model.setRowCount(0);
        lst = CTHDDao.getHoaDon(MaHD);
        for (int i = 0; i < lst.size(); i++) {
            CTHoaDon1 s = lst.get(i);
            Object obj[] = new Object[7];
            obj[0] = model.getRowCount() + 1;
            obj[1] = s.getTenMon();
            obj[3] = s.getGiaTien();
            obj[2] = s.getSoLuong();
            obj[4] = Double.parseDouble(s.getSoLuong() + "") * s.getGiaTien();
            model.addRow(obj);

        }
    }

    private void TongTien() {
        double tien = 0;
        for (int i = 0; i < tbl_Mon.getRowCount(); i++) {
            tien += Double.parseDouble(tbl_Mon.getValueAt(i, 4).toString());
            lb_TongTien.setText(String.valueOf(tien));
        }
    }

    private void LoadText() {
        try {
            String sql = "select *\n"
                    + "from ((HoaDon inner join PhieuDat on PhieuDat.MaPD = HoaDon.MaPD)\n"
                    + "inner join ThongTinKH on ThongTinKH.MaKH= PhieuDat.MaKH)\n"
                    + "where MaHD=?";
            ResultSet rs = JdbcHelper.executeQuery(sql, MaHD);
            while (rs.next()) {
                lb_HoTen.setText(rs.getString("HoTen"));
                lb_SDT.setText(rs.getString("SDT"));
                lb_SoNguoi.setText(rs.getString("SoNguoi"));
                lb_NhanVien.setText(rs.getString("NguoiTao"));
                lb_NgayThang.setText(date_fm.format(rs.getDate("DateBook")));
                lb_MaHD.setText(String.valueOf(MaHD));
                lb_MaPD.setText(String.valueOf(rs.getInt("MaPD")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void UpdatePD() {
        PhieuDat model= getModel1();
        try {
            PDDao.updateTT(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    PhieuDat getModel1() {
        java.util.Date date = new java.util.Date();
        String timeXN = fm.format(date);
        String dateXN = date_fm.format(date);
        PhieuDat model = new PhieuDat();
        model.setDateThanhToan(DateHelper.toDate(dateXN));
        model.setTimeThanToan(DateHelper.toTime(timeXN));
        model.setTrangThai("Đã thanh toán");
        model.setTrangThai("Đã thanh toán");
        model.setMaPD(Integer.parseInt(lb_MaPD.getText()));
        return model;
    }

    HoaDon1 getModel() {
        HoaDon1 model = new HoaDon1();
        double TongTien = Double.parseDouble(lb_TongTien.getText());
        model.setTongTien(TongTien);
        model.setMaHD(MaHD);
        return model;
    }

    void UpdateTien() {
        HoaDon1 model = getModel();
        try {
            HDDao.update(model);
            DialogHelper.alert(this, "Thanh Toán Thành Công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Mon = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lb_SDT = new javax.swing.JLabel();
        lb_SoNguoi = new javax.swing.JLabel();
        lb_NhanVien = new javax.swing.JLabel();
        lb_NgayThang = new javax.swing.JLabel();
        lb_MaHD = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lb_MaPD = new javax.swing.JLabel();
        lb_HoTen = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lb_TongTien = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btn_ThanhToan = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Hóa Đơn Thanh Toán");

        tbl_Mon.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        tbl_Mon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên Món", "Số Lượng", "Đơn Giá", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Mon.setRowHeight(30);
        jScrollPane1.setViewportView(tbl_Mon);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel2.setText("Họ Tên   :");

        jLabel3.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel3.setText("SĐT      :");

        jLabel4.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Nhân Viên:");

        jLabel5.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Số Khách :");

        jLabel6.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel6.setText("Mã Hóa Đơn  :");

        jLabel7.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel7.setText("Ngày Tháng  :");

        lb_SDT.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N

        lb_SoNguoi.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N

        lb_NhanVien.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N

        lb_NgayThang.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N

        lb_MaHD.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel8.setText("Mã Phiếu Đặt:");

        lb_MaPD.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N

        lb_HoTen.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_SoNguoi, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(176, 176, 176)
                        .addComponent(lb_MaPD, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_SDT, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                            .addComponent(lb_HoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lb_MaHD, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                    .addComponent(lb_NgayThang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel8))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_NgayThang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lb_MaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lb_HoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_MaPD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_SoNguoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jLabel9.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Tổng Tiền:");

        lb_TongTien.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        lb_TongTien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btn_ThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        btn_ThanhToan.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        btn_ThanhToan.setText("Thanh Toán");
        btn_ThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThanhToanActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Home.png"))); // NOI18N
        jButton5.setText("Home");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(1, 1, 1)
                        .addComponent(lb_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_ThanhToan)))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(lb_TongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThanhToanActionPerformed
        UpdatePD();
        UpdateTien();
        Loadpdf();
    }//GEN-LAST:event_btn_ThanhToanActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white);
    }//GEN-LAST:event_formWindowOpened

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new HomeNhaHang().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(HoaDonThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDonThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDonThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDonThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDonThanhToan().setVisible(true);
            }
        });
    }
 void Loadpdf() {
        try {
            String file_name = "C:\\Users\\Hi\\Desktop\\FPT Polytechnic\\Dự án 1\\testa.pdf";
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(file_name));
            document.open();
            Anchor anchor = new Anchor("                                                     Hoa Don Thanh Toan", catFont);
            anchor.setName("Hoa Don Thanh Toan");

        // Second parameter is the number of the chapter
            Paragraph para = new Paragraph(anchor);
            Paragraph paraa1 = new Paragraph("  ");
            Paragraph paraa2 = new Paragraph("  ");
            Paragraph para1 = new Paragraph("                Ho Ten: " + lb_HoTen.getText(), subFont);
            Paragraph para2 = new Paragraph("                So Dien Thoai: " + lb_SDT.getText(),subFont);
            Paragraph para3 = new Paragraph("                So Nguoi: " + lb_SoNguoi.getText(),subFont);
            Paragraph para4 = new Paragraph("                Ngay An : " + lb_NgayThang.getText(),subFont);
            Paragraph para5 = new Paragraph("                Ma Hoa Don: " + lb_MaHD.getText(),subFont);
            Paragraph para6 = new Paragraph("                Ma Phieu Dat: " + lb_MaPD.getText(),subFont);
            Paragraph para7 = new Paragraph("");
            Paragraph para8 = new Paragraph("             ");
            document.add(para);
            document.add(para1);
            document.add(para2);
            document.add(para3);
            document.add(para4);
            document.add(para5);
            document.add(para6);
            document.add(para7);
            document.add(para8);

            PdfPTable table = new PdfPTable(4);
            PdfPCell c1 = new PdfPCell(new Phrase("Ten Mon"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);
            c1 = new PdfPCell(new Phrase("So Luong"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);
            c1 = new PdfPCell(new Phrase("Don Gia"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);
            c1 = new PdfPCell(new Phrase("Thanh Tien"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);           
            table.addCell(c1);
            table.setHeaderRows(1);

            for (int i = 0; i < lst.size(); i++) {
                CTHoaDon1 s = lst.get(i);

                table.addCell(s.getTenMon());
                table.addCell(String.valueOf(s.getSoLuong()));
                table.addCell(String.valueOf(s.getGiaTien()));
                Double a = s.getSoLuong() * s.getGiaTien();
                table.addCell(String.valueOf(a));
            }

            document.add(table);
            Paragraph para9 = new Paragraph("                                                                                             Tong Tien :" + lb_TongTien.getText() + " VND");
            document.add(para9);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ThanhToan;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lb_HoTen;
    private javax.swing.JLabel lb_MaHD;
    private javax.swing.JLabel lb_MaPD;
    private javax.swing.JLabel lb_NgayThang;
    private javax.swing.JLabel lb_NhanVien;
    private javax.swing.JLabel lb_SDT;
    private javax.swing.JLabel lb_SoNguoi;
    private javax.swing.JLabel lb_TongTien;
    private javax.swing.JTable tbl_Mon;
    // End of variables declaration//GEN-END:variables
}
