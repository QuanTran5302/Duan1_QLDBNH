/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.JdbcHelper;
import Model.HoaDon;
import Model.HoaDon1;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class HoaDonDAO1 {

    private HoaDon1 readFromResultSet(ResultSet rs) throws SQLException {
        HoaDon1 model = new HoaDon1();
        model.setMaHD(rs.getInt("MaHD"));
        model.setMaPD(rs.getInt("MaPD"));
        model.setSoBan(rs.getInt("SoBan"));
        model.setNgayAn(rs.getDate("NgayAn"));
        model.setNguoiTao(rs.getString("NguoiTao"));
        model.setTongTien(rs.getDouble("TongTien"));
        return model;
    }

    private List<HoaDon1> select(String sql, Object... args) {
        List<HoaDon1> list = new ArrayList<>();
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

    public void insert(HoaDon1 entity) {
        String sql = "INSERT INTO HoaDon ( MaPD, SoBan,NgayAn, NguoiTao,TongTien) VALUES (  ?, ?,?,?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getMaPD(),
                entity.getSoBan(),
                entity.getNgayAn(),
               
                entity.getNguoiTao(),
                entity.getTongTien());
    }

    public List<HoaDon1> select(String trangthai) {
        String sql = "select * from HoaDon join PhieuDat on HoaDon.MaPD = PhieuDat.MaPD where TrangThai = ?";
        return select(sql, trangthai);
    }
    public HoaDon1 findById(int id) {
        String sql = "SELECT * FROM HoaDon WHERE MaHD=?";
        List<HoaDon1> list = select(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }
        public void delete(int id) {
        String sql = "DELETE FROM HoaDon WHERE MaHD=?";
        JdbcHelper.executeUpdate(sql, id);
    }
          public void update(HoaDon1 entity) {
        String sql = "UPDATE HoaDon SET TongTien= ? WHERE MaHD=?";
        JdbcHelper.executeUpdate(sql,
                entity.getTongTien(),
                entity.getMaHD()
                );

    }
}
