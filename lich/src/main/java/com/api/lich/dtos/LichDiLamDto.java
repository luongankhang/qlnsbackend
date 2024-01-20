package com.api.lich.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LichDiLamDto {
    private UUID lichDiLamId;
    private String nhanVienId;
    private String cacNgayTrongTuan;
}
