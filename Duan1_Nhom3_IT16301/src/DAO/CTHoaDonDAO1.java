/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.JdbcHelper;
import Model.BanAn;
import Model.CTHoaDon1;
import Model.HoaDon1;
import Model.LoaiMon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class CTHoaDonDAO1 {

    public static void LoadCTHoaDon(JTable tbl, String tenMon, Double giaTien, String Soluong, String GhiChu, String TrangThai) {
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        Object obj[] = new Object[7];

        obj[0] = model.getRowCount() + 1;
        obj[1] = tenMon;
        obj[2] = giaTien;
        obj[3] = Soluong;
        obj[4] = Double.parseDouble(Soluong) * giaTien;
        obj[5] = GhiChu;
        obj[6] = TrangThai;

        model.addRow(obj);
    }

    public static void LoadMonAn(JTable tbl, String tenMon, Double giaTien, String Soluong) {
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        Object obj[] = new Object[5];

        obj[0] = model.getRowCount() + 1;
        obj[1] = tenMon;
        obj[2] = giaTien;
        obj[3] = Soluong;
        obj[4] = Soluong;

        model.addRow(obj);
    }

    private CTHoaDon1 readFromResultSet(ResultSet rs) throws SQLException {
        CTHoaDon1 model = new CTHoaDon1();
        model.setMaHD(rs.getInt("MaHD"));
        model.setSoLuong(rs.getInt("SoBan"));
        model.setTenMon(rs.getString("TenMon"));
        model.setSoLuong(rs.getInt("SoLuong"));
        model.setGiaTien(rs.getInt("ThanhTien"));
        model.setGhiChu(rs.getString("GhiChu"));
        model.setTrangThaiMon(rs.getString("TrangThaiMon"));
        return model;
    }

    private List<CTHoaDon1> select(String sql, Object... args) {
        List<CTHoaDon1> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    list.add(readFromResultSet(rs));
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
        return list;
    }

    public List<CTHoaDon1> select() {
        String sql = "SELECT * FROM CTHoaDon";
        return select(sql);
    }

    public List<CTHoaDon1> getAll(int ID) {
        List<CTHoaDon1> list = new ArrayList<>();
        String sql = "Select *from CTHoaDon where MaHD =?";
        list = select(sql, ID);
        return list;
    }
    public List<CTHoaDon1> getHoaDon(int ID) {
        List<CTHoaDon1> list = new ArrayList<>();
        String sql = "Select *from CTHoaDon where MaHD =? and TrangThaiMon=N'Đã Lên'";
        list = select(sql, ID);
        return list;
    }
    public void insert(CTHoaDon1 entity) {
        String sql = "INSERT INTO CTHoaDon ( MaHD , SoBan, TenMon ,SoLuong, ThanhTien,GhiChu,TrangThaiMon) VALUES ( ?, ?,?,?, ?,?,?)";
        JdbcHelper.executeUpdate(sql,
                entity.getMaHD(),
                entity.getSoBan(),
                entity.getTenMon(),
                entity.getSoLuong(),
                entity.getGiaTien(),
                entity.getGhiChu(),
                entity.getTrangThaiMon());
    }
    public void update(CTHoaDon1 entity) {
        String sql = "UPDATE CTHoaDon SET TrangThaiMon=?, SoLuong=?, GhiChu=? WHERE TenMon=? and MaHD=? and TrangThaiMon=N'Chưa Lên'";
        JdbcHelper.executeUpdate(sql,
                entity.getTrangThaiMon(),
                entity.getSoLuong(),
                entity.getGhiChu(),
                entity.getTenMon(),
                entity.getMaHD());
    }
    public void SuaMeNu(CTHoaDon1 entity) {
        String sql = "UPDATE CTHoaDon SET SoLuong=?, GhiChu=? WHERE TenMon=? and MaHD=? and TrangThaiMon=N'Chưa Lên'";
        JdbcHelper.executeUpdate(sql,
                entity.getSoLuong(),
                entity.getGhiChu(),
                entity.getTenMon(),
                entity.getMaHD());
    }

}
