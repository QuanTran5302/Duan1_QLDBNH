
package DAO;

import Helper.JdbcHelper;
import Model.TaiKhoanKH;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanKHDAO {
    private TaiKhoanKH readFromResultSet(ResultSet rs) throws SQLException {
        TaiKhoanKH model = new TaiKhoanKH();
        model.setUsername(rs.getString("Username"));
        model.setPass(rs.getString("Pass"));
        return model;
    }

    private List<TaiKhoanKH> select(String sql, Object... args) {
        List<TaiKhoanKH> list = new ArrayList<>();
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
    public void insert(TaiKhoanKH entity) {
        String sql = "INSERT INTO TaiKhoanKH (Username, Pass) VALUES (?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getUsername(),
                entity.getPass());
    }

    /**
     * Cập nhật thực thể vào CSDL
     *
     * @param entity là thực thể chứa thông tin bản ghi cần cập nhật
     */
    public void update(TaiKhoanKH entity) {
        String sql = "UPDATE TaiKhoanKH SET Pass=? WHERE Username=?";
        JdbcHelper.executeUpdate(sql,
                entity.getPass(),
                entity.getUsername());
    }

    /**
     * Xóa bản ghi khỏi CSDL
     *
     * @param id là mã của bản ghi cần xóa
     */
    public void delete(String id) {
        String sql = "DELETE FROM TaiKhoanKH WHERE Username=?";
        JdbcHelper.executeUpdate(sql, id);
    }

    /**
     * Truy vấn tất cả các các thực thể
     *
     * @return list danh sách các thực thể
     */
    public List<TaiKhoanKH> select() {
        String sql = "SELECT * FROM TaiKhoanKH";
        return select(sql);
    }

    /**
     * Truy vấn thực thể theo mã id
     *
     * @param id là mã của bản ghi được truy vấn
     * @return thực thể chứa thông tin của bản ghi
     */
    public TaiKhoanKH findById(String id) {
        String sql = "SELECT * FROM TaiKhoanKH WHERE Username=?";
        List<TaiKhoanKH> list = select(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }
}
