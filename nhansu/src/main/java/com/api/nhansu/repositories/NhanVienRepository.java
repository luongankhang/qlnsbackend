package com.api.nhansu.repositories;

import com.api.nhansu.models.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {
    List<NhanVien> findByTenNhanVienContainingIgnoreCase(String tenNhanVien);
}
