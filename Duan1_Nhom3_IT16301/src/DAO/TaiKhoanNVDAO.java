
package DAO;

import Helper.JdbcHelper;
import Model.TaiKhoanNV;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanNVDAO {
    private TaiKhoanNV readFromResultSet(ResultSet rs) throws SQLException {
        TaiKhoanNV model = new TaiKhoanNV();
        model.setUsername(rs.getString("Username"));
        model.setPass(rs.getString("Pass"));
        model.setVaiTro(rs.getBoolean("Vaitro"));
        return model;
    }

    private List<TaiKhoanNV> select(String sql, Object... args) {
        List<TaiKhoanNV> list = new ArrayList<>();
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

    /**
     * Thêm mới thực thể vào CSDL
     *
     * @param entity là thực thể chứa thông tin bản ghi mới
     */
    public void insert(TaiKhoanNV entity) {
        String sql = "INSERT INTO TaiKhoanNV (Username, Pass, Vaitro) VALUES (?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getUsername(),
                entity.getPass(),
                entity.isVaiTro());
    }

    /**
     * Cập nhật thực thể vào CSDL
     *
     * @param entity là thực thể chứa thông tin bản ghi cần cập nhật
     */
    public void update(TaiKhoanNV entity) {
        String sql = "UPDATE TaiKhoanNV SET Pass=?, Vaitro=? WHERE Username=?";
        JdbcHelper.executeUpdate(sql,
                entity.getPass(),
                entity.isVaiTro(),
                entity.getUsername());
    }

    /**
     * Xóa bản ghi khỏi CSDL
     *
     * @param id là mã của bản ghi cần xóa
     */
    public void delete(String id) {
        String sql = "DELETE FROM TaiKhoanNV WHERE Username=?";
        JdbcHelper.executeUpdate(sql, id);
    }

    /**
     * Truy vấn tất cả các các thực thể
     *
     * @return list danh sách các thực thể
     */
    public List<TaiKhoanNV> select() {
        String sql = "SELECT * FROM TaiKhoanNV";
        return select(sql);
    }

    /**
     * Truy vấn thực thể theo mã id
     *
     * @param id là mã của bản ghi được truy vấn
     * @return thực thể chứa thông tin của bản ghi
     */
    public TaiKhoanNV findById(String id) {
        String sql = "SELECT * FROM TaiKhoanNV WHERE Username=?";
        List<TaiKhoanNV> list = select(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }
}
