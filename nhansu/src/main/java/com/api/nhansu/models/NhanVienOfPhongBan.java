package com.api.nhansu.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tblNhanVienOfPhongBan")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NhanVienOfPhongBan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nvofpbId")
    private UUID nvofpbId;

    @ManyToOne
    @JoinColumn(name = "nhanVienId")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "phongBanId")
    private PhongBan phongBan;

    @Column(name = "ngayBatDauLamViec")
    private LocalDate ngayBatDauLamViec;

    @Column(name = "ngayKetThucLamViec")
    private LocalDate ngayKetThucLamViec;

    public void updateNhanVienOfPhongBan(NhanVienOfPhongBan nhanVienOfPhongBan) {
        this.nhanVien = nhanVienOfPhongBan.nhanVien;
        this.phongBan = nhanVienOfPhongBan.phongBan;
        this.ngayBatDauLamViec = nhanVienOfPhongBan.ngayBatDauLamViec;
        this.ngayKetThucLamViec = nhanVienOfPhongBan.ngayKetThucLamViec;
    }
}
