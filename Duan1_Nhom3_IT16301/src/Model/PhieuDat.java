
package Model;

import java.util.Date;

public class PhieuDat {
    private int MaPD;
    private int MaKH;
    private Date dateBook;
    private Date TimeBook;
    private int soBan;
    private int soNguoi;
    private Date DateXacNhan;
    private Date TimeXacNhan;
    private Date DateThanhToan;
    private Date TimeThanToan;
    private String ghiChu;
    private String TrangThai; 

    public int getSoBan() {
        return soBan;
    }

    public void setSoBan(int soBan) {
        this.soBan = soBan;
    }

    public Date getDateXacNhan() {
        return DateXacNhan;
    }

    public void setDateXacNhan(Date DateXacNhan) {
        this.DateXacNhan = DateXacNhan;
    }

    public Date getDateThanhToan() {
        return DateThanhToan;
    }

    public void setDateThanhToan(Date DateThanhToan) {
        this.DateThanhToan = DateThanhToan;
    }

    public Date getTimeThanToan() {
        return TimeThanToan;
    }

    public void setTimeThanToan(Date TimeThanToan) {
        this.TimeThanToan = TimeThanToan;
    }

    public Date getTimeBook() {
        return TimeBook;
    }

    public void setTimeBook(Date TimeBook) {
        this.TimeBook = TimeBook;
    }

    public Date getTimeXacNhan() {
        return TimeXacNhan;
    }

    public void setTimeXacNhan(Date TimeXacNhan) {
        this.TimeXacNhan = TimeXacNhan;
    }

    public int getMaPD() {
        return MaPD;
    }

    public void setMaPD(int MaPD) {
        this.MaPD = MaPD;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public Date getDateBook() {
        return dateBook;
    }

    public void setDateBook(Date dateBook) {
        this.dateBook = dateBook;
    }

    public int getSoNguoi() {
        return soNguoi;
    }

    public void setSoNguoi(int soNguoi) {
        this.soNguoi = soNguoi;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    
}
