package DAO;

import Helper.JdbcHelper;
import Model.PhieuDat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhieuDatDAO {

    private PhieuDat readFromResultSet(ResultSet rs) throws SQLException {
        PhieuDat model = new PhieuDat();
        model.setMaPD(rs.getInt("MaPD"));
        model.setMaKH(rs.getInt("MaKH"));
        model.setDateBook(rs.getDate("DateBook"));
        model.setTimeBook(rs.getTime("TimeBook"));
        model.setSoBan(rs.getInt("SoBan"));
        model.setSoNguoi(rs.getInt("SoNguoi"));
        model.setDateXacNhan(rs.getDate("DateXacNhan"));
        model.setTimeXacNhan(rs.getTime("TimeXacNhan"));
        model.setDateThanhToan(rs.getDate("DateThanhToan"));
        model.setTimeThanToan(rs.getTime("TimeThanToan"));
        model.setGhiChu(rs.getString("GhiChu"));
        model.setTrangThai(rs.getString("TrangThai"));

        return model;
    }

    private List<PhieuDat> select(String sql, Object... args) {
        List<PhieuDat> list = new ArrayList<>();
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
    public void insert(PhieuDat entity) {
        String sql = "INSERT INTO PhieuDat (MaKH, DateBook, TimeBook, SoBan, SoNguoi, DateXacNhan, TimeXacNhan, DateThanhToan, TimeThanToan, GhiChu, TrangThai) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getMaKH(),
                entity.getDateBook(),
                entity.getTimeBook(),
                entity.getSoBan(),
                entity.getSoNguoi(),
                entity.getDateXacNhan(),
                entity.getTimeXacNhan(),
                entity.getDateThanhToan(),
                entity.getTimeThanToan(),
                entity.getGhiChu(),
                entity.getTrangThai());
    }

    /**
     * Cập nhật thực thể vào CSDL
     *
     * @param entity là thực thể chứa thông tin bản ghi cần cập nhật
     */
    public void update1(PhieuDat entity) {
        String sql = "UPDATE PhieuDat SET DateXacNhan = ?, TimeXacNhan=? ,TrangThai=? WHERE MaPD=?";
        JdbcHelper.executeUpdate(sql,
                entity.getDateXacNhan(),
                entity.getTimeXacNhan(),
                entity.getTrangThai(),
                entity.getMaPD());
    }
    public void update(PhieuDat entity) {
        String sql = "UPDATE PhieuDat SET DateBook=?, TimeBook=?, SoBan = ?, SoNguoi=?, GhiChu=? WHERE MaPD=?";
        JdbcHelper.executeUpdate(sql,
                entity.getDateBook(),
                entity.getTimeBook(),
                entity.getSoBan(),
                entity.getSoNguoi(),
                entity.getGhiChu(),
                entity.getMaPD());
    }

    /**
     * Xóa bản ghi khỏi CSDL
     *
     * @param id là mã của bản ghi cần xóa
     */
    public void delete(int id) {
        String sql = "DELETE FROM PhieuDat WHERE MaPD=?";
        JdbcHelper.executeUpdate(sql, id);
    }
    
    public void delete1(int id) {
        String sql = "UPDATE PhieuDat SET TrangThai = N'Đã hủy' WHERE MaPD=?";
        JdbcHelper.executeUpdate(sql, id);
    }

    /**
     * Truy vấn tất cả các các thực thể
     *
     * @return list danh sách các thực thể
     */
    public List<PhieuDat> select() {
        String sql = "SELECT * FROM PhieuDat WHERE TrangThai =N'Chờ xác nhận'";
        return select(sql);
    }
        public List<PhieuDat> selectDPH() {
        String sql = "SELECT * FROM PhieuDat\n"
                + "WHERE TrangThai =N'Đã xác nhận'";
        return select(sql);
    }
        public List<PhieuDat> selectDTT() {
        String sql = "SELECT * FROM PhieuDat\n"
                + "WHERE TrangThai =N'Đã thanh toán'";
        return select(sql);
    }
    public List<PhieuDat> select(int id, String trangthai) {
        String sql = "	SELECT * FROM PhieuDat WHERE MaKH = ? and TrangThai = ?";
        return select(sql, id, trangthai);
    }
    public List<PhieuDat> select(String datenow, String timenow) {
        String sql = "select * from PhieuDat WHERE DateBook = ? "
                + "AND  DATEDIFF(MINUTE, ?, TimeBook) <= 30 "
                + "AND  DATEDIFF(MINUTE, ?, TimeBook) > 0"
                + "AND TrangThai = N'Đã xác nhận'";
        return select(sql, datenow, timenow, timenow);
    }
    
    public List<PhieuDat> select1(String datenow, String timenow) {
        String sql = "select * from PhieuDat WHERE DateBook = ? "
                + "AND  DATEDIFF(MINUTE, ?, TimeBook) < 0 "
                + "AND TrangThai = N'Đã xác nhận'";;
        return select(sql, datenow, timenow);
    }
    /**
     * Truy vấn thực thể theo mã id
     *
     * @param id là mã của bản ghi được truy vấn
     * @return thực thể chứa thông tin của bản ghi
     */
    public PhieuDat findById(int id) {
        String sql = "SELECT * FROM PhieuDat WHERE MaPD=?";
        List<PhieuDat> list = select(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    public PhieuDat findByIdInDG(int id) {
        String sql = "	select * from PhieuDat a join DanhGia b on a.MaPD = b.MaPD where a.MaPD in (Select MaPD from DanhGia where MaPD = ?)";
        List<PhieuDat> list = select(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }

//    public PhieuDat findByUser(String user) {
//        String sql = "SELECT * FROM PhieuDat WHERE Username=?";
//        List<PhieuDat> list = select(sql, user);
//        return list.size() > 0 ? list.get(0) : null;
//    }
     public void updateTT(PhieuDat entity) {
        String sql = "UPDATE PhieuDat SET DateThanhToan=?, TimeThanToan=?, TrangThai = ? WHERE MaPD=?";
        JdbcHelper.executeUpdate(sql,
                entity.getDateThanhToan(),
                entity.getTimeThanToan(),
                entity.getTrangThai(),
                entity.getMaPD());
    }
}
