package com.ptithcm.quanlytrasua.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ptithcm.quanlytrasua.DTO.*;
import com.ptithcm.quanlytrasua.repository.QuanLyDonHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class QuanLyDonHangService {
    @Autowired
    QuanLyDonHangRepository repository;
    @Autowired
    private ObjectMapper objectMapper;
    public DonHangDTO mapDH (Map<String , Object> map)
    {
        DonHangDTO DTO = new DonHangDTO();
        DTO.setMadonhang(Integer.parseInt(map.get("MADONHANG").toString()));
        DTO.setNgaytao((String) map.get("NGAYTAO").toString());
        DTO.setTrangthai(Integer.parseInt(map.get("TRANGTHAI").toString()));
        DTO.setManv((String) map.get("MANV"));
        DTO.setTennv((String) map.get("TENNV"));
        DTO.setMakh((String) map.get("MAKH"));
        DTO.setTenkh((String) map.get("TENKH"));
        DTO.setThanhtoan(Integer.parseInt(map.get("THANHTOAN").toString()));
        return DTO;
    }
    public CTDonHang mapCTDH (Map<String , Object> map)
    {
        CTDonHang DTO = new CTDonHang();
        DTO.setIdctdh(Integer.parseInt(map.get("IDCTDH").toString()));
        DTO.setIdctsp(Integer.parseInt(map.get("IDCTSP").toString()));
        DTO.setTensp((String) map.get("TENSANPHAM"));
        DTO.setMasize((String) map.get("MASIZE"));
        DTO.setSoluong(Integer.parseInt(map.get("SOLUONG").toString()));
        DTO.setGia(Integer.parseInt(map.get("GIA").toString()));

        return DTO;
    }
    public CTTopping mapCTTopping (Map<String , Object> map)
    {
        CTTopping DTO = new CTTopping();
        DTO.setIdctsp(Integer.parseInt(map.get("IDCTSP").toString()));
        DTO.setTensp((String) map.get("TENSP"));
        DTO.setSoluong(Integer.parseInt(map.get("SOLUONG").toString()));
        DTO.setGia(Integer.parseInt(map.get("GIA").toString()));

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
    public List<DonHangDTO> getListDonHang(){

        List<Map<String,Object>> data = repository.getListDonHang();
        List<DonHangDTO> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            DonHangDTO temp = mapDH(data.get(i));
            list.add(temp);
        }
        return  list;
    }
    public List<HoaDonDTO> getListHoaDon(){

        List<Map<String,Object>> data = repository.getListHoaDon();
        List<HoaDonDTO> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            HoaDonDTO temp = mapHD(data.get(i));
            list.add(temp);
        }
        return  list;
    }
    public List<CTDonHang> getListCTDH(int madonhang){

        List<Map<String,Object>> data = repository.getListCTDH(madonhang);
        List<CTDonHang> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            CTDonHang temp = mapCTDH(data.get(i));
            list.add(temp);
        }
        return  list;
    }
    public String kiemTraTrangThai(int madonhang){

        String data = repository.kiemTraTrangThai(madonhang);
       return data;

    }
    public List<CTTopping> getListCTTopping(int idctdh){

        List<Map<String,Object>> data = repository.getListCTTopping(idctdh);
        List<CTTopping> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            CTTopping temp = mapCTTopping(data.get(i));
            list.add(temp);
        }
        return  list;
    }
    public int taoDonHang(OrderRequest orderRequest) throws JsonProcessingException {
        // Chuyển đổi danh sách sản phẩm thành JSON string
        String listNguyenLieuJson = objectMapper.writeValueAsString(orderRequest.getList_sanpham());

        // Gọi stored procedure và lấy mã đơn hàng mới
        Integer orderId = repository.taoDonHang(orderRequest.getManv(), orderRequest.getThanhtoan(), listNguyenLieuJson);

        if (orderId != null) {
            return orderId;  // Trả về mã đơn hàng nếu thành công
        } else {
            return 0;  // Trả về 0 nếu thất bại
        }
    }


    public int duyetDonHang(String manv, int madonhang){
        try {
            repository.duyetDonHang(manv,madonhang);
            return 1;
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }

    }
    public int KiemTraSoLuongSanPhamKhaDung(String masp, String masize){
        Integer temp = repository.KiemTraSoLuongSanPhamKhaDung(masp,masize);
        if(temp != null)
        {
            return temp;
        }
        else return -1;
    }
    public int donHangThatBai( int madonhang){
        try {
            repository.donHangThatBai(madonhang);
            return 1;
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }

    }
    public int hoanThanhDonHang(HoanThanhDonHang orderRequest) throws JsonProcessingException {
        String listJson = objectMapper.writeValueAsString(orderRequest.getList_sanpham());
        try {
            repository.hoanThanhDonHang(orderRequest.getMadonhang(),listJson);
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
    public int xoaDonHang(int madonhang){
        try {
            repository.XoaDonHang(madonhang);
            return 1;
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }

    }
}
