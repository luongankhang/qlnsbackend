package com.api.lich.controllers;

import com.api.lich.dtos.LichDiLamDto;
import com.api.lich.repositories.LichDiLamRepository;
import com.api.lich.services.LichDiLamService;
import com.api.lich.services.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/lich")
@RequiredArgsConstructor
public class LichDiLamController {
    private final LichDiLamRepository lichDiLamRepository;
    private final LichDiLamService lichDiLamService;

    @GetMapping
    public ResponseEntity danhSachLichDiLam() {
        return ResponseEntity.ok(lichDiLamRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<ResponseMessage> themLichDiLam(@RequestBody LichDiLamDto lichDiLamDto) {
        return ResponseEntity.ok(lichDiLamService.themLichChoNhanVien(lichDiLamDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> xoaLichDiLam(@PathVariable UUID id) {
        return ResponseEntity.ok(lichDiLamService.xoaLichDiLamChoNhanVien(id));
    }
}
