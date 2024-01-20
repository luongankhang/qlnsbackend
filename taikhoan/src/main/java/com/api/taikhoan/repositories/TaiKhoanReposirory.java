package com.api.taikhoan.repositories;

import com.api.taikhoan.models.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaiKhoanReposirory extends JpaRepository<TaiKhoan, UUID> {
    Optional<TaiKhoan> findByUsername(String username);
}
