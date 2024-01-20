package com.api.nhansu.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "tblPhongBan")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PhongBan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "phongBanId")
    private UUID phongBanId;

    @Column(name = "tenPhongBan", length = 100)
    private String tenPhongBan;

    @Column(name = "moTaPhongBan", length = 100)
    private String moTaPhongBan;

    public void updatePhongBan(PhongBan phongBan) {
        this.tenPhongBan = phongBan.tenPhongBan;
        this.moTaPhongBan = phongBan.moTaPhongBan;
    }
}
