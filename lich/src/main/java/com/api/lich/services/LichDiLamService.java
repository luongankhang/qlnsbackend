package com.api.lich.services;

import com.api.lich.dtos.LichDiLamDto;
import com.api.lich.models.LichDiLam;
import com.api.lich.repositories.LichDiLamRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LichDiLamService {
    private final LichDiLamRepository lichDiLamRepository;

    public ResponseMessage themLichChoNhanVien(LichDiLamDto lichDiLamDto) {
        final var lich = LichDiLam
                .builder()
                .nhanVienId(lichDiLamDto.getNhanVienId())
                .cacNgayTrongTuan(lichDiLamDto.getCacNgayTrongTuan())
                .build();
        final var luuLich = lichDiLamRepository.save(lich);
        return ResponseMessage
                .builder()
                .message("Thêm thành công.")
                .data(lich)
                .build();
    }

    public ResponseMessage xoaLichDiLamChoNhanVien(UUID id) {
        final var lich = lichDiLamRepository
                .findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Nhân viên không tồn tại."));
        lichDiLamRepository.delete(lich);
        return ResponseMessage
                .builder()
                .message("Xóa thành công.")
                .data(lich)
                .build();
    }
}
