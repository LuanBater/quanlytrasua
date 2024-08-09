package com.ptithcm.quanlytrasua.service;

import com.ptithcm.quanlytrasua.DTO.KhachHangDTO;
import com.ptithcm.quanlytrasua.DTO.NhanVienDTO;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import com.ptithcm.quanlytrasua.DTO.ThongTinDTO;
import com.ptithcm.quanlytrasua.repository.QuanLyKhachHangRepository;
import com.ptithcm.quanlytrasua.repository.QuanLyNhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//8cd07a5f-4013-45c1-835f-1c7744f861d7
@Service
public class QLThongTinService {
    @Autowired
    QuanLyNhanVienRepository repository;
    @Autowired
    QuanLyKhachHangRepository KHrepository;
    public NhanVienDTO mapNV (Map<String , Object> map)
    {
        NhanVienDTO DTO = new NhanVienDTO();
        DTO.setManv((String) map.get("MANV"));
        DTO.setTennv((String) map.get("HOTEN"));
        DTO.setPhai(Integer.parseInt(map.get("PHAI").toString()));
        DTO.setDiachi((String) map.get("DIACHI"));
        DTO.setNgaysinh((String) map.get("NGAYSINH").toString());
        DTO.setSdt((String) map.get("SDT"));
        DTO.setEmail((String) map.get("EMAIL"));
        DTO.setNghilam(Integer.parseInt(map.get("NGHILAM").toString()));
        DTO.setHinhanh((String) map.get("HINHANH"));
        DTO.setMaquyen((String) map.get("MAQUYEN"));

        return DTO;
    }

    public KhachHangDTO mapKH (Map<String , Object> map)
    {
        KhachHangDTO DTO = new KhachHangDTO();
        DTO.setMakh((String) map.get("MAKH"));
        DTO.setTenkh((String) map.get("HOTEN"));
        DTO.setDiachi((String) map.get("DIACHI"));
        DTO.setSdt((String) map.get("SDT"));
        DTO.setEmail((String) map.get("EMAIL"));
        return DTO;
    }
    public ThongTinDTO mapTTNV (Map<String , Object> map)
    {
        ThongTinDTO DTO = new ThongTinDTO();
        DTO.setMa((String) map.get("MANV"));
        DTO.setTen((String) map.get("HOTEN"));
        DTO.setPhai(Integer.parseInt(map.get("PHAI").toString()));
        DTO.setDiachi((String) map.get("DIACHI"));
        DTO.setNgaysinh((String) map.get("NGAYSINH").toString());
        DTO.setSdt((String) map.get("SDT"));
        DTO.setEmail((String) map.get("EMAIL"));
        DTO.setNghilam(Integer.parseInt(map.get("NGHILAM").toString()));
        DTO.setHinhanh((String) map.get("HINHANH"));
        DTO.setMaquyen((String) map.get("MAQUYEN"));

        return DTO;
    }
    public ThongTinDTO mapTTKH (Map<String , Object> map)
    {
        ThongTinDTO DTO = new ThongTinDTO();
        DTO.setMa((String) map.get("MAKH"));
        DTO.setTen((String) map.get("HOTEN"));
        DTO.setDiachi((String) map.get("DIACHI"));
        DTO.setSdt((String) map.get("SDT"));
        DTO.setEmail((String) map.get("EMAIL"));
        return DTO;
    }
    public List<NhanVienDTO> getListNV(){

        List<Map<String,Object>> data = repository.getListNhanVien();
        List<NhanVienDTO> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            NhanVienDTO temp = mapNV(data.get(i));
            list.add(temp);
        }
        return  list;
    }
    public List<KhachHangDTO> getListKH(){

        List<Map<String,Object>> data = KHrepository.getListKhachHang();
        List<KhachHangDTO> list = new ArrayList<>();
        for (int i = 0 ; i< data.size();i++)
        {
            KhachHangDTO temp = mapKH(data.get(i));
            list.add(temp);
        }
        return  list;
    }
    public ThongTinDTO getThongTinKH(String makh){

        Map<String,Object> data = KHrepository.getThongTinKhachHang(makh);
        ThongTinDTO temp = mapTTKH(data);

        return  temp;
    }
    public ThongTinDTO getThongTinNV(String manv){

        Map<String,Object> data = repository.getThongTinNhanVien(manv);
        ThongTinDTO temp = mapTTNV(data);

        return  temp;
    }
    public int themNV(NhanVienDTO nv , String password) {
        PasswordEncoder encoder = new BCryptPasswordEncoder(10);
        String newPass = encoder.encode(password);

        try {
            repository.themNV(nv.getManv(),nv.getTennv(),nv.getPhai(),nv.getNgaysinh(),nv.getDiachi(),nv.getSdt(),
            nv.getEmail(),nv.getHinhanh(),nv.getMaquyen(),newPass);
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
    public int updateNV(NhanVienDTO nv) {

        try {
            repository.updateNV(nv.getManv(),nv.getTennv(),nv.getPhai(),nv.getNgaysinh(),nv.getDiachi(),nv.getSdt(),
                    nv.getEmail(),nv.getHinhanh());
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
    public int updateKH(KhachHangDTO kh) {

        try {
            KHrepository.updateKH(kh.getMakh(),kh.getTenkh(),kh.getDiachi(),kh.getSdt(),
                    kh.getEmail());
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
    public int changeQuyen(String manv , String maquyen) {

        try {
            repository.changeQuyen(manv,maquyen);
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
    public int changeNghiLam(String manv) {

        try {
            repository.changeNghiLam(manv);
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
}
