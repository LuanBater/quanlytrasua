package com.ptithcm.quanlytrasua.controller;

import com.ptithcm.quanlytrasua.DTO.*;
import com.ptithcm.quanlytrasua.service.QLThongKeService;
import com.ptithcm.quanlytrasua.service.QLThongTinService;
import com.ptithcm.quanlytrasua.service.QuanLyDonHangService;
import org.apache.coyote.http11.filters.ChunkedInputFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/thong-ke")
public class QlThongKeController {

    @Autowired
    QuanLyDonHangService QLDHservice;
    @Autowired
    QLThongKeService QLTKservice;


    @GetMapping("/lay-hoa-don-ngay")
    public ResponseEntity<List<HoaDonDTO>> hoaDonNgay(@RequestParam("ngay") String ngay) {
        List<HoaDonDTO> list = QLTKservice.getListHDNgay(ngay);

        for(HoaDonDTO hd : list)
        {
            List<CTDonHang> ctDonHangs = QLDHservice.getListCTDH(hd.getMadonhang());
            for (CTDonHang ct : ctDonHangs)
            {
                List<CTTopping> ctToppings = QLDHservice.getListCTTopping(ct.getIdctdh());
                ct.setListCT_Topping(ctToppings);
            }
            hd.setCtdh(ctDonHangs);
        }

        return ResponseEntity.ok(list);

    }

    @GetMapping("/lay-hoa-don-thang")
    public ResponseEntity<List<ThongKeThang>> getHoaDonThang(@RequestParam("thang") int thang,@RequestParam("nam")int nam) {
        List<ThongKeThang> list = QLTKservice.getListHDTHANG(thang,nam);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/lay-hoa-don-quy")
    public ResponseEntity<ThongKeQuy> getHoaDonQuy(@RequestParam("year") int nam,@RequestParam("maquy")String maquy) {
        ThongKeQuy quy = QLTKservice.getListHDQuy(nam,maquy);
        System.out.println(quy.toString());
        return ResponseEntity.ok(quy);
    }
    @GetMapping("/lay-hoa-don-nam")
    public ResponseEntity<ThongKeNam> getHoaDonNam(@RequestParam("year") int nam) {
        ThongKeNam hdNam = QLTKservice.getListHDNam(nam);
        System.out.println(hdNam.toString());
        return ResponseEntity.ok(hdNam);
    }
    @GetMapping("/lay-phieu-nhap-thang")
    public ResponseEntity<List<ThongKePhieuNhap>> getPhieuNhapThang(@RequestParam("thang") int thang,@RequestParam("nam")int nam) {
        List<ThongKePhieuNhap> list = QLTKservice.getListPNTHANG(thang,nam);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/lay-thong-ke-nguyen-lieu")
    public ResponseEntity<List<ThongKeNguyenLieu>> thongKeNguyenLieuSuDung(@RequestParam("thang") int thang,@RequestParam("nam")int nam) {
        List<ThongKeNguyenLieu> list = QLTKservice.getListNguyenLieuSuDung(thang,nam);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/lay-nguyen-lieu-trong-ngay")
    public ResponseEntity<List<ThongKeNguyenLieu>> nguyenLieuTrongNgay(@RequestParam("ngay") String ngay) {
        List<ThongKeNguyenLieu> list = QLTKservice.getNguyenLieuSuDungTrongNgay(ngay);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/lay-nguyen-lieu-trong-thang")
    public ResponseEntity<List<NguyenLieuNhapTrongThang>> getNguyenLieuNhapTrongThang(@RequestParam("thang") int thang,@RequestParam("nam")int nam) {
        List<NguyenLieuNhapTrongThang> list = QLTKservice.getNguyenLieuNhapTrongThang(thang,nam);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/lay-doanh-thu-san-pham")
    public ResponseEntity<List<DoanhThuSanPham>> doanhThuSanPham(@RequestParam("thang") int thang,@RequestParam("nam")int nam) {
        List<DoanhThuSanPham> list = QLTKservice.getDoanhThuSanPham(thang,nam);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/lay-doanh-thu-san-pham-trong-ngay")
    public ResponseEntity<List<DoanhThuSanPham>> doanhThuSanPhamTrongNgay(@RequestParam("ngay") String ngay) {
        List<DoanhThuSanPham> list = QLTKservice.getDoanhThuSanPhamTrongNgay(ngay);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/lay-top-san-pham")
    public ResponseEntity<List<DoanhThuSanPham>> getTopSP() {
        List<DoanhThuSanPham> list = QLTKservice.getTopSanPham();
        System.out.println(list);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/lay-top-san-pham-ban-cham")
    public ResponseEntity<List<DoanhThuSanPham>> getTopSanPhamThap() {
        List<DoanhThuSanPham> list = QLTKservice.getTopSanPhamThap();
        System.out.println(list);
        return ResponseEntity.ok(list);
    }
}
