
package Model;

import java.util.Date;

public class HoaDon1 {
    private int MaHD;
    private int MaPD;
    private int SoBan;
    private Date ngayAn;
    private String nguoiTao;
    private double  TongTien;

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public int getMaPD() {
        return MaPD;
    }

    public void setMaPD(int MaPD) {
        this.MaPD = MaPD;
    }

    public int getSoBan() {
        return SoBan;
    }

    public void setSoBan(int SoBan) {
        this.SoBan = SoBan;
    }

    public Date getNgayAn() {
        return ngayAn;
    }

    public void setNgayAn(Date ngayAn) {
        this.ngayAn = ngayAn;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }
    
    
}
