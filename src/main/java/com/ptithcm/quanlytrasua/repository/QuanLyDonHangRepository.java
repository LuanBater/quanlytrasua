package com.ptithcm.quanlytrasua.repository;

import com.ptithcm.quanlytrasua.model.DonHang;
import com.ptithcm.quanlytrasua.model.NguyenLieu;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

@Transactional
public interface QuanLyDonHangRepository  extends JpaRepository<DonHang, Integer> {
    @Query(value = "{call SP_DanhSachDonHang}", nativeQuery = true)
    public List<Map<String, Object>> getListDonHang();
    @Query(value = "{call SP_LayChiTietDonHang (:p_madonhang)}", nativeQuery = true)
    public List<Map<String, Object>> getListCTDH(@Param("p_madonhang") int madonhang);
    @Query(value = "{call SP_KiemTraTrangThai (:p_madonhang)}", nativeQuery = true)
    public String kiemTraTrangThai(@Param("p_madonhang") int madonhang);
    @Query(value = "{call SP_CTTopping (:p_idctdh)}", nativeQuery = true)
    public List<Map<String, Object>> getListCTTopping(@Param("p_idctdh") int idctdh);
    @Query(value = "{call SP_LayHoaDon}", nativeQuery = true)
    public List<Map<String, Object>> getListHoaDon();

    @Procedure(procedureName = "SP_TaoDonHang")
    Integer taoDonHang(
            @Param("p_manv") String manv,
            @Param("p_thanhtoan") int thanhtoan,
            @Param("p_list_sanpham") String listSanpham
    );
    @Procedure(procedureName = "SP_XoaDonHang")
    void XoaDonHang(
            @Param("p_madonhang") int madonhang
    );
    @Procedure(procedureName = "SP_KiemTraSoLuongSanPhamKhaDung")
    Integer KiemTraSoLuongSanPhamKhaDung(
            @Param("p_masp") String masp,
            @Param("p_masize") String masize
    );
    @Procedure(procedureName = "SP_DuyetDonHang")
    void duyetDonHang(
            @Param("p_manv") String manv,
            @Param("p_madonhang") int madonhang
    );
    @Procedure(procedureName = "SP_DonHangThatBai")
    void donHangThatBai(
            @Param("p_madonhang") int madonhang
    );
    @Procedure(procedureName = "SP_HoanThanhDonHang")
    void hoanThanhDonHang(
            @Param("p_manv") int madonhang,
            @Param("p_list_sanpham") String list_sanpham
    );
}
