package com.ptithcm.quanlytrasua.service;

import com.ptithcm.quanlytrasua.DTO.*;
import com.ptithcm.quanlytrasua.model.TaiKhoan;
import com.ptithcm.quanlytrasua.repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TaiKhoanService {
    @Autowired
    TaiKhoanRepository repository;
    @Autowired
    private JavaMailSender mailSender;
    public TaiKhoanDTO mapTK (Map<String , Object> map)
    {
        TaiKhoanDTO DTO = new TaiKhoanDTO();
        DTO.setUsername((String) map.get("USERNAME"));
        DTO.setPassword((String) map.get("PASSWORD"));
        DTO.setTrangthai((Boolean) map.get("TRANGTHAI"));
        DTO.setMaquyen((String) map.get("MAQUYEN"));
        return DTO;
    }
    public int KhachHangDangKi(KhachHangDangKi kh) {
        PasswordEncoder encoder = new BCryptPasswordEncoder(10);
        String newPass = encoder.encode(kh.getPassword());
        kh.setPassword(newPass);
        try {
            repository.dangKi(kh.getMakh(),kh.getTenkh(),kh.getDiachi(),kh.getSdt(),kh.getEmail(),kh.getPassword());
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
//    public boolean checkStatus(String username){
//
//        Map<String,Object> data = repository.findAccByUsername(username);
//        TaiKhoanDTO temp = mapTK(data);
//        if (temp != null)
//        {
//            return temp.isTrangthai();
//        }
//        else return false;
//    }
    public boolean checkStatus(String username) {
        Optional<TaiKhoan> optionalTaiKhoan = repository.findById(username);
        if (optionalTaiKhoan.isEmpty()) {
            return false;
        }
        return !optionalTaiKhoan.get().isTrangThai();
    }

    public TaiKhoan getTaiKhoan(String username)
    {
        return repository.findByUsername(username);
    }
    @Value("$(spring.mail.username)")
    private String fromMail;

    public void sendEmail (EmailResponse emailResponse){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(fromMail);
        simpleMailMessage.setSubject(emailResponse.getSubject());
        simpleMailMessage.setText(emailResponse.getMessage());
        simpleMailMessage.setTo(emailResponse.getMailTo());
        mailSender.send(simpleMailMessage);

    }
    public int checktaikhoan(String username, String email)
    {
        String data = repository.checkTaiKhoan(username,email);
        if (data.equals("Hop le")) return 1;
        else return 0;
    }
    public int doiMatKhau(String username,String password) {
        PasswordEncoder encoder = new BCryptPasswordEncoder(10);
        String newPass = encoder.encode(password);
        try {
            repository.doiPass(username,newPass);
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
}
