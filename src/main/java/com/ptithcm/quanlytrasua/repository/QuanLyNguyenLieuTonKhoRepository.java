package com.ptithcm.quanlytrasua.repository;

import com.ptithcm.quanlytrasua.DTO.NguyenLieuNhap;
import com.ptithcm.quanlytrasua.model.NguyenLieu;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Transactional
public interface QuanLyNguyenLieuTonKhoRepository extends JpaRepository<NguyenLieu, String> {
    @Query(value = "{call SP_LayDanhSachNguyenLieu}", nativeQuery = true)
    public List<Map<String, Object>> getListNguyenLieu();
    @Procedure(procedureName = "SP_ChangeTrangThaiNguyenLieu")
    void changeTrangThai(
            @Param("p_manl") String manl
    );
    @Procedure(procedureName = "SP_ThemNguyenLieuMoi")
    void themNL(
            @Param("p_manl") String manl,
            @Param("p_tennl") String tennl,
            @Param("p_hinhanh") String hinhanh,
            @Param("p_soluongton") Float soluongton,
            @Param("p_donvi") String donvi,
            @Param("p_gioihanton") Float gioihanton
    );
    @Procedure(procedureName = "SP_CapNhatNguyenLieu")
    void updateNL(
            @Param("p_manl") String masp,
            @Param("p_tennl") String tennl,
            @Param("p_hinhanh") String hinhanh,
            @Param("p_soluongton") Float soluongton,
            @Param("p_donvi") String donvi,
            @Param("p_gioihanton") Float gioihanton
    );
    @Procedure(procedureName = "SP_XoaNguyenLieu")
    void xoaNL(
            @Param("p_manl") String manl
    );
    @Procedure(procedureName = "SP_TaoDonDatMua")
    void taoDonDatMua(
            @Param("p_mancc") String mancc,
            @Param("p_manv") String manv,
            @Param ("p_list_nguyenlieu") String listNguyenLieuJson
    );
    @Procedure(procedureName = "SP_TaoPhieuNhap")
    void taoPhieuNhap(
            @Param("p_maddm") int madondat,
            @Param("p_manv") String manv,
            @Param ("p_list_nguyenlieu") String listNguyenLieuJson
    );
    @Procedure(procedureName = "SP_ThemNguyenLieuPhatSinh")
    void themNLPS(

            @Param("p_manl") String manl,
            @Param("p_manv") String manv,
            @Param ("p_ngay") String ngay,
            @Param ("p_soluong") float soluong,
            @Param ("p_mota") String mota
    );
    @Procedure(procedureName = "SP_CapNhatNguyenLieuPhatSinh")
    void updateNLPS(

            @Param("p_manl") String manl,
            @Param("p_manv") String manv,
            @Param ("p_ngay") String ngay,
            @Param ("p_soluong") float soluong,
            @Param ("p_mota") String mota
    );
    @Procedure(procedureName = "SP_XoaNguyenLieuPhatSinh")
    void xoaNLPS(

            @Param("p_manl") String manl,
            @Param("p_manv") String manv,
            @Param ("p_ngay") String ngay
    );
    @Procedure(procedureName = "SP_ThemNhaCungCap")
    void themNCC(

            @Param("p_mancc") String mancc,
            @Param("p_tenncc") String tenncc,
            @Param ("p_diachi") String diachi,
            @Param ("p_sdt") String sdt,
            @Param ("p_email") String email
    );
    @Procedure(procedureName = "SP_CapNhatNhaCungCap")
    void updateNCC(

            @Param("p_mancc") String mancc,
            @Param("p_tenncc") String tenncc,
            @Param ("p_diachi") String diachi,
            @Param ("p_sdt") String sdt,
            @Param ("p_email") String email
    );
    @Procedure(procedureName = "SP_XoaNhaCungCap")
    void xoaNCC(

            @Param("p_mancc") String mancc
    );
    @Query(value = "{call SP_DanhSachDonDatMua}", nativeQuery = true)
    public List<Map<String, Object>> getListDonDat();
    @Query(value = "{call SP_DanhSachPhieuNhap}", nativeQuery = true)
    public List<Map<String, Object>> getListPhieuNhap();
    @Query(value = "{call SP_TinhSoLuongKhaDung}", nativeQuery = true)
    public List<Map<String, Object>> getSanPhamKhaDung();
    @Query(value = "{call SP_DanhSachNhaCungCap}", nativeQuery = true)
    public List<Map<String, Object>> getListNhaCungCap();
    @Query(value = "{call SP_NguyenLieuCanhBao}", nativeQuery = true)
    public List<Map<String, Object>> getListNguyenLieuCanhBao();
    @Query(value = "{call SP_ChiTietDonDatMua (:p_maddm)}", nativeQuery = true)
    public List<Map<String, Object>> getListCTNguyenLieu(@Param("p_maddm") int madondat);
    @Query(value = "{call SP_ChiTietPhieuNhap (:p_mapn)}", nativeQuery = true)
    public List<Map<String, Object>> getListCTNguyenLieuPN(@Param("p_mapn") int mapn);
    @Query(value = "{call SP_KiemTraKhaDung (:p_masp)}", nativeQuery = true)
    public List<Map<String, Object>> getListCTNguyenLieuPN(@Param("p_masp") String masp);
    @Query(value = "{call SP_DanhSachNguyenLieuPhatSinh}", nativeQuery = true)
    public List<Map<String, Object>> getListNguyenLieuPhatSinh();
    @Query(value = "{call SP_ChiTietNhapNL (:p_manl)}", nativeQuery = true)
    public List<Map<String, Object>> getListCTNhapNL(@Param("p_manl") String manl);
}
