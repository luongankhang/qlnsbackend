package com.api.taikhoan.services;

import com.api.taikhoan.dtos.TaiKhoanDto;
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
}
