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
    public ChiPhiPhatSinhDTO mapcpps (Map<String , Object> map)
    {
        ChiPhiPhatSinhDTO DTO = new ChiPhiPhatSinhDTO();
        DTO.setMacpps((String) map.get("MACPPS"));
        DTO.setChiphi(Integer.parseInt(map.get("CHIPHI").toString()));
        DTO.setNgay((String) map.get("NGAY").toString());
        DTO.setMota((String) map.get("MOTA"));
        DTO.setManv((String) map.get("MANV"));
        DTO.setTennv((String) map.get("TENNV"));
        return DTO;
    }
    public ThongKeThang mapPNTHANG (Map<String , Object> map)
    {
        ThongKeThang DTO = new ThongKeThang();

        DTO.setNgay((String) map.get("Ngay").toString());
        DTO.setSoluong(Integer.parseInt(map.get("TONGSOPHIEUNHAP").toString()));
        DTO.setTong(Integer.parseInt(map.get("TONGNHAP").toString()));
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
    public HoaDonDTO mapHD (Map<String , Object> map)
    {
        HoaDonDTO DTO = new HoaDonDTO();
        DTO.setMahoadon(Integer.parseInt(map.get("MAHOADON").toString()));
        DTO.setMadonhang(Integer.parseInt(map.get("MADONHANG").toString()));
        DTO.setNgayxuat((String) map.get("NGAYXUAT").toString());
        DTO.setTonggia(Integer.parseInt(map.get("TONGGIA").toString()));
        DTO.setMst((String) map.get("MST"));
        return DTO;
    }
    public List<ChiPhiPhatSinhDTO> getListCTPS(){

        List<Map<String,Object>> data = repository.getListCPPS();
        List<ChiPhiPhatSinhDTO> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            ChiPhiPhatSinhDTO temp = mapcpps(data.get(i));
            list.add(temp);
        }
        return  list;
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
    public List<ThongKeThang> getListPNTHANG(int thang, int nam){

        List<Map<String,Object>> data = repository.getListPhieuNhapTrongThang(thang,nam);
        List<ThongKeThang> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            ThongKeThang temp = mapPNTHANG(data.get(i));
            list.add(temp);
        }
        return  list;
    }
    public int xoaCPPS(String macpps){
        try {
            repository.xoaCPPS(macpps);
            return 1;
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }

    }
    public int themCPPS(ChiPhiPhatSinhDTO dto) {

        try {
            repository.themCPPS(dto.getMacpps(),dto.getChiphi(),dto.getNgay(),dto.getMota(),dto.getManv());
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
    public int updateCPPS(ChiPhiPhatSinhDTO dto) {

        try {
            repository.updateCPPS(dto.getMacpps(),dto.getChiphi(),dto.getNgay(),dto.getMota(),dto.getManv());
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
}
