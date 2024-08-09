package com.ptithcm.quanlytrasua.controller;

import com.ptithcm.quanlytrasua.DTO.*;
import com.ptithcm.quanlytrasua.model.TaiKhoan;
import com.ptithcm.quanlytrasua.securiry.service.AuthService;
import com.ptithcm.quanlytrasua.service.QLThongTinService;
import com.ptithcm.quanlytrasua.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/user")
public class LoginController {
    @Autowired
    QLThongTinService QLTTservice;
    @Autowired
    TaiKhoanService taiKhoanService;
    @Autowired
    private AuthService authService;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> authenticate(@RequestBody LoginDTO login){
        if(taiKhoanService.checkStatus(login.getUsername())){
            return ResponseEntity.badRequest().body("User is not active");
        }
        LoginDTO loginDTO = new LoginDTO(login.getUsername(), login.getPassword());

        TaiKhoan tk = taiKhoanService.getTaiKhoan(loginDTO.getUsername());
        String token = authService.login(loginDTO);
        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);
        jwtAuthResponse.setUsername(login.getUsername());
        jwtAuthResponse.setPassword(login.getPassword()); // Chỉ để ví dụ, không khuyến khích truyền password dưới dạng plain text
        jwtAuthResponse.setMaquyen(tk.getQuyen().getMaQuyen()); // Thay thế bằng giá trị thực tế của mã quyền

        System.out.println(jwtAuthResponse.toString());
        return ResponseEntity.ok(jwtAuthResponse);
    }
    @GetMapping("/kiem-tra-dang-ki")
    public int ktDangKi(@RequestParam("makh") String makh,@RequestParam("sdt") String sdt, @RequestParam("email") String email ) {
        List<KhachHangDTO> list = QLTTservice.getListKH();
        for (KhachHangDTO kh : list){
            if (kh.getMakh().equals(makh)) return 2;
            if (kh.getSdt().equals(sdt)) return 3;
            if (kh.getEmail().equals(email)) return 4;
        }
        return 1;
    }
    @GetMapping("/kiem-tra-update")
    public int kiemTraUpdate(@RequestParam("maquyen") String maquyen,@RequestParam("makh") String makh,@RequestParam("sdt") String sdt, @RequestParam("email") String email ) {
        if (maquyen.equals("KH"))
        {
            List<KhachHangDTO> list = QLTTservice.getListKH();
            for (KhachHangDTO kh : list){
                if (kh.getSdt().equals(sdt) && !kh.getMakh().equals(makh)) return 2;
                if (kh.getEmail().equals(email) && !kh.getMakh().equals(makh)) return 3;
            }
            return 1;
        }
        else {
            List<NhanVienDTO> list = QLTTservice.getListNV();
            for (NhanVienDTO nv : list){
                if (nv.getSdt().equals(sdt) && !nv.getManv().equals(makh)) return 2;
                if (nv.getEmail().equals(email) && !nv.getManv().equals(makh)) return 3;
            }
            return 1;
        }
    }
    @RequestMapping(value = "/khach-hang-dang-ki", method = RequestMethod.POST)
    public ResponseEntity<String> updateKH(@Validated @RequestBody KhachHangDangKi DTO){

        int x = taiKhoanService.KhachHangDangKi(DTO);
        if (x == 1)
            return new ResponseEntity<>("Thành công", HttpStatus.OK);
        return new ResponseEntity<>("Thất bại", HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/send-email")
    public String sendMail(@RequestBody EmailResponse emailResponse){
        String randomCode = generateRandomCode();
        emailResponse.setMessage("Mã OTP của bạn là " + randomCode);
        taiKhoanService.sendEmail(emailResponse);
        return randomCode;
    }
    private String generateRandomCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000); // Tạo số ngẫu nhiên từ 100000 đến 999999
        return String.valueOf(code);
    }
    @GetMapping("/check-tai-khoan")
    public int checkTaiKhoan (@RequestParam("username") String username ,@RequestParam("email") String email )
    {
        int data = taiKhoanService.checktaikhoan(username,email);
        if (data == 1) return 1;
        else return 0;
    }
    @RequestMapping(value = "/doi-mat-khau", method = RequestMethod.GET)
    public ResponseEntity<?> doimatkhau(@RequestParam("username") String username,@RequestParam("password") String password) {
        if (taiKhoanService.doiMatKhau(username,password) == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("thay đổi thất bại");
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("thay đổi thành công");
        }
    }
}
