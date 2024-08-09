package com.ptithcm.quanlytrasua.repository;

import com.ptithcm.quanlytrasua.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface QuanLyKhachHangRepository extends JpaRepository<KhachHang, String> {
    @Query(value = "{call SP_DanhSachKhachHang}", nativeQuery = true)
    public List<Map<String, Object>> getListKhachHang();
    @Query(value = "{call SP_ThongTinKhachHang(:p_makh)}", nativeQuery = true)
    public Map<String, Object> getThongTinKhachHang(@Param("p_makh") String makh);
    @Procedure(procedureName = "SP_UpdateKhachHang")
    void updateKH(
            @Param("p_makh") String makh,
            @Param("p_tenkh") String tenkh,
            @Param("p_diachi") String diachi,
            @Param("p_sdt") String sdt,
            @Param("p_email") String email
    );
}
