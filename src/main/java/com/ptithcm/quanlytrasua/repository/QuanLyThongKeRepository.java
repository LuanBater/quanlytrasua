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
    @Query(value = "{call SP_HoaDonTrongNgay (:p_ngayxuat)}", nativeQuery = true)
    public List<Map<String, Object>> getHoaDonTrongNgay(@Param("p_ngayxuat") String ngay);
    @Query(value = "{call ThongKeNguyenLieuSuDungTrongThang (:THANG, :NAM)}", nativeQuery = true)
    public List<Map<String, Object>> getThongKeNguyenLieuSuDung(@Param("THANG") int thang,@Param("NAM") int nam);
    @Query(value = "{call ThongKeNguyenLieuSuDungTrongNgayX (:p_NGAY)}", nativeQuery = true)
    public List<Map<String, Object>> getNguyenLieuSuDungTrongNgay(@Param("p_NGAY") String ngay);
    @Query(value = "{call DoanhThuSanPham (:THANG, :NAM)}", nativeQuery = true)
    public List<Map<String, Object>> DoanhThuSanPham(@Param("THANG") int thang,@Param("NAM") int nam);

    @Query(value = "{call ThongKeNguyenLieuNhapTrongThang (:p_thang, :p_nam)}", nativeQuery = true)
    public List<Map<String, Object>> getNguyenLieuNhapTrongThang(@Param("p_thang") int thang,@Param("p_nam") int nam);
    @Query(value = "{call DoanhThuSanPhamTrongNgay (:NGAY)}", nativeQuery = true)
    public List<Map<String, Object>> DoanhThuSanPhamTrongNgay(@Param("NGAY") String ngay);
    @Query(value = "{call ThongKeDoanhThuTheoQuy (:year, :quarter_code)}", nativeQuery = true)
    public Map<String, Object> getListHoaDonTrongQuy(@Param("year") int nam ,@Param("quarter_code") String quy);
    @Query(value = "{call ThongKeDoanhThuTheoNam (:year)}", nativeQuery = true)
    public Map<String, Object> getListHoaDonTrongNam(@Param("year") int nam);
    @Query(value = "{call SP_HoaDonTrongThang (:p_thang, :p_nam)}", nativeQuery = true)
    public List<Map<String, Object>> getListHoaDonTrongThang(@Param("p_thang") int thang,@Param("p_nam") int nam);
    @Query(value = "{call SP_ThongKePhieuNhapTrongThang(:p_thang, :p_nam)}", nativeQuery = true)
    List<Map<String,Object>> getListPhieuNhapTrongThang(
            @Param("p_thang") int thang,
            @Param("p_nam") int nam
    );
    @Query(value = "{call DoanhThuSanPhamTop5}", nativeQuery = true)
    public List<Map<String, Object>> getTopSanPham();
    @Query(value = "{call DoanhThuSanPhamTop5Thap}", nativeQuery = true)
    public List<Map<String, Object>> getTopSanPhamThap();
}
