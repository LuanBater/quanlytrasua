package com.ptithcm.quanlytrasua.repository;

import com.ptithcm.quanlytrasua.model.NhanVien;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

@Transactional
public interface QuanLyNhanVienRepository extends JpaRepository<NhanVien, String> {
    @Query(value = "{call SP_DanhSachNhanVien}", nativeQuery = true)
    public List<Map<String, Object>> getListNhanVien();

    @Query(value = "{call SP_ThongTinNhanVien (:p_manv)}", nativeQuery = true)
    public Map<String, Object> getThongTinNhanVien(@Param("p_manv") String manv);

    @Procedure(procedureName = "SP_ThemNhanVien")
    void themNV(
            @Param("p_manv") String manv,
            @Param("p_hoten") String tennv,
            @Param("p_phai") int phai,
            @Param("p_ngaysinh") String ngaysinh,
            @Param("p_diachi") String diachi,
            @Param("p_sdt") String sdt,
            @Param("p_email") String email,
            @Param("p_hinhanh") String hinhanh,
            @Param("p_maquyen") String maquyen,
            @Param("p_password") String password
    );
    @Procedure(procedureName = "SP_CapNhatNhanVien")
    void updateNV(
            @Param("p_manv") String manv,
            @Param("p_hoten") String tennv,
            @Param("p_phai") int phai,
            @Param("p_ngaysinh") String ngaysinh,
            @Param("p_diachi") String diachi,
            @Param("p_sdt") String sdt,
            @Param("p_email") String email,
            @Param("p_hinhanh") String hinhanh
    );
    @Procedure(procedureName = "SP_ThayDoiTrangThaiLamViec")
    void changeNghiLam(
            @Param("p_manv") String manv
    );
    @Procedure(procedureName = "SP_ThayDoiQuyen")
    void changeQuyen(
            @Param("p_manv") String manv,
            @Param("p_quyen") String maquyen
    );

}
