package com.api.nhansu.repositories;

import com.api.nhansu.models.PhongBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PhongBanRepository extends JpaRepository<PhongBan, UUID> {
    List<PhongBan> findByTenPhongBanContainingIgnoreCase(String tenPhongBan);
}
