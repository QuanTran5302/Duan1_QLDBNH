/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author DELL 7480
 */
public class ManHinhChao extends javax.swing.JFrame {

    /**
     * Creates new form ManHinhChao
     */
    public ManHinhChao() {
        initComponents();
        intit();
    }
   String check="";
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
     void intit(){
         this.getContentPane().setBackground(new java.awt.Color(205,133,63));
        ImageIcon banner = new ImageIcon("src/Logo/banner.jpg");
        Image im = banner.getImage();
        ImageIcon icon = new ImageIcon(im.getScaledInstance(lblbanner.getWidth(), lblbanner.getHeight(), im.SCALE_SMOOTH));
        lblbanner.setIcon(icon);
        new Timer(50, new ActionListener() {
            @Override
             public void actionPerformed(ActionEvent e) {
              
                setLocationRelativeTo(null); 
                int value = jProgressBar1.getValue();
                int a=0;
               
                if (value < 100) {
                    jProgressBar1.setValue(value + 1);
                    a=value+1;
                    lbln.setText(a+"%");
                    
                    
                     

                    if(value<30){
                        lblload.setText("Xin chào đến với hệ thống");
                    }else{
                        lblload.setText("Đặt bàn online");
                    }if(value>60){
                        lblload.setText("Đặt bàn online");
                    }
                    if(value>80){
                        lblload.setText("Sẵn sàng để bắt đầu! wellcom");
                     
                    }
                }else{
                    check+="Stop";     
                    ManHinhChao.this.dispose();
                    checkwwin();                                      
                    }
                
            }
        }).start();
       checkwwin();
       
    
    }
    void checkwwin(){
          if(check.equals("Stop")){
              new Login_KH().setVisible(true);
        }
     }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblbanner = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        lblload = new javax.swing.JLabel();
        lbln = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblload.setBackground(new java.awt.Color(105, 102, 51));
        lblload.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblload.setForeground(new java.awt.Color(0, 102, 255));
        lblload.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblload.setText("Loading");
        lblload.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbln.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbln.setForeground(new java.awt.Color(0, 102, 255));
        lbln.setText("0%");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblload, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbln, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblbanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblbanner, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblload, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(lbln, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ManHinhChao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManHinhChao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManHinhChao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManHinhChao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManHinhChao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lblbanner;
    private javax.swing.JLabel lblload;
    private javax.swing.JLabel lbln;
    // End of variables declaration//GEN-END:variables
}