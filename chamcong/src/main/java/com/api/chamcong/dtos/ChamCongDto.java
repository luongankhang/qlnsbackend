package com.api.chamcong.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ChamCongDto {
    private UUID chamCongId;
    private String nhanVienId;
    private String nvofpbId;
    private BigDecimal tienLuong;
}
