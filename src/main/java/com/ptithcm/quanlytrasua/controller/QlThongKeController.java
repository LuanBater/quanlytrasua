package com.ptithcm.quanlytrasua.controller;

import com.ptithcm.quanlytrasua.DTO.*;
import com.ptithcm.quanlytrasua.service.QLThongKeService;
import com.ptithcm.quanlytrasua.service.QLThongTinService;
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
    QLThongKeService QLTKservice;

    @GetMapping("/lay-danh-sach-cpps")
    public ResponseEntity<List<ChiPhiPhatSinhDTO>> getLISTCPPS() {
        List<ChiPhiPhatSinhDTO> list = QLTKservice.getListCTPS();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/lay-hoa-don-ngay")
    public ResponseEntity<List<HoaDonDTO>> hoaDonNgay(@RequestParam("ngay") String ngay) {
        return  ResponseEntity.ok(QLTKservice.getListHDNgay(ngay));
    }

    @GetMapping("/lay-hoa-don-thang")
    public ResponseEntity<List<ThongKeThang>> getHoaDonThang(@RequestParam("thang") int thang,@RequestParam("nam")int nam) {
        List<ThongKeThang> list = QLTKservice.getListHDTHANG(thang,nam);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/lay-phieu-nhap-thang")
    public ResponseEntity<List<ThongKeThang>> getPhieuNhapThang(@RequestParam("thang") int thang,@RequestParam("nam")int nam) {
        List<ThongKeThang> list = QLTKservice.getListPNTHANG(thang,nam);
        return ResponseEntity.ok(list);
    }
    @RequestMapping(value = "/them-chi-phi-phat-sinh", method = RequestMethod.POST)
    public ResponseEntity<String> themcpps(@Validated @RequestBody ChiPhiPhatSinhDTO DTO) {

        int x = QLTKservice.themCPPS(DTO);
        if (x == 1)
            return new ResponseEntity<>("Thành công", HttpStatus.OK);
        return new ResponseEntity<>("Thất bại", HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value = "/update-chi-phi-phat-sinh", method = RequestMethod.POST)
    public ResponseEntity<String> updatecpps(@Validated @RequestBody ChiPhiPhatSinhDTO DTO) {

        int x = QLTKservice.updateCPPS(DTO);
        if (x == 1)
            return new ResponseEntity<>("Thành công", HttpStatus.OK);
        return new ResponseEntity<>("Thất bại", HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value = "/xoa-chi-phi-phat-sinh", method = RequestMethod.GET)
    public ResponseEntity<?> xoacpps(@RequestParam("macpps") String macpps) {
        if (QLTKservice.xoaCPPS(macpps) == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Xóa thất bại");
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Xóa thành công");
        }
    }
}
