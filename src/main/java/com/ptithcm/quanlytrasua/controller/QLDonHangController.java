package com.ptithcm.quanlytrasua.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ptithcm.quanlytrasua.DTO.*;
import com.ptithcm.quanlytrasua.momo.MomoModel;
import com.ptithcm.quanlytrasua.momo.ResultMoMo;
import com.ptithcm.quanlytrasua.momo.utils.Constant;
import com.ptithcm.quanlytrasua.momo.utils.Decode;
import com.ptithcm.quanlytrasua.service.QuanLyDonHangService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/don-hang")
public class QLDonHangController {
    @Autowired
    QuanLyDonHangService QLDHservice;
    @GetMapping("/lay-danh-sach-don-hang")
    public ResponseEntity<List<DonHangDTO>> getListDH() {
        List<DonHangDTO> list = QLDHservice.getListDonHang();

        for(DonHangDTO dh : list)
        {
            List<CTDonHang> ctDonHangs = QLDHservice.getListCTDH(dh.getMadonhang());
            for (CTDonHang ct : ctDonHangs)
            {
                List<CTTopping> ctToppings = QLDHservice.getListCTTopping(ct.getIdctdh());
                ct.setListCT_Topping(ctToppings);
            }
            dh.setCtdh(ctDonHangs);
        }

        return ResponseEntity.ok(list);
    }
    @GetMapping("/kiem-tra-trang-thai")
    public ResponseEntity<String> kiemTraTrangThai(@RequestParam("madonhang") int madonhang) {
        String data = QLDHservice.kiemTraTrangThai(madonhang);

        return ResponseEntity.ok(data);
    }
    @GetMapping("/lay-danh-sach-hoa-don")
    public ResponseEntity<List<HoaDonDTO>> getListHoaDon() {
        List<HoaDonDTO> list = QLDHservice.getListHoaDon();

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
    @GetMapping("/xem-hoa-don")
    public ResponseEntity<HoaDonDTO> getCTHoaDon(@RequestParam(value = "madonhang", required = false) Integer madonhang) {
        // Kiểm tra nếu `madonhang` không có mặt
        if (madonhang == null) {
            return ResponseEntity.badRequest().body(null); // Hoặc gửi thông báo lỗi cụ thể
        }

        List<HoaDonDTO> list = QLDHservice.getListHoaDon();
        HoaDonDTO hdOut = null;
        for(HoaDonDTO hd : list) {
            if ((hd.getMadonhang()) == (madonhang)) {
                hdOut = hd;
                List<CTDonHang> ctDonHangs = QLDHservice.getListCTDH(hd.getMadonhang());
                for (CTDonHang ct : ctDonHangs) {
                    List<CTTopping> ctToppings = QLDHservice.getListCTTopping(ct.getIdctdh());
                    ct.setListCT_Topping(ctToppings);
                }
                hdOut.setCtdh(ctDonHangs);
                return ResponseEntity.ok(hdOut);
            }
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/lay-don-hang-da-dat")
    public ResponseEntity<List<DonHangDTO>> getListDaDat() {
        List<DonHangDTO> list = QLDHservice.getListDonHang();
        List <DonHangDTO> listOUT = new ArrayList<>();
        for(DonHangDTO dh : list)
        {
            if ((dh.getTrangthai() ==0 || dh.getTrangthai() ==1)) {
                List<CTDonHang> ctDonHangs = QLDHservice.getListCTDH(dh.getMadonhang());
                for (CTDonHang ct : ctDonHangs) {
                    List<CTTopping> ctToppings = QLDHservice.getListCTTopping(ct.getIdctdh());
                    ct.setListCT_Topping(ctToppings);
                }
                dh.setCtdh(ctDonHangs);
                listOUT.add(dh);
            }
        }

        return ResponseEntity.ok(listOUT);
    }
    @GetMapping("/lay-don-hang-hoan-thanh")
    public ResponseEntity<List<DonHangDTO>> getListHoanThanh() {
        List<DonHangDTO> list = QLDHservice.getListDonHang();
        List <DonHangDTO> listOUT = new ArrayList<>();
        for(DonHangDTO dh : list)
        {
            if (dh.getTrangthai() ==2 ) {
                List<CTDonHang> ctDonHangs = QLDHservice.getListCTDH(dh.getMadonhang());
                for (CTDonHang ct : ctDonHangs) {
                    List<CTTopping> ctToppings = QLDHservice.getListCTTopping(ct.getIdctdh());
                    ct.setListCT_Topping(ctToppings);
                }
                dh.setCtdh(ctDonHangs);
                listOUT.add(dh);
            }
        }

        return ResponseEntity.ok(listOUT);
    }
    @GetMapping("/lay-don-hang-da-dat-khach")
    public ResponseEntity<List<DonHangDTO>> getListDaDatKhach(String makh) {
        List<DonHangDTO> list = QLDHservice.getListDonHang();
        List <DonHangDTO> listOUT = new ArrayList<>();
        for(DonHangDTO dh : list)
        {
            if ((dh.getTrangthai() ==0 || dh.getTrangthai() == 1) && dh.getMakh().equals(makh)) {
                List<CTDonHang> ctDonHangs = QLDHservice.getListCTDH(dh.getMadonhang());
                for (CTDonHang ct : ctDonHangs) {
                    List<CTTopping> ctToppings = QLDHservice.getListCTTopping(ct.getIdctdh());
                    ct.setListCT_Topping(ctToppings);
                }
                dh.setCtdh(ctDonHangs);
                listOUT.add(dh);
            }
        }

        return ResponseEntity.ok(listOUT);
    }
    @GetMapping("/lay-don-hang-hoan-thanh-khach")
    public ResponseEntity<List<DonHangDTO>> getListHTKhach(String makh) {
        List<DonHangDTO> list = QLDHservice.getListDonHang();
        List <DonHangDTO> listOUT = new ArrayList<>();
        for(DonHangDTO dh : list)
        {
            if (dh.getTrangthai() == 2 && dh.getMakh().equals(makh)) {
                List<CTDonHang> ctDonHangs = QLDHservice.getListCTDH(dh.getMadonhang());
                for (CTDonHang ct : ctDonHangs) {
                    List<CTTopping> ctToppings = QLDHservice.getListCTTopping(ct.getIdctdh());
                    ct.setListCT_Topping(ctToppings);
                }
                dh.setCtdh(ctDonHangs);
                listOUT.add(dh);
            }
        }

        return ResponseEntity.ok(listOUT);
    }
    @RequestMapping(value = "/tao-don-hang", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> taoDonHang(@Validated @RequestBody OrderRequest DTO) throws JsonProcessingException {
        Map<String, Object> response = new HashMap<>();

        int orderId = QLDHservice.taoDonHang(DTO);

        if (orderId > 0) {
            if (DTO.getThanhtoan()==1)
            {
                List<DonHangDTO> list = QLDHservice.getListDonHang();

                for(DonHangDTO dh : list)
                {
                    if (dh.getMadonhang() == orderId)
                    {
                        List<CTDonHang> ctDonHangs = QLDHservice.getListCTDH(dh.getMadonhang());
                        for (CTDonHang ct : ctDonHangs)
                        {
                            List<CTTopping> ctToppings = QLDHservice.getListCTTopping(ct.getIdctdh());
                            ct.setListCT_Topping(ctToppings);
                        }
                        HoanThanhDonHang temp = new HoanThanhDonHang(orderId,ctDonHangs);
                        QLDHservice.hoanThanhDonHang(temp);
                        break;
                    }


                }
            }
            System.out.println(orderId);
            response.put("message", "Thành công");
            response.put("orderId", orderId); // Trả về mã đơn hàng
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("message", "Thất bại");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping(value = "/hoan-thanh-don-hang", method = RequestMethod.POST)
    public ResponseEntity<String> hoanThanhDonHang(@Validated @RequestBody HoanThanhDonHang DTO) throws JsonProcessingException {

        int x = QLDHservice.hoanThanhDonHang(DTO);
        if (x == 1)
            return new ResponseEntity<>("Thành công", HttpStatus.OK);
        return new ResponseEntity<>("Thất bại", HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/xoa-don-hang", method = RequestMethod.GET)
    public ResponseEntity<?> xoaDonHang(@RequestParam("madonhang") int madonhang) {
        if (QLDHservice.xoaDonHang(madonhang) == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Xóa thất bại");
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Xóa thành công");
        }
    }
    @RequestMapping(value = "/kiem-tra-kha-dung", method = RequestMethod.GET)
    public int kiemTraKhaDung(@RequestParam("masp") String masp,@RequestParam("masize") String masize) {
        return QLDHservice.KiemTraSoLuongSanPhamKhaDung(masp,masize);
    }
    }
