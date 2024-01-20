package com.api.nhansu.services;

import com.api.nhansu.dtos.PhongBanDto;
import com.api.nhansu.models.NhanVien;
import com.api.nhansu.models.NhanVienOfPhongBan;
import com.api.nhansu.models.PhongBan;
import com.api.nhansu.repositories.PhongBanRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PhongBanService {
    private final PhongBanRepository phongBanRepository;

    public ResponseMessage timKiemPhongBan(String tenPhongBan) {
        List<PhongBan> danhSachPhongBan = phongBanRepository.findByTenPhongBanContainingIgnoreCase(tenPhongBan);
        if (danhSachPhongBan.isEmpty()) {
            return ResponseMessage
                    .builder()
                    .message("Không tìm thấy.")
                    .data(null)
                    .build();
        }
        return ResponseMessage
                .builder()
                .message("Kết quả tìm thấy.")
                .data(danhSachPhongBan)
                .build();
    }

    public ResponseMessage themPhongBan(PhongBanDto phongBanDto) {
        final var phongBan = PhongBan
                .builder()
                .tenPhongBan(phongBanDto.getTenPhongBan())
                .moTaPhongBan(phongBanDto.getMoTaPhongBan())
                .build();
        final var luuPhongBan = phongBanRepository.save(phongBan);
        return ResponseMessage
                .builder()
                .message("Thêm thành công.")
                .data(phongBan)
                .build();
    }

    public ResponseMessage suaPhongBan(UUID id, PhongBanDto phongBanDto) {
        final var phongBan = phongBanRepository
                .findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Phòng ban không tồn tại."));
        final var suaPhongBan = PhongBan
                .builder()
                .tenPhongBan(phongBanDto.getTenPhongBan())
                .moTaPhongBan(phongBanDto.getMoTaPhongBan())
                .build();
        final var luuPhongBan = phongBanRepository.save(phongBan);
        return ResponseMessage
                .builder()
                .message("Sửa thành công.")
                .data(phongBan)
                .build();
    }

    public ResponseMessage xoaPhongBan(UUID id) {
        final var phongBan = phongBanRepository
                .findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Phòng ban không tồn tại."));
        phongBanRepository.delete(phongBan);
        return ResponseMessage
                .builder()
                .message("Xóa thành công.")
                .data(phongBan)
                .build();
    }
}
