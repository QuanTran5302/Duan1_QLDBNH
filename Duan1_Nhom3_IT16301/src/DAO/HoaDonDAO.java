/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.JdbcHelper;
import Model.HoaDon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class HoaDonDAO {

    private HoaDon readFromResultSet(ResultSet rs) throws SQLException {
        HoaDon model = new HoaDon();
        model.setMaHD(rs.getInt("MaHD"));
        model.setMaPD(rs.getInt("MaPD"));
        model.setSoBan(rs.getInt("SoBan"));
        model.setNgayAn(rs.getDate("NgayAn"));
        model.setGhiChu(rs.getString("GhiChu"));
        model.setNguoiTao(rs.getString("NguoiTao"));
        return model;
    }

    private List<HoaDon> select(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
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

    public void insert(HoaDon entity) {
        String sql = "INSERT INTO HoaDon ( MaPD, SoBan,NgayAn,GhiChu, NguoiTao) VALUES ( ?, ?, ?,?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getMaPD(),
                entity.getSoBan(),
                entity.getNgayAn(),
                entity.getGhiChu(),
                entity.getNguoiTao());
    }

    public List<HoaDon> select() {
        String sql = "select *\n"
                + "from HoaDon inner join PhieuDat on HoaDon.MaPD=PhieuDat.MaPD\n"
                + "where TrangThai= N'Đã Xác Nhận'";
        return select(sql);
    }
    public HoaDon findById(int id) {
        String sql = "SELECT * FROM HoaDon WHERE MaHD=?";
        List<HoaDon> list = select(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }
        public void delete(int id) {
        String sql = "DELETE FROM HoaDon WHERE MaHD=?";
        JdbcHelper.executeUpdate(sql, id);
    }
}
