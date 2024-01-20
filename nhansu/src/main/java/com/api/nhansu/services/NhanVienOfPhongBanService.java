package com.api.nhansu.services;

import com.api.nhansu.dtos.NhanVienOfPhongBanDto;
import com.api.nhansu.models.NhanVienOfPhongBan;
import com.api.nhansu.repositories.NhanVienOfPhongBanRepository;
import com.api.nhansu.repositories.NhanVienRepository;
import com.api.nhansu.repositories.PhongBanRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NhanVienOfPhongBanService {
    private final NhanVienRepository nhanVienRepository;
    private final PhongBanRepository phongBanRepository;
    private final NhanVienOfPhongBanRepository nhanVienOfPhongBanRepository;

    public ResponseMessage timKiemNhanVien(String tenNhanVien) {
        List<NhanVienOfPhongBan> danhSachOf = nhanVienOfPhongBanRepository.findByNhanVien_TenNhanVien(tenNhanVien);
        if (danhSachOf.isEmpty()) {
            return ResponseMessage
                    .builder()
                    .message("Không tìm thấy.")
                    .data(null)
                    .build();
        }
        return ResponseMessage
                .builder()
                .message("Kết quả tìm thấy.")
                .data(danhSachOf)
                .build();
    }

    public ResponseMessage themOf(NhanVienOfPhongBanDto nhanVienOfPhongBanDto) {
        final var nhanVien = nhanVienRepository
                .findById(nhanVienOfPhongBanDto.getNhanVien().getNhanVienId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Nhân viên không tồn tại."));
        final var phongBan = phongBanRepository
                .findById(nhanVienOfPhongBanDto.getPhongBan().getPhongBanId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Phòng ban không tồn tại."));
        final var of = NhanVienOfPhongBan
                .builder()
                .nhanVien(nhanVien)
                .phongBan(phongBan)
                .ngayBatDauLamViec(nhanVienOfPhongBanDto.getNgayBatDauLamViec())
                .ngayKetThucLamViec(nhanVienOfPhongBanDto.getNgayKetThucLamViec())
                .build();
        final var luuOf = nhanVienOfPhongBanRepository.save(of);
        return ResponseMessage
                .builder()
                .message("Thêm thành công.")
                .data(of)
                .build();
    }

    public ResponseMessage suaOf(UUID id, NhanVienOfPhongBanDto nhanVienOfPhongBanDto) {
        final var of = nhanVienOfPhongBanRepository
                .findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Of không tồn tại."));
        final var nhanVien = nhanVienRepository
                .findById(nhanVienOfPhongBanDto.getNhanVien().getNhanVienId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Nhân viên không tồn tại."));
        final var phongBan = phongBanRepository
                .findById(nhanVienOfPhongBanDto.getPhongBan().getPhongBanId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Phòng ban không tồn tại."));
        final var suaOf = NhanVienOfPhongBan
                .builder()
                .nhanVien(nhanVien)
                .phongBan(phongBan)
                .ngayBatDauLamViec(nhanVienOfPhongBanDto.getNgayBatDauLamViec())
                .ngayKetThucLamViec(nhanVienOfPhongBanDto.getNgayKetThucLamViec())
                .build();
        final var luuOf = nhanVienOfPhongBanRepository.save(of);
        return ResponseMessage
                .builder()
                .message("Sửa thành công.")
                .data(of)
                .build();
    }

    public ResponseMessage xoaOf(UUID id) {
        final var of = nhanVienOfPhongBanRepository
                .findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Of không tồn tại."));
        nhanVienOfPhongBanRepository.delete(of);
        return ResponseMessage
                .builder()
                .message("Xóa thành công.")
                .data(of)
                .build();
    }
}
