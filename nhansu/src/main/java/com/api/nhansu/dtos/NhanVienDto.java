package com.api.nhansu.dtos;

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
public class NhanVienDto {
    private UUID nhanVienId;
    private String tenNhanVien;
    private LocalDate ngaySinh;
    private String diaChi;
    private String viTriCongViec;
}
