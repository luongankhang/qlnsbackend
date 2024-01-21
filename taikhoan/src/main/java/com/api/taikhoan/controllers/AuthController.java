package com.api.taikhoan.controllers;

import com.api.taikhoan.dtos.TaiKhoanDto;
import com.api.taikhoan.services.ResponseMessage;
import com.api.taikhoan.services.TaiKhoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final TaiKhoanService taiKhoanService;

    @PostMapping
    public ResponseEntity<ResponseMessage> login(@RequestBody TaiKhoanDto taiKhoanDto) {
        return ResponseEntity.ok(taiKhoanService.login(taiKhoanDto));
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseMessage> register(@RequestBody TaiKhoanDto taiKhoanDto) {
        return ResponseEntity.ok(taiKhoanService.register(taiKhoanDto));
    }
}
