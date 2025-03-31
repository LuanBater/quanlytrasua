package com.ptithcm.quanlytrasua.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ptithcm.quanlytrasua.DTO.*;
import com.ptithcm.quanlytrasua.service.QLNguyenLieuTonKhoService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.UrlResource;
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
@RequestMapping("/api/nguyen-lieu")
public class QLNguyenLieuTonKhoController {
    @Autowired
    QLNguyenLieuTonKhoService QLNLservice;
    @GetMapping("/lay-danh-sach-nguyen-lieu")
    public ResponseEntity<List<NguyenLieuDTO>> getlistNL() {
        List<NguyenLieuDTO> list = QLNLservice.getlistNL();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/lay-nguyen-lieu-hien-co")
    public ResponseEntity<List<NguyenLieuDTO>> getlistNLHienCo() {
        List<NguyenLieuDTO> list = QLNLservice.getlistNL();
        for (int i = 0 ; i< list.size();i++)
        {
            if(list.get(i).getSoluongton()<= 0)
            {
                list.remove(i);
            }
        }
        return ResponseEntity.ok(list);
    }
    @GetMapping("/lay-nguyen-lieu-phat-sinh")
    public ResponseEntity<List<NLPhatSinhDTO>> getListNLPS() {
        List<NLPhatSinhDTO> list = QLNLservice.getlistNLPS();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/lay-chi-tiet-nhap-nguyen-lieu")
    public ResponseEntity<List<ChiTietNhapNL>> getChiTietNhapNL(@RequestParam("manl") String manl ){
        List<ChiTietNhapNL> list = QLNLservice.getlistCTNhapNL(manl);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/lay-danh-sach-nguyen-lieu-de-xuat")
    public ResponseEntity<List<NguyenLieuDTO>> getListDeXuat() {
        List<NguyenLieuDTO> list = QLNLservice.getlistNLCB();
        return ResponseEntity.ok(list);
    }
    @RequestMapping(value = "/them-nl", method = RequestMethod.POST)
    public ResponseEntity<NguyenLieuDTO> themNL(@Validated @RequestBody NguyenLieuDTO DTO) {

        int x = QLNLservice.themNL(DTO);
        if (x == 1)
            return new ResponseEntity<>(DTO, HttpStatus.OK);
        return new ResponseEntity<>(DTO, HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value = "/them-nguyen-lieu", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> themNguyenLieu(@RequestParam("nl") String nlString,
                                                            @RequestParam("imgNguyenLieu") MultipartFile file) throws IOException {
        Map<String, Object> result = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        NguyenLieuDTO nguyenlieu;
        try {
            nguyenlieu = objectMapper.readValue(nlString, NguyenLieuDTO.class);
        } catch (Exception e) {
            result.put("status", "Invalid JSON data");
            return ResponseEntity.badRequest().body(result);
        }

        LocalDateTime currentDateTime = LocalDateTime.now();
        String fileName = nguyenlieu.getManl().trim() + "_" +
                currentDateTime.getHour() + "h" +
                currentDateTime.getMinute() + "m" +
                currentDateTime.getSecond() + "s" + ".jpg";
        nguyenlieu.setHinhanh(fileName);
        Path root = Paths.get("src/main/resources/imgNguyenLieu");
        try {
            Files.copy(file.getInputStream(), root.resolve(fileName));
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file of that name already exists.");
            }
            System.out.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

        if (QLNLservice.themNL(nguyenlieu) == 0) {
            result.put("status", "Insert Fail!");
            return ResponseEntity.badRequest().body(result);
        } else {
            result.put("status", "OK");
            result.put("filename", fileName);
            return ResponseEntity.ok().body(result);
        }
    }
    @RequestMapping(value = "/update-nguyen-lieu", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> updateNguyenLieu(@RequestParam("nl") String nlString,
                                                                @RequestParam("imgNguyenLieu") MultipartFile file) throws IOException {
        Map<String, Object> result = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        NguyenLieuDTO nguyenlieu;

        // Xử lý dữ liệu JSON
        try {
            nguyenlieu = objectMapper.readValue(nlString, NguyenLieuDTO.class);
        } catch (Exception e) {
            result.put("status", "Invalid JSON data");
            return ResponseEntity.badRequest().body(result);
        }

        // Tạo tên tệp tin hình ảnh
        LocalDateTime currentDateTime = LocalDateTime.now();
        String fileName = nguyenlieu.getManl().trim() + "_" +
                currentDateTime.getHour() + "h" +
                currentDateTime.getMinute() + "m" +
                currentDateTime.getSecond() + "s" + ".jpg";
        nguyenlieu.setHinhanh(fileName);

        // Xử lý lưu trữ tệp tin
        Path root = Paths.get("src/main/resources/imgNguyenLieu"); // Sử dụng đường dẫn tương đối
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
        if (QLNLservice.updateNL(nguyenlieu) == 0) {
            result.put("status", "Update failed");
            return ResponseEntity.badRequest().body(result);
        } else {
            result.put("status", "OK");
            result.put("filename", fileName);
            return ResponseEntity.ok().body(result);
        }
    }


    @RequestMapping(value = "/xoa-nl", method = RequestMethod.GET)
    public ResponseEntity<?> xoaNL(@RequestParam("manl") String manl) {
        if (QLNLservice.xoaNL(manl) == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Xóa nguyên liệu thất bại");
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Xóa nguyên liệu thành công");
        }
    }
    @RequestMapping(value = "/tao-don-dat-mua", method = RequestMethod.POST)
    public ResponseEntity<String> taoDonDatMua(@Validated @RequestBody DonDatMuaDTO DTO) throws JsonProcessingException {

        int x = QLNLservice.taoDonDatMua(DTO);
        if (x == 1)
            return new ResponseEntity<>("Thành công", HttpStatus.OK);
        return new ResponseEntity<>("Thất bại", HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value = "/tao-phieu-nhap", method = RequestMethod.POST)
    public ResponseEntity<String> taoPhieuNhap(@Validated @RequestBody PhieuNhapDTO DTO) throws JsonProcessingException {

        int x = QLNLservice.taoPhieuNhap(DTO);
        if (x == 1)
            return new ResponseEntity<>("Thành công", HttpStatus.OK);
        return new ResponseEntity<>("Thất bại", HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value = "/them-nguyen-lieu-phat-sinh", method = RequestMethod.POST)
    public ResponseEntity<String> themNLPS(@Validated @RequestBody NLPhatSinhDTO DTO) {

        int x = QLNLservice.themNLPS(DTO);
        if (x == 1)
            return new ResponseEntity<>("Thành công", HttpStatus.OK);
        return new ResponseEntity<>("Thất bại", HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value = "/update-nguyen-lieu-phat-sinh", method = RequestMethod.POST)
    public ResponseEntity<String> updateNLPS(@Validated @RequestBody NLPhatSinhDTO DTO) {

        int x = QLNLservice.updateNLPS(DTO);
        if (x == 1)
            return new ResponseEntity<>("Thành công", HttpStatus.OK);
        return new ResponseEntity<>("Thất bại", HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value = "/xoa-nguyen-lieu-phat-sinh", method = RequestMethod.POST)
    public ResponseEntity<String> xoaNLPS(@Validated @RequestBody NLPhatSinhDTO DTO) {

        int x = QLNLservice.xoaNLPS(DTO);
        if (x == 1)
            return new ResponseEntity<>("Thành công", HttpStatus.OK);
        return new ResponseEntity<>("Thất bại", HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/lay-danh-sach-don-dat")
    public ResponseEntity<List<DonDatMuaShow>> getListDDM() {
        List<DonDatMuaShow> list = QLNLservice.getlistDDM();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/lay-danh-sach-phieu-nhap")
    public ResponseEntity<List<PhieuNhapShow>> getListPN() {
        List<PhieuNhapShow> list = QLNLservice.getlistPN();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/lay-san-pham-kha-dung")
    public ResponseEntity<List<SanPhamKhaDung>> getListKhaDung() {
        List<SanPhamKhaDung> list = QLNLservice.getListKhaDung();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/lay-danh-sach-nha-cung-cap")
    public ResponseEntity<List<NhaCungCapDTO>> getListNCC() {
        List<NhaCungCapDTO> list = QLNLservice.getlistNCC();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/lay-chi-tiet-don-dat")
    public ResponseEntity<List<NguyenLieuNhap>> getListCPDDM(@RequestParam("madondat") int madondat) {
        List<NguyenLieuNhap> list = QLNLservice.getCTDDM(madondat);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/lay-chi-tiet-phieu-nhap")
    public ResponseEntity<List<NguyenLieuNhap>> getListCTCP(@RequestParam("mapn") int mapn) {
        List<NguyenLieuNhap> list = QLNLservice.getCTPN(mapn);
        return ResponseEntity.ok(list);
    }
    @GetMapping(value = "get-img")
    public ResponseEntity<InputStreamResource> getImageDynamicType(@RequestParam("name") String name) {
        System.out.println("ĐÃ GETIMG");
        MediaType contentType = MediaType.IMAGE_JPEG;
        InputStream in = getClass().getResourceAsStream("/imgNguyenLieu/" + name);
        return ResponseEntity.ok()
                .contentType(contentType)
                .body(new InputStreamResource(in));
    }
    @RequestMapping(value = "/them-nha-cung-cap", method = RequestMethod.POST)
    public ResponseEntity<String> themNCC(@Validated @RequestBody NhaCungCapDTO DTO) {

        int x = QLNLservice.themNCC(DTO);
        if (x == 1)
            return new ResponseEntity<>("Thành công", HttpStatus.OK);
        return new ResponseEntity<>("Thất bại", HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value = "/update-nha-cung-cap", method = RequestMethod.POST)
    public ResponseEntity<String> updateNCC(@Validated @RequestBody NhaCungCapDTO DTO) {

        int x = QLNLservice.updateNCC(DTO);
        if (x == 1)
            return new ResponseEntity<>("Thành công", HttpStatus.OK);
        return new ResponseEntity<>("Thất bại", HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value = "/xoa-nha-cung-cap", method = RequestMethod.GET)
    public ResponseEntity<?> XoaNhaCungCap(@RequestParam("mancc") String mancc) {
        if (QLNLservice.xoaNCC(mancc) == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Xóa thất bại");
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Xóa thành công");
        }
    }
    @RequestMapping(value = "/change-status-nguyen-lieu", method = RequestMethod.GET)
    public ResponseEntity<?> changeTrangThai(@RequestParam("manl") String manl) {
        if (QLNLservice.changeTrangThai(manl) == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("thay đổi thất bại");
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("thay đổi thành công");
        }
    }
}
