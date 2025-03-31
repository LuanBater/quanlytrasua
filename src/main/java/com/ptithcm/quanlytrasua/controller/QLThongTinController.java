package com.ptithcm.quanlytrasua.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ptithcm.quanlytrasua.DTO.*;
import com.ptithcm.quanlytrasua.service.QLThongTinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/thong-tin")
public class QLThongTinController {
    @Autowired
    QLThongTinService QLTTservice;
    @GetMapping("/lay-danh-sach-nhan-vien")
    public ResponseEntity<List<NhanVienDTO>> getListNV() {
        List<NhanVienDTO> list = QLTTservice.getListNV();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/lay-danh-sach-khach-hang")
    public ResponseEntity<List<KhachHangDTO>> getListKH() {
        List<KhachHangDTO> list = QLTTservice.getListKH();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/lay-thong-tin-khach-hang")
    public ResponseEntity<ThongTinDTO> getThongTinKH(@RequestParam("makh") String makh) {
        return ResponseEntity.ok(QLTTservice.getThongTinKH(makh));
    }
    @GetMapping("/lay-thong-tin-nhan-vien")
    public ResponseEntity<ThongTinDTO> getThongTinNV(@RequestParam("manv") String manv) {
        return ResponseEntity.ok(QLTTservice.getThongTinNV(manv));
    }
    @RequestMapping(value = "/change-quyen", method = RequestMethod.GET)
    public ResponseEntity<?> changeQuyen(@RequestParam("manv") String manv,@RequestParam("maquyen") String maquyen) {
        if (QLTTservice.changeQuyen(manv,maquyen) == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("thay đổi quyền thất bại");
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("thay đổi quyền thành công");
        }
    }
    @RequestMapping(value = "/change-nghi-lam", method = RequestMethod.GET)
    public ResponseEntity<?> changeNghiLam(@RequestParam("manv") String manv) {
        if (QLTTservice.changeNghiLam(manv) == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("thay đổi thất bại");
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("thay đổi thành công");
        }
    }
    @RequestMapping(value = "/them-nhan-vien", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> themNhanVien(@RequestParam("nv") String NVString,
                                                                @RequestParam("img") MultipartFile file) throws IOException {
        Map<String, Object> result = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        NhanVienDTO nhanVien;

        // Xử lý dữ liệu JSON
        try {
            nhanVien = objectMapper.readValue(NVString, NhanVienDTO.class);
        } catch (Exception e) {
            result.put("status", "Invalid JSON data");
            return ResponseEntity.badRequest().body(result);
        }

        // Tạo tên tệp tin hình ảnh
        LocalDateTime currentDateTime = LocalDateTime.now();
        String fileName = nhanVien.getManv().trim() + "_" +
                currentDateTime.getHour() + "h" +
                currentDateTime.getMinute() + "m" +
                currentDateTime.getSecond() + "s" + ".jpg";
        nhanVien.setHinhanh(fileName);

        // Xử lý lưu trữ tệp tin
        Path root = Paths.get("src/main/resources/imgNhanVien"); // Sử dụng đường dẫn tương đối
        try {
            if (!Files.exists(root)) {
                Files.createDirectories(root); // Tạo thư mục nếu chưa tồn tại
            }
            Path filePath = root.resolve(fileName);
            if (Files.exists(filePath)) {
                result.put("status", "File already exists");
                return ResponseEntity.badRequest().body(result);
            }
            Files.copy(file.getInputStream(), filePath);
        } catch (Exception e) {
            System.err.println("Error while saving file: " + e.getMessage());
            result.put("status", "Error while saving file");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }

        // Cập nhật nguyên liệu
        if (QLTTservice.themNV(nhanVien,"123456") == 0) {
            result.put("status", "Insert failed");
            return ResponseEntity.badRequest().body(result);
        } else {
            result.put("status", "OK");
            result.put("filename", fileName);
            return ResponseEntity.ok().body(result);
        }
    }

        @RequestMapping(value = "/update-nhan-vien", method = RequestMethod.POST)
        public ResponseEntity<Map<String, Object>> updateNhanVien(@RequestParam("nv") String NVString,
                                                                    @RequestParam("img") MultipartFile file) throws IOException {
            Map<String, Object> result = new HashMap<>();
            ObjectMapper objectMapper = new ObjectMapper();
            NhanVienDTO nhanVien;

            // Xử lý dữ liệu JSON
            try {
                nhanVien = objectMapper.readValue(NVString, NhanVienDTO.class);
            } catch (Exception e) {
                result.put("status", "Invalid JSON data");
                return ResponseEntity.badRequest().body(result);
            }

            // Tạo tên tệp tin hình ảnh
            LocalDateTime currentDateTime = LocalDateTime.now();
            String fileName = nhanVien.getManv().trim() + "_" +
                    currentDateTime.getHour() + "h" +
                    currentDateTime.getMinute() + "m" +
                    currentDateTime.getSecond() + "s" + ".jpg";
            nhanVien.setHinhanh(fileName);

            // Xử lý lưu trữ tệp tin
            Path root = Paths.get("src/main/resources/imgNhanVien"); // Sử dụng đường dẫn tương đối
            try {
                if (!Files.exists(root)) {
                    Files.createDirectories(root); // Tạo thư mục nếu chưa tồn tại
                }
                Path filePath = root.resolve(fileName);
                if (Files.exists(filePath)) {
                    result.put("status", "File already exists");
                    return ResponseEntity.badRequest().body(result);
                }
                Files.copy(file.getInputStream(), filePath);
            } catch (Exception e) {
                System.err.println("Error while saving file: " + e.getMessage());
                result.put("status", "Error while saving file");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
            }

            // Cập nhật nguyên liệu
            if (QLTTservice.updateNV(nhanVien) == 0) {
                result.put("status", "Update failed");
                return ResponseEntity.badRequest().body(result);
            } else {
                result.put("status", "OK");
                result.put("filename", fileName);
                return ResponseEntity.ok().body(result);
            }
        }
    @RequestMapping(value = "/update-thong-tin-nhan-vien", method = RequestMethod.POST)
    public ResponseEntity<String> updateInfoNV(@Validated @RequestBody  NhanVienDTO DTO){

        int x = QLTTservice.updateNV(DTO);
        if (x == 1)
            return new ResponseEntity<>("Thành công", HttpStatus.OK);
        return new ResponseEntity<>("Thất bại", HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value = "/update-khach-hang", method = RequestMethod.POST)
    public ResponseEntity<String> updateKH(@Validated @RequestBody  KhachHangDTO DTO){

        int x = QLTTservice.updateKH(DTO);
        if (x == 1)
            return new ResponseEntity<>("Thành công", HttpStatus.OK);
        return new ResponseEntity<>("Thất bại", HttpStatus.BAD_REQUEST);
    }
    @GetMapping(value = "get-img")
    public ResponseEntity<InputStreamResource> getImageDynamicType(@RequestParam("name") String name) {
        System.out.println("ĐÃ GETIMG");
        MediaType contentType = MediaType.IMAGE_JPEG;
        InputStream in = getClass().getResourceAsStream("/imgNhanVien/" + name);
        return ResponseEntity.ok()
                .contentType(contentType)
                .body(new InputStreamResource(in));
    }
}
