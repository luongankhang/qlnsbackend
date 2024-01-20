package com.api.nhansu.controllers;

import com.api.nhansu.dtos.NhanVienDto;
import com.api.nhansu.repositories.NhanVienRepository;
import com.api.nhansu.services.NhanVienService;
import com.api.nhansu.services.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/nhanvien")
@RequiredArgsConstructor
public class NhanVienController {
    private final NhanVienRepository nhanVienRepository;
    private final NhanVienService nhanVienService;

    @GetMapping
    public ResponseEntity danhSachNhanVien() {
        return ResponseEntity.ok(nhanVienRepository.findAll());
    }

    @GetMapping("/tenNhanVien")
    public ResponseEntity<ResponseMessage> timKiemNhanVien(@RequestParam String tenNhanVien) {
        return ResponseEntity.ok(nhanVienService.timKiemNhanVien(tenNhanVien));
    }

    @PostMapping
    public ResponseEntity<ResponseMessage> themNhanVien(@RequestBody NhanVienDto nhanVienDto) {
        return ResponseEntity.ok(nhanVienService.themNhanVien(nhanVienDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseMessage> suaNhanVien(@PathVariable UUID id, @RequestBody NhanVienDto nhanVienDto) {
        return ResponseEntity.ok(nhanVienService.suaNhanVien(id, nhanVienDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> xoaNhanVien(@PathVariable UUID id) {
        return ResponseEntity.ok(nhanVienService.xoaNhanVien(id));
    }
}
