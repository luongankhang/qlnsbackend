package com.api.chamcong.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tblChamCong")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ChamCong {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "chamCongId")
    private UUID chamCongId;

    @Column(name = "nhanVienId")
    private String nhanVienId;

    @Column(name = "tienLuong")
    private BigDecimal tienLuong;
}
