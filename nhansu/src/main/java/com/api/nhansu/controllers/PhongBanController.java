package com.api.nhansu.controllers;

import com.api.nhansu.dtos.PhongBanDto;
import com.api.nhansu.repositories.PhongBanRepository;
import com.api.nhansu.services.PhongBanService;
import com.api.nhansu.services.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/phongban")
@RequiredArgsConstructor
public class PhongBanController {
    private final PhongBanRepository phongBanRepository;
    private final PhongBanService phongBanService;

    @GetMapping
    public ResponseEntity danhSachPhongBan() {
        return ResponseEntity.ok(phongBanRepository.findAll());
    }

    @GetMapping("/tenPhongBan")
    public ResponseEntity<ResponseMessage> timKiemPhongBan(@RequestParam String tenPhongBan) {
        return ResponseEntity.ok(phongBanService.timKiemPhongBan(tenPhongBan));
    }

    @PostMapping
    public ResponseEntity<ResponseMessage> themPhongBan(@RequestBody PhongBanDto phongBanDto) {
        return ResponseEntity.ok(phongBanService.themPhongBan(phongBanDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseMessage> suaPhongBan(@PathVariable UUID id, @RequestBody PhongBanDto phongBanDto) {
        return ResponseEntity.ok(phongBanService.suaPhongBan(id, phongBanDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> xoaPhongBan(@PathVariable UUID id) {
        return ResponseEntity.ok(phongBanService.xoaPhongBan(id));
    }
}
