package com.api.nhansu.dtos;

import com.api.nhansu.models.NhanVien;
import com.api.nhansu.models.PhongBan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NhanVienOfPhongBanDto {
    private UUID nvofpbId;
    private NhanVien nhanVien;
    private PhongBan phongBan;
    private LocalDate ngayBatDauLamViec;
    private LocalDate ngayKetThucLamViec;
}
