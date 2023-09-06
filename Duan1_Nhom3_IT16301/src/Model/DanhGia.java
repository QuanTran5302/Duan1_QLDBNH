
package Model;

public class DanhGia {
    private int MaID;
    private int MaKH;
    private int MaPD;
    private int soSao;
    private String nhanXet;
    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
   
    public int getMaPD() {
        return MaPD;
    }

    public void setMaPD(int MaPD) {
        this.MaPD = MaPD;
    }

    public String getNhanXet() {
        return nhanXet;
    }

    public void setNhanXet(String nhanXet) {
        this.nhanXet = nhanXet;
    }

    public int getMaID() {
        return MaID;
    }

    public void setMaID(int MaID) {
        this.MaID = MaID;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public int getSoSao() {
        return soSao;
    }

    public void setSoSao(int soSao) {
        this.soSao = soSao;
    }
    
}
