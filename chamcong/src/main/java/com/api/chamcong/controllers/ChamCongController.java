package com.api.chamcong.controllers;

import com.api.chamcong.dtos.ChamCongDto;
import com.api.chamcong.repositories.ChamCongRepository;
import com.api.chamcong.services.ChamCongService;
import com.api.chamcong.services.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/chamcong")
@RequiredArgsConstructor
public class ChamCongController {
    private final ChamCongRepository chamCongRepository;
    private final ChamCongService chamCongService;

    @GetMapping
    public ResponseEntity danhSachChamCong() {
        return ResponseEntity.ok(chamCongRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<ResponseMessage> themChamCong(@RequestBody ChamCongDto chamCongDto) {
        return ResponseEntity.ok(chamCongService.themChamCong(chamCongDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> xoaChamCong(@PathVariable UUID id) {
        return ResponseEntity.ok(chamCongService.xoaChamCong(id));
    }
}
