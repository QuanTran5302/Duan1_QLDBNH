/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.JdbcHelper;
import Model.KhachHang;
import Model.MonAn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class MonAnDAO {
    private MonAn readFromResultSet(ResultSet rs) throws SQLException {
        MonAn model = new MonAn();
        model.setMaMon(rs.getString("MaMon"));
        model.setMaLoaiMon(rs.getString("MaLoaiMon"));
        model.setTenMon(rs.getString("TenMon"));
        model.setGiaTien(rs.getDouble("GiaTien"));
        model.setHinhAnh(rs.getString("Anh"));
        model.setGioiThieu(rs.getString("GioiThieu"));

        return model;
    }

    private List<MonAn> select(String sql, Object... args) {
        List<MonAn> list = new ArrayList<>();
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

    
    public void insert(MonAn entity) {
        String sql = "INSERT INTO MonAn  (MaMon,MaLoaiMon,TenMon,GiaTien,Anh,GioiThieu) VALUES (?, ?, ?, ?,?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getMaMon(),
                entity.getMaLoaiMon(),
                entity.getTenMon(),
                entity.getGiaTien(),
                entity.getHinhAnh(),
                entity.getGioiThieu());

    }
    public void update(MonAn entity) {
        String sql = "UPDATE MonAn SET MaLoaiMon=?, TenMon=?, GiaTien=?, Anh=?, GioiThieu=? WHERE MaMon=?";
        JdbcHelper.executeUpdate(sql,
                entity.getMaLoaiMon(),
                entity.getTenMon(),
                entity.getGiaTien(),
                entity.getHinhAnh(),
                entity.getGioiThieu(),
                entity.getMaMon());

    }
    public void delete(String id) {
        String sql = "DELETE FROM MonAn WHERE MaMon=?";
        JdbcHelper.executeUpdate(sql, id);
    }
    public List<MonAn> select() {
        String sql = "SELECT * FROM MonAn";
        return select(sql);
    }

    public MonAn findbyID(String id) {
        String sql = "SELECT * FROM MonAn WHERE MaMon=?";
        List<MonAn> list = select(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }


    public List<MonAn> getAll(String MaLoaiMon) {
        List<MonAn> list = new ArrayList<>();
        String sql = "Select *from MonAn where MaLoaiMon =?";
        list = select(sql, MaLoaiMon);
        return list;
    }

}
