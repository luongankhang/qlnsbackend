package com.api.taikhoan.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "tblTaiKhoan")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TaiKhoan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "taiKhoanId")
    private UUID taiKhoanId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private Role role;
}
