package com.api.nhansu.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tblNhanVien")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nhanVienId")
    private UUID nhanVienId;

    @Column(name = "tenNhanVien", length = 100)
    private String tenNhanVien;

    @Column(name = "ngaySinh")
    private LocalDate ngaySinh;

    @Column(name = "diaChi", length = 100)
    private String diaChi;

    @Column(name = "viTriCongViec", length = 100)
    private String viTriCongViec;

    public void updateNhanVien(NhanVien nhanVien) {
        this.tenNhanVien = nhanVien.tenNhanVien;
        this.ngaySinh = nhanVien.ngaySinh;
        this.diaChi = nhanVien.diaChi;
        this.viTriCongViec = nhanVien.viTriCongViec;
    }
}
