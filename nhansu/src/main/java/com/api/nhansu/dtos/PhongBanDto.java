package com.api.nhansu.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PhongBanDto {
    private UUID phongBanId;
    private String tenPhongBan;
    private String moTaPhongBan;
}
