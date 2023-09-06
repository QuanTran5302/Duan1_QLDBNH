
package Model;

import java.util.Date;

public class HoaDon {
    private int MaHD;
    private int MaPD;
    private int SoBan;
    private Date ngayAn;
    private String ghiChu;
    private String nguoiTao;

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

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }
    
    
}
