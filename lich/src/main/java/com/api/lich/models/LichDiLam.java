package com.api.lich.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "tblLichDiLam")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LichDiLam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lichDiLamId")
    private UUID lichDiLamId;

    @Column(name = "nhanVienId")
    private String nhanVienId;

    @Column(name = "cacNgayTrongTuan")
    private String cacNgayTrongTuan;
}
