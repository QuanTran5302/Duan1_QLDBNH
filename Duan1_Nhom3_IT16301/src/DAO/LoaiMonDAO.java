/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Helper.JdbcHelper;
import Model.KhachHang;
import Model.LoaiMon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class LoaiMonDAO {
    private LoaiMon readFromResultSet(ResultSet rs) throws SQLException {
        LoaiMon model = new LoaiMon();
        model.setMaLoaiMon(rs.getString("MaLoaiMon"));
        model.setTenLoaiMon(rs.getString("TenLoaiMon"));

        return model;
    }
    public void insert(LoaiMon entity) {
        String sql = "INSERT INTO LoaiMon  (MaLoaiMon,TenLoaiMon) VALUES (?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getMaLoaiMon(),
                entity.getTenLoaiMon());

    }

    public void update(LoaiMon entity) {
        String sql = "UPDATE LoaiMon SET TenLoaiMon=? WHERE MaLoaiMon=?";
        JdbcHelper.executeUpdate(sql,
                entity.getTenLoaiMon(),
                entity.getMaLoaiMon()
                );

    }
     public void delete(String id) {
        String sql = "DELETE FROM LoaiMon WHERE MaLoaiMon=?";
        JdbcHelper.executeUpdate(sql, id);
    }
     public LoaiMon findbyID(String id) {
        String sql = "SELECT * FROM LoaiMon WHERE MaLoaiMon=?";
        List<LoaiMon> list = select(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }
    private List<LoaiMon> select(String sql, Object... args) {
        List<LoaiMon> list = new ArrayList<>();
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
    public List<LoaiMon> select() {
        String sql = "SELECT * FROM LoaiMon";
        return select(sql);
    }
}
