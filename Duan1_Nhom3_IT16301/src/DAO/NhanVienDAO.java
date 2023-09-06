
package DAO;

import Helper.JdbcHelper;
import Model.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO {
    private NhanVien readFromResultSet(ResultSet rs) throws SQLException {
        NhanVien model = new NhanVien();
        model.setMaNV(rs.getString("MaNV"));
        model.setGioiTinh(rs.getBoolean("GioiTinh"));
        model.setHoTen(rs.getString("Hoten"));
        model.setNgaySinh(rs.getDate("NgaySinh"));
        model.setSdt(rs.getString("SDT"));
        model.setUsername(rs.getString("Username"));
        model.setDiaChi(rs.getString("DiaChi"));
        model.setAvatar(rs.getString("Avatar"));
        return model;
    }

    private List<NhanVien> select(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
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
    public void insert(NhanVien entity) {
        String sql = "INSERT INTO ThongTinNV (MaNV, Username, Hoten,NgaySinh,SDT, DiaChi, GioiTinh,Avatar) VALUES (?, ?, ?, ?,?, ?, ?,?)";
        JdbcHelper.executeUpdate(sql,
                entity.getMaNV(),
                entity.getUsername(),
                entity.getHoTen(),
                entity.getNgaySinh(),
                entity.getSdt(),
                entity.getDiaChi(),
                entity.isGioiTinh(),
                entity.getAvatar());
    }

    /**
     * Cập nhật thực thể vào CSDL
     *
     * @param entity là thực thể chứa thông tin bản ghi cần cập nhật
     */
    public void update(NhanVien entity) {
        String sql = "UPDATE ThongTinNV SET Username=?, Hoten=?, NgaySinh=?, SDT=?, DiaChi=?, GioiTinh=?, Avatar=? WHERE MaNV=?";
        JdbcHelper.executeUpdate(sql,
                entity.getUsername(),
                entity.getHoTen(),
                entity.getNgaySinh(),
                entity.getSdt(),
                entity.getDiaChi(),
                entity.isGioiTinh(),
                entity.getAvatar(),
                entity.getMaNV());
    }

    /**
     * Xóa bản ghi khỏi CSDL
     *
     * @param id là mã của bản ghi cần xóa
     */
    public void delete(String id) {
        String sql = "DELETE FROM ThongTinNV WHERE MaNV=?";
        JdbcHelper.executeUpdate(sql, id);
    }

    /**
     * Truy vấn tất cả các các thực thể
     *
     * @return list danh sách các thực thể
     */
    public List<NhanVien> select() {
        String sql = "SELECT * FROM ThongTinNV";
        return select(sql);
    }

    /**
     * Truy vấn thực thể theo mã id
     *
     * @param id là mã của bản ghi được truy vấn
     * @return thực thể chứa thông tin của bản ghi
     */
    public NhanVien findById(String id) {
        String sql = "SELECT * FROM ThongTinNV WHERE MaNV=?";
        List<NhanVien> list = select(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }
}
