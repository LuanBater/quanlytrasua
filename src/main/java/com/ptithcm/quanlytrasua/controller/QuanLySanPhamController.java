package com.ptithcm.quanlytrasua.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ptithcm.quanlytrasua.DTO.*;
import com.ptithcm.quanlytrasua.service.QuanLySanPhamService;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/san-pham")
public class QuanLySanPhamController {
    @Autowired
    QuanLySanPhamService QLSPservice;

    @GetMapping("/lay-danh-sach-sp")
    public ResponseEntity<List<SanPhamDTO>> getlistSP(@RequestParam("maloai") String maloai) {
        if (maloai.equals("ALL")) maloai = null;
        return  ResponseEntity.ok(QLSPservice.getlistSP(maloai));
    }
    @GetMapping("/lay-danh-sach-sp-ban")
    public ResponseEntity<List<ThongTinSanPhamDTO>> getlistSPBan(@RequestParam("maloai") String maloai) {
        if (maloai.equals("ALL")) maloai = null;
        return  ResponseEntity.ok(QLSPservice.getlistSPBan(maloai));
    }
    @GetMapping("/lay-danh-sach-sp-ha-gia")
    public ResponseEntity<List<ThongTinSanPhamDTO>> getlistSPKM() {
        List<ThongTinSanPhamDTO> list = QLSPservice.getlistSPBan(null);
        List<ThongTinSanPhamDTO> listKm = new ArrayList<>();
        for(ThongTinSanPhamDTO sp : list){
           if ( sp.getTylegiam() > 0)  listKm.add(sp);
        }
        return  ResponseEntity.ok(listKm);
    }
    @GetMapping("/lay-danh-sach-topping")
    public ResponseEntity<List<ToppingBan>> getListTopping() {
        List<ToppingBan> list = QLSPservice.getlistTopping();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/lay-danh-sach-the-loai")
    public ResponseEntity<List<TheLoaiDTO>> getListTL() {
        List<TheLoaiDTO> theLoaiList = QLSPservice.getlistTL();
        return ResponseEntity.ok(theLoaiList);
    }
    @GetMapping("/lay-danh-sach-bang-gia")
    public ResponseEntity<List<BangGiaDTO>> getListBG() {
        List<BangGiaDTO> list = QLSPservice.getlistBG();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/lay-bang-gia-kha-dung")
    public ResponseEntity<List<BangGiaDTO>> getListBGKhaDung() {
        List<BangGiaDTO> list = QLSPservice.getlistBGKhaDung();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/lay-bang-gia-khuyen-mai")
    public ResponseEntity<List<BangGiaDTO>> getListBGKhuyenMai() {
        List<BangGiaDTO> list = QLSPservice.getlistBGKhuyenMai();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/lay-gia-sp")
    public ResponseEntity<CT_GiaDTO> xemHP(@RequestParam("masp") String masp, @RequestParam("masize") String masize) {
        return  ResponseEntity.ok(QLSPservice.getGiaSP(masp,masize));
    }
    @GetMapping("/lay-cong-thuc-sp")
    public ResponseEntity<List<CongThucDTO>> xemCongThuc(@RequestParam("masp") String masp) {
        return  ResponseEntity.ok(QLSPservice.getCongThucSP(masp));
    }
        @RequestMapping(value = "/them-sp", method = RequestMethod.POST)
    public ResponseEntity<ThongTinSanPhamDTO> themSP(@Validated @RequestBody ThongTinSanPhamDTO sp) {

        int x = QLSPservice.themSP(sp);
        if (x == 1)
            return new ResponseEntity<>(sp, HttpStatus.OK);
        return new ResponseEntity<>(sp, HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value = "/them-topping", method = RequestMethod.POST)
    public ResponseEntity<ThongTinSanPhamDTO> themTP(@Validated @RequestBody ThongTinSanPhamDTO sp) {

        int x = QLSPservice.themTP(sp);
        if (x == 1)
            return new ResponseEntity<>(sp, HttpStatus.OK);
        return new ResponseEntity<>(sp, HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value = "/update-cong-thuc", method = RequestMethod.POST)
    public ResponseEntity<String> updateCongThuc(@RequestBody updateCongThucDTO DTO
                                                )
    {

        int x = QLSPservice.updateCongThuc(DTO);
        if (x == 1)
            return new ResponseEntity<>("Thêm công thức thành công", HttpStatus.OK);
        return new ResponseEntity<>("Thêm công thức thất bại", HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value = "/update-khuyen-mai", method = RequestMethod.POST)
    public ResponseEntity<String> updateKhuyeMai(@RequestBody UpdateKhuyenMaiDTO DTO
    )
    {

        int x = QLSPservice.updateKhuyenMai(DTO);
        if (x == 1)
            return new ResponseEntity<>("update khuyến mãi thành công", HttpStatus.OK);
        return new ResponseEntity<>("update khuyến mãi thất bại", HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value = "/xoa-khuyen-mai", method = RequestMethod.GET)
    public ResponseEntity<String> xoaKhuyeMai(@RequestParam String mabg, @RequestParam int idctspM,@RequestParam int idctspL
                                                 )
    {

        int x = QLSPservice.xoaKhuyenMai(mabg,idctspM,idctspL);
        if (x == 1)
            return new ResponseEntity<>("xóa khuyến mãi thành công", HttpStatus.OK);
        return new ResponseEntity<>("xóa khuyến mãi thất bại", HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value = "/change-gia", method = RequestMethod.GET)
    public ResponseEntity<String> changeGia(@RequestParam String maloai,@RequestParam int giaM,@RequestParam int giaL, @RequestParam int idctspM,@RequestParam int idctspL
    )
    {

        int x = QLSPservice.changeGia(maloai,giaM,giaL,idctspM,idctspL);
        if (x == 1)
            return new ResponseEntity<>("thay đổi giá thành công", HttpStatus.OK);
        return new ResponseEntity<>("thay đổi giá thất bại", HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value = "/them-san-pham", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> themSP(@RequestParam("sp") String spString,
                                                                @RequestParam("img") MultipartFile file) throws IOException {
        Map<String, Object> result = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        ThongTinSanPhamDTO DTO;

        // Xử lý dữ liệu JSON
        try {
            DTO = objectMapper.readValue(spString, ThongTinSanPhamDTO.class);
        } catch (Exception e) {
            result.put("status", "Invalid JSON data");
            return ResponseEntity.badRequest().body(result);
        }

        // Tạo tên tệp tin hình ảnh
        LocalDateTime currentDateTime = LocalDateTime.now();
        String fileName = DTO.getMasp().trim() + "_" +
                currentDateTime.getHour() + "h" +
                currentDateTime.getMinute() + "m" +
                currentDateTime.getSecond() + "s" + ".jpg";
        DTO.setHinhanh(fileName);

        // Xử lý lưu trữ tệp tin
        Path root = Paths.get("src/main/resources/imgSanPham"); // Sử dụng đường dẫn tương đối
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
        if (QLSPservice.themSP(DTO) == 0) {
            result.put("status", "Update failed");
            return ResponseEntity.badRequest().body(result);
        } else {
            result.put("status", "OK");
            result.put("filename", fileName);
            return ResponseEntity.ok().body(result);
        }
    }
    @RequestMapping(value = "/update-san-pham", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> updateSP(@RequestParam("sp") String spString,
                                                                @RequestParam("img") MultipartFile file) throws IOException {
        Map<String, Object> result = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        SanPhamDTO DTO;

        // Xử lý dữ liệu JSON
        try {
            DTO = objectMapper.readValue(spString, SanPhamDTO.class);
        } catch (Exception e) {
            result.put("status", "Invalid JSON data");
            return ResponseEntity.badRequest().body(result);
        }

        // Tạo tên tệp tin hình ảnh
        LocalDateTime currentDateTime = LocalDateTime.now();
        String fileName = DTO.getMasp().trim() + "_" +
                currentDateTime.getHour() + "h" +
                currentDateTime.getMinute() + "m" +
                currentDateTime.getSecond() + "s" + ".jpg";
        DTO.setHinhanh(fileName);

        // Xử lý lưu trữ tệp tin
        Path root = Paths.get("src/main/resources/imgSanPham"); // Sử dụng đường dẫn tương đối
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

        if (QLSPservice.updateSP(DTO) == 0) {
            result.put("status", "Update failed");
            return ResponseEntity.badRequest().body(result);
        } else {
            result.put("status", "OK");
            result.put("filename", fileName);
            return ResponseEntity.ok().body(result);
        }
    }
    @RequestMapping(value = "/xoa-sp", method = RequestMethod.GET)
    public ResponseEntity<?> xoasp(@RequestParam("masp") String masp) {
        if (QLSPservice.xoaSP(masp) == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Xóa thất bại");
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Xóa thành công");
        }
    }
    @RequestMapping(value = "/xoa-cong-thuc", method = RequestMethod.GET)
    public ResponseEntity<?> xoaCongThuc(@RequestParam("masp") String masp) {
        if (QLSPservice.xoaCongThuc(masp) == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Xóa thất bại");
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Xóa thành công");
        }
    }
    @GetMapping(value = "get-img")
    public ResponseEntity<InputStreamResource> getImageDynamicType(@RequestParam("name") String name) {
        System.out.println("ĐÃ GETIMG");
        MediaType contentType = MediaType.IMAGE_JPEG;
        InputStream in = getClass().getResourceAsStream("/imgSanPham/" + name);
        return ResponseEntity.ok()
                .contentType(contentType)
                .body(new InputStreamResource(in));
    }
    @RequestMapping(value = "/them-bang-gia-khuyen-mai", method = RequestMethod.POST)
    public ResponseEntity<String> themBGKM(@Validated @RequestBody BangGiaDTO DTO) {

        int x = QLSPservice.themBangGiaKM(DTO);
        if (x == 1)
            return new ResponseEntity<>("Thành công", HttpStatus.OK);
        return new ResponseEntity<>("Thất bại", HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value = "/update-bang-gia", method = RequestMethod.POST)
    public ResponseEntity<String> updateNLPS(@Validated @RequestBody BangGiaDTO DTO) {

        int x = QLSPservice.updateBangGiaKM(DTO);
        if (x == 1)
            return new ResponseEntity<>("Thành công", HttpStatus.OK);
        return new ResponseEntity<>("Thất bại", HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value = "/xoa-bang-gia", method = RequestMethod.GET)
    public ResponseEntity<?> xoaBangGia(@RequestParam("mabg") String mabg) {
        if (QLSPservice.xoaBangGia(mabg) == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Xóa thất bại");
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Xóa thành công");
        }
    }
}
