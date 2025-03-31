package com.ptithcm.quanlytrasua.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ptithcm.quanlytrasua.DTO.CTDonHang;
import com.ptithcm.quanlytrasua.DTO.CTTopping;
import com.ptithcm.quanlytrasua.DTO.HoanThanhDonHang;
import com.ptithcm.quanlytrasua.model.MoMoIPNRequest;
import com.ptithcm.quanlytrasua.service.QuanLyDonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/momo_ipn")
public class MomoIpnController {
    @Autowired
    QuanLyDonHangService QLDHservice;
    @PostMapping()
    public ResponseEntity<String> handleMoMoIpn(@RequestBody MoMoIPNRequest request ) throws JsonProcessingException {
        if (request.getResultCode() == 0) {
            System.out.println("Thanh toán thành công"+request);
            List<CTDonHang> ctDonHangs = QLDHservice.getListCTDH(Integer.parseInt(request.getOrderId()));
            for (CTDonHang ct : ctDonHangs)
            {
                List<CTTopping> ctToppings = QLDHservice.getListCTTopping(ct.getIdctdh());
                ct.setListCT_Topping(ctToppings);
            }
            HoanThanhDonHang temp = new HoanThanhDonHang(Integer.parseInt(request.getOrderId()),ctDonHangs);
            QLDHservice.hoanThanhDonHang(temp);
//        	   return ResponseEntity.ok("Payment processed successfully");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        else {
            System.out.println("Thanh toán thất bại");
            QLDHservice.donHangThatBai(Integer.parseInt(request.getOrderId()));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Payment processing failed");
        }
    }
}
