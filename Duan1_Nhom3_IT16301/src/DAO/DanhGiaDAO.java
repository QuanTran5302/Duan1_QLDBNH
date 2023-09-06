
package DAO;

import Helper.JdbcHelper;
import Model.DanhGia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DanhGiaDAO {
    private DanhGia readFromResultSet(ResultSet rs) throws SQLException {
        DanhGia model = new DanhGia();
        model.setMaKH(rs.getInt("MaKH"));
        model.setMaPD(rs.getInt("MaPD"));
        model.setSoSao(rs.getInt("SoSao"));
        model.setNhanXet(rs.getString("NhanXet"));
        model.setUser(rs.getString("Username"));
        return model;
    }

    private List<DanhGia> select(String sql, Object... args) {
        List<DanhGia> list = new ArrayList<>();
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

    public List<DanhGia> select() {
        String sql = "select * from DanhGia join ThongTinKH on DanhGia.MaKH = ThongTinKH.MaKH";
        return select(sql);
    }
    public List<DanhGia> select(int sosao) {
        String sql = "select * from DanhGia join ThongTinKH on DanhGia.MaKH = ThongTinKH.MaKH where SoSao = ?";
        return select(sql, sosao);
    }
    public List<DanhGia> select1() {
        String sql = "select * from DanhGia join ThongTinKH on DanhGia.MaKH = ThongTinKH.MaKH where NhanXet is not null";
        return select(sql);
    }
    
    public void insert(DanhGia entity) {
        String sql = "INSERT INTO DanhGia (MaKH, MaPD, SoSao,NhanXet) VALUES ( ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getMaKH(),
                entity.getMaPD(),
                entity.getSoSao(),
                entity.getNhanXet());
    }
}
