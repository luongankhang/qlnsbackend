package com.api.taikhoan.services;

import com.api.taikhoan.dtos.TaiKhoanDto;
import com.api.taikhoan.models.Role;
import com.api.taikhoan.models.TaiKhoan;
import com.api.taikhoan.repositories.TaiKhoanReposirory;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaiKhoanService {
    private final PasswordUtils passwordUtils;
    private final TaiKhoanReposirory taiKhoanReposirory;

    public ResponseMessage login(TaiKhoanDto taiKhoanDto) {
        return taiKhoanReposirory.findByUsername(taiKhoanDto.getUsername())
                .map(storedCustomer -> {
                    if (PasswordUtils.verifyPassword(taiKhoanDto.getPassword(), storedCustomer.getPassword())) {
                        return ResponseMessage.builder().message("Đăng nhập thành công.").data(storedCustomer.getRole()).build();
                    } else {
                        throw new EntityNotFoundException("Tài khoản hoặc mật khẩu không chính xác.");
                    }
                })
                .orElseThrow(() -> new EntityNotFoundException("Tài khoản hoặc mật khẩu không chính xác."));
    }

    public ResponseMessage register(TaiKhoanDto taiKhoanDto) {
        var obj = TaiKhoan.builder()
                .username(taiKhoanDto.getUsername())
                .password(PasswordUtils.hashPassword(taiKhoanDto.getPassword()))
                .role(Role.ADMIN)
                .build();
        var saved = taiKhoanReposirory.save(obj);
        return ResponseMessage.builder().message("Đăng ký tài khoản thành công").data("user").build();
    }
}
