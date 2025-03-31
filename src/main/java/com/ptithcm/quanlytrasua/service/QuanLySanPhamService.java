package com.ptithcm.quanlytrasua.service;

import com.ptithcm.quanlytrasua.DTO.*;
import com.ptithcm.quanlytrasua.repository.QuanLySanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class QuanLySanPhamService {
    @Autowired
    QuanLySanPhamRepository repository;
    public int addSP(String masp,String tensp, String maloai) {

        try {
            repository.addSP(masp,tensp,maloai);
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
    public int themSP(ThongTinSanPhamDTO sp) {

        try {
            repository.themSP(sp.getMasp(),sp.getTensp(),sp.getMaloai(),sp.getHinhanh(),sp.getGiaM(),sp.getGiaL(),sp.getMabg());
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
    public int updateSP(SanPhamDTO sp) {

        try {
            repository.updateSP(sp.getMasp(),sp.getTensp(),sp.getMaloai(),sp.getHinhanh());
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
    public int updateCongThuc(updateCongThucDTO DTO) {

        try {
            repository.updateCongThuc(DTO.getMasp(),DTO.getManl(),DTO.getSoluong(),DTO.getMota());
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }


    public int changeGia(String maloai,int giaM, int giaL ,int idctspM, int idctspL) {

        try {
            repository.changeGia(maloai,giaM,giaL, idctspM,idctspL);
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
    public int themChiTietGia(CT_GiaDTO ct,String maloai) {

        try {
            repository.themChiTietGia(ct.getMabg(),ct.getMasp(),maloai, ct.getGiasizeM(),ct.getGiasizeL(),ct.getNgayapdung(),ct.getNgaykt());
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
    public int updateChiTietGia(CT_GiaDTO ct,String maloai) {

        try {
            repository.updateChiTietGia(ct.getMabg(),ct.getMasp(),maloai, ct.getGiasizeM(),ct.getGiasizeL(),ct.getNgayapdung(),ct.getNgaykt());
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
    public SanPhamDTO mapSPDTO (Map<String , Object> sp)
    {
        SanPhamDTO sanPhamDTO = new SanPhamDTO();
        sanPhamDTO.setMasp((String) sp.get("MASP"));
        sanPhamDTO.setTensp((String) sp.get("TENSP"));
        sanPhamDTO.setMaloai((String) sp.get("MALOAI"));
        sanPhamDTO.setHinhanh((String) sp.get("HINHANH"));
        sanPhamDTO.setIdctspM(Integer.parseInt(sp.get("IDCTSPM").toString()));
        sanPhamDTO.setIdctspL(Integer.parseInt(sp.get("IDCTSPL").toString()));
        sanPhamDTO.setGiaM(Integer.parseInt(sp.get("GIASIZEM").toString()));
        sanPhamDTO.setGiaL(Integer.parseInt(sp.get("GIASIZEL").toString()));
        sanPhamDTO.setMabg((String) sp.get("MABANGGIA"));
        return sanPhamDTO;
    }
    public CT_GiaDTO mapCTGDTO (Map<String , Object> ct_gia)
    {

        CT_GiaDTO ctGiaDTO = new CT_GiaDTO();
        ctGiaDTO.setMasp((String) ct_gia.get("MASP"));
        ctGiaDTO.setTenbg((String) ct_gia.get("TENBANGGIA"));
        ctGiaDTO.setMabg((String) ct_gia.get("MABANGGIA"));
        ctGiaDTO.setGiasizeM(Integer.parseInt(ct_gia.get("GIASIZE_M").toString()));
        ctGiaDTO.setGiasizeL(Integer.parseInt(ct_gia.get("GIASIZE_L").toString()));
        ctGiaDTO.setNgayapdung((String) ct_gia.get("NGAYAPDUNG").toString());
        ctGiaDTO.setNgaykt((String) ct_gia.get("NGAYKT").toString());

        return ctGiaDTO;
    }
    public CongThucDTO mapCT (Map<String , Object> ct)
    {

        CongThucDTO ctDTO = new CongThucDTO();
        ctDTO.setManl((String) ct.get("MANL"));
        ctDTO.setTennl((String) ct.get("TENNL"));
        ctDTO.setDonvi((String) ct.get("DONVI"));
        ctDTO.setSoluong(Float.parseFloat(ct.get("SOLUONG").toString()));
        ctDTO.setMota((String) ct.get("MOTA"));
        return ctDTO;
    }
    public BangGiaDTO mapBG (Map<String , Object> ct)
    {

        BangGiaDTO DTO = new BangGiaDTO();
        DTO.setMabg((String) ct.get("MABANGGIA"));
        DTO.setTenbg((String) ct.get("TENBANGGIA"));
//        DTO.setTylegiam(Integer.parseInt(ct.get("TYLEGIAM").toString()));
//        DTO.setNgayapdung((String) ct.get("NGAYAPDUNG").toString());
//        if (ct.get("NGAYKT")!= null) DTO.setNgaykt((String) ct.get("NGAYKT").toString());
        DTO.setManv((String) ct.get("MANV"));
//        DTO.setLoaigia((String) ct.get("LOAIGIA"));
        return DTO;
    }
    public TheLoaiDTO mapTL (Map<String , Object> tl)
    {

        TheLoaiDTO DTO = new TheLoaiDTO();
        DTO.setMaloai((String) tl.get("MALOAI"));
        DTO.setTenloai((String) tl.get("TENLOAI"));

        return DTO;
    }
    public ThongTinSanPhamDTO mapSPBan (Map<String , Object> sp)
    {
        ThongTinSanPhamDTO sanPhamDTO = new ThongTinSanPhamDTO();
        sanPhamDTO.setMasp((String) sp.get("MASP"));
        sanPhamDTO.setTensp((String) sp.get("TENSP"));
        sanPhamDTO.setHinhanh((String) sp.get("HINHANH"));
        sanPhamDTO.setIdctspM(Integer.parseInt(sp.get("IDCTSPM").toString()));
        sanPhamDTO.setGiaM(Integer.parseInt(sp.get("GIASIZEM").toString()));
        sanPhamDTO.setIdctspL(Integer.parseInt(sp.get("IDCTSPL").toString()));
        sanPhamDTO.setGiaL(Integer.parseInt(sp.get("GIASIZEL").toString()));
        sanPhamDTO.setKhadung(Integer.parseInt(sp.get("KHADUNG").toString()));
        return sanPhamDTO;
    }
    public ToppingBan mapTopping (Map<String , Object> sp)
    {
        ToppingBan sanPhamDTO = new ToppingBan();
        sanPhamDTO.setMasp((String) sp.get("MASP"));
        sanPhamDTO.setIdctsp(Integer.parseInt(sp.get("IDCTSP").toString()));
        sanPhamDTO.setTensp((String) sp.get("TENSP"));
        sanPhamDTO.setHinhanh((String) sp.get("HINHANH"));
        sanPhamDTO.setGia(Integer.parseInt(sp.get("GIATOPPING").toString()));
        sanPhamDTO.setKhadung(Integer.parseInt(sp.get("KHADUNG").toString()));

        return sanPhamDTO;
    }
    public List<SanPhamDTO> getlistSP(String maloai){

        List<Map<String,Object>> data = repository.getListSanPham(maloai);
        List<SanPhamDTO> splist = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            SanPhamDTO temp = mapSPDTO(data.get(i));
            splist.add(temp);
        }
        return  splist;
    }
    public List<ThongTinSanPhamDTO> getlistSPBan(String maloai){

        List<Map<String,Object>> data = repository.getListSanPhamBan(maloai);
        List<ThongTinSanPhamDTO> splist = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            ThongTinSanPhamDTO temp = mapSPBan(data.get(i));
            splist.add(temp);
        }
        return  splist;
    }
    public List<ToppingBan> getlistTopping(){

        List<Map<String,Object>> data = repository.getListTopping();
        List<ToppingBan> splist = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            ToppingBan temp = mapTopping(data.get(i));
            splist.add(temp);
        }
        return  splist;
    }

    public List<TheLoaiDTO> getlistTL(){

        List<Map<String,Object>> data = repository.getListTheLoai();
        List<TheLoaiDTO> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            TheLoaiDTO temp = mapTL(data.get(i));
            list.add(temp);
        }
        return  list;
    }

    public List<CongThucDTO> getCongThucSP(String masp){

        List<Map<String,Object>> data = repository.getCongThucSanPham(masp);
        List<CongThucDTO> congThuclist = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            CongThucDTO temp = mapCT(data.get(i));
            congThuclist.add(temp);
        }
        return  congThuclist;
    }
    public List<CT_GiaDTO> getGiaSP(String masp, String maloai){

        List<Map<String,Object>> data = repository.getGiaSanPham(masp,maloai);
        List<CT_GiaDTO> ct = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            CT_GiaDTO temp = mapCTGDTO(data.get(i));
            ct.add(temp);
        }
        return  ct;
    }
    public int themTP(ThongTinSanPhamDTO sp) {

        try {
            repository.themTP(sp.getMasp(),sp.getTensp(),sp.getMaloai(),sp.getHinhanh(),sp.getGiaM(),sp.getMabg());
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }

    public List<BangGiaDTO> getlistBG(){

        List<Map<String,Object>> data = repository.getListBangGia();
        List<BangGiaDTO> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            BangGiaDTO temp = mapBG(data.get(i));
            list.add(temp);
        }
        return  list;
    }
    public List<BangGiaDTO> getlistBGKhaDung(){

        List<Map<String,Object>> data = repository.getListGiaKhaDung();
        List<BangGiaDTO> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            BangGiaDTO temp = mapBG(data.get(i));
            list.add(temp);
        }
        return  list;
    }

    public int xoaSP(String masp){
        try {
            repository.xoaSP(masp);
            return 1;
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }

    }
    public int xoaChiTietGia(String mabg,String masp,String maloai){
        try {
            repository.xoaChiTietGia(mabg,masp,maloai);
            return 1;
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }

    }

    public int xoaCongThuc(String masp){
        try {
            repository.XoaCongThuc(masp);
            return 1;
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }

    }
}
