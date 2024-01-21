package com.api.chamcong.services;

import com.api.chamcong.dtos.ChamCongDto;
import com.api.chamcong.models.ChamCong;
import com.api.chamcong.repositories.ChamCongRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChamCongService {
    private final ChamCongRepository chamCongRepository;

    public ResponseMessage themChamCong(ChamCongDto chamCongDto) {
        final var chamCong = ChamCong
                .builder()
                .nhanVienId(chamCongDto.getNhanVienId())
                .tienLuong(chamCongDto.getTienLuong())
                .build();
        final var luuChamCong = chamCongRepository.save(chamCong);
        return ResponseMessage
                .builder()
                .message("Thêm thành công.")
                .data(chamCong)
                .build();
    }

    public ResponseMessage xoaChamCong(UUID id) {
        final var chamCong = chamCongRepository
                .findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Nhân viên không tồn tại."));
        chamCongRepository.delete(chamCong);
        return ResponseMessage
                .builder()
                .message("Xóa thành công.")
                .data(chamCong)
                .build();
    }
}
