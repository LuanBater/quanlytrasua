package com.ptithcm.quanlytrasua.securiry.service;

import com.ptithcm.quanlytrasua.model.TaiKhoan;
import com.ptithcm.quanlytrasua.repository.TaiKhoanRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TaiKhoan taiKhoan = taiKhoanRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not exists by Username"));
        GrantedAuthority authority =  new SimpleGrantedAuthority(taiKhoan.getQuyen().getTenQuyen());
        return new org.springframework.security.core.userdetails.User(
                username,
                taiKhoan.getPassword(),
                Collections.singleton(authority)
        );
    }


}

