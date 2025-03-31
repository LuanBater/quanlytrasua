package com.ptithcm.quanlytrasua.repository;

import com.ptithcm.quanlytrasua.model.SanPham;
import com.ptithcm.quanlytrasua.model.TheLoai;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

@Transactional
public interface QuanLySanPhamRepository extends JpaRepository<SanPham, String> {
    @Procedure(procedureName = "LuuSanPhamMoi")
    void addSP(
            @Param("p_masp") String masp,
            @Param("p_tensp") String tensp,
            @Param("p_maloai") String maloai
    );

    @Procedure(procedureName = "SP_ThemSanPhamMoi")
    void themSP(
            @Param("p_masp") String masp,
            @Param("p_tensp") String tensp,
            @Param("p_maloai") String maloai,
            @Param("p_hinhanh") String hinhanh,
            @Param("p_giaM") int giaM,
            @Param("p_giaL") int giaL,
             @Param("p_mabanggia") String mabg
    );
    @Procedure(procedureName = "SP_CapNhatSanPham")
    void updateSP(
            @Param("p_masp") String masp,
            @Param("p_tensp") String tensp,
            @Param("p_maloai") String maloai,
            @Param("p_hinhanh") String hinhanh
    );
    @Procedure(procedureName = "SP_XoaSanPham")
    void xoaSP(
            @Param("p_masp") String masp
    );
    @Procedure(procedureName = "SP_ThemTopping")
    void themTP(
            @Param("p_masp") String masp,
            @Param("p_tensp") String tensp,
            @Param("p_maloai") String maloai,
            @Param("p_hinhanh") String hinhanh,
            @Param("p_gia") int gia,
            @Param("p_mabanggia") String mabg
    );
    @Procedure(procedureName = "SP_CapNhatCongThuc")
    void updateCongThuc(
            @Param("p_masp") String masp,
            @Param("p_manl") String manl,
            @Param("p_soluong") float soluong,
            @Param("p_mota") String mota
    );



    @Procedure(procedureName = "SP_ThemBangGia")
    void themChiTietGia(
            @Param("p_mabg") String mabg,
            @Param("p_masp") String masp,
            @Param("p_maloai") String maloai,
            @Param("p_giasizeM") int giasizeM,
            @Param("p_giasizeL") int giasizeL,
            @Param("p_ngayapdung") String ngayApDung,
            @Param("p_ngaykt") String ngayKetThuc
    );
    @Procedure(procedureName = "SP_CapNhatBangGia")
    void updateChiTietGia(
            @Param("p_mabg") String mabg,
            @Param("p_masp") String masp,
            @Param("p_maloai") String maloai,
            @Param("p_giasizeM") int giasizeM,
            @Param("p_giasizeL") int giasizeL,
            @Param("p_ngayapdung") String ngayApDung,
            @Param("p_ngaykt") String ngayKetThuc
    );
    @Procedure(procedureName = "SP_XoaBangGia")
    void xoaChiTietGia(
            @Param("p_mabg") String mabg,
            @Param("p_masp") String masp,
            @Param("p_maloai") String maloai
    );
    @Procedure(procedureName = "SP_ThayDoiGia")
    void changeGia(
            @Param("p_maloai") String maloai,
            @Param("p_giaM") int giaM,
            @Param("p_giaL") int giaL,
            @Param("p_idctspM") int idctspM,
            @Param("p_idctspL") int idctspL

    );
    @Procedure(procedureName = "SP_XoaCongThuc")
    void XoaCongThuc(
            @Param("p_masp") String masp
    );
    @Query(value = "{call SP_DanhSachSanPham (:p_maloai)}", nativeQuery = true)
    public List<Map<String, Object>> getListSanPham(@Param("p_maloai") String maloai);
    @Query(value = "{call SP_LaySanPhamBan (:p_maloai)}", nativeQuery = true)
    public List<Map<String, Object>> getListSanPhamBan(@Param("p_maloai") String maloai);
    @Query(value = "{call SP_ThongTinTopping}", nativeQuery = true)
    public List<Map<String, Object>> getListTopping();
    @Query(value = "{call SP_DanhSachTheLoai}", nativeQuery = true)
    public List<Map<String, Object>> getListTheLoai();
    @Query(value = "{call SP_LayCongThuc (:p_masp)}", nativeQuery = true)
    public List<Map<String, Object>> getCongThucSanPham(@Param("p_masp") String masp);
    @Query(value = "{call SP_LayChiTietGia(:p_masp, :p_maloai)}", nativeQuery = true)
    public List<Map<String, Object>> getGiaSanPham(@Param("p_masp") String masp,@Param("p_maloai") String maloai);
    @Query(value = "{call SP_LayDanhSachBangGia}", nativeQuery = true)
    public List<Map<String, Object>> getListBangGia();
    @Query(value = "{call SP_GiaKhaDung}", nativeQuery = true)
    public List<Map<String, Object>> getListGiaKhaDung();


}
