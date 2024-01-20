package com.api.nhansu.controllers;

import com.api.nhansu.dtos.NhanVienOfPhongBanDto;
import com.api.nhansu.repositories.NhanVienOfPhongBanRepository;
import com.api.nhansu.services.NhanVienOfPhongBanService;
import com.api.nhansu.services.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/of")
@RequiredArgsConstructor
public class NhanVienOfPhongBanController {
    private final NhanVienOfPhongBanRepository nhanVienOfPhongBanRepository;
    private final NhanVienOfPhongBanService nhanVienOfPhongBanService;

    @GetMapping
    public ResponseEntity danhSachOf() {
        return ResponseEntity.ok(nhanVienOfPhongBanRepository.findAll());
    }

    @GetMapping("/tenNhanVien")
    public ResponseEntity<ResponseMessage> timKiemNhanVien(@RequestParam String tenNhanVien) {
        return ResponseEntity.ok(nhanVienOfPhongBanService.timKiemNhanVien(tenNhanVien));
    }

    @PostMapping
    public ResponseEntity<ResponseMessage> themOf(@RequestBody NhanVienOfPhongBanDto nhanVienOfPhongBanDto) {
        return ResponseEntity.ok(nhanVienOfPhongBanService.themOf(nhanVienOfPhongBanDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseMessage> suaOf(@PathVariable UUID id, @RequestBody NhanVienOfPhongBanDto nhanVienOfPhongBanDto) {
        return ResponseEntity.ok(nhanVienOfPhongBanService.suaOf(id, nhanVienOfPhongBanDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> xoaOf(@PathVariable UUID id) {
        return ResponseEntity.ok(nhanVienOfPhongBanService.xoaOf(id));
    }
}
