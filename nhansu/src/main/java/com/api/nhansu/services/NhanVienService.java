package com.api.nhansu.services;

import com.api.nhansu.dtos.NhanVienDto;
import com.api.nhansu.models.NhanVien;
import com.api.nhansu.repositories.NhanVienRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NhanVienService {
    private final NhanVienRepository nhanVienRepository;

    public ResponseMessage timKiemNhanVien(String tenNhanVien) {
        List<NhanVien> danhSachNhanVien = nhanVienRepository.findByTenNhanVienContainingIgnoreCase(tenNhanVien);
        if (danhSachNhanVien.isEmpty()) {
            return ResponseMessage
                    .builder()
                    .message("Không tìm thấy.")
                    .data(null)
                    .build();
        }
        return ResponseMessage
                .builder()
                .message("Kết quả tìm thấy.")
                .data(danhSachNhanVien)
                .build();
    }

    public ResponseMessage themNhanVien(NhanVienDto nhanVienDto) {
        final var nhanVien = NhanVien
                .builder()
                .tenNhanVien(nhanVienDto.getTenNhanVien())
                .ngaySinh(nhanVienDto.getNgaySinh())
                .diaChi(nhanVienDto.getDiaChi())
                .viTriCongViec(nhanVienDto.getViTriCongViec())
                .build();
        final var luuNhanVien = nhanVienRepository.save(nhanVien);
        return ResponseMessage
                .builder()
                .message("Thêm thành công.")
                .data(nhanVien)
                .build();
    }

    public ResponseMessage suaNhanVien(UUID id, NhanVienDto nhanVienDto) {
        final var nhanVien = nhanVienRepository
                .findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Nhân viên không tồn tại."));
        final var suaNhanVien = NhanVien
                .builder()
                .tenNhanVien(nhanVienDto.getTenNhanVien())
                .ngaySinh(nhanVienDto.getNgaySinh())
                .diaChi(nhanVienDto.getDiaChi())
                .viTriCongViec(nhanVienDto.getViTriCongViec())
                .build();
        nhanVien.updateNhanVien(suaNhanVien);
        final var luuNhanVien = nhanVienRepository.save(nhanVien);
        return ResponseMessage
                .builder()
                .message("Sửa thành công.")
                .data(nhanVien)
                .build();
    }

    public ResponseMessage xoaNhanVien(UUID id) {
        final var nhanVien = nhanVienRepository
                .findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Nhân viên không tồn tại."));
        nhanVienRepository.delete(nhanVien);
        return ResponseMessage
                .builder()
                .message("Xóa thành công.")
                .data(nhanVien)
                .build();
    }
}
