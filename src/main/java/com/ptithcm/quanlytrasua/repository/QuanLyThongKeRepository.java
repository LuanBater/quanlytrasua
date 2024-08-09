package com.ptithcm.quanlytrasua.repository;

import com.ptithcm.quanlytrasua.model.HoaDon;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

@Transactional
public interface QuanLyThongKeRepository extends JpaRepository<HoaDon, Integer> {
    @Query(value = "{call SP_LayDanhSachChiPhiPhatSinh}", nativeQuery = true)
    public List<Map<String, Object>> getListCPPS();
    @Query(value = "{call SP_HoaDonTrongNgay (:p_ngayxuat)}", nativeQuery = true)
    public List<Map<String, Object>> getHoaDonTrongNgay(@Param("p_ngayxuat") String ngay);
    @Query(value = "{call SP_HoaDonTrongThang (:p_thang, :p_nam)}", nativeQuery = true)
    public List<Map<String, Object>> getListHoaDonTrongThang(@Param("p_thang") int thang,@Param("p_nam") int nam);
    @Query(value = "{call SP_PhieuNhapTrongThang(:p_thang, :p_nam)}", nativeQuery = true)
    List<Map<String,Object>> getListPhieuNhapTrongThang(
            @Param("p_thang") int thang,
            @Param("p_nam") int nam
    );
    @Procedure(procedureName = "SP_ThemChiPhiPhatSinh")
    void themCPPS(
            @Param("p_macpps") String macpps,
            @Param("p_chiphi") int chiphi,
            @Param("p_ngay") String ngay,
            @Param("p_mota") String mota,
            @Param("p_manv") String manv
    );
    @Procedure(procedureName = "SP_CapNhatChiPhiPhatSinh")
    void updateCPPS(
            @Param("p_macpps") String macpps,
            @Param("p_chiphi") int chiphi,
            @Param("p_ngay") String ngay,
            @Param("p_mota") String mota,
            @Param("p_manv") String manv
    );
    @Procedure(procedureName = "SP_XoaChiPhiPhatSinh")
    void xoaCPPS(
            @Param("p_macpps") String macpps
    );
}
