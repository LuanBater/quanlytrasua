package com.ptithcm.quanlytrasua.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ptithcm.quanlytrasua.DTO.*;
import com.ptithcm.quanlytrasua.model.NguyenLieuPhatSinh;
import com.ptithcm.quanlytrasua.repository.QuanLyNguyenLieuTonKhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class QLNguyenLieuTonKhoService {
    @Autowired
    QuanLyNguyenLieuTonKhoRepository repository;
    @Autowired
    private ObjectMapper objectMapper;
    public NguyenLieuDTO mapNL (Map<String , Object> map)
    {
        NguyenLieuDTO DTO = new NguyenLieuDTO();
        DTO.setManl((String) map.get("MANL"));
        DTO.setTennl((String) map.get("TENNL"));
        DTO.setSoluongton(Float.parseFloat(map.get("SOLUONGTON").toString()));
        DTO.setHinhanh((String) map.get("HINHANH"));
        DTO.setToithieu(Float.parseFloat(map.get("GIOIHANTON").toString()));
        DTO.setDonvi((String) map.get("DONVI"));
        DTO.setTrangthai(Integer.parseInt(map.get("TRANGTHAI").toString()));
        return DTO;
    }
    public DonDatMuaShow mapDDM (Map<String , Object> map)
    {
        DonDatMuaShow DTO = new DonDatMuaShow();
        DTO.setMadondat(Integer.parseInt(map.get("MADONDAT").toString()));
        DTO.setMancc((String) map.get("MANCC"));
        DTO.setTenncc((String) map.get("TENNCC"));
        DTO.setManv((String) map.get("MANV"));
        DTO.setTennv((String) map.get("HOTEN"));
        DTO.setNgaydat((String) map.get("NGAYDAT").toString());
        DTO.setDanhap(Integer.parseInt(map.get("DANHAP").toString()));
        return DTO;
    }
    public PhieuNhapShow mapPN (Map<String , Object> map)
    {
        PhieuNhapShow DTO = new PhieuNhapShow();
        DTO.setMapn(Integer.parseInt(map.get("MAPHIEUNHAP").toString()));
        DTO.setMadondat(Integer.parseInt(map.get("MADONDAT").toString()));
        DTO.setTennv((String) map.get("HOTEN"));
        DTO.setManv((String) map.get("MANV"));
        DTO.setNgaynhap((String) map.get("NGAYNHAP").toString());
        DTO.setMancc((String) map.get("MANCC"));
        DTO.setTenncc((String) map.get("TENNCC"));

        return DTO;
    }
    public SanPhamKhaDung mapKhaDung (Map<String , Object> map)
    {
        SanPhamKhaDung DTO = new SanPhamKhaDung();
        DTO.setIdctsp(Integer.parseInt(map.get("IDCTSP").toString()));
        DTO.setTensp((String) map.get("TENSP"));
        DTO.setMasize((String) map.get("MASIZE"));
        DTO.setSoluongkhadung(Float.parseFloat(map.get("SOLUONGKHADUNG").toString()));

        return DTO;
    }
    public NhaCungCapDTO mapNCC (Map<String , Object> map)
    {
        NhaCungCapDTO DTO = new NhaCungCapDTO();
        DTO.setMancc((String) map.get("MANCC"));
        DTO.setTenncc((String) map.get("TENNCC"));
        DTO.setSdt((String) map.get("SDT"));
        DTO.setEmail((String) map.get("EMAIL"));
        DTO.setDiachi((String) map.get("DIACHI"));
        return DTO;
    }
    public NguyenLieuNhap mapCTDDM (Map<String , Object> map)
    {
        NguyenLieuNhap DTO = new NguyenLieuNhap();
        DTO.setManl((String) map.get("MANL"));
        DTO.setTennl((String) map.get("TENNL"));
        DTO.setDonvi((String) map.get("DONVI"));
        DTO.setSoluong(Float.parseFloat(map.get("SOLUONG").toString()));
        return DTO;
    }
    public NguyenLieuNhap mapCTPN (Map<String , Object> map)
    {
        NguyenLieuNhap DTO = new NguyenLieuNhap();
        DTO.setManl((String) map.get("MANL"));
        DTO.setTennl((String) map.get("TENNL"));
        DTO.setDonvi((String) map.get("DONVI"));
        DTO.setSoluong(Float.parseFloat(map.get("SOLUONG").toString()));
        DTO.setGianhap(Integer.parseInt(map.get("GIANHAP").toString()));
        return DTO;
    }
    public NLPhatSinhDTO mapNLPS (Map<String , Object> map)
    {
        NLPhatSinhDTO DTO = new NLPhatSinhDTO();
        DTO.setManv((String) map.get("MANV"));
        DTO.setTennv((String) map.get("HOTEN"));
        DTO.setManl((String) map.get("MANL"));
        DTO.setTennl((String) map.get("TENNL"));
        DTO.setSoluong(Float.parseFloat(map.get("SOLUONG").toString()));
        DTO.setMota((String) map.get("MOTA"));
        DTO.setNgay((String) map.get("NGAY").toString());
        DTO.setDonvi((String) map.get("DONVI"));
        return DTO;
    }
    public ChiTietNhapNL mapCTNhapNL(Map<String , Object> map)
    {
        ChiTietNhapNL DTO = new ChiTietNhapNL();
        DTO.setMaphieunhap(Integer.parseInt(map.get("MAPHIEUNHAP").toString()));
        DTO.setManl((String) map.get("MANL"));
        DTO.setTennl((String) map.get("TENNL"));
        DTO.setSoluong(Float.parseFloat(map.get("SOLUONG").toString()));
        DTO.setDonvi((String) map.get("DONVI"));
        DTO.setNgaynhap((String) map.get("NGAYNHAP").toString());
        DTO.setGianhap(Integer.parseInt(map.get("GIANHAP").toString()));
       if (map.get("TONKHOTRUOC") == null)
       {
           DTO.setTonkhotruoc(0);
       }
       else
           DTO.setTonkhotruoc(Float.parseFloat(map.get("TONKHOTRUOC").toString()));
       if (map.get("TONKHOSAU") == null)
        {
            DTO.setTonkhosau(0);
        }
        else
            DTO.setTonkhosau(Float.parseFloat(map.get("TONKHOSAU").toString()));
        return DTO;
    }
    public List<NguyenLieuNhap> getCTDDM(int madondat){

        List<Map<String,Object>> data = repository.getListCTNguyenLieu(madondat);
        List<NguyenLieuNhap> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            NguyenLieuNhap temp = mapCTDDM(data.get(i));
            list.add(temp);
        }
        return  list;
    }
    public List<NguyenLieuNhap> getCTPN(int mapn){

        List<Map<String,Object>> data = repository.getListCTNguyenLieuPN(mapn);
        List<NguyenLieuNhap> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            NguyenLieuNhap temp = mapCTPN(data.get(i));
            list.add(temp);
        }
        return  list;
    }
    public List<NguyenLieuDTO> getlistNL(){

        List<Map<String,Object>> data = repository.getListNguyenLieu();
        List<NguyenLieuDTO> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            NguyenLieuDTO temp = mapNL(data.get(i));
            list.add(temp);
        }
        return  list;
    }
    public List<NguyenLieuDTO> getlistNLCB(){

        List<Map<String,Object>> data = repository.getListNguyenLieuCanhBao();
        List<NguyenLieuDTO> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            NguyenLieuDTO temp = mapNL(data.get(i));
            list.add(temp);
        }
        return  list;
    }
    public List<DonDatMuaShow> getlistDDM(){

        List<Map<String,Object>> data = repository.getListDonDat();
        List<DonDatMuaShow> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            DonDatMuaShow temp = mapDDM(data.get(i));
            list.add(temp);
        }
        return  list;
    }
    public List<PhieuNhapShow> getlistPN(){

        List<Map<String,Object>> data = repository.getListPhieuNhap();
        List<PhieuNhapShow> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            PhieuNhapShow temp = mapPN(data.get(i));
            list.add(temp);
        }
        return  list;
    }
    public List<SanPhamKhaDung> getListKhaDung(){

        List<Map<String,Object>> data = repository.getSanPhamKhaDung();
        List<SanPhamKhaDung> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            SanPhamKhaDung temp = mapKhaDung(data.get(i));
            list.add(temp);
        }
        return  list;
    }
    public List<NhaCungCapDTO> getlistNCC(){

        List<Map<String,Object>> data = repository.getListNhaCungCap();
        List<NhaCungCapDTO> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            NhaCungCapDTO temp = mapNCC(data.get(i));
            list.add(temp);
        }
        return  list;
    }
    public List<NLPhatSinhDTO> getlistNLPS(){

        List<Map<String,Object>> data = repository.getListNguyenLieuPhatSinh();
        List<NLPhatSinhDTO> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            NLPhatSinhDTO temp = mapNLPS(data.get(i));
            list.add(temp);
        }
        return  list;
    }
    public List<ChiTietNhapNL> getlistCTNhapNL(String manl){

        List<Map<String,Object>> data = repository.getListCTNhapNL(manl);
        List<ChiTietNhapNL> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            ChiTietNhapNL temp = mapCTNhapNL(data.get(i));
            list.add(temp);
        }
        return  list;
    }
    public int themNL(NguyenLieuDTO addObject) {

        try {
            repository.themNL(addObject.getManl(),addObject.getTennl(),addObject.getHinhanh(),addObject.getSoluongton(),addObject.getDonvi(),addObject.getToithieu());
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
    public int updateNL(NguyenLieuDTO updateObject) {

        try {
            repository.updateNL(updateObject.getManl(),updateObject.getTennl(),updateObject.getHinhanh(),updateObject.getSoluongton(),updateObject.getDonvi(),updateObject.getToithieu());
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
    public int xoaNL(String manl){
        try {
            repository.xoaNL(manl);
            return 1;
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }

    }
    public int taoDonDatMua(DonDatMuaDTO DTO) throws JsonProcessingException {
        String listNguyenLieuJson = objectMapper.writeValueAsString(DTO.getListNL());
        try {
            repository.taoDonDatMua(DTO.getMancc(),DTO.getManv(),listNguyenLieuJson);
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
    public int taoPhieuNhap(PhieuNhapDTO DTO) throws JsonProcessingException {
        String listNguyenLieuJson = objectMapper.writeValueAsString(DTO.getListNL());
        try {
            repository.taoPhieuNhap(DTO.getMadondat(),DTO.getManv(),listNguyenLieuJson);
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
    public int themNLPS (NLPhatSinhDTO addObject) {

        try {
            repository.themNLPS(addObject.getManl(),addObject.getManv(),addObject.getNgay(),addObject.getSoluong(),addObject.getMota());
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
    public int updateNLPS (NLPhatSinhDTO Object) {

        try {
            repository.updateNLPS(Object.getManl(),Object.getManv(),Object.getNgay(),Object.getSoluong(),Object.getMota());
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }

    public int xoaNLPS (NLPhatSinhDTO addObject) {

        try {
            repository.xoaNLPS(addObject.getManl(),addObject.getManv(),addObject.getNgay());
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
    public int themNCC (NhaCungCapDTO addObject) {

        try {
            repository.themNCC(addObject.getMancc(),addObject.getTenncc(),addObject.getDiachi(),addObject.getSdt(),addObject.getEmail());
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
    public int updateNCC (NhaCungCapDTO Object) {

        try {
            repository.updateNCC(Object.getMancc(),Object.getTenncc(),Object.getDiachi(),Object.getSdt(),Object.getEmail());
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
    public int xoaNCC(String mancc){
        try {
            repository.xoaNCC(mancc);
            return 1;
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }

    }
    public int changeTrangThai(String manl) {

        try {
            repository.changeTrangThai(manl);
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
}
