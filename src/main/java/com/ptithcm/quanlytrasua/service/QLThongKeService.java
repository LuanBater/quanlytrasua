package com.ptithcm.quanlytrasua.service;

import com.ptithcm.quanlytrasua.DTO.*;
import com.ptithcm.quanlytrasua.repository.QuanLyThongKeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class QLThongKeService {
    @Autowired
    QuanLyThongKeRepository repository;

    public ThongKePhieuNhap mapPNTHANG (Map<String , Object> map)
    {
        ThongKePhieuNhap DTO = new ThongKePhieuNhap();
        DTO.setManl((String) map.get("MANL"));
        DTO.setTennl((String) map.get("TENNL"));
        DTO.setMaphieunhap(Integer.parseInt(map.get("MAPHIEUNHAP").toString()));
        DTO.setNgaynhap((String) map.get("Ngay").toString());
        DTO.setSoluong(Float.parseFloat(map.get("SOLUONG").toString()));
        DTO.setGianhap(Integer.parseInt(map.get("SOLUONG").toString()));
        DTO.setThanhtien(Float.parseFloat(map.get("THANHTIEN").toString()));
        return DTO;
    }
    public ThongKeThang mapHDTHANG (Map<String , Object> map)
    {
        ThongKeThang DTO = new ThongKeThang();

        DTO.setNgay((String) map.get("Ngay").toString());
        DTO.setSoluong(Integer.parseInt(map.get("TONGSOHOADON").toString()));
        DTO.setTong(Integer.parseInt(map.get("TONGGIA").toString()));
        return DTO;
    }
    public ThongKeQuy mapHDQuy (Map<String , Object> map)
    {
        ThongKeQuy DTO = new ThongKeQuy();

        DTO.setQuy((String) map.get("Quater").toString());
        DTO.setTongthang1(Float.parseFloat(map.get("Month_1_Revenue").toString()));
        DTO.setTongthang2(Float.parseFloat(map.get("Month_2_Revenue").toString()));
        DTO.setTongthang3(Float.parseFloat(map.get("Month_3_Revenue").toString()));
        DTO.setTongquy(Float.parseFloat(map.get("Quarter_Revenue").toString()));
        return DTO;
    }
    public ThongKeNam mapHDNam (Map<String , Object> map)
    {
        ThongKeNam DTO = new ThongKeNam();

        DTO.setTongq1(Float.parseFloat(map.get("Q1_Revenue").toString()));
        DTO.setTongq2(Float.parseFloat(map.get("Q2_Revenue").toString()));
        DTO.setTongq3(Float.parseFloat(map.get("Q3_Revenue").toString()));
        DTO.setTongq4(Float.parseFloat(map.get("Q4_Revenue").toString()));
        DTO.setNam(Integer.parseInt(map.get("Year").toString()));
        return DTO;
    }
    public HoaDonDTO mapHD (Map<String , Object> map)
    {
        HoaDonDTO DTO = new HoaDonDTO();
        DTO.setMahoadon(Integer.parseInt(map.get("MAHOADON").toString()));
        DTO.setMadonhang(Integer.parseInt(map.get("MADONHANG").toString()));
        DTO.setNgayxuat((String) map.get("NGAYXUAT").toString());
        DTO.setTonggia(Integer.parseInt(map.get("TONGGIA").toString()));
        DTO.setMst((String) map.get("MST"));
        DTO.setManv((String) map.get("MANV"));
        DTO.setTennv((String) map.get("TENNV"));
        DTO.setMakh((String) map.get("MAKH"));
        DTO.setTenkh((String) map.get("TENKH"));
        return DTO;
    }

    public ThongKeNguyenLieu mapTKNL (Map<String , Object> map)
    {
        ThongKeNguyenLieu DTO = new ThongKeNguyenLieu();

        DTO.setManl((String) map.get("MANL"));
        DTO.setTennl((String) map.get("TENNL"));
        DTO.setDonvi((String) map.get("DONVI"));
        DTO.setTongsudung(Float.parseFloat(map.get("TONGSUDUNG").toString()));
        DTO.setSoluongphatsinh(Float.parseFloat(map.get("SOLUONGPHATSINH").toString()));
        DTO.setTongthuc(Float.parseFloat(map.get("TONGTHUC").toString()));
        return DTO;
    }
    public NguyenLieuNhapTrongThang mapNLNhapThang (Map<String , Object> map)
    {
        NguyenLieuNhapTrongThang DTO = new NguyenLieuNhapTrongThang();
        DTO.setMaphieunhap(Integer.parseInt(map.get("MAPHIEUNHAP").toString()));
        DTO.setNgaynhap((String) map.get("NGAYNHAP").toString());
        DTO.setManl((String) map.get("MANL"));
        DTO.setTennl((String) map.get("TENNL"));
        DTO.setDonvi((String) map.get("DONVI"));
        DTO.setGianhap(Integer.parseInt(map.get("GIANHAP").toString()));
        DTO.setSoluongnhap(Float.parseFloat(map.get("SOLUONGNHAP").toString()));
        DTO.setThanhtien(Float.parseFloat(map.get("THANHTIEN").toString()));
        DTO.setTongsoluong(Float.parseFloat(map.get("TONG_SOLUONG").toString()));
        DTO.setTongthanhtien(Float.parseFloat(map.get("TONG_THANHTIEN").toString()));
        return DTO;
    }
    public DoanhThuSanPham mapDTSP (Map<String , Object> map)
    {
        DoanhThuSanPham DTO = new DoanhThuSanPham();
        DTO.setIdctsp(Integer.parseInt(map.get("IDCTSP").toString()));
        DTO.setMasp((String) map.get("MASP"));
        DTO.setTensp((String) map.get("TENSP"));
        DTO.setMasize((String) map.get("MASIZE"));
        DTO.setGiaban(Integer.parseInt(map.get("GIA").toString()));
        DTO.setSoluongban(Integer.parseInt(map.get("SO_LUONG_BAN").toString()));
        DTO.setDoanhthu(Float.parseFloat(map.get("DOANH_THU").toString()));

        return DTO;
    }
    public DoanhThuSanPham mapTopSP (Map<String , Object> map)
    {
        DoanhThuSanPham DTO = new DoanhThuSanPham();
        DTO.setMasp((String) map.get("MASP"));
        DTO.setTensp((String) map.get("TENSP"));
        DTO.setSoluongban(Integer.parseInt(map.get("SO_LUONG_BAN").toString()));
        DTO.setDoanhthu(Float.parseFloat(map.get("DOANH_THU").toString()));

        return DTO;
    }

    public List<HoaDonDTO> getListHDNgay(String ngay){

        List<Map<String,Object>> data = repository.getHoaDonTrongNgay(ngay);
        List<HoaDonDTO> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            HoaDonDTO temp = mapHD(data.get(i));
            list.add(temp);
        }
        return  list;
    }
    public List<ThongKeThang> getListHDTHANG(int thang, int nam){

        List<Map<String,Object>> data = repository.getListHoaDonTrongThang(thang,nam);
        List<ThongKeThang> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            ThongKeThang temp = mapHDTHANG(data.get(i));
            list.add(temp);
        }
        return  list;
    }
    public ThongKeQuy getListHDQuy(int nam, String quy){

        Map<String,Object> data = repository.getListHoaDonTrongQuy(nam,quy);
        ThongKeQuy temp = mapHDQuy(data);

        return  temp;
    }
    public ThongKeNam getListHDNam(int nam){

        Map<String,Object> data = repository.getListHoaDonTrongNam(nam);
        ThongKeNam temp = mapHDNam(data);

        return  temp;
    }
    public List<ThongKePhieuNhap> getListPNTHANG(int thang, int nam){

        List<Map<String,Object>> data = repository.getListPhieuNhapTrongThang(thang,nam);
        List<ThongKePhieuNhap> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            ThongKePhieuNhap temp = mapPNTHANG(data.get(i));
            list.add(temp);
        }
        return  list;
    }
    public List<ThongKeNguyenLieu> getListNguyenLieuSuDung(int thang, int nam){

        List<Map<String,Object>> data = repository.getThongKeNguyenLieuSuDung(thang,nam);
        List<ThongKeNguyenLieu> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            ThongKeNguyenLieu temp = mapTKNL(data.get(i));
            list.add(temp);
        }
        return  list;
    }
    public List<ThongKeNguyenLieu> getNguyenLieuSuDungTrongNgay(String ngay){

        List<Map<String,Object>> data = repository.getNguyenLieuSuDungTrongNgay(ngay);
        List<ThongKeNguyenLieu> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            ThongKeNguyenLieu temp = mapTKNL(data.get(i));
            list.add(temp);
        }
        return  list;
    }
    public List<NguyenLieuNhapTrongThang> getNguyenLieuNhapTrongThang(int thang, int nam){

        List<Map<String,Object>> data = repository.getNguyenLieuNhapTrongThang(thang,nam);
        List<NguyenLieuNhapTrongThang> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            NguyenLieuNhapTrongThang temp = mapNLNhapThang(data.get(i));
            list.add(temp);
        }
        return  list;
    }
    public List<DoanhThuSanPham> getDoanhThuSanPham(int thang, int nam){

        List<Map<String,Object>> data = repository.DoanhThuSanPham(thang,nam);
        List<DoanhThuSanPham> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            DoanhThuSanPham temp = mapDTSP(data.get(i));
            list.add(temp);
        }
        return  list;
    }
    public List<DoanhThuSanPham> getDoanhThuSanPhamTrongNgay(String ngay){

        List<Map<String,Object>> data = repository.DoanhThuSanPhamTrongNgay(ngay);
        List<DoanhThuSanPham> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            DoanhThuSanPham temp = mapDTSP(data.get(i));
            list.add(temp);
        }
        return  list;
    }
    public List<DoanhThuSanPham> getTopSanPham(){

        List<Map<String,Object>> data = repository.getTopSanPham();
        List<DoanhThuSanPham> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            DoanhThuSanPham temp = mapTopSP(data.get(i));
            list.add(temp);
        }
        return  list;
    }
    public List<DoanhThuSanPham> getTopSanPhamThap(){

        List<Map<String,Object>> data = repository.getTopSanPhamThap();
        List<DoanhThuSanPham> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            DoanhThuSanPham temp = mapTopSP(data.get(i));
            list.add(temp);
        }
        return  list;
    }
}
