package DAO;

import Helper.JdbcHelper;
import Model.KhachHang;
import Model.TaiKhoanKH;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDAO {

    private KhachHang readFromResultSet(ResultSet rs) throws SQLException {
        KhachHang model = new KhachHang();
        model.setMaKH(rs.getInt("MaKH"));
        model.setGioiTinh(rs.getBoolean("GioiTinh"));
        model.setHoTen(rs.getString("Hoten"));
        model.setNgaySinh(rs.getDate("NgaySinh"));
        model.setSdt(rs.getString("SDT"));
        model.setUsername(rs.getString("Username"));
        model.setEmail(rs.getString("Email"));
        return model;
    }

    private List<KhachHang> select(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
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
    public void insert(KhachHang entity) {
        String sql = "INSERT INTO ThongTinKH (Username, Hoten, NgaySinh, SDT, Email, GioiTinh) VALUES (?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getUsername(),
                entity.getHoTen(),
                entity.getNgaySinh(),
                entity.getSdt(),
                entity.getEmail(),
                entity.isGioiTinh());
    }

    /**
     * Cập nhật thực thể vào CSDL
     *
     * @param entity là thực thể chứa thông tin bản ghi cần cập nhật
     */
    public void update(KhachHang entity) {
        String sql = "UPDATE ThongTinKH SET Username=?, Hoten=?, NgaySinh=?, SDT=?, Email=?, GioiTinh=? WHERE MaKH=?";
        JdbcHelper.executeUpdate(sql,
                entity.getUsername(),
                entity.getHoTen(),
                entity.getNgaySinh(),
                entity.getSdt(),
                entity.getEmail(),
                entity.isGioiTinh(),
                entity.getMaKH());
    }

    /**
     * Xóa bản ghi khỏi CSDL
     *
     * @param id là mã của bản ghi cần xóa
     */
    public void delete(String id) {
        String sql = "DELETE FROM ThongTinKH WHERE MaKH=?";
        JdbcHelper.executeUpdate(sql, id);
    }

    /**
     * Truy vấn tất cả các các thực thể
     *
     * @return list danh sách các thực thể
     */
    public List<KhachHang> select() {
        String sql = "SELECT * FROM ThongTinKH";
        return select(sql);
    }

    /**
     * Truy vấn thực thể theo mã id
     *
     * @param id là mã của bản ghi được truy vấn
     * @return thực thể chứa thông tin của bản ghi
     */
    public KhachHang findById(String id) {
        String sql = "SELECT * FROM ThongTinKH WHERE Username=?";
        List<KhachHang> list = select(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    public KhachHang findByUser(String user) {
        String sql = "SELECT * FROM ThongTinKH WHERE Username=?";
        List<KhachHang> list = select(sql, user);
        return list.size() > 0 ? list.get(0) : null;
    }
}
