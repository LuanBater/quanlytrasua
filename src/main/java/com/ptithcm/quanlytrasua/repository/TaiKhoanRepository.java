package com.ptithcm.quanlytrasua.repository;


import java.util.Map;
import java.util.Optional;

import com.ptithcm.quanlytrasua.DTO.TaiKhoanDTO;
import com.ptithcm.quanlytrasua.model.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, String> {
    //8b0d8d39-7fc4-4983-b36c-0214679ebc20
   TaiKhoan findByUsername(String username);

    @Query(value = "{call SP_CheckTaiKhoan(:p_username, :p_email)}", nativeQuery = true)
    String checkTaiKhoan(@Param("p_username") String username,@Param("p_email") String email);
    @Procedure(procedureName = "SP_KhachHangDangKi")
    void dangKi(
            @Param("p_makh") String makh,
            @Param("p_tenkh") String tenkh,
            @Param("p_diachi") String diachi,
            @Param("p_sdt") String sdt,
            @Param("p_email") String email,
            @Param("p_password") String password
    );
    @Procedure(procedureName = "SP_DoiMatKhau")
    void doiPass(
            @Param("p_username") String username,
            @Param("p_password") String password
    );
}